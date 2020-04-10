package com.example.coronavirusupdates;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.coronavirusupdates.ProgressButtons.ProgressButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    View infoBtn, helpBtn, newsBtn, advisoryBtn, statewiseBtn, symptomCheckerBtn;
    ProgressButton progressButton, progressButton2, progressButton3, progressButton4,progressButton5, progressButton6;
    ImageView videoImg1, videoImg2, videoImg3;

    Toolbar mainActivityToolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    TextView totalCasesText, activeCasesText, dischargedCasesText, deceasedCasesText;

    ProgressBar mainActivityProgressBar;

    Button locationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityToolbar = findViewById(R.id.mainActivityToolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);

        mainActivityProgressBar = findViewById(R.id.mainActivityProgressBar);

        setSupportActionBar(mainActivityToolbar);
        getSupportActionBar().setTitle("Corona Virus (COVID-19)");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);

        infoBtn = findViewById(R.id.view);
        statewiseBtn = findViewById(R.id.view5);
        helpBtn = findViewById(R.id.view2);
        symptomCheckerBtn = findViewById(R.id.view6);
        newsBtn = findViewById(R.id.view3);
        advisoryBtn = findViewById(R.id.view4);

        totalCasesText = findViewById(R.id.totalCasesText);
        activeCasesText = findViewById(R.id.activeCasesText);
        dischargedCasesText = findViewById(R.id.dischargedCasesText);
        deceasedCasesText = findViewById(R.id.deceasedCasesText);

        videoImg1 = findViewById(R.id.videoImg1);
        videoImg2 = findViewById(R.id.videoImg2);
        videoImg3 = findViewById(R.id.videoImg3);

        progressButton = new ProgressButton(MainActivity.this,infoBtn,"Info About Coronavirus (COVID-19)",R.drawable.info_corona1);
        progressButton5 = new ProgressButton(MainActivity.this,statewiseBtn,"COVID-19 State Wise Figures",R.drawable.state_figure);
        progressButton2 = new ProgressButton(MainActivity.this,helpBtn,"In Case of Emergency, Press Here",R.drawable.helpline);
        progressButton6 = new ProgressButton(MainActivity.this, symptomCheckerBtn, "Check for Symptoms of COVID-19", R.drawable.symptom_checker);
        progressButton3 = new ProgressButton(MainActivity.this,newsBtn,"State/UT wise Government Updates",R.drawable.updates_corona);
        progressButton4 = new ProgressButton(MainActivity.this,advisoryBtn,"Advisory over COVID-19 from Central Govt.",R.drawable.advisory);

        locationBtn = findViewById(R.id.locationBtn);

        locationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationBtn.setEnabled(false);
                startActivity(new Intent(getApplicationContext(),TestCentersLocation.class));
                locationBtn.setEnabled(true);
            }
        });

        //navigationView
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()) {
                    case R.id.nav_profile:
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        return true;

                    case R.id.nav_share:
                        drawerLayout.closeDrawers();
                        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        String text = "https://drive.google.com/file/d/19svpApfzqgVqGRONTia2IqZWY_1svh5E/view?usp=drivesdk";
                        ClipData clip = ClipData.newPlainText("appLink", text);
                        clipboard.setPrimaryClip(clip);
                        Toast.makeText(getApplicationContext(),"Google Drive App Link has been copied!",Toast.LENGTH_SHORT).show();
                        return true;

                    default:
                        return false;
                }
            }
        });


        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoBtn.setEnabled(false);
                progressButton.buttonActivated();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressButton.buttonFinished();
                        startActivityForResult(new Intent(MainActivity.this,Info.class),101);
                    }
                },300);

            }
        });

        statewiseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statewiseBtn.setEnabled(false);
                progressButton5.buttonActivated();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressButton5.buttonFinished();
                        startActivityForResult(new Intent(MainActivity.this,StatewiseStats.class),105);
                    }
                },300);
            }
        });

        helpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpBtn.setEnabled(false);
                progressButton2.buttonActivated();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressButton2.buttonFinished();
                        startActivityForResult(new Intent(MainActivity.this,Helpline.class),102);
                    }
                },300);

            }
        });

        symptomCheckerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                symptomCheckerBtn.setEnabled(false);
                progressButton6.buttonActivated();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressButton6.buttonFinished();
                        startActivityForResult(new Intent(getApplicationContext(),SymptomsChecker.class),106);
                    }
                },300);
            }
        });

        newsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsBtn.setEnabled(false);
                progressButton3.buttonActivated();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressButton3.buttonFinished();
                        startActivityForResult(new Intent(getApplicationContext(),News.class),103);
                    }
                },300);
            }
        });

        advisoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                advisoryBtn.setEnabled(false);
                progressButton4.buttonActivated();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressButton4.buttonFinished();
                        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1010);
                        }else {
                            startActivityForResult(new Intent(getApplicationContext(),Advisory.class),104);
                        }

                    }
                },300);
            }
        });

        //videos
        videoImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=EJbjyo2xa2o")));
            }
        });
        videoImg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=OFFg21KhOV0&t=1s")));
            }
        });videoImg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=oBSkHZPu2xU")));
            }
        });

        DownloadTask downloadTask = new DownloadTask();
        downloadTask.execute("https://api.rootnet.in/covid19-in/stats/latest");

    }


    class DownloadTask extends AsyncTask<String ,Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            String result = "";

            URL url;
            HttpURLConnection httpURLConnection;

            try {
                url = new URL(urls[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream in = httpURLConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while (data != -1) {
                    result += (char) data;
                    data = reader.read();
                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.i("TAG","JSON => "+ s);
            try {
                JSONObject totalDataJson = new JSONObject(s);
                String dataString = totalDataJson.getString("data");
                Log.i("TAG","Data => "+dataString);

                //for total stats
                JSONObject summaryJSON = new JSONObject(dataString);
                String summary  = summaryJSON.getString("summary");
                Log.i("TAG","Summary => "+summary);
                JSONObject summaryJSONItemObject = new JSONObject(summary);

                String confirmed = summaryJSONItemObject.getString("total");
                String discharged = summaryJSONItemObject.getString("discharged");
                String deaths = summaryJSONItemObject.getString("deaths");

                int totalConfirmed = Integer.parseInt(confirmed);
                int totalDischarged = Integer.parseInt(discharged);
                int totalDeaths = Integer.parseInt(deaths);
                int totalActive = totalConfirmed - totalDischarged - totalDeaths;

                String active = Integer.toString(totalActive);

                Log.i("TAG","Total => "+confirmed);
                Log.i("TAG","Active =>" +active);
                Log.i("TAG","Discharged => "+discharged);
                Log.i("TAG","Deaths => "+deaths);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    setData(confirmed,active,discharged,deaths);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setData(String confirmed, String active, String discharged, String deaths) {

        totalCasesText.setText(confirmed);
        activeCasesText.setText(active);
        dischargedCasesText.setText(discharged);
        deceasedCasesText.setText(deaths);
        mainActivityProgressBar.setVisibility(View.INVISIBLE);

    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 1010) {
            if(grantResults.length == 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(),"Permission is Required!",Toast.LENGTH_SHORT).show();
            } else {
                startActivityForResult(new Intent(getApplicationContext(),Advisory.class),104);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            infoBtn.setEnabled(true);
            progressButton.buttonRefresh();
        }
        if (requestCode == 102) {
            helpBtn.setEnabled(true);
            progressButton2.buttonRefresh();
        }
        if(requestCode==103) {
            newsBtn.setEnabled(true);
            progressButton3.buttonRefresh();
        }
        if(requestCode==104) {
            advisoryBtn.setEnabled(true);
            progressButton4.buttonRefresh();
        }
        if(requestCode==105) {
            statewiseBtn.setEnabled(true);
            progressButton5.buttonRefresh();
        }
        if(requestCode==106)
        {
            symptomCheckerBtn.setEnabled(true);
            progressButton6.buttonRefresh();
        }

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.logout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(),WelcomeActivity.class));
            finish();
            return true;
        }
        if(item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

}