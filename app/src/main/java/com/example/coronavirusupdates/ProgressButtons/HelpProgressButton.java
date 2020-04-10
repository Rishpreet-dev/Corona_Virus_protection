package com.example.coronavirusupdates.ProgressButtons;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.coronavirusupdates.R;


public class HelpProgressButton {
    private CardView cardView;
    private ConstraintLayout constraintLayout;
    private TextView textView;
    private ImageView img;
    private String label;
    private int icon;

    Animation fade_in;

    public HelpProgressButton(Context ct, View view, String text, int iconArg) {

        cardView = view.findViewById(R.id.cardView);
        constraintLayout = view.findViewById(R.id.constraintLayout);
        textView = view.findViewById(R.id.textView);
        img = view.findViewById(R.id.infoIcon);

        fade_in = AnimationUtils.loadAnimation( ct, R.anim.fade_in);
        label = text;
        icon = iconArg;
        img.setImageResource(icon);
        textView.setText(label);
    }

    public void buttonRefresh() {

        constraintLayout.setBackgroundColor(cardView.getResources().getColor(R.color.colorPrimary));
        textView.setText(label);
    }

    public void buttonActivated () {

        textView.setWidth(100);
        textView.setAnimation(fade_in);
        textView.setText("Please wait...");

    }

    public void buttonFinished() {

        constraintLayout.setBackgroundColor(cardView.getResources().getColor(R.color.colorPrimaryDark));
        textView.setText("Done");

    }
}
