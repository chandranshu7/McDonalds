package com.example.mcdonalds;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class order extends AppCompatActivity {

int quantity=0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.order_main_activity);


        // Create a list of foods
        final ArrayList<food> foods = new ArrayList<food>();
        foods.add(new food("McAloo Tikki™ Burger", "₹44", "A tikki delight: Potato and peas patty topped with veg sauce, ketchup, tomatoes and onions with toasted buns. ",R.drawable.mcalootikki));
        foods.add(new food("McSpicy Paneer™ Burger", "₹149","Crispy and spicy paneer patty with creamy tandoori sauce and crispy lettuce topping. ", R.drawable.mcspicypaneer
               ));
        foods.add(new food("McSpicy Chicken™ Burger", "₹159", "Juicy Chicken meat coated in crispy batter with a kick of spice topped with a creamy sauce and crispy lettuce. ",R.drawable.mcspicychicken
                ));
        foods.add(new food("McSpicy Paneer™ Wrap", "₹179","Tender paneer patty with a fiery, crunchy batter coating, dressed with fresh veggies and seasonings, topped with creamy sauce and a dash of mustard and melted cheese ", R.drawable.paneerwrap));
        foods.add(new food("Pizza McPuff", "₹31","Blend of assorted vegetables [carrot, beans, capsicum, onion and green peas], mozzarella cheese mixed with tomato sauce and exotic spices stuffed in rectangle shaped savoury dough. "
                , R.drawable.mcpuff));
        foods.add(new food("McVeggie™ Double Patty Extra Value Meal", "₹234","Save ₹40 on combo of your favourite burger with fries [M] and beverage ... more. ", R.drawable.mcveggiemeal));
        foods.add(new food("Shake Shake Fries [Piri Piri]", "₹99.05","The perfect, taste bud tingling partner for our world-famous fries. Shake shake, and dive in! ", R.drawable.periperifries));
        foods.add(new food("Cold Coffee", "₹64", R.drawable.coldcoffee));
        foods.add(new food("Coke", "₹59", R.drawable.coke));
        foods.add(new food("McFlurry™ Oreo", "₹77", R.drawable.mcflurryoreo));




        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        FoodAdapter adapter = new FoodAdapter(this,foods);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView)findViewById(R.id.list_order);

listView.setAdapter(adapter);


    }



     public void minus(View view) {

     LinearLayout parentRow = (LinearLayout) view.getParent();

     TextView quantityView = (TextView) parentRow.findViewById(R.id.count);
     String quantityString = quantityView.getText().toString();
     quantity = Integer.parseInt(quantityString);
     quantity -= 1;

     if (quantity < 0) {
     quantity = 0;
     Toast.makeText(order.this, "Can not be less than 0",
     Toast.LENGTH_SHORT).show();}
     quantityView.setText(String.valueOf(quantity));
     }
     public void add(View view) {

     LinearLayout parentRow = (LinearLayout) view.getParent();

     TextView quantityView = (TextView) parentRow.findViewById(R.id.count);
     String quantityString = quantityView.getText().toString();
     quantity = Integer.parseInt(quantityString);
     quantity += 1;
     quantityView.setText(String.valueOf(quantity));
     }}