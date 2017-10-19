package edu.orangecoastcollege.cs273.ttran1272.candystoreapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity {

    private DatabaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        updateView();
    }

    // Build a View dynamically with all the candies
    public void updateView() {
        ArrayList<Candy> candies = dbManager.selectAll();
        RelativeLayout layout = new RelativeLayout( this );
        ScrollView scrollView = new ScrollView( this );
        RadioGroup group = new RadioGroup( this );

        for (Candy candy : candies ){
            RadioButton rb = new RadioButton( this );
            rb.setId(candy.getId());
            rb.setText(candy.toString());

            group.addView(rb);
        }

        // set up event handling
        RadioButtonHandler rbh = new RadioButtonHandler();
        group.setOnCheckedChangeListener(rbh);

        // create a back button
        Button backButton = new Button( this );
        backButton.setText(R.string.button_back);
        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                DeleteActivity.this.finish();
            }
        });

        scrollView.addView(group);
        layout.addView(scrollView);
    }

    private class RadioButtonHandler implements RadioGroup.OnCheckedChangeListener{
        public void onCheckedChanged( RadioGroup group, int checkId) {

            // delete candy from database
            dbManager.deleteById(checkId);
            Toast.makeText(DeleteActivity.this, "Candy deleted", Toast.LENGTH_SHORT).show();

            // update screen
            updateView();
        }
    }

}
