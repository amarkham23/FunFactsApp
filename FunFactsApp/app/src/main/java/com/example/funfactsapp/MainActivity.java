package com.example.funfactsapp;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActvity";
    private FactBook factBook = new FactBook();
    private ColorWheel colorWheel = new ColorWheel();

    // Declare View Variables
    private TextView header;
    private TextView factText;
    private Button factButton;
    private ConstraintLayout mainLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link View Variables
        mainLayout = findViewById(R.id.main_Screen_Layout);
        header = findViewById(R.id.header_tv);
        factText = findViewById(R.id.presented_fact_tv);
        factButton = findViewById(R.id.new_fact_btn);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fact = factBook.getFact();

                factText.setText(fact);

                int colorPicked = colorWheel.getColor();
                mainLayout.setBackgroundColor(colorPicked);
                factButton.setTextColor(colorPicked);

            }
        };
        factButton.setOnClickListener(listener);

        Toast.makeText(this, "What's Up Dood", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", "Logging from the OnCreate Method!");
    }


}
