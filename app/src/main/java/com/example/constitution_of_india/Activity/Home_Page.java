package com.example.constitution_of_india.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.constitution_of_india.Fragmets.AboutActivity;
import com.example.constitution_of_india.Fragmets.ContactUs;
import com.example.constitution_of_india.Fragmets.HomeFragment;
import com.example.constitution_of_india.Fragmets.NightModeActivity;
import com.example.constitution_of_india.Fragmets.NotesActivity;
import com.example.constitution_of_india.Fragmets.NotificationsActivity;
import com.example.constitution_of_india.R;
import com.example.constitution_of_india.Fragmets.RateUsActivity;
import com.google.android.datatransport.backend.cct.BuildConfig;
import com.google.android.material.navigation.NavigationView;

public class Home_Page extends AppCompatActivity {
    TextView btn4, btn7, btn6, btn8, btn9, btn5;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Button share;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        btn4 = findViewById(R.id.btn4);
        btn7 = findViewById(R.id.btn7);
        btn6 = findViewById(R.id.btn6);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn5 = findViewById(R.id.btn5);
        toolbar = findViewById(R.id.toolbar);
        share = findViewById(R.id.share);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);


        View header = navigationView.getHeaderView(0);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Page.this, PreambleActivity.class);
                startActivity(intent);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Page.this, Amenment_api_calling.class);
                startActivity(intent);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Page.this, Schedule_Api_calling.class);
                startActivity(intent);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Page.this, NewsArticles_ApiCalling.class);
                startActivity(intent);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(Intent.ACTION_SEND);
                inten.setType("text/plain");
                String shareBody = "Your Body here";
                String shareSub = "Your Subject here";
                inten.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                inten.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(inten,"Share Via"));
                startActivity(inten);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Page.this, CaseStudies_ApiCalling.class);
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Page.this, Parts_apicalling.class);
                startActivity(intent);
            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);

        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                        break;

                    case R.id.nav_about:
                        Intent intent1 = new Intent(Home_Page.this, AboutActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.nav_notification:
                        Intent intent = new Intent(Home_Page.this, NotificationsActivity.class);
                        startActivity(intent);
                        break;


                    case R.id.nav_notes:
                        Intent intent3 = new Intent(Home_Page.this, NotesActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.nav_nightmode:
                        Intent intent4 = new Intent(Home_Page.this, NightModeActivity.class);
                        startActivity(intent4);
                        break;

                    case R.id.nav_rateus:
                        Intent intent5 = new Intent(Home_Page.this, RateUsActivity.class);
                        startActivity(intent5);
                        break;
                    case R.id.nav_contact_us:
                        Intent intent6 = new Intent(Home_Page.this, ContactUs.class);
                        startActivity(intent6);
                        break;



                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }

        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}

