package com.present.model.entities.present_items;

import java.lang.reflect.Method;

/**
 * Created by Yuliia Tesliuk on 11/01/2018
 */

public class Sweety implements IPresentItem {
    private int id;
    private String name;
    private int weight;
    private double sugarContent;
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
    public void setID(int id) {
        StackTraceElement element = Thread.currentThread().getStackTrace()[2];

        try {
            Class callerClazz = Class.forName(element.getClassName());
            String methodName = element.getMethodName();
            for (Method m : callerClazz.getDeclaredMethods()){
                if (m.getName().equals(methodName) && m.isAnnotationPresent(IDSetter.class)) {
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

    public double getPriceUAH(){
        return ((double) getPrice()) / 100;
    }

    @Override
    public String toString() {
        return "Sweety{" + "id=" + id + ", name='" + name + '\'' + ", weight=" + weight + ", sugarContent=" + sugarContent + ", price=" + price + '}';
    }

}
