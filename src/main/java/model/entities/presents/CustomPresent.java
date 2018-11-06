package model.entities.presents;

import javafx.util.Pair;
import model.entities.present_containers.Box;
import model.entities.present_items.IPresentItem;

import java.util.List;
import java.util.Map;

/**
 * Created by Yuliia Tesliuk on 11/02/2018
 */
public class CustomPresent extends Present<CustomPresent, Pair<IPresentItem,Integer>> {


    public CustomPresent(){
        this.container = new Box(weight);
    }


    @Override
    public CustomPresent createPresent(List<Pair<IPresentItem,Integer>> list) {

        return this;
    }
}
