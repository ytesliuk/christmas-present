package model.entities.presents;

import model.entities.present_containers.IPresentContainer;
import model.entities.present_items.IPresentItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yuliia Tesliuk on 11/01/2018
 */
public abstract class Present<T,V> {
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

    public abstract T createPresent(List<V> presentItems);

    protected boolean addToPresent(IPresentItem item, int number) {
        if(this.hasEnoughSpace(item,number)) {
            this.packagedPresent.put(item,packagedPresent.getOrDefault(item,0) + number);
            this.weight += item.getWeight() * number;
            return true;
        }
        return false;
    }

}
