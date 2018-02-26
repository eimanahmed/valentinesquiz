package com.example.eiman.valentinesdayquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eiman on 2/25/2018.
 */

public class Questions extends AppCompatActivity {

    private HashMap<String, String[]> questions_map;
    public static int score;
    private TextView question;
    private Button choice_one;
    private Button choice_two;
    private Button choice_three;
    private Button choice_four;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        setUp();

        choice_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score += 5;
                setUpQuestion();
            }
        });
        choice_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score += 10;
                setUpQuestion();
            }
        });
        choice_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score += 15;
                setUpQuestion();
            }
        });
        choice_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score += 20;
                setUpQuestion();
            }
        });
    }


    private void setUp(){
        //declaring all variables
        score = 0;
        questions_map = new HashMap<String,String[]>();

        question = (TextView) findViewById(R.id.current_question);
        choice_one = (Button) findViewById(R.id.choice_one);
        choice_two = (Button) findViewById(R.id.choice_two);
        choice_three = (Button) findViewById(R.id.choice_three);
        choice_four = (Button) findViewById(R.id.choice_four);

        //can be done in many ways
        //                category                  comfort             romance               fancy             independent
        questions_map.put("meals", new String[]{"Pizza", "Caprese Sandwich", "Potatoes & Steak", "Lemon Garlic Pasta"});
        questions_map.put("outfits", new String[]{"Sweatpants", "Sun Dress", "Lace Dress", "Pants and a Tee"});
        questions_map.put("times of day", new String[]{"Night", "Morning", "Evening", "Afternoon"});
        questions_map.put("movies", new String[]{"Princess Bride", "The Notebook", "Lady & The Tramp", "Wonder Woman"});

        setUpQuestion();

    }

    private void setUpQuestion(){

        if(questions_map.isEmpty()){
            Intent next_page = new Intent(this, End.class);
            startActivity(next_page);
        }

        String[] list;
        String entry_storage = "";
        try{
        for (Map.Entry<String, String[]> entry : questions_map.entrySet()) {
            list = entry.getValue();
            entry_storage = entry.getKey();
            question.setText("Choose one of the following " + entry_storage);
            choice_one.setText(list[0]);
            choice_two.setText(list[1]);
            choice_three.setText(list[2]);
            choice_four.setText(list[3]);
        }
            questions_map.remove(entry_storage);
        }
        catch (Exception e){
            Log.d("There was a problem" , e.toString());
        }

    }
}
