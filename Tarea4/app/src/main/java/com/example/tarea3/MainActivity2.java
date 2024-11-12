package com.example.tarea3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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

public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //Vista 1
        //setContentView(R.layout.activity_main);

        //Vista2
        setContentView(R.layout.activity_main2);


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
        Intent intentMain = getIntent();
        String seleccion = intentMain.getStringExtra("seleccion");
        TextView textIngredients = findViewById(R.id.IngredientesReceta);
        TextView textPasos = findViewById(R.id.Pasos1);
        TextView textPasos2 = findViewById(R.id.Pasos2);
        TextView name = findViewById(R.id.Name);
        ImageView imagenReceta = findViewById(R.id.ImagenReceta);
        Button video = findViewById(R.id.video);

        switch(seleccion){
            case "postre":
                setTitle("Postre");
                textIngredients.setText(R.string.IngredientesTiramisu);
                textPasos.setText(R.string.PasoTiramisu);
                name.setText(R.string.NombreTiramisu);
                imagenReceta.setImageResource(R.drawable.recipe_0006_tiramisu);
                video.setOnClickListener((v)->{
                    Intent videointent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/7VTtenyKRg4?si=56Oq8Fp8woUYQye2"));
                    startActivity(videointent);
                });
                break;
            case "cena":
                setTitle("Cena");
                textIngredients.setText(R.string.IngredientesChangua);
                textPasos.setText(R.string.PasoChangua);
                textPasos2.setText("");
                name.setText(R.string.NombreChangua);
                imagenReceta.setImageResource(R.drawable.changua);
                video.setOnClickListener((v)->{
                    Intent videointent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/avYreG_4f7Y?si=ir2XmMzCU-QCaPnD"));
                    startActivity(videointent);
                });
                break;
            case "desayuno":
                setTitle("Desayuno");
                textIngredients.setText(R.string.IngredientesGalleta);
                textPasos.setText(R.string.PasoGalleta);
                textPasos2.setText("");
                name.setText(R.string.NombreGalletas);
                imagenReceta.setImageResource(R.drawable.galleta);
                video.setOnClickListener((v)->{
                    Intent videointent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/kSvexYR2w6E?si=a7gqlTp_JwvtD9Zp"));
                    startActivity(videointent);
                });
                break;
            case "comida":
                setTitle("Comida");
                textIngredients.setText(R.string.IngredientesPiernaMostaza);
                textPasos.setText(R.string.PasoPiernaMostaza);
                textPasos2.setText("");
                name.setText(R.string.NombrePollo);
                imagenReceta.setImageResource(R.drawable.muslo);
                video.setOnClickListener((v)->{
                    Intent videointent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/vAwzoq_rPcg?si=DkM2l1JJO7WVCe92"));
                    startActivity(videointent);
                });
                break;
            default:
                break;
        }


        Button button = findViewById(R.id.regresar);
        button.setOnClickListener((view)->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
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
