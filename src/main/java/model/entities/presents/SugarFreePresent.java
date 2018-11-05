package model.entities.presents;

import model.entities.present_containers.Box;
import model.entities.present_items.IPresentItem;
import model.entities.present_items.Sweety;

/**
 * Created by Yuliia Tesliuk on 11/01/2018
 */
public class SugarFreePresent extends Present {


    public SugarFreePresent(int weight){
        this.container = new Box(weight);
    }

    @Override
    public boolean addToPresent(IPresentItem item, int number) {
        if(isSugarFree(item) && this.hasEnoughSpace(item,number)) {
            this.packagedPresent.put(item,number);
            this.weight += item.getWeight() * number;
            return true;
        }
        return false;
    }

    private boolean isSugarFree(IPresentItem item){
        if (item instanceof Sweety) {
            return ((Sweety) item).getSugarContent() > 0;
        } else return false;
    }
}
