package com.example.coronavirusupdates.StateUtUpdates;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coronavirusupdates.PagerAdapter.NewArrayAdapter;
import com.example.coronavirusupdates.R;

import java.util.ArrayList;

public class OdishaUpdate extends AppCompatActivity {

    ListView listView;
    ArrayList<Spanned> arrayList;
    NewArrayAdapter adap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_ut_update);

        listView = findViewById(R.id.listView);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.6));

        arrayList = new ArrayList<>();
        arrayList.add(Html.fromHtml("<b>UPDATES</b>"));
        arrayList.add(Html.fromHtml("Odisha: Notification for lockdown in 13 districts <br><font color=\"blue\">2020-03-29</font>"));

        adap = new NewArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(adap);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url="", title = "";
                if(position==1) {
                    url = "https://static.mygov.in/rest/s3fs-public/mygov_158505891251307401.pdf";
                    title = "mygov_158505891251307401.pdf";
                }
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
        });
    }
}
