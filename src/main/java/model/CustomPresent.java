package model;

/**
 * Created by Yuliia Tesliuk on 11/02/2018
 */
public class CustomPresent extends Present {


    public CustomPresent(int weight){
        this.container = new Box(weight);
    }

    @Override
    public boolean addToPresent(IPresentItem item, int number) {
        if(isEnoughSpace(item,number)) {
            this.present.put(item,number);
            this.weight += item.getWeight() * number;
            return true;
        }
        return false;
    }
}
