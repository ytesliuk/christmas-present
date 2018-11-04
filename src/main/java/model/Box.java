package model;

/**
 * Created by Yuliia Tesliuk on 11/01/2018
 */
public class Box implements IPresentContainer {
    private int maxWeight;
    // private int utilizedWeight;   -?

    public Box(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public int getMaxWeight() {
        return maxWeight;
    }
    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

}
