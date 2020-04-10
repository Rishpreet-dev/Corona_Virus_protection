package com.example.coronavirusupdates;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Register extends AppCompatActivity {

    GridLayout editGender;
    TextView selectedGender, textFullName, textAge, textEmail;
    EditText editFullName, editAge, editEmail;
    Button male, female, other, btnFullName, btnAge, btnEmail;
    Toolbar addDetailsToolbar;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        addDetailsToolbar = findViewById(R.id.addDetailsToolbar);

        editGender = findViewById(R.id.editGender);

        selectedGender = findViewById(R.id.selectedGender);

        textFullName = findViewById(R.id.textFullName);
        textAge = findViewById(R.id.textAge);
        textEmail = findViewById(R.id.textEmailAddress);

        editFullName = findViewById(R.id.editFullName);
        editAge = findViewById(R.id.editAge);
        editEmail = findViewById(R.id.editEmail);

        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        other = findViewById(R.id.other);
        btnFullName = findViewById(R.id.btnFullName);
        btnAge = findViewById(R.id.btnAge);
        btnEmail = findViewById(R.id.btnEmailAddress);

        setActionBar(addDetailsToolbar);
        Objects.requireNonNull(getActionBar()).setTitle("Add Your Details");

        btnFullName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editFullName.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Enter your Name",Toast.LENGTH_SHORT).show();
                } else {
                    editFullName.setEnabled(false);
                    btnFullName.setEnabled(false);
                    btnFullName.setVisibility(View.GONE);
                    textAge.setVisibility(View.VISIBLE);
                    editAge.setVisibility(View.VISIBLE);
                    btnAge.setVisibility(View.VISIBLE);
                }
            }
        });

        btnAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editAge.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Enter your Age",Toast.LENGTH_SHORT).show();
                } else {
                    editAge.setEnabled(false);
                    btnAge.setEnabled(false);
                    btnAge.setVisibility(View.GONE);
                    textEmail.setVisibility(View.VISIBLE);
                    editEmail.setVisibility(View.VISIBLE);
                    btnEmail.setVisibility(View.VISIBLE);
                }
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editEmail.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Enter your Email", Toast.LENGTH_SHORT).show();
                } else {
                    editEmail.setEnabled(false);
                    btnEmail.setEnabled(false);
                    btnEmail.setVisibility(View.GONE);

                    addDetails();
                }

            }
        });
    }

    public void getGender (View v) {

        editGender.setVisibility(View.INVISIBLE);
        String text = "";
        if(Integer.parseInt(v.getTag().toString()) == 0) {
            text = "Male";
        } else if(Integer.parseInt(v.getTag().toString()) == 1) {
            text = "Female";
        } else if(Integer.parseInt(v.getTag().toString()) == 2) {
            text = "Other";
        }
        selectedGender.setText(text);
        selectedGender.setVisibility(View.VISIBLE);
        textFullName.setVisibility(View.VISIBLE);
        editFullName.setVisibility(View.VISIBLE);
        btnFullName.setVisibility(View.VISIBLE);
    }

    private void addDetails() {

        DocumentReference docRef = fStore.collection("Users").document(fAuth.getCurrentUser().getPhoneNumber());
        Map<String,Object> user = new HashMap<>();

        user.put("Name",editFullName.getText().toString());
        user.put("Gender",selectedGender.getText().toString());
        user.put("Age",editAge.getText().toString());
        user.put("Phone Number",fAuth.getCurrentUser().getPhoneNumber());
        user.put("UID",fAuth.getCurrentUser().getUid());
        user.put("Email Address",editEmail.getText().toString());

        docRef.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(),"User Details Added",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Unable to add Data.",Toast.LENGTH_SHORT).show();
            }
        });

    }
}