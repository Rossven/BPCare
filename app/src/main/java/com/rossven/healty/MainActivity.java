package com.rossven.healty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {


    private DataAccess databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton history;
        TextView kucukView,buyukView;
        history = findViewById(R.id.historyButton);
        kucukView = findViewById(R.id.kucuk_tans);
        buyukView = findViewById(R.id.buyuk_tans);


        Intent intent = new Intent(this, RateService.class);
        startService(intent);

        RateService rateService = new RateService();

        databaseHelper = new DataAccess(this);
        databaseHelper.connectToDatabase();

        history.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent2 = new Intent(MainActivity.this, DataView.class);
                startActivity(intent2);
            }
        });

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try{
                    rateService.setPressuresFunc();
                    buyukView.setText(String.valueOf(rateService.pressures[0]));
                    kucukView.setText(String.valueOf(rateService.pressures[1]));

                    if(rateService.pressures[2]>3 || rateService.pressures[2]<2){
                        Toast.makeText(getApplicationContext(),rateService.Stages(rateService.pressures),Toast.LENGTH_SHORT).show();
                    }

                    Informations informations1 = new Informations("Atakan",rateService.pressures[0],rateService.pressures[1],new Date());
                    databaseHelper.addInf(informations1);

                }
                catch (Exception e) {
                    // TODO: handle exception
                }
                finally{
                    //also call the same runnable to call it at regular interval
                    handler.postDelayed(this, 5000);
                }
            }
        };

        //runnable must be execute once
        handler.post(runnable);

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (databaseHelper != null){
            databaseHelper.closeDatabase();
        }
    }



}



