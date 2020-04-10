package com.example.coronavirusupdates;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SymptomsChecker extends AppCompatActivity {

    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox100,checkBox8,checkBox9,checkBox10;
    private CheckBox checkBox11,checkBox12,checkBox101,checkBox13,checkBox14,checkBox15,checkBox16,checkBox17,checkBox18,checkBox19,checkBox20;
    private CheckBox checkBox21,checkBox22,checkBox23,checkBox24,checkBox25,checkBox26,checkBox27,checkBox28,checkBox29,checkBox30;
    private CheckBox checkBox31,checkBox32,checkBox33,checkBox34,checkBox35,checkBox36,checkBox37,checkBox38,checkBox39,checkBox40,checkBox41;
    private CheckBox checkBox42,checkBox43;
    private Button submit;
    private TextView ans,risk,recomd,note,hml;
    double count=0;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms_checker);

        toolbar = findViewById(R.id.symptomToolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Symptoms Checker");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        checkBox1=findViewById(R.id.checkBox);
        checkBox2=findViewById(R.id.checkBox2);

        checkBox3=findViewById(R.id.checkBox3);
        checkBox4=findViewById(R.id.checkBox4);
        checkBox5=findViewById(R.id.checkBox5);
        checkBox6=findViewById(R.id.checkBox6);
        checkBox7=findViewById(R.id.checkBox7);
        checkBox100=findViewById(R.id.checkBox100);
        checkBox8=findViewById(R.id.checkBox8);
        checkBox9=findViewById(R.id.checkBox9);
        checkBox10=findViewById(R.id.checkBox10);
        checkBox11=findViewById(R.id.checkBox11);
        checkBox12=findViewById(R.id.checkBox12);
        checkBox101=findViewById(R.id.checkBox101);
        checkBox13=findViewById(R.id.checkBox13);
        checkBox14=findViewById(R.id.checkBox14);
        checkBox15=findViewById(R.id.checkBox15);
        checkBox16=findViewById(R.id.checkBox16);
        checkBox17=findViewById(R.id.checkBox17);
        checkBox18=findViewById(R.id.checkBox18);
        checkBox19=findViewById(R.id.checkBox19);
        checkBox20=findViewById(R.id.checkBox20);
        checkBox21=findViewById(R.id.checkBox21);
        checkBox22=findViewById(R.id.checkBox22);
        checkBox23=findViewById(R.id.checkBox23);
        checkBox24=findViewById(R.id.checkBox24);
        checkBox25=findViewById(R.id.checkBox25);
        checkBox26=findViewById(R.id.checkBox26);
        checkBox27=findViewById(R.id.checkBox27);
        checkBox28=findViewById(R.id.checkBox28);
        checkBox29=findViewById(R.id.checkBox29);
        checkBox30=findViewById(R.id.checkBox30);
        checkBox31=findViewById(R.id.checkBox31);
        checkBox32=findViewById(R.id.checkBox32);
        checkBox33=findViewById(R.id.checkBox33);
        checkBox34=findViewById(R.id.checkBox34);
        checkBox35=findViewById(R.id.checkBox35);
        checkBox36=findViewById(R.id.checkBox36);
        checkBox37=findViewById(R.id.checkBox37);
        checkBox38=findViewById(R.id.checkBox38);
        checkBox39=findViewById(R.id.checkBox39);
        checkBox40=findViewById(R.id.checkBox40);
        checkBox41=findViewById(R.id.checkBox41);
        checkBox42=findViewById(R.id.checkBox42);
        checkBox43=findViewById(R.id.checkBox43);
        risk =findViewById(R.id.risk);
        note=findViewById(R.id.note);
        recomd = findViewById(R.id.recommendation);
        ans=findViewById(R.id.ans);
        hml=findViewById(R.id.hml);
        submit =findViewById(R.id.submit);


        //All the data of covid 19 System are converted into number.. On the Basis of their effect on Human;

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox1.isChecked())
                {
                    //              collect.add(0,4);
                    count=count+4.5;
                    checkBox3.setEnabled(false);
                    checkBox2.setEnabled(false);
                }
                else
                {
                    checkBox3.setEnabled(true);
                    checkBox2.setEnabled(true);
                    count=count-4.5;
                }


            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox2.isChecked())
                {
                    //collect.add(0,3);
                    count=count+3.25;

                    checkBox3.setEnabled(false);
                    checkBox1.setEnabled(false);
                }
                else
                {
                    checkBox3.setEnabled(true);
                    checkBox1.setEnabled(true);
                    count=count-3.25;
                }

            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox3.isChecked())
                {
                    //  collect.add(0,3);
                    //      count++;
                    count=count+3.5;
                    checkBox1.setEnabled(false);
                    checkBox2.setEnabled(false);
                }
                else
                {
                    count=count-3.5;
                    checkBox1.setEnabled(true);
                    checkBox2.setEnabled(true);
                    //collect.remove(0);
                }

            }
        });
        //Toast toast=Toast.makeText(getApplicationContext(),collect.get(0),Toast.LENGTH_SHORT);
        //toast.show();


        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkBox4.isChecked())
                {
                    //  collect.add(1,0);
                    count=count+0.65;
                    checkBox5.setEnabled(false);
                    checkBox6.setEnabled(false);
                    checkBox7.setEnabled(false);
                    checkBox100.setEnabled(false);

                }
                else
                {

                    //collect.remove(1);
                    count = count-0.65;
                    checkBox5.setEnabled(true);
                    checkBox6.setEnabled(true);
                    checkBox7.setEnabled(true);
                    checkBox100.setEnabled(true);
                }

            }
        });
        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkBox5.isChecked())
                {
                    //collect.add(1,1);
                    count=count+1.5;

                    checkBox4.setEnabled(false);
                    checkBox6.setEnabled(false);
                    checkBox7.setEnabled(false);
                    checkBox100.setEnabled(false);

                }
                else
                {

                    //collect.remove(1);
                    count=count-1.5;
                    checkBox4.setEnabled(true);
                    checkBox6.setEnabled(true);
                    checkBox7.setEnabled(true);
                    checkBox100.setEnabled(true);
                }

            }
        });

        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox6.isChecked())
                {
                    //            collect.add(1,2);
                    count=count+2.75;

                    checkBox5.setEnabled(false);
                    checkBox4.setEnabled(false);
                    checkBox7.setEnabled(false);
                    checkBox100.setEnabled(false);

                }
                else
                {

                    // collect.remove(1);
                    count=count-2.75;
                    checkBox5.setEnabled(true);
                    checkBox4.setEnabled(true);
                    checkBox7.setEnabled(true);
                    checkBox100.setEnabled(true);
                }

            }
        });

        checkBox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox7.isChecked())
                {
                    //            collect.add(1,3);
                    count=count+3.45;

                    checkBox5.setEnabled(false);
                    checkBox6.setEnabled(false);
                    checkBox4.setEnabled(false);
                    checkBox100.setEnabled(false);

                }
                else
                {

                    //collect.remove(1);
                    count=count-3.45;
                    checkBox5.setEnabled(true);
                    checkBox6.setEnabled(true);
                    checkBox4.setEnabled(true);
                    checkBox100.setEnabled(true);
                }

            }
        });
        checkBox100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox100.isChecked())
                {
                    //collect.add(1,4);
                    count=count+4.375;

                    checkBox5.setEnabled(false);
                    checkBox6.setEnabled(false);
                    checkBox7.setEnabled(false);
                    checkBox4.setEnabled(false);

                }
                else
                {

                    //collect.remove(1);
                    count=count-4.375;
                    checkBox5.setEnabled(true);
                    checkBox6.setEnabled(true);
                    checkBox7.setEnabled(true);
                    checkBox4.setEnabled(true);
                }

            }
        });
        checkBox8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox8.isChecked())
                {
                    //collect.add(2,6);
                    //               ar[0]=6;
                    count=count+7.37;
                    checkBox9.setEnabled(false);
                    checkBox10.setEnabled(false);
                    checkBox11.setEnabled(false);
                    checkBox12.setEnabled(false);
                    checkBox101.setEnabled(false);
                    checkBox13.setEnabled(false);
                    checkBox14.setEnabled(false);




                }
                else
                {
                    count=count-7.37;
                    checkBox9.setEnabled(true);
                    checkBox10.setEnabled(true);
                    checkBox11.setEnabled(true);
                    checkBox12.setEnabled(true);
                    checkBox101.setEnabled(true);
                    checkBox13.setEnabled(true);
                    checkBox14.setEnabled(true);
                }


            }
        });
        checkBox9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkBox9.isChecked())
                {
                    count=count+5.75;
                    checkBox8.setEnabled(false);
                    checkBox10.setEnabled(false);
                    checkBox11.setEnabled(false);
                    checkBox12.setEnabled(false);
                    checkBox101.setEnabled(false);
                    checkBox13.setEnabled(false);
                    checkBox14.setEnabled(false);




                }
                else
                {
                    count=count-5.75;
                    checkBox8.setEnabled(true);
                    checkBox10.setEnabled(true);
                    checkBox11.setEnabled(true);
                    checkBox12.setEnabled(true);
                    checkBox101.setEnabled(true);
                    checkBox13.setEnabled(true);
                    checkBox14.setEnabled(true);
                }


            }
        });
        checkBox10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox10.isChecked()&& !checkBox8.isChecked()&& !checkBox11.isChecked())
                {
                    //collect.set(2,5);
                    count=count+6.02;
                    checkBox9.setEnabled(false);
                    checkBox8.setEnabled(false);
                    checkBox11.setEnabled(false);
                    checkBox12.setEnabled(false);
                    checkBox101.setEnabled(false);
                    checkBox13.setEnabled(false);
                    checkBox14.setEnabled(false);




                }
                else
                {
                    count=count-6.02;
                    checkBox9.setEnabled(true);
                    checkBox8.setEnabled(true);
                    checkBox11.setEnabled(true);
                    checkBox12.setEnabled(true);
                    checkBox101.setEnabled(true);
                    checkBox13.setEnabled(true);
                    checkBox14.setEnabled(true);
                }


            }
        });
        checkBox11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox11.isChecked())
                {count=count+7.03;
                    checkBox9.setEnabled(false);
                    checkBox10.setEnabled(false);
                    checkBox8.setEnabled(false);
                    checkBox12.setEnabled(false);
                    checkBox101.setEnabled(false);
                    checkBox13.setEnabled(false);
                    checkBox14.setEnabled(false);




                }
                else
                {
                    count=count-7.03;
                    checkBox9.setEnabled(true);
                    checkBox10.setEnabled(true);
                    checkBox8.setEnabled(true);
                    checkBox12.setEnabled(true);
                    checkBox101.setEnabled(true);
                    checkBox13.setEnabled(true);
                    checkBox14.setEnabled(true);
                }


            }
        });

        checkBox12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox12.isChecked()&& !checkBox8.isChecked()&& !checkBox11.isChecked())
                {
                    count=count+5.25;
                    checkBox9.setEnabled(false);
                    checkBox10.setEnabled(false);
                    checkBox11.setEnabled(false);
                    checkBox8.setEnabled(false);
                    checkBox101.setEnabled(false);
                    checkBox13.setEnabled(false);
                    checkBox14.setEnabled(false);

                }
                else
                {
                    count=count-5.25;
                    checkBox9.setEnabled(true);
                    checkBox10.setEnabled(true);
                    checkBox11.setEnabled(true);
                    checkBox8.setEnabled(true);
                    checkBox101.setEnabled(true);
                    checkBox13.setEnabled(true);
                    checkBox14.setEnabled(true);
                }

            }
        });
        checkBox101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox8.isChecked()|| checkBox11.isChecked())
                {
                    count=count+4;
                    checkBox9.setEnabled(false);
                    checkBox10.setEnabled(false);
                    checkBox11.setEnabled(false);
                    checkBox12.setEnabled(false);
                    checkBox8.setEnabled(false);
                    checkBox13.setEnabled(false);
                    checkBox14.setEnabled(false);




                }
                else
                {
                    count=count-4;
                    checkBox9.setEnabled(true);
                    checkBox10.setEnabled(true);
                    checkBox11.setEnabled(true);
                    checkBox12.setEnabled(true);
                    checkBox8.setEnabled(true);
                    checkBox13.setEnabled(true);
                    checkBox14.setEnabled(true);
                }


            }
        });
        checkBox13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox8.isChecked()|| checkBox11.isChecked())
                {
                    count=count+4.5;
                    checkBox9.setEnabled(false);
                    checkBox10.setEnabled(false);
                    checkBox11.setEnabled(false);
                    checkBox12.setEnabled(false);
                    checkBox101.setEnabled(false);
                    checkBox8.setEnabled(false);
                    checkBox14.setEnabled(false);




                }
                else
                {
                    count=count-4.5;
                    checkBox9.setEnabled(true);
                    checkBox10.setEnabled(true);
                    checkBox11.setEnabled(true);
                    checkBox12.setEnabled(true);
                    checkBox101.setEnabled(true);
                    checkBox8.setEnabled(true);
                    checkBox14.setEnabled(true);
                }


            }
        });
        checkBox14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox14.isChecked())
                {
                    count=count+0;
                    checkBox9.setEnabled(false);
                    checkBox10.setEnabled(false);
                    checkBox11.setEnabled(false);
                    checkBox12.setEnabled(false);
                    checkBox101.setEnabled(false);
                    checkBox13.setEnabled(false);
                    checkBox8.setEnabled(false);




                }
                else
                {
                    count=count-0;
                    checkBox9.setEnabled(true);
                    checkBox10.setEnabled(true);
                    checkBox11.setEnabled(true);
                    checkBox12.setEnabled(true);
                    checkBox101.setEnabled(true);
                    checkBox13.setEnabled(true);
                    checkBox8.setEnabled(true);
                }


            }
        });




        checkBox15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox15.isChecked())
                {
                    // if(!checkBox24.isChecked() && !checkBox26.isChecked())
                    count=count+25;
                    // collect.set(3,45);
                    //ar[1]=45;
                    checkBox16.setEnabled(false);
                    checkBox17.setEnabled(false);
                    checkBox18.setEnabled(false);
                    checkBox19.setEnabled(false);
                    checkBox20.setEnabled(false);
                    checkBox21.setEnabled(false);
                    checkBox22.setEnabled(false);
                    checkBox23.setEnabled(false);


                }
                else
                {
                    //if(!checkBox24.isChecked() || !checkBox26.isChecked())
                    count=count-25;
                    checkBox16.setEnabled(true);
                    checkBox17.setEnabled(true);
                    checkBox18.setEnabled(true);
                    checkBox19.setEnabled(true);
                    checkBox20.setEnabled(true);
                    checkBox21.setEnabled(true);
                    checkBox22.setEnabled(true);
                    checkBox23.setEnabled(true);

                }

            }
        });
        checkBox16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox16.isChecked())
                {
                    // if(!checkBox24.isChecked() || !checkBox26.isChecked())
                    count=count+25;
                    // collect.set(3,45);
                    //ar[1]=45;
                    checkBox15.setEnabled(false);
                    checkBox17.setEnabled(false);
                    checkBox18.setEnabled(false);
                    checkBox19.setEnabled(false);
                    checkBox20.setEnabled(false);
                    checkBox21.setEnabled(false);
                    checkBox22.setEnabled(false);
                    checkBox23.setEnabled(false);


                }
                else
                {
                    //if(!checkBox24.isChecked() || !checkBox26.isChecked())
                    count=count-25;
                    checkBox15.setEnabled(true);
                    checkBox17.setEnabled(true);
                    checkBox18.setEnabled(true);
                    checkBox19.setEnabled(true);
                    checkBox20.setEnabled(true);
                    checkBox21.setEnabled(true);
                    checkBox22.setEnabled(true);
                    checkBox23.setEnabled(true);

                }
            }
        });
        checkBox17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox17.isChecked())
                {
                    //if(!checkBox24.isChecked() || !checkBox26.isChecked())
                    count=count+25;
                    // collect.set(3,45);
                    //ar[1]=45;
                    checkBox16.setEnabled(false);
                    checkBox15.setEnabled(false);
                    checkBox18.setEnabled(false);
                    checkBox19.setEnabled(false);
                    checkBox20.setEnabled(false);
                    checkBox21.setEnabled(false);
                    checkBox22.setEnabled(false);
                    checkBox23.setEnabled(false);


                }
                else
                {
                    //if(!checkBox24.isChecked() || !checkBox26.isChecked())
                    count=count-25;
                    checkBox16.setEnabled(true);
                    checkBox15.setEnabled(true);
                    checkBox18.setEnabled(true);
                    checkBox19.setEnabled(true);
                    checkBox20.setEnabled(true);
                    checkBox21.setEnabled(true);
                    checkBox22.setEnabled(true);
                    checkBox23.setEnabled(true);
                }

            }
        });
        checkBox18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox18.isChecked())
                {
                    //if(!checkBox24.isChecked() || !checkBox26.isChecked())
                    count=count+25;
                    // collect.set(3,45);
                    //ar[1]=45;
                    checkBox16.setEnabled(false);
                    checkBox17.setEnabled(false);
                    checkBox15.setEnabled(false);
                    checkBox19.setEnabled(false);
                    checkBox20.setEnabled(false);
                    checkBox21.setEnabled(false);
                    checkBox22.setEnabled(false);
                    checkBox23.setEnabled(false);


                }
                else
                {
                    //if(!checkBox24.isChecked() || !checkBox26.isChecked())
                    count=count-25;
                    checkBox16.setEnabled(true);
                    checkBox17.setEnabled(true);
                    checkBox15.setEnabled(true);
                    checkBox19.setEnabled(true);
                    checkBox20.setEnabled(true);
                    checkBox21.setEnabled(true);
                    checkBox22.setEnabled(true);
                    checkBox23.setEnabled(true);

                }

            }
        });
        checkBox19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox19.isChecked())
                {
                    //if(!checkBox24.isChecked() || !checkBox26.isChecked())
                    count=count+25;
                    // collect.set(3,45);
                    //ar[1]=45;
                    checkBox16.setEnabled(false);
                    checkBox17.setEnabled(false);
                    checkBox18.setEnabled(false);
                    checkBox15.setEnabled(false);
                    checkBox20.setEnabled(false);
                    checkBox21.setEnabled(false);
                    checkBox22.setEnabled(false);
                    checkBox23.setEnabled(false);


                }
                else
                {
                    //if(!checkBox24.isChecked() || !checkBox26.isChecked())
                    count=count-25;
                    checkBox16.setEnabled(true);
                    checkBox17.setEnabled(true);
                    checkBox18.setEnabled(true);
                    checkBox15.setEnabled(true);
                    checkBox20.setEnabled(true);
                    checkBox21.setEnabled(true);
                    checkBox22.setEnabled(true);
                    checkBox23.setEnabled(true);

                }


            }
        });
        checkBox20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox20.isChecked())
                {
                    //if(!checkBox24.isChecked() || !checkBox26.isChecked())
                    count=count+25;
                    // collect.set(3,45);
                    //ar[1]=45;
                    checkBox16.setEnabled(false);
                    checkBox17.setEnabled(false);
                    checkBox18.setEnabled(false);
                    checkBox19.setEnabled(false);
                    checkBox15.setEnabled(false);
                    checkBox21.setEnabled(false);
                    checkBox22.setEnabled(false);
                    checkBox23.setEnabled(false);


                }
                else
                {
                    //if(!checkBox24.isChecked() || !checkBox26.isChecked())
                    count=count-25;
                    checkBox16.setEnabled(true);
                    checkBox17.setEnabled(true);
                    checkBox18.setEnabled(true);
                    checkBox19.setEnabled(true);
                    checkBox15.setEnabled(true);
                    checkBox21.setEnabled(true);
                    checkBox22.setEnabled(true);
                    checkBox23.setEnabled(true);

                }


            }
        });
        checkBox21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox21.isChecked())
                {
                    //if(!checkBox24.isChecked() || !checkBox26.isChecked())
                    count=count+25;
                    // collect.set(3,45);
                    //ar[1]=45;
                    checkBox16.setEnabled(false);
                    checkBox17.setEnabled(false);
                    checkBox18.setEnabled(false);
                    checkBox19.setEnabled(false);
                    checkBox20.setEnabled(false);
                    checkBox15.setEnabled(false);
                    checkBox22.setEnabled(false);
                    checkBox23.setEnabled(false);


                }
                else
                {
                    // if(!checkBox24.isChecked() || !checkBox26.isChecked())
                    count=count-25;
                    checkBox16.setEnabled(true);
                    checkBox17.setEnabled(true);
                    checkBox18.setEnabled(true);
                    checkBox19.setEnabled(true);
                    checkBox20.setEnabled(true);
                    checkBox15.setEnabled(true);
                    checkBox22.setEnabled(true);
                    checkBox23.setEnabled(true);

                }


            }
        });
        checkBox22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox22.isChecked())
                {
                    //if(!checkBox24.isChecked() || !checkBox26.isChecked())
                    count=count+25;
                    // collect.set(3,45);
                    //ar[1]=45;
                    checkBox16.setEnabled(false);
                    checkBox17.setEnabled(false);
                    checkBox18.setEnabled(false);
                    checkBox19.setEnabled(false);
                    checkBox20.setEnabled(false);
                    checkBox21.setEnabled(false);
                    checkBox15.setEnabled(false);
                    checkBox23.setEnabled(false);


                }
                else
                {
                    // if(!checkBox24.isChecked() || !checkBox26.isChecked())
                    count=count-25;
                    checkBox16.setEnabled(true);
                    checkBox17.setEnabled(true);
                    checkBox18.setEnabled(true);
                    checkBox19.setEnabled(true);
                    checkBox20.setEnabled(true);
                    checkBox21.setEnabled(true);
                    checkBox15.setEnabled(true);
                    checkBox23.setEnabled(true);

                }


            }
        });
        checkBox23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox23.isChecked())
                {
                    count=count+0;
                    // collect.set(3,45);
                    //ar[1]=45;
                    checkBox16.setEnabled(false);
                    checkBox17.setEnabled(false);
                    checkBox18.setEnabled(false);
                    checkBox19.setEnabled(false);
                    checkBox20.setEnabled(false);
                    checkBox21.setEnabled(false);
                    checkBox22.setEnabled(false);
                    checkBox15.setEnabled(false);


                }
                else
                {
                    count=count-0;
                    checkBox16.setEnabled(true);
                    checkBox17.setEnabled(true);
                    checkBox18.setEnabled(true);
                    checkBox19.setEnabled(true);
                    checkBox20.setEnabled(true);
                    checkBox21.setEnabled(true);
                    checkBox22.setEnabled(true);
                    checkBox15.setEnabled(true);

                }

            }
        });

        checkBox24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox24.isChecked() )
                {
//                    collect.set(3,45);
                    //ar[1]=45;
                    //if( checkBox23.isChecked()&& !checkBox26.isChecked())
                    count=count+15;
                    checkBox25.setEnabled(false);
                }
                else
                {
                    //if(checkBox23.isChecked())
                    count=count-15;
                    checkBox25.setEnabled(true);

                }

            }
        });
        checkBox25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox25.isChecked() )
                {
                    // collect.set(3,0);
                    checkBox24.setEnabled(false);

                }
                else
                {
                    checkBox24.setEnabled(true);

                }

            }
        });
        checkBox26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox26.isChecked() )
                {
//                    collect.set(3,45);
                    //ar[1]=45;
                    //  if( !checkBox24.isChecked() && !checkBox23.isChecked())
                    count=count+30;
                    checkBox27.setEnabled(false);
                }
                else
                {
                    //if( !checkBox24.isChecked() && !checkBox23.isChecked())
                    count=count-30;
                    checkBox27.setEnabled(true);

                }

            }
        }); checkBox27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox27.isChecked())
                {
                    checkBox26.setEnabled(false);


                }
                else
                {
                    checkBox26.setEnabled(true);

                }

            }
        });
        checkBox28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox28.isChecked())
                {
//                    collect.set(4,5);
                    count=count+5;
                    checkBox29.setEnabled(false);
                }
                else
                {
//                    collect.set(4,0);
                    count=count-5;
                    checkBox29.setEnabled(true);
                }

            }
        });
        checkBox29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox29.isChecked())
                {
                    checkBox28.setEnabled(false);
                }
                else
                {
                    checkBox28.setEnabled(true);
                }

            }
        });
        checkBox30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox30.isChecked())
                {
                    //                  collect.set(5,4);
                    count = count+4;
                    checkBox31.setEnabled(false);
                }
                else
                {
                    //collect.set(5,0);
                    count=count-4;
                    checkBox31.setEnabled(true);
                }

            }
        });
        checkBox31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox31.isChecked())
                {
                    checkBox30.setEnabled(false);
                }
                else
                {
                    checkBox30.setEnabled(true);
                }

            }
        });
        checkBox32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox32.isChecked())
                {
                    //  collect.set(6,4);
                    count=count+4;
                    checkBox33.setEnabled(false);
                }
                else
                {
                    //collect.set(6,0);
                    count=count-4;
                    checkBox33.setEnabled(true);
                }

            }
        });
        checkBox33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox33.isChecked())
                {
                    checkBox32.setEnabled(false);
                }
                else
                {
                    checkBox32.setEnabled(true);
                }

            }
        });
        checkBox34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox34.isChecked())
                {
                    //  collect.set(7,6);
                    count=count+6;
                    checkBox35.setEnabled(false);
                }
                else
                {
                    //collect.set(7,0);
                    count=count-6;
                    checkBox35.setEnabled(true);
                }

            }
        });
        checkBox35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox35.isChecked())
                {
                    checkBox34.setEnabled(false);
                }
                else
                {
                    checkBox34.setEnabled(true);
                }

            }
        });
        checkBox36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox36.isChecked())
                {
                    //     collect.set(8,5);
                    count=count+5;
                    checkBox37.setEnabled(false);
                }
                else
                {
                    // collect.set(8,0);
                    count=count-5;
                    checkBox37.setEnabled(true);
                }
            }
        });
        checkBox37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox37.isChecked())
                {
                    checkBox36.setEnabled(false);
                }
                else
                {
                    checkBox36.setEnabled(true);
                }

            }
        });
        checkBox38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox38.isChecked())
                {
                    //  collect.set(9,4);
                    count=count+4;
                    checkBox39.setEnabled(false);
                }
                else
                {
                    //collect.set(9,0);
                    count=count-4;
                    checkBox39.setEnabled(true);
                }

            }
        });
        checkBox39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox39.isChecked())
                {
                    checkBox38.setEnabled(false);
                }
                else
                {
                    checkBox38.setEnabled(true);
                }
            }
        });

        checkBox40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox40.isChecked())
                {
                    //collect.set(10,6);
                    count=count+6;
                    checkBox41.setEnabled(false);
                }
                else
                {
                    // collect.set(10,0);

                    count=count-6;
                    checkBox41.setEnabled(true);
                }

            }
        });
        checkBox41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox41.isChecked())
                {
                    checkBox40.setEnabled(false);
                }
                else
                {
                    checkBox40.setEnabled(true);
                }
            }
        });
        checkBox42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox42.isChecked())
                {
                    //collect.add(5);
                    count=count+5;
                    checkBox43.setEnabled(false);
                }
                else
                {
                    //collect.remove(11);
                    count=count-5;
                    checkBox43.setEnabled(true);
                }
            }
        });
        checkBox43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox43.isChecked())
                {
                    checkBox42.setEnabled(false);
                }
                else
                {
                    checkBox42.setEnabled(true);
                }

            }
        });

        //s=Double.toString((count/132)*100);
        String s = String.format("%.2f",(count/132)*100 );

        //  percent=(float)(count/132)*100;
        //  percent=(int)count*100;
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                risk.setVisibility(View.VISIBLE);
                recomd.setVisibility(View.VISIBLE);
                note.setVisibility(View.VISIBLE);
                hml.setVisibility(View.VISIBLE);
                risk.setText("Risk of COVID_19*");
                note.setText("*This is based on current understanding of the disease which is subject to change. Please do consult the Doctor and take advice in case you are not feeling well");
                ans.setVisibility(View.VISIBLE);

                if(count<30) {

                    ans.setBackgroundResource(R.drawable.checkback);
                    hml.setText("Low Risk");
                    // hml.setTextColor(0xFF00FF00);
                    recomd.setText("Recommendation = Practice personal hygiene as a prevention measure. Avoid public activities outside home.Avoid any travel unless necessary");
                }
                else if(count<55)
                {
                    ans.setBackgroundResource(R.drawable.checkbacklight);
                    hml.setText("Medium Risk");
                    //hml.setTextColor(0xff6347);
                    recomd.setText("Recommendation = Seek medical evaluation froam a doctor. Maintain social distancing. Avoid any travel unless absolutely necessary");
                }
                else
                {
                    ans.setBackgroundResource(R.drawable.checkbackdark);
                    hml.setText("High Risk");
                    //hml.setTextColor(0x800000);
                    recomd.setText("Recommendation = Home quarantine for 14 days. Avoid public activities outside home.Monitor your health daily for any active symptoms.Avoid any travel unless absolutely necessary");

                }
/*
                for(int i = 0; i < collect.size(); i++)
                {
                    count = count + collect.get(i);
                }
                */
                ans.setText(String.format("%.2f",(count/132)*100 )+"%");

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