package model.entities.presents;

import model.entities.present_containers.Box;
import model.entities.present_items.IPresentItem;

/**
 * Created by Yuliia Tesliuk on 11/02/2018
 */
public class CustomPresent extends Present {


    public CustomPresent(int weight){
        this.container = new Box(weight);
    }

    @Override
    public boolean addToPresent(IPresentItem item, int number) {
        if(this.hasEnoughSpace(item,number)) {
            this.packagedPresent.put(item,number);
            this.weight += item.getWeight() * number;
            return true;
        }
        return false;
    }
}
