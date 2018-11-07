package com.present.model.entities.presents;

import com.present.model.entities.present_containers.IPresentContainer;
import com.present.model.entities.present_items.IPresentItem;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yuliia Tesliuk on 11/01/2018
 */
public abstract class Present {
    public static final int DEFAULT_WEIGHT = 500;
    protected int weight;
    protected IPresentContainer container;
    protected Map<IPresentItem,Integer> packagedPresent = new HashMap<>();

    public int getWeight(){
        return weight;
    }

    public Map<IPresentItem, Integer> getPackagedPresent() {
        return packagedPresent;
    }

    protected boolean hasEnoughSpace(IPresentItem item, int number){
        return (this.weight + item.getWeight() * number) <= container.getMaxWeight();
    }

    public abstract void createPresent(List<IPresentItem> presentItems);

    public abstract void createPresent(Map<IPresentItem,Integer> presentItems);


    protected boolean addToPresent(IPresentItem item, int number) {
        if(this.hasEnoughSpace(item,number)) {
            this.packagedPresent.put(item,packagedPresent.getOrDefault(item,0) + number);
            this.weight += item.getWeight() * number;
            return true;
        }
        return false;
    }

}
