package edu.orangecoastcollege.cs273.ttran1272.candystoreapp;

/**
 * Created by AnhTran on 10/19/2017.
 */

public class Candy {

    private int id;
    private String name;
    private double price;

    public Candy(int newId, String newName, double newPrice) {
        setId(newId);
        setName(newName);
        setPrice(newPrice);
    }

    public int getId() {
        return id;
    }

    public void setId(int newId) {
        id = newId;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        if (newPrice >= 0.0)
            price = newPrice;
    }

    public String toString() {
        return id + " " + name + " " + price;
    }
}
