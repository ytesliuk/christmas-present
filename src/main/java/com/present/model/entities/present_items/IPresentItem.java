package com.present.model.entities.present_items;


/**
 * Implementing this interface allows an object to be included into a present.
 */
public interface IPresentItem{
    /**
     * return the weight of a single item in the present
     * @return weight of a single item in the present
     */
    int getWeight();

    /**
     * return the price of a single item in the present
     * @return price of a single item in the present
     */
    int getPrice();

    String getName();

    default double getSugarContent(){
        return 0;
    }

}