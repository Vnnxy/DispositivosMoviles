package com.example.tarea3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Set;

public class MainActivity4 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        SharedPreferences sharedPreferences = getSharedPreferences("names",Context.MODE_PRIVATE);
        Set<String> nombres = sharedPreferences.getStringSet("names",null);
        String[] list;
        if (nombres == null)
            list = new String[]{"No hay recetas"};
        else {
            int n = nombres.size();
            list = new String[n];
            int c = 0;
            for (String s : nombres){
                list[c++] = s;
            }
        }
        ListView simpleList = findViewById(R.id.simpleListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.activity_list,R.id.textView,list);
        simpleList.setAdapter(arrayAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selecteditem = (String) parent.getItemAtPosition(position);
                displayToast(selecteditem);
                Intent intent = new Intent(MainActivity4.this,MainActivity2.class);
                intent.putExtra("seleccion",selecteditem);
                startActivity(intent);
            }
        });



        Toolbar toolbars = findViewById(R.id.toolbar);
        setSupportActionBar(toolbars);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbars, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus_menu_main, menu);
        return true;
    }

    /**
     * Handles app bar item clicks.
     *
     * @param item Item clicked.
     * @return Returns true if one of the defined items was clicked.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_search) {
            displayToast(getString(R.string.action_search_message));
            displayLog(getString(R.string.action_search_message));
            return true;
        } else if (id == R.id.action_setting) {
            displayToast(getString(R.string.action_setting_message));
            displayLog(getString(R.string.action_setting_message));
            return true;
        } else if (id == R.id.action_share) {
            displayToast(getString(R.string.action_share_message));
            displayLog(getString(R.string.action_share_message));
            return true;
        } else if (id == R.id.action_favorites) {
            displayToast(getString(R.string.action_favorites_message));
            displayLog(getString(R.string.action_favorites_message));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /**
     * Shows a message that the donut image was clicked.

     /**
     * Displays a Toast message for the food order.
     *
     * @param message Message to display.
     */

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void displayLog(String message){
        Log.d("Currently pressed", message);
    }

    /**
     * Handles the Back button: closes the nav drawer.
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        // Handle navigation view item clicks here.
        int itemId = menuItem.getItemId();
        if (itemId == R.id.nav_gallery) {
            // Handle the gallery action (for now display a toast).
            drawer.closeDrawer(GravityCompat.START);
            displayToast(getString(R.string.chose_gallery));
            displayLog(getString(R.string.chose_gallery));
            return true;
        } else if (itemId == R.id.nav_create) {
            // Handle the tools action (for now display a toast).
            drawer.closeDrawer(GravityCompat.START);
            displayToast(getString(R.string.chose_create));
            displayLog(getString(R.string.chose_create));
            Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.acc_set) {
            // Handle the share action (for now display a toast).
            drawer.closeDrawer(GravityCompat.START);
            displayToast(getString(R.string.chose_acc));
            displayLog(getString(R.string.chose_acc));
            return true;
        } else if (itemId == R.id.nav_fav) {
            // Handle the send action (for now display a toast).
            drawer.closeDrawer(GravityCompat.START);
            displayToast(getString(R.string.chose_favs));
            displayLog(getString(R.string.chose_favs));
            return true;
        }
        return false;
    }
}