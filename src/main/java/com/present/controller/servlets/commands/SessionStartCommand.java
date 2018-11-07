package com.present.controller.servlets.commands;

import com.present.model.entities.present_items.IPresentItem;
import com.present.model.jdbc.SweetyDAO;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.stream.Collectors;


/**
 * Created by Yuliia Tesliuk on 11/07/2018
 */
public class SessionStartCommand extends Command {

    @Override
    public void process() throws ServletException, IOException {
        itemDAO = new SweetyDAO(db.getConnection());
        sweeties = itemDAO.readAll().stream().map(x -> (IPresentItem) x).collect(Collectors.toList());

        //req.setAttribute("sweeties",sweeties);
        session.setAttribute("sweeties",sweeties);

        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
    }
}
