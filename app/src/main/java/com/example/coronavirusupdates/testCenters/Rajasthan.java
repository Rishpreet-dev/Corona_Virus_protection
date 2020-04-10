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

public class Rajasthan extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6;
    Button b1,b2,b3,b4,b5,b6;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajasthan_test);

        toolbar = findViewById(R.id.rajasthanTestToolbar);
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
