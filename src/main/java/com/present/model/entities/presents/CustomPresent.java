package com.present.model.entities.presents;

import javafx.util.Pair;
import com.present.model.entities.present_containers.Box;
import com.present.model.entities.present_items.IPresentItem;

import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

/**
 * Created by Yuliia Tesliuk on 11/02/2018
 */
public class CustomPresent extends Present {


    public CustomPresent(){
        this.container = new Box(weight);
    }


    @Override
    public void createPresent(List<IPresentItem> presentItems) {

    }

    @Override
    public void createPresent(Map<IPresentItem, Integer> presentItems) {
        packagedPresent = presentItems;
        weight = packagedPresent.entrySet().stream()
                .map(x -> x.getKey().getWeight() * x.getValue())
                .reduce((x,y) -> x+y)
                .orElse(0);
    }
}

