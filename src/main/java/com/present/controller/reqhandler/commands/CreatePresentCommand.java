package com.present.controller.reqhandler.commands;


import com.present.controller.util.NumberUtil;
import com.present.model.entities.present_items.IPresentItem;
import com.present.model.entities.presents.CustomPresent;
import com.present.model.entities.presents.Present;


import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by Yuliia Tesliuk on 11/07/2018
 */
public class CreatePresentCommand extends Command {
    private Present present;

    //TODO: think how to merge GeneratePresentCommand and CreatePresentCommand

    @Override
    public void process() throws ServletException, IOException {
        present = new CustomPresent();
        items = (List<IPresentItem>) session.getAttribute("items");

        present.createPresent(convertInputData());

        session.setAttribute("present",present);
        session.setAttribute("presentContent", present.getPackagedPresent().entrySet());
        session.setAttribute("weight", present.getWeight());
        session.setAttribute("price", present.getPrice());

        req.getRequestDispatcher("/WEB-INF/view/present.jsp").forward(req, resp);
    }

    private Map<IPresentItem,Integer> convertInputData(){

        Map<String,String> receivedPresentMap = req.getParameterMap().entrySet()
                .stream()
                .filter(x-> x.getValue().length == 1 )
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()[0]));

        Map<IPresentItem,Integer> presentItems = new HashMap<>();

        for (IPresentItem item : items) {
            int itemNumber = NumberUtil.stringToInt(receivedPresentMap.get(item.getName()),0);
            if (receivedPresentMap.containsKey(item.getName()) && itemNumber > 0){
                presentItems.put(item, itemNumber);
            }
        }

        return presentItems;
    }

}
