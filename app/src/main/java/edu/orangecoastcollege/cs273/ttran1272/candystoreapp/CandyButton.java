package edu.orangecoastcollege.cs273.ttran1272.candystoreapp;

import android.content.Context;
import android.widget.Button;

/**
 * Created by AnhTran on 10/19/2017.
 */

public class CandyButton extends Button{
    private Candy candy;

    public CandyButton(Context context, Candy newCandy) {
        super(context);
        candy = newCandy;
    }

    public double getPrice() {
        return candy.getPrice();
    }
}
