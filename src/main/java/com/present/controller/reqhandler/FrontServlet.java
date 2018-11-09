package com.present.controller.reqhandler;

import com.present.controller.reqhandler.commands.Command;
import com.present.controller.reqhandler.commands.SessionStartCommand;
import com.present.controller.reqhandler.commands.UnknownCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


/**
 * Created by Yuliia Tesliuk on 11/05/2018
 */
@WebServlet("")
public class FrontServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        process(req,resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) {
        Command command;
        try {
            command = getCommand(req);
            command.init(req.getServletContext(), req, resp);
            command.process();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Command getCommand(HttpServletRequest req) throws InstantiationException, IllegalAccessException {
        try {
            return (Command) getCommandClass(req).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw e;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private Class getCommandClass(HttpServletRequest req) {
        Class commandClazz;
        if(req.getParameter("command") == null){
            commandClazz = SessionStartCommand.class;
        } else {
            try{
                req.getParameter("name");
                String classFullName = "com.present.controller.reqhandler.commands." + req.getParameter("command") + "Command";
                commandClazz = Class.forName(classFullName);
            } catch (ClassNotFoundException e){
                commandClazz = UnknownCommand.class;
            }
        }
        return commandClazz;
    }


}
