package com.example.mcdonalds;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class ReportProblem extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Button done=(Button)findViewById(R.id.done);
        final CheckBox checkBox=(CheckBox)findViewById((R.id.checkbox5));
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               clickFunction(checkBox);
            }
        });


        final CheckBox checkBox4=(CheckBox)findViewById((R.id.checkbox4));
        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickFunction(checkBox4);
            }
        });



        final CheckBox checkBox3=(CheckBox)findViewById((R.id.checkbox3));
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickFunction(checkBox3);
            }
        });



        final CheckBox checkBox2=(CheckBox)findViewById((R.id.checkbox2));
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickFunction(checkBox2);
            }
        });


        final CheckBox checkBox1=(CheckBox)findViewById((R.id.checkbox1));
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickFunction(checkBox1);
            }
        });







    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }

    // set a boolean value
    private boolean firstImageShown = true;


    public void clickFunction(View view) {


        CheckBox button = (CheckBox) findViewById(R.id.checkbox5);
        Button done=(Button)findViewById(R.id.done);

        if ((button != null) && (firstImageShown)) {
            done.setBackgroundColor(Color.parseColor("#ED5A6B"));
            firstImageShown = false;
        } else {
            if (button != null)  done.setBackgroundColor(Color.parseColor("#D6D7D7"));
            firstImageShown = true;
        }

    }
}
