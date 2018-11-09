package com.present.model.entities.present_items;

import com.present.controller.util.Setter;

import java.lang.reflect.Method;

import static com.present.controller.util.Constants.CENTS;

/**
 * A kind of present item
 * @see com.present.model.entities.present_items.IPresentItem
 */

public class Sweety implements IPresentItem {
    private int id;
    private String name;
    private int weight;
    private double sugarContent;

    /**
     * price in cents
     */
    private int price;


    public Sweety(String name, int weight, double sugarContent, int price) {
        this.name = name;
        this.weight = weight;
        this.sugarContent = sugarContent;
        this.price = price;
    }

    public int getID() {
        return this.id;
    }

    /**
     * Set the object's ID only if the invocing method has {@code  @Setter} annotation
     * @param id the value to be set to ID field
     * @see com.present.controller.util.Setter
     */
    public void setID(int id) {
        StackTraceElement element = Thread.currentThread().getStackTrace()[2];  //TODO: check the stack trace paths

        try {
            Class callerClazz = Class.forName(element.getClassName());
            String methodName = element.getMethodName();
            for (Method m : callerClazz.getDeclaredMethods()){
                if (m.getName().equals(methodName) && m.isAnnotationPresent(Setter.class)) {
                    this.id = id;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public double getSugarContent() {
        return sugarContent;
    }
    public void setSugarContent(int sugarContent) {
        this.sugarContent = sugarContent;
    }
    @Override
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * transform the value in cents into banknote equivalent
     * @return price in banknote equivalent
     */
    public double getPriceUAH(){
        return ((double) getPrice()) / CENTS;
    }

    @Override
    public String toString() {
        return "Sweety{" + "id=" + id + ", name='" + name + '\'' + ", weight=" + weight + ", sugarContent=" + sugarContent + ", price=" + price + '}';
    }

}
