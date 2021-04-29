package com.example.l02_ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class ActivityAddGrade extends AppCompatActivity {
    TextView tvWeek;
    RadioButton rbA, rbB, rbC, rbD, rbF, rbX;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grade);

        Intent i = getIntent();

        Grade markgrade = (Grade) i.getSerializableExtra("grade");


        tvWeek = findViewById(R.id.textViewWeek);
        rbA = findViewById(R.id.radioButtonA);
        rbB = findViewById(R.id.radioButtonB);
        rbC = findViewById(R.id.radioButtonC);
        rbD = findViewById(R.id.radioButtonD);
        rbF = findViewById(R.id.radioButtonF);
        rbX = findViewById(R.id.radioButtonX);
        btnSubmit = findViewById(R.id.buttonSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                //Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("dg", 'a');
                i.putExtra("dg", 'b');
                i.putExtra("dg", 'c');
                i.putExtra("dg", 'd');
                i.putExtra("dg", 'f');
                i.putExtra("dg", 'x');
                setResult(RESULT_OK, i);
                finish();
            }});

    }
}