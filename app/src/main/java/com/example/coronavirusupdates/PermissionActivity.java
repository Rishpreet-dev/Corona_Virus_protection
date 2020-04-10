package com.example.coronavirusupdates;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.TimeUnit;

public class PermissionActivity extends AppCompatActivity {

    Toolbar toolbar;

    Button acceptBtn;

    ProgressBar bar;

    ImageView closeBtn, backBtn;
    Button submitBtn, submitOtpBtn;
    BottomSheetDialog registerDialog, otpDialog;
    ProgressBar progressBarMobile, progressBarOtp;
    EditText phoneNumber, otpCode;
    TextView resendOtp;
    CountDownTimer resendcount;

    String phone, otp;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    PhoneAuthCredential credential;
    PhoneAuthProvider.ForceResendingToken token;
    String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        toolbar = findViewById(R.id.toolbar);
        acceptBtn = findViewById(R.id.acceptBtn);
        bar = findViewById(R.id.progressBarCheck);

        registerDialog = new BottomSheetDialog(this);
        otpDialog = new BottomSheetDialog(this);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setActionBar(toolbar);
        }
        getActionBar().setTitle("Required Permissions");

        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askPermissions();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        bar.setVisibility(View.VISIBLE);
        if(fAuth.getCurrentUser() != null) {
            acceptBtn.setEnabled(false);
            checkUserProfile();
        } else {
            bar.setVisibility(View.INVISIBLE);
            acceptBtn.setEnabled(true);
        }
    }



    private void askPermissions() {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) +
                ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PermissionActivity.this,new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CALL_PHONE},101);
        } else {
            showPopup();
        }
    }

    private void showPopup() {

        registerDialog.setContentView(R.layout.register_popup);

        phoneNumber = registerDialog.findViewById(R.id.phone_number);
        closeBtn = registerDialog.findViewById(R.id.close);
        submitBtn = registerDialog.findViewById(R.id.submitBtn);
        progressBarMobile = registerDialog.findViewById(R.id.progressBarMobile);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeBtn.setEnabled(false);
                registerDialog.dismiss();
            }
        });

        phoneNumber.setText("+91");
        Selection.setSelection(phoneNumber.getText(),phoneNumber.getText().length());

        phoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(!s.toString().startsWith("+91")) {
                    phoneNumber.setText("+91");
                    Selection.setSelection(phoneNumber.getText(),phoneNumber.getText().length());
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().startsWith("+91")) {
                    phoneNumber.setText("+91");
                    Selection.setSelection(phoneNumber.getText(),phoneNumber.getText().length());
                }
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phoneNumber.getText().length() != 13) {
                    phoneNumber.setError("Please Enter a valid Phone Number!");
                    Toast.makeText(getApplicationContext(),"Please enter Phone Number with Country Code.",Toast.LENGTH_SHORT).show();
                }else {
                    phone = phoneNumber.getText().toString().trim();
                    Log.i("TAG", "PhoneNo => " + phone);
                    submitBtn.setEnabled(false);
                    phoneNumber.setEnabled(false);
                    progressBarMobile.setVisibility(View.VISIBLE);
                    sendOTP();
                }
            }
        });

        registerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        registerDialog.show();

    }



    private void sendOTP() {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(phone, 60l, TimeUnit.SECONDS, this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);

                verificationId = s;
                token = forceResendingToken;

                progressBarMobile.setVisibility(View.INVISIBLE);
                otpDialog.setContentView(R.layout.otp_popup);

                backBtn = otpDialog.findViewById(R.id.back);
                otpCode = otpDialog.findViewById(R.id.otp);
                submitOtpBtn = otpDialog.findViewById(R.id.submitOtpBtn);
                progressBarOtp = otpDialog.findViewById(R.id.progressBarOtp);
                resendOtp = otpDialog.findViewById(R.id.resendBtn);

                resendOtpCountDown();

                backBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        backBtn.setEnabled(false);
                        otpDialog.dismiss();
                    }
                });

                resendOtp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getApplicationContext(),"OTP sent again",Toast.LENGTH_SHORT).show();
                        resendOtpCountDown();
                        sendOTP();

                    }
                });

                submitOtpBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(otpCode.getText().toString().isEmpty() || otpCode.getText().toString().length() != 6) {
                            otpCode.setError("Please Enter a valid Otp Code!");
                        } else {
                            submitOtpBtn.setEnabled(false);
                            otpCode.setEnabled(false);
                            otp = otpCode.getText().toString();
                            Log.i("TAG","OTP => "+otp);
                            progressBarOtp.setVisibility(View.VISIBLE);

                            credential = PhoneAuthProvider.getCredential(verificationId,otp);
                            verifyAuth(credential);

                        }

                    }
                });

                otpDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                otpDialog.show();

                otpDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        submitBtn.setEnabled(true);
                        phoneNumber.setEnabled(true);
                    }
                });

            }

            @Override
            public void onCodeAutoRetrievalTimeOut(@NonNull String s) {
                super.onCodeAutoRetrievalTimeOut(s);
                Toast.makeText(getApplicationContext(),"OTP timeout, Please Re-generate the OTP again.",Toast.LENGTH_SHORT).show();
                resendOtp.setEnabled(true);

            }

            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                verifyAuth(phoneAuthCredential);

            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {

                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                otpDialog.dismiss();
                showPopup();

            }
        });

    }


    private void verifyAuth(PhoneAuthCredential credential) {

        fAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {

                    Toast.makeText(getApplicationContext(),"Phone Number Verified! "+ fAuth.getCurrentUser().getUid(),Toast.LENGTH_SHORT).show();
                    resendcount.cancel();
                    checkUserProfile();

                } else {

                    Toast.makeText(getApplicationContext(),"Can not verify Phone Number! Please Try Again.",Toast.LENGTH_SHORT).show();
                    submitOtpBtn.setEnabled(true);
                    progressBarOtp.setVisibility(View.INVISIBLE);
                    otpCode.setEnabled(true);
                }
            }
        });

    }

    private void checkUserProfile() {

        DocumentReference docRef = fStore.collection("Users").document(fAuth.getCurrentUser().getPhoneNumber());
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if (documentSnapshot.exists()) {

                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

                } else {

                    startActivity(new Intent(getApplicationContext(),Register.class));

                }
                bar.setVisibility(View.INVISIBLE);
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(getApplicationContext(),"Error : "+ e.getMessage(),Toast.LENGTH_SHORT).show();
                otpDialog.dismiss();
                showPopup();

            }
        });

    }

    private void resendOtpCountDown() {

        resendcount = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                resendOtp.setEnabled(false);
                String stringResendOtp;
                long secondleft = millisUntilFinished/1000;
                if(secondleft > 9) {
                    stringResendOtp = "Resend OTP in 00:" + secondleft;
                } else {
                    stringResendOtp = "Resend OTP in 00:0" + secondleft;
                }
                resendOtp.setText(stringResendOtp);

            }

            @Override
            public void onFinish() {

                resendOtp.setText("Resend OTP");
                resendOtp.setEnabled(true);

            }
        }.start();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 101) {
            if(grantResults.length > 0 && grantResults[0] + grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                showPopup();
            }
        } else {
            Toast.makeText(this,"Permissions are Required",Toast.LENGTH_SHORT).show();

        }
    }
}