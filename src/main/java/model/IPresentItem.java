package model;


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
}
