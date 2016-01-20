package com.example.jewel.myappthemecolour;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.jewel.myappthemecolour.adapter.DegainDemoPagerAdapter;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout layout;
    NavigationView navigationView;
    FloatingActionButton fab;
    TabLayout tl;
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        DegainDemoPagerAdapter adapter=new DegainDemoPagerAdapter(getSupportFragmentManager());
        layout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView=(NavigationView)findViewById(R.id.nagivation);
        fab=(FloatingActionButton)findViewById(R.id.fab);
        tl=(TabLayout)findViewById(R.id.tab_layout);
        vp=(ViewPager)findViewById(R.id.viewpager);
        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"floating",Toast.LENGTH_SHORT).show();
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                layout.closeDrawers();
                Toast.makeText(MainActivity.this,menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:

                if (layout.isDrawerOpen(GravityCompat.START)) {

                    layout.closeDrawer(GravityCompat.START);
                }
                else {
                    layout.openDrawer(GravityCompat.START);
                }

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
