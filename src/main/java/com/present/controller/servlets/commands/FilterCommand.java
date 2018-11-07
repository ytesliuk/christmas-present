package com.present.controller.servlets.commands;

import com.present.controller.util.Util;
import com.present.model.entities.present_items.IPresentItem;
import com.present.model.entities.present_items.Sweety;
import com.present.model.jdbc.DBConnection;
import com.present.model.jdbc.PresentItemDAO;
import com.present.model.jdbc.SweetyDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Yuliia Tesliuk on 11/07/2018
 */
public class FilterCommand extends Command {

    @Override
    public void process() throws ServletException, IOException {
        itemDAO = new SweetyDAO(db.getConnection());
        sweeties = itemDAO.readAll().stream().map(x -> (IPresentItem) x).collect(Collectors.toList());
        double minSugar = Util.stringToDouble(req.getParameter("minSugar"),0);
        double maxSugar = Util.stringToDouble(req.getParameter("maxSugar"),Integer.MAX_VALUE);
        int minWeight = Util.stringToInt(req.getParameter("minWeight"),0);
        int maxWeight = Util.stringToInt(req.getParameter("maxWeight"),Integer.MAX_VALUE);
        int minPrice = (int) (Util.stringToDouble(req.getParameter("minPrice"),0) * 100);
        int maxPrice = (int) (Util.stringToDouble(req.getParameter("maxPrice"),Integer.MAX_VALUE) * 100);
        List<IPresentItem> filteredSweeties = sweeties
                .stream()
                .filter(x -> (Util.isWithinBounds(x.getSugarContent(),minSugar,maxSugar) &&
                        Util.isWithinBounds(x.getWeight(),minWeight,maxWeight) &&
                        Util.isWithinBounds(x.getPrice(),minPrice,maxPrice)))
                .collect(Collectors.toList());


        session.setAttribute("sweeties", filteredSweeties);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/constructor.jsp");
        rd.forward(req, resp);
    }
}
