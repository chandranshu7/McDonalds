package com.example.mcdonalds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

public class IosAdapter extends SectionAdapter {

    private Context context;

    public IosAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int numberOfSections() {
        return 4; //return the total number of headers
    }

    @Override
    public int numberOfRows(int section) {
        return 5; //return the number of children for particular header
    }

    @Override
    public Object getRowItem(int section, int row) {
        return null;
    }

    @Override
    public boolean hasSectionHeaderView(int section) {
        return true;
    }

    @Override
    public View getRowView(int section, int row, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = (TextView) inflater.inflate(context.getResources().getLayout(android.R.layout.simple_list_item_1), null);
        }
        ((TextView) convertView).setText("Section " + section + " Row " + row);
        return convertView;
    }

    @Override
    public int getSectionHeaderViewTypeCount() {
        return 2;
    }

    @Override
    public int getSectionHeaderItemViewType(int section) {
        return section % 2;
    }

    @Override
    public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            if (getSectionHeaderItemViewType(section) == 0) {
                convertView = (TextView) inflater.inflate(context.getResources().getLayout(android.R.layout.simple_list_item_1), null);
            } else {
                convertView = inflater.inflate(context.getResources().getLayout(android.R.layout.simple_list_item_2), null);
            }
        }

        if (getSectionHeaderItemViewType(section) == 0) {
            ((TextView) convertView).setText("Header for section " + section);
        } else {
            ((TextView) convertView.findViewById(android.R.id.text1)).setText("Header for section " + section);
            //  ((TextView) convertView.findViewById(android.R.id.text2)).setText("Has a detail text field");
        }

        switch (section) {
            case 0:
                convertView.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                break;
            case 1:
                convertView.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                break;
            case 2:
                convertView.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                break;
            case 3:
                convertView.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                break;
        }
        return convertView;
    }

    @Override
    public void onRowItemClick(AdapterView<?> parent, View view, int section, int row, long id) {
        super.onRowItemClick(parent, view, section, row, id);
        Toast.makeText(context, "Section " + section + " Row " + row, Toast.LENGTH_SHORT).show();
    }

}
