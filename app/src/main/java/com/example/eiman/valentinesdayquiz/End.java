package com.example.eiman.valentinesdayquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Eiman on 2/25/2018.
 */

public class End extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        TextView ideal_date = (TextView) findViewById(R.id.response);

       if(Questions.score < 20) {
           ideal_date.setText("Your ideal date is at home with your loved one.");
       }
       else if (Questions.score < 40){
           ideal_date.setText("Your ideal date is a picnic at a park with your loved one.");
       }
       else if (Questions.score <60){
           ideal_date.setText("Your ideal date is dinner on a rooftop with your loved one. ");
       }
       else{
            ideal_date.setText("Your ideal date is by yourself doing whatever you want!");
       }
    }
}
