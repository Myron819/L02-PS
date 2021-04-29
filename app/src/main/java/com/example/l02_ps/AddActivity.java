package com.example.l02_ps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class AddActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grade);


        TextView tvWeekNumber = findViewById(R.id.tvWeekNumber);
        RadioGroup rgDG = findViewById(R.id.rgDG);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        Intent i1 = getIntent();
        int weekNumber = i1.getIntExtra("tempWeekNumber", 0) + 1;

        tvWeekNumber.setText("Week " + (weekNumber));

        btnSubmit.setOnClickListener(v -> {

            int checkedRadioButtonId = rgDG.getCheckedRadioButtonId();
            RadioButton rb = findViewById(checkedRadioButtonId);
            Intent i2 = new Intent();

            i2.putExtra("grade", rb.getText().toString());
            i2.putExtra("week", weekNumber);
            setResult(RESULT_OK, i2);

            finish();
        });
    }
}