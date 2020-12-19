package com.example.mcdonalds;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends ArrayAdapter<food> {

    public FoodAdapter(Activity context, ArrayList<food> foods) {
        super(context, 0, foods);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.order_list, parent, false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        food f = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView FoodTextView = (TextView) listItemView.findViewById(R.id.food_name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        FoodTextView.setText(f.getFoodTitle());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView Rate = (TextView) listItemView.findViewById(R.id.rate);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        Rate.setText(f.getRate());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView specs = (TextView) listItemView.findViewById(R.id.specs);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        specs.setText(f.getSpecs());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.icon_item);
        iconView.setImageResource(f.getImage());



        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}



