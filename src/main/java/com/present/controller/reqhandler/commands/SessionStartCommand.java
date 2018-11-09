package com.present.controller.reqhandler.commands;

import com.present.model.jdbc.SweetyDAO;

import javax.servlet.ServletException;
import java.io.IOException;


/**
 * Created by Yuliia Tesliuk on 11/07/2018
 */
public class SessionStartCommand extends Command {

    @Override
    public void process() throws ServletException, IOException {
        itemDAO = new SweetyDAO(db.getConnection());
        items = itemDAO.readAll();

        if(req.getParameter("lang") == null){
            session.setAttribute("lang","ua");
        } else {
            session.setAttribute("lang",req.getParameter("lang"));
        }


        session.setAttribute("items",items);

        req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req, resp);
    }
}
