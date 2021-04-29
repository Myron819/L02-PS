package com.example.l02_ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DailyAdapter extends ArrayAdapter<DailyCA> {

    private ArrayList<DailyCA> dailyCA;
    private Context context;


    public DailyAdapter(Context context, int resource, ArrayList<DailyCA> objects) {
        super(context, resource, objects);
        dailyCA = objects;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.info_row, parent, false);

        TextView tvWeekNumber = rowView.findViewById(R.id.tvWeekNumber);
        TextView tvDGLetter = rowView.findViewById(R.id.tvDGLetter);

        DailyCA currentCA = dailyCA.get(position);
        tvWeekNumber.setText("Week: " + (position + 1));
        tvDGLetter.setText(currentCA.getDgGrade());

        return rowView;
    }
}