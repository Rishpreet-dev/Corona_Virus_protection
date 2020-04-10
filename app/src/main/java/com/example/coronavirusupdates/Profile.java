package com.example.coronavirusupdates;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Profile extends AppCompatActivity {

    Toolbar profileToolbar;

    TextView editFullName, editEmail, editPhone, editAge, editGender;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileToolbar = findViewById(R.id.profileToolbar);

        setSupportActionBar(profileToolbar);
        getSupportActionBar().setTitle("My Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editFullName = findViewById(R.id.editFullName);
        editEmail = findViewById(R.id.editEmail);
        editPhone = findViewById(R.id.editPhoneNumber);
        editAge = findViewById(R.id.editAge);
        editGender = findViewById(R.id.editGender);


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        phone = fAuth.getCurrentUser().getPhoneNumber();

        DocumentReference docRef = fStore.collection("Users").document(phone);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()) {

                    String name, email, phone, age, gender;

                    name = documentSnapshot.getString("Name");
                    email = documentSnapshot.getString("Email Address");
                    phone = documentSnapshot.getString("Phone Number");
                    age = documentSnapshot.getString("Age");
                    gender = documentSnapshot.getString("Gender");

                    editFullName.setText(name);
                    editEmail.setText(email);
                    editPhone.setText(phone);
                    editAge.setText(age);
                    editGender.setText(gender);

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Some Error",Toast.LENGTH_SHORT).show();
                Log.d("TAG","Error =>" + e.getMessage());
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}