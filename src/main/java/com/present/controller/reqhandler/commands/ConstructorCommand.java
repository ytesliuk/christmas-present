package com.present.controller.reqhandler.commands;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Yuliia Tesliuk on 11/07/2018
 */
public class ConstructorCommand extends Command {
    @Override
    public void process() throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/constructor.jsp").forward(req,resp);
    }
}
