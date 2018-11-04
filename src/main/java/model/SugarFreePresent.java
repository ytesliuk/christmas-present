package model;

/**
 * Created by Yuliia Tesliuk on 11/01/2018
 */
public class SugarFreePresent extends Present {


    public SugarFreePresent(int weight){
        this.container = new Box(weight);
    }

    @Override
    public boolean addToPresent(IPresentItem item, int number) {
        if(isSugarFree(item) && isEnoughSpace(item,number)) {
            this.present.put(item,number);
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
