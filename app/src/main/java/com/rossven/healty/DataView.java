package com.rossven.healty;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;



public class DataView extends AppCompatActivity {

    RecyclerView recyclerView;
    DataAccessHelper dataAccessHelper;
    ArrayList<String> id, name, dia, sys, date;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_view);

        recyclerView = findViewById(R.id.recyclerView);


        dataAccessHelper = new DataAccessHelper(DataView.this);
        id = new ArrayList<>();
        name = new ArrayList<>();
        dia = new ArrayList<>();
        sys = new ArrayList<>();
        date = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter( DataView.this, id, name, dia, sys, date);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(DataView.this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.delete_all){
            confirmDialog();
        }
        return super.onOptionsItemSelected(item);
    }


    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Tüm veriler silinecek");
        builder.setMessage("Tüm verileri silmek istediğinizden emin misiniz ?");
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DataAccess dbHelper = new DataAccess(DataView.this);
                dbHelper.deleteAllData();
                /*Intent homepage = new Intent(MainActivity.this, MainActivity.class);
                startActivity(homepage);*/
                finish();
            }
        });
        builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

    void storeDataInArrays(){
        Cursor cursor = dataAccessHelper.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No Data.", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                dia.add(cursor.getString(2));
                sys.add(cursor.getString(3));
                date.add(cursor.getString(4));


            }
        }
    }
}