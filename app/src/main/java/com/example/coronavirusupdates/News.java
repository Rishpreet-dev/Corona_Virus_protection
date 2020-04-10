package com.example.coronavirusupdates;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import com.example.coronavirusupdates.PagerAdapter.NewArrayAdapter;
import com.example.coronavirusupdates.StateUtUpdates.*;

import java.util.ArrayList;

public class News extends AppCompatActivity {

    Toolbar toolbar;

    ListView list;
    ArrayList<Spanned> states;
    NewArrayAdapter adap;
    String[] names,names2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        toolbar = findViewById(R.id.toolbar);
        list = findViewById(R.id.listView);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("State/UT wise Updates");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        names = new String[] {"Andhra Pradesh", "Arunachal Pradesh", "Assam",
                "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh",
                "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra",
                "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab",
                "Rajasthan", "Sikkim", "Tamil Nadu", "Telengana", "Tripura",
                "Uttarakhand", "Uttar Pradesh", "West Bengal"};

        names2 = new String[]{"Andaman and Nicobar Islands", "Chandigarh",
                "Dadra and Nagar Haveli and Daman & Diu", "Delhi", "Jammu & Kashmir",
                "Ladakh", "Lakshadweep", "Puducherry"};

        states = new ArrayList<>();

        states.add(Html.fromHtml("<b>States</b>"));
        for(int i=0;i<names.length;i++)
            states.add(Html.fromHtml(names[i]));

        states.add(Html.fromHtml("<b>Union Territories (UTs)"));

        for(int i=0;i<names2.length;i++)
            states.add(Html.fromHtml(names2[i]));

        adap = new NewArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,states);
        list.setAdapter(adap);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(News.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);
                }else {
                    if (position == 1) {
                        startActivity(new Intent(getApplicationContext(), AndhraPradeshUpdate.class));
                    }
                    if (position == 2) {
                        startActivity(new Intent(getApplicationContext(), ArunachalPradeshUpdate.class));
                    }
                    if (position == 3) {
                        startActivity(new Intent(getApplicationContext(), AssamUpdate.class));
                    }
                    if (position == 4) {
                        startActivity(new Intent(getApplicationContext(), BiharUpdate.class));
                    }
                    if (position == 5) {
                        startActivity(new Intent(getApplicationContext(), ChhattisgarhUpdate.class));
                    }
                    if (position == 6) {
                        startActivity(new Intent(getApplicationContext(), GoaUpdate.class));
                    }
                    if (position == 7) {
                        startActivity(new Intent(getApplicationContext(), GujratUpdate.class));
                    }
                    if (position == 8) {
                        startActivity(new Intent(getApplicationContext(), HaryanaUpdate.class));
                    }
                    if (position == 9) {
                        startActivity(new Intent(getApplicationContext(), HimachalPradeshUpdate.class));
                    }
                    if (position == 10) {
                        startActivity(new Intent(getApplicationContext(), JharkhandUpdate.class));
                    }
                    if (position == 11) {
                        startActivity(new Intent(getApplicationContext(), KarnatakaUpdate.class));
                    }
                    if (position == 12) {
                        startActivity(new Intent(getApplicationContext(), KeralaUpdate.class));
                    }
                    if (position == 13) {
                        startActivity(new Intent(getApplicationContext(), MadhyaPradeshUpdate.class));
                    }
                    if (position == 14) {
                        startActivity(new Intent(getApplicationContext(), MaharashtraUpdate.class));
                    }
                    if (position == 15) {
                        startActivity(new Intent(getApplicationContext(), ManipurUpdate.class));
                    }
                    if (position == 16) {
                        startActivity(new Intent(getApplicationContext(), MeghalayaUpdate.class));
                    }
                    if (position == 17) {
                        startActivity(new Intent(getApplicationContext(), MizoramUpdate.class));
                    }
                    if (position == 18) {
                        startActivity(new Intent(getApplicationContext(), NagalandUpdate.class));
                    }
                    if (position == 19) {
                        startActivity(new Intent(getApplicationContext(), OdishaUpdate.class));
                    }
                    if (position == 20) {
                        startActivity(new Intent(getApplicationContext(), PunjabUpdate.class));
                    }
                    if (position == 21) {
                        startActivity(new Intent(getApplicationContext(), RajasthanUpdate.class));
                    }
                    if (position == 22) {
                        startActivity(new Intent(getApplicationContext(), SikkimUpdate.class));
                    }
                    if (position == 23) {
                        startActivity(new Intent(getApplicationContext(), TamilNaduUpdate.class));
                    }
                    if (position == 24) {
                        startActivity(new Intent(getApplicationContext(), TelenganaUpdate.class));
                    }
                    if (position == 25) {
                        startActivity(new Intent(getApplicationContext(), TripuraUpdate.class));
                    }
                    if (position == 26) {
                        startActivity(new Intent(getApplicationContext(), UttarakhandUpdate.class));
                    }
                    if (position == 27) {
                        startActivity(new Intent(getApplicationContext(), UttarPradeshUpdate.class));
                    }
                    if (position == 28) {
                        startActivity(new Intent(getApplicationContext(), WestBengalUpdate.class));
                    }
                    if (position == 30) {
                        startActivity(new Intent(getApplicationContext(), AndamanAndNicobarIslandsUpdate.class));
                    }
                    if (position == 31) {
                        startActivity(new Intent(getApplicationContext(), ChandigarhUpdate.class));
                    }
                    if (position == 32) {
                        startActivity(new Intent(getApplicationContext(), DadraAndNagarHaveliAndDamanAndDiuUpdate.class));
                    }
                    if (position == 33) {
                        startActivity(new Intent(getApplicationContext(), DelhiUpdate.class));
                    }
                    if (position == 34) {
                        startActivity(new Intent(getApplicationContext(), JammuAndKashmirUpdate.class));
                    }
                    if (position == 35) {
                        startActivity(new Intent(getApplicationContext(), LadakhUpdate.class));
                    }
                    if (position == 36) {
                        startActivity(new Intent(getApplicationContext(), LakshadweepUpdate.class));
                    }
                    if (position == 37) {
                        startActivity(new Intent(getApplicationContext(), PuducherryUpdate.class));
                    }
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==101) {
            if(grantResults.length == 0 || grantResults[0]!=PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this,"Permission is required!",Toast.LENGTH_SHORT).show();
            }
        }
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