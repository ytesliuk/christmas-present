package com.present.model.entities.presents;

import com.present.controller.util.CollectionsUtil;
import javafx.util.Pair;
import com.present.model.entities.present_containers.Box;
import com.present.model.entities.present_items.IPresentItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * Present where present collection is provided externally
 */
public class CustomPresent extends Present {

    public CustomPresent(){
        this.container = new Box(weight);
    }

    /**
     * create present collection from a provided list by grouping identical items.
     * is null free
     * @param presentItems
     * @see com.present.controller.util.CollectionsUtil#nullFreeList(List)
     */
    @Override
    public void createPresent(List<IPresentItem> presentItems) {
        List<IPresentItem> filteredList = CollectionsUtil.nullFreeList(presentItems);
        packagedPresent = filteredList
                        .stream()
                        .collect(Collectors.groupingBy(x -> x,Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue().intValue()));
    }

    /**
     * create present collection from a provided map.
     * present collection is null free and has zero values
     * @param presentItems
     * @see com.present.controller.util.CollectionsUtil#nullFreeMap(Map)
     * @see com.present.controller.util.CollectionsUtil#filledMap(Map)
     */
    @Override
    public void createPresent(Map<IPresentItem, Integer> presentItems) {
        Map<IPresentItem, Integer> nullFreeMap = CollectionsUtil.nullFreeMap(presentItems);
        packagedPresent = CollectionsUtil.filledMap(nullFreeMap);
    }
}

