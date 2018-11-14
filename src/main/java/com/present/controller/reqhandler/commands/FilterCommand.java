package com.present.controller.reqhandler.commands;

import com.present.controller.util.NumberUtil;
import com.present.model.entities.present_items.IPresentItem;
import com.present.model.jdbc.DaoFactory;
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
    private double minSugar, maxSugar;
    private int minWeight, maxWeight;
    private int minPrice, maxPrice;

    @Override
    public void process() throws ServletException, IOException {
        itemDAO = DaoFactory.getInstance().createSweetyDAO();
        items = itemDAO.readAll();

        List<IPresentItem> filteredItems = filter();

        session.setAttribute("items", filteredItems);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/constructor.jsp");
        rd.forward(req, resp);
    }

    private List<IPresentItem> filter(){
        extractData();
        return items.stream()
                .filter(x -> (NumberUtil.isWithinBounds(x.getSugarContent(),minSugar,maxSugar) &&
                        NumberUtil.isWithinBounds(x.getWeight(),minWeight,maxWeight) &&
                        NumberUtil.isWithinBounds(x.getPrice(),minPrice,maxPrice)))
                .collect(Collectors.toList());
    }

    private void extractData(){
        minSugar = NumberUtil.stringToDouble(req.getParameter("minSugar"),0);
        maxSugar = NumberUtil.stringToDouble(req.getParameter("maxSugar"),Integer.MAX_VALUE);
        minWeight = NumberUtil.stringToInt(req.getParameter("minWeight"),0);
        maxWeight = NumberUtil.stringToInt(req.getParameter("maxWeight"),Integer.MAX_VALUE);
        minPrice = (int) (NumberUtil.stringToDouble(req.getParameter("minPrice"),0) * 100);
        maxPrice = (int) (NumberUtil.stringToDouble(req.getParameter("maxPrice"),Integer.MAX_VALUE) * 100);
    }
}
