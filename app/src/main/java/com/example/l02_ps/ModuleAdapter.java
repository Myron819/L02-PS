package com.example.l02_ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// Done by Shufang
public class ModuleAdapter extends ArrayAdapter<Module> {

    private final ArrayList<Module> moduleArrayList;
    private final Context context;


    public ModuleAdapter(Context context, int resource, ArrayList<Module> objects) {
        super(context, resource, objects);
        moduleArrayList = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.module_row, parent, false);

        TextView tvModuleCode = rowView.findViewById(R.id.tvModuleCode);
        TextView tvModuleName = rowView.findViewById(R.id.tvModuleName);

        tvModuleCode.setText(moduleArrayList.get(position).getModuleCode());
        tvModuleName.setText(moduleArrayList.get(position).getModuleName());
        return rowView;
    }
}