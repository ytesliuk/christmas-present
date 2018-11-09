package com.present.model.entities.present_items;

/**
 * Implementing this interface allows an object to be included into a present.
 */
public interface IPresentItem{
    /**
     * return weight of a single item in the present
     * @return weight of a single item in the present
     */
    int getWeight();

    /**
     * return price of a single item in the present
     * @return price of a single item in the present
     */
    int getPrice();

    String getName();

    /**
     * return sugar content in a single item in the present
     * @return sugar content in a single item in the present
     */
    default double getSugarContent(){
        return 0;
    }

}
