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

public class Himachal extends AppCompatActivity {

    TextView t1, t2;
    Button b1, b2;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_himachal_test);

        toolbar = findViewById(R.id.himachalTestToolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Test Centers");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        t1 = findViewById(R.id.t1);
        b1 = findViewById(R.id.b1);
        t2 = findViewById(R.id.t2);
        b2 = findViewById(R.id.b2);


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