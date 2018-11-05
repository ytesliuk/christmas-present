package model.entities.presents;

import model.entities.present_containers.IPresentContainer;
import model.entities.present_items.IPresentItem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuliia Tesliuk on 11/01/2018
 */
public abstract class Present {
    protected int weight;
    protected IPresentContainer container;
    protected Map<IPresentItem,Integer> packagedPresent = new HashMap<>();

    public int getWeight(){
        return weight;
    }

    protected boolean hasEnoughSpace(IPresentItem item, int number){
        return (this.weight + item.getWeight() * number) <= container.getMaxWeight();
    }

    public abstract boolean addToPresent(IPresentItem item, int number);

}
