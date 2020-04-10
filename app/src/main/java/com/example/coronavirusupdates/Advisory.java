package com.example.coronavirusupdates;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.coronavirusupdates.PagerAdapter.NewArrayAdapter;

import java.util.ArrayList;

public class Advisory extends AppCompatActivity {

    ListView advisoryListView;

    ArrayList<Spanned> advisoriesArrayList;
    String[] advisoryArray, advisoryLinks;
    NewArrayAdapter adap;

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisory);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Advisory by Central Government");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        advisoryListView = findViewById(R.id.advisoryListView);
        advisoryArray = new String[] {"Video on \"Know what the meaning of Lockdown is for them.\" - Hindi <br><font color=\"blue\">2020-04-04</font>",
                "AarogyaSetu App for staying informed and alert against COVID-19. Government initiative to develop a digital Bridge to fight against COVID-19. Download Today! Play store APP, IOS APP <br><font color=\"blue\">2020-04-02</font>",
                "Video on COVID-19 awareness for community level workers <br><font color=\"blue\">2020-04-02</font>",
                "What is Novel Coronavirus? <br><font color=\"blue\">2020-04-01</font>",
                "How to use the handrub? <br><font color=\"blue\">2020-04-01</font>",
                "A letter from HFM to the Health Administrators <br><font color=\"blue\">2020-04-01</font>",
                "Community leaflet <br><font color=\"blue\">2020-04-01</font>",
                "Handling Public Grievances pertaining to COVID-1 in M/o Health & Family Welfare <br><font color=\"blue\">2020-03-31</font>",
                "Minding our minds during the COVID-19 pandemic <br><font color=\"blue\">2020-03-31</font>",

                "Video from experts from AIIMS, New Delhi sharing basic steps on hand washing to fight against COVID-19 - English <br><font color=\"blue\">2020-03-29</font>",
                "Video from experts from AIIMS, New Delhi sharing basic steps on hand washing to fight against COVID-19 - English <br><font color=\"blue\">2020-03-29</font>",
                "Video from experts from AIIMS advising Stay Home Stay Safe - English <br><font color=\"blue\">2020-03-29</font>",
                "Video from experts from AIIMS advising Stay Home Stay Safe - Hindi <br><font color=\"blue\">2020-03-29</font>",
                "Various Health Experts on hw to manage Mental Health & Weel Being during COVID-19 outbreak <br><font color=\"blue\">2020-03-28</font>",
                "When to get tested for COVID-19 - English <br><font color=\"blue\">2020-03-28</font>",
                "When to get tested for COVID-19 - Hindi <br><font color=\"blue\">2020-03-28</font>",
                "Dr. Shekhar P. Seshadri on 'Connecting with little ones during the COVID-19 lockdown' - English <br><font color=\"blue\">2020-03-28</font>",
                "Do's and Don't Poster in English <br><font color=\"blue\">2020-03-26</font>",

                "Do's and Don't Poster in Hindi <br><font color=\"blue\">2020-03-26</font>",
                "Watch all COVID-19 management videos here <br><font color=\"blue\">2020-03-26</font>",
                "TV and Radio Spots (English & Hindi) for COVID-19 <br><font color=\"blue\">2020-03-26</font>",
                "KIDS, VAAYU & CORONA : Comic book for children to provide correct information about COVID-19 <br><font color=\"blue\">2020-03-26</font>",
                "KIDS, VAAYU & CORONA : Comic book for children to provide correct information about COVID-19 - Part 2 <br><font color=\"blue\">2020-03-26</font>",
                "Role of Frontline Workers in Prevention and Management of Corornavirus - English <br><font color=\"blue\">2020-03-26</font>",
                "Role of Frontline Workers in Prevention and Management of Corornavirus - Hindi <br><font color=\"blue\">2020-03-26</font>",
                "Posters for safety measures against COVID-19 - English <br><font color=\"blue\">2020-03-26</font>",
                "Posters for safety measures against COVID-19 - Hindi <br><font color=\"blue\">2020-03-26</font>",

                "Posters for Indians traveling from abroad - English <br><font color=\"blue\">202-03-26</font>",
                "Posters for Indians traveling from abroad - Hindi <br><font color=\"blue\">202-03-26</font>",
                "When to wear mask? - English <br><font color=\"blue\">2020-03-26</font>",
                "When to wear mask? - Hindi <br><font color=\"blue\">2020-03-26</font>",
                "When to get tested for COVID-19 - English <br><font color=\"blue\">2020-03-26</font>",
                "When to get tested for COVID-19 - Hindi <br><font color=\"blue\">2020-03-26</font>"
        };
        advisoryLinks = new String[] {"https://youtu.be/maBw7HmrU8c",
                "https://www.mygov.in/aarogya-setu-app?app=aarogya",
                "https://www.youtube.com/watch?v=UIQlZBO2ilA&feature=youtu.be",
                "https://www.mohfw.gov.in/pdf/Poster1GHFanDHGA.pdf",
                "https://www.mohfw.gov.in/pdf/Poster3GHFGA.pdf",
                "https://www.mohfw.gov.in/pdf/HFMLettergeneralawarness.pdf",
                "https://www.mohfw.gov.in/pdf/LeafletGHFandDHGA.pdf",
                "https://www.mohfw.gov.in/pdf/MoHFWCOVIDNODALOFFICER.pdf",
                "https://www.mohfw.gov.in/pdf/MindingourmindsduringCoronaeditedat.pdf",

                "https://www.youtube.com/watch?v=htl6ZUQ-b3Y&list=PL1a9DHjZmejE-Ep2PAu2OR8HBfLP0BLIk&index=1",
                "https://www.youtube.com/watch?v=8Dt1BTGXn5I&list=PL1a9DHjZmejE-Ep2PAu2OR8HBfLP0BLIk&index=2",
                "https://www.youtube.com/watch?v=yZd8bPTfYOg&list=PL1a9DHjZmejE-Ep2PAu2OR8HBfLP0BLIk&index=3",
                "https://www.youtube.com/watch?v=IfeWAxE4OZE&list=PL1a9DHjZmejE-Ep2PAu2OR8HBfLP0BLIk&index=4",
                "https://www.youtube.com/watch?v=iuKhtSehp24&feature=youtu.be",
                "https://www.mohfw.gov.in/pdf/FINAL_14_03_2020_ENg.pdf",
                "https://www.mohfw.gov.in/pdf/FINAL_14_03_2020_Hindi.pdf",
                "https://www.youtube.com/watch?v=OYD9bogtJlU&feature=youtu.be",
                "https://www.mohfw.gov.in/pdf/Poster_Corona_ad_Eng.pdf",

                "https://www.mohfw.gov.in/pdf/Poster_Corona_ad_Hin.pdf",
                "https://www.youtube.com/playlist?list=PL1a9DHjZmejE-Ep2PAu2OR8HBfLP0BLIk",
                "https://drive.google.com/open?id=1wvEmLyv3w3gUMpJP5VhgZgXruuusRpJS",
                "https://www.mohfw.gov.in/pdf/Corona_comic_PGI.pdf",
                "https://www.mohfw.gov.in/pdf/CoronaComic2PGIPU22Mar20.pdf",
                "https://www.mohfw.gov.in/pdf/PreventionandManagementofCOVID19FLWEnglish.pdf",
                "https://www.mohfw.gov.in/pdf/PreventionandManagementofCOVID19FLWHindi.pdf",
                "https://www.mohfw.gov.in/pdf/ProtectivemeasuresEng.pdf",
                "https://www.mohfw.gov.in/pdf/ProtectivemeasuresHin.pdf",

                "https://www.mohfw.gov.in/pdf/PostrerEnglishtraveller.pdf",
                "https://www.mohfw.gov.in/pdf/PosterTravellerHindi.pdf",
                "https://www.mohfw.gov.in/pdf/Mask-Eng.pdf",
                "https://www.mohfw.gov.in/pdf/Mask-Hindi.pdf",
                "https://www.mohfw.gov.in/pdf/FINAL_14_03_2020_ENg.pdf",
                "https://www.mohfw.gov.in/pdf/FINAL_14_03_2020_Hindi.pdf"
        };

        advisoriesArrayList = new ArrayList<>();
        for (String s : advisoryArray) advisoriesArrayList.add(Html.fromHtml(s));

        adap = new NewArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,advisoriesArrayList);
        advisoryListView.setAdapter(adap);

        advisoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0 || position == 1 || position == 2 ||position == 9 || position == 10 || position == 11
                        || position == 12 || position == 13 || position == 16 || position == 19 || position == 20) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(advisoryLinks[position])));
                } else {
                    String url, title;

                    url = advisoryLinks[position];

                    String[] splitStrings = url.split("/pdf/");
                    title = splitStrings[1];
                    Log.i("TAG","Title =>" + title);

                    try {
                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
                        request.setTitle(title);
                        request.setDescription("Downloading File...");
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title);

                        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                        manager.enqueue(request);
                        Toast.makeText(getApplicationContext(), "Downloading in Progress..", Toast.LENGTH_SHORT).show();
                    } catch(Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),"Sorry, file not found.",Toast.LENGTH_SHORT).show();
                    }
                }
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