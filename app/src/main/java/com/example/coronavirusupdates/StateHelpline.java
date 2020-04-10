package com.example.coronavirusupdates;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.coronavirusupdates.PagerAdapter.NewArrayAdapter;

import java.util.ArrayList;


public class StateHelpline extends AppCompatActivity {

    Toolbar toolbar;

    ListView listView;
    ArrayList<Spanned> states;
    NewArrayAdapter adap;
    String[] phone,names,names2,phone2;
    int selectedIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_helpline);

        toolbar = findViewById(R.id.toolbar);
        listView = findViewById(R.id.listView);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Helpline Numbers of States/UTs");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        names = new String[]{"Andhra Pradesh", "Arunachal Pradesh", "Assam",
                "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh",
                "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra",
                "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab",
                "Rajasthan", "Sikkim", "Tamil Nadu", "Telengana", "Tripura",
                "Uttarakhand", "Uttar Pradesh", "West Bengal"};

        phone = new String[] {"","tel:0866-2410978", "tel:9436055743", "tel:6913347770",
                "tel:104", "tel:104", "tel:104", "tel:104", "tel:8558893911", "tel:104",
                "tel:104", "tel:104", "tel:0471-2552056", "tel:104", "tel:020-26127394",
                "tel:3852411668", "tel:108", "tel:102", "tel:7005539653", "tel:9439994859",
                "tel:104", "tel:0141-2225624", "tel:104", "tel:044-29510500", "tel:104",
                "tel:381-2315879", "tel:104", "tel:18001805145","tel:1800313444222","","tel:03192-232102", "tel:9779558282", "tel:104", "tel:011-22307145",
                "tel:01912520982", "tel:01982256462", "tel:104", "tel:104"};

        names2 = new String[] {"Andaman and Nicobar Islands", "Chandigarh",
                "Dadra and Nagar Haveli and Daman & Diu", "Delhi", "Jammu & Kashmir",
                "Ladakh", "Lakshadweep", "Puducherry"};

        states = new ArrayList<>();
        states.add(Html.fromHtml("<b>States</b>"));

        for(int i=0; i< names.length;i++)
        states.add(Html.fromHtml(names[i]));

        states.add(Html.fromHtml("<b>Union Territories (UTs)</b>"));
        for (int i=0;i<names2.length;i++)
        states.add(Html.fromHtml(names2[i]));

        adap = new NewArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,states);

        listView.setAdapter(adap);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedIndex = position;
                if(selectedIndex!=0&&selectedIndex!=29)
                    askCallPermission();

            }
        });
    }


    private void makePhoneCall() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(StateHelpline.this);
        if(selectedIndex<=28)
            alertDialog.setTitle("Phone Numbers for "+names[selectedIndex-1]);
        else if(selectedIndex>29)
            alertDialog.setTitle("Phone Numbers for "+names2[selectedIndex-30]);
        alertDialog.setMessage("You can make phone call on number given below.");
        alertDialog.setPositiveButton("CALL  "+phone[selectedIndex].substring(4), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse(phone[selectedIndex]));
                    startActivity(callIntent);
                }
            });
        if(selectedIndex == 28) {
            alertDialog.setNegativeButton("CALL  03323412600", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:03323412600"));
                    startActivity(callIntent);
                }
            });
        }
        if(selectedIndex == 34){
            alertDialog.setNegativeButton("CALL  0194-2440283", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:0194-2440283"));
                    startActivity(callIntent);
                }
            });
        }
        alertDialog.create().show();

    }


    private void askCallPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1000);
        } else {
            makePhoneCall();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1000) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(getApplicationContext(), "Permission is Required", Toast.LENGTH_SHORT).show();
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
