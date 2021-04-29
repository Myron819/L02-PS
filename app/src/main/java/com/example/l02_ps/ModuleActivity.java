package com.example.l02_ps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ModuleActivity extends AppCompatActivity {


    DailyAdapter dailyAdapter;
    ArrayList<DailyCA> dailyArrayList;
    Button btnEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);

        Intent intent = getIntent();
        Module module = (Module) intent.getSerializableExtra("module");

        ListView lvDG = findViewById(R.id.lvDG);
        Button btnInfo = findViewById(R.id.btnInfo);
        btnEmail = findViewById(R.id.btnEmail);
        Button btnAddWeek = findViewById(R.id.btnAddWeek);


        dailyArrayList = new ArrayList<>();
        dailyArrayList.add(new DailyCA("A", 1));
        dailyArrayList.add(new DailyCA("B", 2));
        dailyArrayList.add(new DailyCA("C", 3));
        dailyArrayList.add(new DailyCA("D", 4));
        dailyArrayList.add(new DailyCA("F", 5));
        dailyArrayList.add(new DailyCA("X", 6));


        dailyAdapter = new DailyAdapter(this, R.layout.info_activity, dailyArrayList);
        lvDG.setAdapter(dailyAdapter);

        btnInfo.setOnClickListener(v -> {
            Intent rpIntent = new Intent(Intent.ACTION_VIEW);
            rpIntent.setData(Uri.parse("https://www.rp.edu.sg/soi/full-time-diplomas/details/diploma-in-digital-design-and-development"));
            startActivity(rpIntent);
        });

        btnEmail.setOnClickListener(v -> {
            Intent btnEmail = new Intent(Intent.ACTION_SEND);
            btnEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});

            String emailOutput = "";

            for (DailyCA dca : dailyArrayList) {
                emailOutput += "Week " + dca.getWeek() + ": DG: " + dca.getDgGrade() + "\n";
                btnEmail.putExtra(Intent.EXTRA_TEXT, emailOutput);
            }


            btnEmail.setType("message/rfc822");
            startActivity(Intent.createChooser(btnEmail, "Choose an btnEmail client :"));
        });

        btnAddWeek.setOnClickListener(v -> {
            Intent i = new Intent(ModuleActivity.this, AddActivity.class);
            int weekNumber = dailyArrayList.size();


            i.putExtra("weekNumber", weekNumber);
            startActivityForResult(i, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (data != null) {
                int week = data.getIntExtra("week", 0);
                String grade = data.getStringExtra("grade");
                dailyArrayList.add(new DailyCA(grade, week));

                dailyAdapter.notifyDataSetChanged();
            }

        }

    }
}