package edu.orangecoastcollege.cs273.ttran1272.candystoreapp;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity {

    DatabaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        //setContentView(R.layout.activity_update);
        updateView();
    }

    public void updateView() {
        ArrayList<Candy> candies = dbManager.selectAll();
        if(candies.size() > 0 )
        {
            // Create ScrollView and GridLayout
            ScrollView scrollView = new ScrollView(this);
            GridLayout grid = new GridLayout(this);
            grid.setRowCount(candies.size());
            grid.setColumnCount( 4 );

            // Create arrays of components
            TextView [] ids = new TextView[candies.size()];
            EditText [] [] namesAndPrices = new EditText[candies.size()][2];
            Button [] buttons = new Button[candies.size()];
            ButtonHandler bh = new ButtonHandler();

            // Retrieve width of screen
            Point size = new Point();
            int width = size.x;

            int i = 0;

            for (Candy candy : candies)
            {
                // Create the TextView for the candy's id
                ids[i] = new TextView(this);
                ids[i].setGravity(Gravity.CENTER);
                ids[i].setText("" + candy.getId());

                // Create the two EditTexts for the candy's name and price
                namesAndPrices[i][0] = new EditText(this);
                namesAndPrices[i][1] = new EditText(this);

                namesAndPrices[i][0].setText(candy.getName());
                namesAndPrices[i][0].setId( 10 * candy.getId());

                namesAndPrices[i][1].setText("" + candy.getPrice());
                namesAndPrices[i][1].setInputType(InputType.TYPE_CLASS_NUMBER);
                namesAndPrices[i][1].setId( 10 * candy.getId() + 1 );

                // create the button
                buttons[i] = new Button(this);
                buttons[i].setText( " Update");
                buttons[i].setId(candy.getId());

                // Set up event handling

            }
        }
    }
}
