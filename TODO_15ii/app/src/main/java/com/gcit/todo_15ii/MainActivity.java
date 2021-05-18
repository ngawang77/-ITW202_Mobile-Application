package com.gcit.todo_15ii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        switch (item.getItemId()) {
            case R.id.nav_import:
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.nav_import));
                return true;

            case R.id.nav_gallery:
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.nav_gallery));
                return true;

            case R.id.nav_slideshow:
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.nav_slideshow));
                return true;

            case R.id.nav_tool:
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.nav_tool));
                return true;


            case R.id.nav_share:
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.nav_share));
                return true;

            case R.id.nav_send:
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.nav_send));
                return true;

            default:
                return false;
        }
    }
}