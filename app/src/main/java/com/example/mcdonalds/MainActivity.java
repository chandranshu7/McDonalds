package com.example.mcdonalds;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    private static final int CAMERA_PERMISSION_CODE = 100;



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // disable landscape mode//
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//get rating//
        RatingBar ratingBar=(RatingBar)findViewById(R.id.DeliveryRatingBar);
        ratingBar.setNumStars(5);
        TextView textView=(TextView)findViewById(R.id.deliveryText);
                textView.setText(String.valueOf(ratingBar.getRating()));

        RatingBar ratingBar1=(RatingBar)findViewById(R.id.DiningRatingBar);
        ratingBar1.setNumStars(5);
        TextView textView1=(TextView)findViewById(R.id.dinningText);
        textView1.setText(String.valueOf(ratingBar1.getRating()));

// make text bold//
        TextView maxSafety=(TextView)findViewById(R.id.maxSAfetyLine);
        String text="This restaurant follows all Max Safety measures to ensure your food reaches you safely.";
        Spannable spannable=new SpannableString(text);
        final StyleSpan boldSpan=new StyleSpan(Typeface.BOLD);

        spannable.setSpan(boldSpan,28,47, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        maxSafety.setText(spannable);

// set open close timings
TextView textView2=(TextView)findViewById(R.id.open_close);

TextView timings=(TextView)findViewById(R.id.timings);

        Calendar c = Calendar.getInstance(); // Get current time
        int hr1 = c.get(Calendar.HOUR_OF_DAY); // Gets the current hour of the day from the calendar created ( from 1 to 24 )

        if(hr1>=11&& hr1<23)
        {
            textView2.setText("Open now - ");
            textView2.setTextColor(getResources().getColor(R.color.openNow));
            timings.setText("11am - 11pm (Today)");
        }
        else if (hr1>23 && hr1<11){
            textView2.setText("Close - ");
        }
// working call button
        ImageView call_button=(ImageView)findViewById(R.id.call_button);
        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    makePhoneCall();
                }

        });

// camera
        ImageView camera=(ImageView)findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                checkPermission(Manifest.permission.CAMERA,
                        CAMERA_PERMISSION_CODE);

                Intent camera_intent
                        = new Intent(MediaStore
                        .ACTION_IMAGE_CAPTURE);

                // Start the activity with camera_intent,
                // and request pic id
                startActivity(camera_intent);
            }
        });

    final ImageView bookmark=(ImageView)findViewById(R.id.bookmark);
    bookmark.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clickFunction(bookmark);
        }
    });

    ImageView share=(ImageView)findViewById(R.id.share);
    share.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Here is the share content body";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        }
    });

    // report button
        ImageView report=(ImageView)findViewById(R.id.report);
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), ReportProblem.class);
                startActivityForResult(myIntent, 0);
            }
        });

        // copyLocation
TextView copy=(TextView)findViewById(R.id.copy);
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Copy to Clipboard",Toast.LENGTH_SHORT).show();
            }
        });
// get directions
        TextView directions=(TextView)findViewById(R.id.directions);
        directions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://goo.gl/maps/FQETLJPhAKK8ht63A"));
                startActivity(intent);
            }
        });

        LinearLayout getDirections=(LinearLayout)findViewById(R.id.getDirections);
        getDirections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://goo.gl/maps/FQETLJPhAKK8ht63A"));
                startActivity(intent);
            }
        });


        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPagerMain);
        ViewPagerAdapter adapterView = new ViewPagerAdapter(this);
        mViewPager.setAdapter(adapterView);


        LinearLayout orderFood=(LinearLayout)findViewById(R.id.order_food);
        orderFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),order.class);
                startActivity(intent);
            }
        });


    }




// function to call
        private void makePhoneCall() {
        String number ="8360483595";
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            Toast.makeText(MainActivity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }

            if (requestCode == CAMERA_PERMISSION_CODE) {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this,
                            "Camera Permission Granted",
                            Toast.LENGTH_SHORT)
                            .show();
                }
                else {
                    Toast.makeText(MainActivity.this,
                            "Camera Permission Denied",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }


        }
    }


    // Function to check and request permission.
    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission)
                == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[] { permission },
                    requestCode);
        }

    }


    // set a boolean value
    private boolean firstImageShown = true;


    public void clickFunction(View view) {


        ImageView firstImage = (ImageView) findViewById(R.id.bookmark);

        if ((firstImage != null) && (firstImageShown)) {
            firstImage.setImageResource(R.drawable.baseline_bookmark_black_36);
            firstImageShown = false;
            Toast.makeText(MainActivity.this, "Bookmarked", Toast.LENGTH_SHORT).show();
        } else {
            if (firstImage != null) firstImage.setImageResource(R.drawable.baseline_bookmark_border_black_36);
            firstImageShown = true;
        }

    }

}