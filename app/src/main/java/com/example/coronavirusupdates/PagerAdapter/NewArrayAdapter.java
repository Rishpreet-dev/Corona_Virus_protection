package com.example.coronavirusupdates.PagerAdapter;

import android.content.Context;
import android.text.Spanned;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class NewArrayAdapter extends ArrayAdapter {

    public NewArrayAdapter(@NonNull Context context, int resource, ArrayList<Spanned> string) {
        super(context, resource, string);
    }

}
