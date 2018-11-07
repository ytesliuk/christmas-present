package com.present.controller.servlets.commands;

import com.present.model.entities.present_items.IPresentItem;
import com.present.model.entities.present_items.Sweety;
import com.present.model.jdbc.DBConnection;
import com.present.model.jdbc.PresentItemDAO;
import com.present.model.jdbc.SweetyDAO;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yuliia Tesliuk on 11/07/2018
 */
public class AddSweetyCommand extends Command {

    @Override
    public void process() throws ServletException, IOException {
        itemDAO = new SweetyDAO(db.getConnection());

        String name = req.getParameter("name");
        int weight = Integer.parseInt(req.getParameter("weight"));
        double sugarContent = Double.parseDouble(req.getParameter("sugarContent"));
        int price = (int) (Double.parseDouble(req.getParameter("price")) * 100);

        Sweety newSweety = new Sweety(name, weight, sugarContent, price);
        System.out.println(itemDAO.create(newSweety));

        sweeties = (List<IPresentItem>) session.getAttribute("sweeties");
        sweeties.add(newSweety);
        session.setAttribute("sweeties",sweeties);
        //req.setAttribute("sweeties",sweeties);

        try {
            req.getRequestDispatcher("/WEB-INF/view/constructor.jsp").forward(req, resp); ;
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
