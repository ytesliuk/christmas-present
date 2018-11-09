package com.present.controller.reqhandler.commands;

import com.present.model.entities.present_items.IPresentItem;
import com.present.model.entities.presents.Present;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Yuliia Tesliuk on 11/07/2018
 */
public class SortCommand extends Command {

    @Override
    public void process() throws ServletException, IOException {
        Present present = (Present) session.getAttribute("present");

        List<Map.Entry<IPresentItem, Integer>> sortedPresent = sort(present.getPackagedPresent());

        session.setAttribute("presentContent", sortedPresent);
        req.setAttribute("weight", present.getWeight());
        req.getRequestDispatcher("/WEB-INF/view/present.jsp").forward(req, resp);
    }

    private List<Map.Entry<IPresentItem, Integer>> sort(Map<IPresentItem, Integer> packagedPresent){
        String sortCriteria = req.getParameter("sort");

        return packagedPresent.entrySet().stream()
                .sorted(Comparator.comparing(x ->
                        (sortCriteria.equals("sortByQTY")) ? x.getValue() :
                        (sortCriteria.equals("sortByWeight")) ? x.getKey().getWeight() :
                        (sortCriteria.equals("sortByPrice")) ? x.getKey().getPrice() :
                        (sortCriteria.equals("sortBySugarContent")) ? (int)(x.getKey().getSugarContent() * 100) :
                         x.getKey().getName().charAt(0),Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }
}
