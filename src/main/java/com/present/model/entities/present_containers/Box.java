package com.present.model.entities.present_containers;


/**
 * A form of container for present items
 */
public class Box implements IPresentContainer{
    /**
     * Maximum weight which a particular box can hold
     */
    private int maxWeight;
    // private int utilizedWeight;   -?

    public Box(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public int getMaxWeight() {
        return maxWeight;
    }


}
