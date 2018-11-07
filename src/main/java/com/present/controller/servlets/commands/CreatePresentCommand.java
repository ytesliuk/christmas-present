package com.present.controller.servlets.commands;


import com.present.controller.util.Util;
import com.present.model.entities.present_items.IPresentItem;
import com.present.model.entities.presents.CustomPresent;
import com.present.model.entities.presents.Present;
import javafx.collections.transformation.SortedList;


import javax.servlet.ServletException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by Yuliia Tesliuk on 11/07/2018
 */
public class CreatePresentCommand extends Command {
    private Present present;

    @Override
    public void process() throws ServletException, IOException {
        present = new CustomPresent();
        sweeties = (List<IPresentItem>) session.getAttribute("sweeties");


        Map<String,String> presentMap = req.getParameterMap().entrySet()
                .stream()
                .filter(x-> x.getValue().length == 1 )
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()[0]));

        Map<IPresentItem,Integer> presentItems = new HashMap<>();

        for (IPresentItem item : sweeties) {
            int itemNumber = Util.stringToInt(presentMap.get(item.getName()),0);
            if (presentMap.containsKey(item.getName()) && itemNumber > 0){
                presentItems.put(item, itemNumber);
            }
        }

        present.createPresent(presentItems);

        session.setAttribute("present",present);
        session.setAttribute("presentContent", present.getPackagedPresent().entrySet());
        req.setAttribute("weight", present.getWeight());

        req.getRequestDispatcher("/WEB-INF/view/present.jsp").forward(req, resp);
    }
}
