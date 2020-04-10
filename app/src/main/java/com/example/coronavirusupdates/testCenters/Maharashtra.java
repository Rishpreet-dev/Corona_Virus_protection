package com.example.coronavirusupdates.testCenters;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.coronavirusupdates.R;

public class Maharashtra extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maharashtra_test);

        toolbar = findViewById(R.id.maharashtraTestToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Test Centers");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        t1=findViewById(R.id.t1);
        b1=findViewById(R.id.b1);
        t2=findViewById(R.id.t2);
        b2=findViewById(R.id.b2);

        t3=findViewById(R.id.t3);
        b3=findViewById(R.id.b3);
        t4=findViewById(R.id.t4);
        b4=findViewById(R.id.b4);
        t5=findViewById(R.id.t5);
        b5=findViewById(R.id.b5);
        t6=findViewById(R.id.t6);
        b6=findViewById(R.id.b6);
        t7=findViewById(R.id.t7);
        b7=findViewById(R.id.b7);

        t8=findViewById(R.id.t8);
        b8=findViewById(R.id.b8);
        t9=findViewById(R.id.t9);
        b9=findViewById(R.id.b9);

        t10=findViewById(R.id.t10);
        b10=findViewById(R.id.b10);
        t11=findViewById(R.id.t11);
        b11=findViewById(R.id.b11);

        t12=findViewById(R.id.t12);
        b12=findViewById(R.id.b12);
        t13=findViewById(R.id.t13);
        b13=findViewById(R.id.b13);
        t14=findViewById(R.id.t14);
        b14=findViewById(R.id.b14);

        t15=findViewById(R.id.t15);
        b15=findViewById(R.id.b15);
        t16=findViewById(R.id.t16);
        b16=findViewById(R.id.b16);

        t17=findViewById(R.id.t18);
        b17=findViewById(R.id.b18);
        t18=findViewById(R.id.t19);
        b18=findViewById(R.id.b19);

        t19=findViewById(R.id.t20);
        b19=findViewById(R.id.b20);

        t20=findViewById(R.id.t21);
        b20=findViewById(R.id.b21);

        t21=findViewById(R.id.t22);
        b21=findViewById(R.id.b22);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t1.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t2.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t3.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t4.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t5.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t6.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t7.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t8.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t9.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t10.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t11.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t12.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });


        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t13.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t14.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t15.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t16.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t17.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t18.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });


        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t19.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t20.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = t21.getText().toString();
                location = location.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(i);

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}