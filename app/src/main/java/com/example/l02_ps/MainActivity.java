package com.example.l02_ps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvModule;
    ArrayList<Module> al;
    ModuleAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvModule = findViewById(R.id.lvModule);

        al = new ArrayList<>();
        al.add(new Module("C302", "Web Service"));
        al.add(new Module("C347", "Android Programming II"));


        aa = new ModuleAdapter(this, R.layout.module_row, al);
        lvModule.setAdapter(aa);

        lvModule.setOnItemClickListener((parent, view, position, id) -> {

            Intent intent = new Intent(MainActivity.this, ModuleActivity.class);
            intent.putExtra("module", al.get(position));
            startActivity(intent);

        });


    }
}