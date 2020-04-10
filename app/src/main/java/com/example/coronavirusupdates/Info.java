package com.example.coronavirusupdates;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.coronavirusupdates.Fragments.FragmentOne;
import com.example.coronavirusupdates.Fragments.FragmentThree;
import com.example.coronavirusupdates.Fragments.FragmentTwo;
import com.example.coronavirusupdates.PagerAdapter.PagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class Info extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Info about CoronaVirus");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager());

        pagerAdapter.addFragment(new FragmentOne(),"Overview");
        pagerAdapter.addFragment(new FragmentTwo(),"Prevention");
        pagerAdapter.addFragment(new FragmentThree(),"Symptoms");

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
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