package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Spinner drink1 , drink2,temp1,temp2,temp3,temp4;
    TextView txv,txv1;
    Button But1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv =(TextView)findViewById(R.id.order1);
        txv1 =(TextView)findViewById(R.id.order2);
        temp1=(Spinner)findViewById(R.id.temp1);
        temp2=(Spinner)findViewById(R.id.temp2);
        temp3=(Spinner)findViewById(R.id.temp3);
        temp4=(Spinner)findViewById(R.id.temp4);
        drink1=(Spinner)findViewById(R.id.drink1);
        drink2=(Spinner)findViewById(R.id.drink2);
        But1=(Button) findViewById(R.id.button);

        drink1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                String[] tempSet;
                if (arg2 == 0)
                    tempSet = getResources().getStringArray(R.array.temp3);
                else
                    tempSet = getResources().getStringArray(R.array.temp);
                ArrayAdapter<String> tempAd = new ArrayAdapter<String>(
                        MainActivity.this,
                        android.R.layout.simple_spinner_item, tempSet);
                tempAd.setDropDownViewResource(
                        android.R.layout.simple_spinner_dropdown_item);
                temp1.setAdapter(tempAd);

                String[] tempSet1;
                if (arg2 == 0)
                    tempSet1 = getResources().getStringArray(R.array.temp2);
                else
                    tempSet1 = getResources().getStringArray(R.array.temp1);
                ArrayAdapter<String> tempAd1 = new ArrayAdapter<String>(
                        MainActivity.this,
                        android.R.layout.simple_spinner_item, tempSet1);
                tempAd1.setDropDownViewResource(
                        android.R.layout.simple_spinner_dropdown_item);
                temp2.setAdapter(tempAd1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });

        drink2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                String[] tempSet;
                tempSet = getResources().getStringArray(R.array.temp);
                ArrayAdapter<String> tempAd = new ArrayAdapter<String>(
                        MainActivity.this,
                        android.R.layout.simple_spinner_item, tempSet);
                tempAd.setDropDownViewResource(
                        android.R.layout.simple_spinner_dropdown_item);
                temp3.setAdapter(tempAd);

                String[] tempSet1;
                    tempSet1 = getResources().getStringArray(R.array.temp4);
                ArrayAdapter<String> tempAd1 = new ArrayAdapter<String>(
                        MainActivity.this,
                        android.R.layout.simple_spinner_item, tempSet1);
                tempAd1.setDropDownViewResource(
                        android.R.layout.simple_spinner_dropdown_item);
                temp4.setAdapter(tempAd1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });


        But1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String msg =drink1.getSelectedItem().toString()+","+
                        temp1.getSelectedItem().toString()+","+
                        temp2.getSelectedItem().toString();
                txv.setText(msg);
                String msg1 =drink2.getSelectedItem().toString()+","+
                        temp3.getSelectedItem().toString()+","+
                        temp4.getSelectedItem().toString();
                txv1.setText(msg1);
            }
        });
           }
    }