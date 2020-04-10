package com.example.coronavirusupdates;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.coronavirusupdates.ProgressButtons.HelpProgressButton;

import java.util.Objects;

public class Helpline extends AppCompatActivity {

    public static final int PERM_CALL = 1000;
    View nationalHelp, stateHelp, emailHelp, whatsAppHelpDesk;
    Toolbar toolbar;

    HelpProgressButton progressButton1, progressButton2,progressButton3,progressButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);

        toolbar = findViewById(R.id.toolbar);
        nationalHelp = findViewById(R.id.callNationalHelpline);
        stateHelp = findViewById(R.id.callStateHelpline);
        emailHelp = findViewById(R.id.emailHelpline);
        whatsAppHelpDesk = findViewById(R.id.whatsAppHelpDesk);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("For Help");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressButton1 = new HelpProgressButton(Helpline.this, nationalHelp, "Call National Helpline", R.drawable.ic_call_black_24dp);
        progressButton2 = new HelpProgressButton(Helpline.this, stateHelp, "Call State/UT Helpline", R.drawable.ic_call_black_24dp);
        progressButton3 = new HelpProgressButton(Helpline.this, emailHelp, "Email to Central Government", R.drawable.ic_email_black_24dp);
        progressButton4 = new HelpProgressButton(Helpline.this,whatsAppHelpDesk,"MyGov WhatsApp HelpDesk",R.drawable.ic_baseline_chat_24);


        nationalHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nationalHelp.setEnabled(false);
                progressButton1.buttonActivated();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressButton1.buttonFinished();
                        askCallPermission();

                    }
                }, 300);
            }
        });

        stateHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateHelp.setEnabled(false);
                progressButton2.buttonActivated();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressButton2.buttonFinished();
                        startActivityForResult(new Intent(getApplicationContext(),StateHelpline.class),102);
                    }
                },300);

            }
        });

        emailHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emailHelp.setEnabled(false);
                progressButton3.buttonActivated();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent in = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","ncov2019@gov.in",null));
                        in.putExtra(Intent.EXTRA_SUBJECT,"Help related to Coronavirus (COVID-19)");
                        startActivityForResult(in,101);
                    }
                },300);
            }
        });

        whatsAppHelpDesk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                whatsAppHelpDesk.setEnabled(false);
                progressButton4.buttonActivated();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent in = new Intent(Intent.ACTION_VIEW,Uri.parse("https://t.co/REabfIp5QT"));
                        startActivityForResult(in,110);
                    }
                },300);

            }
        });

    }

    private void askCallPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERM_CALL);
        } else {
            makePhoneCall();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERM_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(getApplicationContext(), "Permission is Required", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void makePhoneCall() {
        androidx.appcompat.app.AlertDialog.Builder alertDialog = new AlertDialog.Builder(Helpline.this);
        alertDialog.setTitle("Phone Call");
        alertDialog.setMessage("You can make phone call on anyone of the numbers given below.");
        alertDialog.setPositiveButton("+91-11-23978046", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+91-11-23978046"));
                startActivity(callIntent);
            }
        });
        alertDialog.setNegativeButton("1075", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:1075"));
                startActivity(callIntent);
            }
        });
        alertDialog.create().show();
        nationalHelp.setEnabled(true);
        progressButton1.buttonRefresh();

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101) {
            emailHelp.setEnabled(true);
            progressButton3.buttonRefresh();
        }
        if (requestCode == 102) {
            stateHelp.setEnabled(true);
            progressButton2.buttonRefresh();
        }
        if(requestCode == 110) {
            whatsAppHelpDesk.setEnabled(true);
            progressButton4.buttonRefresh();
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