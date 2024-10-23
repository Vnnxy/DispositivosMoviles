package com.example.tarea2;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.receta);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        } else {
            // Log or handle the null case if needed
        }

        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.menuSeleccion), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
         */
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.action_bar_home,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int i = R.id.settings;
        int b = R.id.share;
        int c = R.id.favorites;
        int d = R.id.search;
        int id = item.getItemId();
        if(id == i){
            Log.d("Se presionó:",(String) "settings");
            return true;
        } else if(id == b){
            Log.d("Se presionó:",(String) "share");
            return true;
        } else if(id == c){
            Log.d("Se presionó:",(String) "favorites");
            return true;
        } else if(id == d){
            Log.d("Se presionó:",(String) "search");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


} 