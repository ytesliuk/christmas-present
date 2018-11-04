package model;

/**
 * Created by Yuliia Tesliuk on 11/01/2018
 */
public class Sweety implements IPresentItem {
    private String name;
    private int weight;
    private int sugarContent;


    public Sweety(String name, int weight, int sugarContent) {
        this.name = name;
        this.weight = weight;
        this.sugarContent = sugarContent;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getSugarContent() {
        return sugarContent;
    }
    public void setSugarContent(int sugarContent) {
        this.sugarContent = sugarContent;
    }
}
