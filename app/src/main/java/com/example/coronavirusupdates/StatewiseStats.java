package com.example.coronavirusupdates;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class StatewiseStats extends AppCompatActivity {

    TableLayout mTableLayout;
    ProgressDialog mProgressBar;
    int i = -1;

    Toolbar statewiseToolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statewise_stats);


        statewiseToolbar = findViewById(R.id.statewiseToolbar);

        setSupportActionBar(statewiseToolbar);
        getSupportActionBar().setTitle("State Wise Figures");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mProgressBar = new ProgressDialog(this);
        mTableLayout = (TableLayout) findViewById(R.id.data);
        mTableLayout.setStretchAllColumns(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setData("STATE/UT","CONFIRMED","ACTIVE","DISCHARGED","DECEASED");
        }
        startLoadData();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void startLoadData() {
        mProgressBar.setCancelable(false);
        mProgressBar.setMessage("Fetching Data..");
        mProgressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressBar.show();
        new DownloadTask().execute("https://api.rootnet.in/covid19-in/stats/latest");
    }

    class DownloadTask extends AsyncTask<String ,Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            String result = "";

            URL url;
            HttpURLConnection httpURLConnection = null;

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

                //for state wise stats
                JSONObject regionalJSON = new JSONObject(dataString);
                String regional = regionalJSON.getString("regional");
                Log.i("TAG","Regional => "+regional);

                JSONArray regionalJsonArray = new JSONArray(regional);

                for(int i=0;i<regionalJsonArray.length();i++) {

                    JSONObject regionalJSONItemObject = (JSONObject) regionalJsonArray.get(i);
                    String locationState = regionalJSONItemObject.getString("loc");
                    String confirmedState = regionalJSONItemObject.getString("totalConfirmed");
                    String dischargedState = regionalJSONItemObject.getString("discharged");
                    String deathsState = regionalJSONItemObject.getString("deaths");

                    int totalConfirmedState = Integer.parseInt(confirmedState);
                    int totalDischargedState = Integer.parseInt(dischargedState);
                    int totalDeathsState = Integer.parseInt(deathsState);
                    int totalActiveState = totalConfirmedState - totalDischargedState - totalDeathsState;

                    String activeState = Integer.toString(totalActiveState);

                    Log.i("TAG","Location => "+locationState);
                    Log.i("TAG","Total => "+confirmedState);
                    Log.i("TAG","Active =>" + activeState);
                    Log.i("TAG","Discharged => "+dischargedState);
                    Log.i("TAG","Deaths => "+deathsState);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        setStateData(locationState, confirmedState, activeState, dischargedState, deathsState);
                    }

                }

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
                    setData("Total",confirmed,active,discharged,deaths);
                }
                mProgressBar.hide();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setData(String total, String confirmed, String active, String discharged, String deaths) {

        final TextView tv = new TextView(this);
        tv.setLayoutParams(new TableRow.LayoutParams(100, TableRow.LayoutParams.WRAP_CONTENT));
        tv.setText(total);
        tv.setTextColor(getResources().getColor(R.color.state_head));
        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv.setGravity(Gravity.CENTER_HORIZONTAL);

        final TextView tv2 = new TextView(this);
        tv2.setLayoutParams(new TableRow.LayoutParams(70, TableRow.LayoutParams.WRAP_CONTENT));
        tv2.setText(confirmed);
        tv2.setTextColor(getResources().getColor(R.color.state_head));
        tv2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv2.setGravity(Gravity.CENTER_HORIZONTAL);

        final TextView tv3 = new TextView(this);
        tv3.setLayoutParams(new TableRow.LayoutParams(55, TableRow.LayoutParams.WRAP_CONTENT));
        tv3.setText(active);
        tv3.setTextColor(getResources().getColor(R.color.state_head));
        tv3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv3.setGravity(Gravity.CENTER_HORIZONTAL);

        final TextView tv4 = new TextView(this);
        tv4.setLayoutParams(new TableRow.LayoutParams(70, TableRow.LayoutParams.WRAP_CONTENT));
        tv4.setText(discharged);
        tv4.setTextColor(getResources().getColor(R.color.state_head));
        tv4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv4.setGravity(Gravity.CENTER_HORIZONTAL);

        final TextView tv5 = new TextView(this);
        tv5.setLayoutParams(new TableRow.LayoutParams(70, TableRow.LayoutParams.WRAP_CONTENT));
        tv5.setText(deaths);
        tv5.setTextColor(getResources().getColor(R.color.state_head));
        tv5.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv5.setGravity(Gravity.CENTER_HORIZONTAL);

        i++;
        final TableRow tr = new TableRow(this);
        tr.setId(i+1);
        TableLayout.LayoutParams trParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
        trParams.setMargins(0,0,0,0);
        tr.setPadding(0,0,0,0);
        tr.setBackground(getDrawable(R.drawable.backgroundo));
        tr.setLayoutParams(trParams);
        tr.addView(tv);
        tr.addView(tv2);
        tr.addView(tv3);
        tr.addView(tv4);
        tr.addView(tv5);

        mTableLayout.addView(tr, trParams);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setStateData(String locationState, String confirmedState, String activeState, String dischargedState, String deathsState) {
        // data columns
        final TextView tv = new TextView(this);
            tv.setLayoutParams(new
                    TableRow.LayoutParams(100,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv.setText(locationState);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        final TextView tv2 = new TextView(this);
            tv2.setLayoutParams(new
                    TableRow.LayoutParams(70,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv2.setText(confirmedState);
            tv2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


        final TextView tv3 = new TextView(this);
            tv3.setLayoutParams(new
                    TableRow.LayoutParams(55,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv3.setText(activeState);
            tv3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        final TextView tv4 = new TextView(this);
            tv4.setLayoutParams(new
                    TableRow.LayoutParams(70,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv4.setText(dischargedState);
            tv4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        final TextView tv5 = new TextView(this);
            tv5.setLayoutParams(new
                    TableRow.LayoutParams(70,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv5.setText(deathsState);
            tv5.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        final TableRow tr = new TableRow(this);
        tr.setId(i + 1);
        TableLayout.LayoutParams trParams = new
                TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT);
        trParams.setMargins(0,0,0,0);
        tr.setPadding(0,0,0,0);
        if(i % 2 == 1 ) {
            tr.setBackground(getResources().getDrawable(R.drawable.background1));
        }
        i++;
        tr.setLayoutParams(trParams);
        tr.addView(tv);
        tr.addView(tv2);
        tr.addView(tv3);
        tr.addView(tv4);
        tr.addView(tv5);

        mTableLayout.addView(tr, trParams);

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