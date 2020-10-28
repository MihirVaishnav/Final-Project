package com.example.mlkit;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Functions extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    static  final  float END_SCALE = 0.7f;

    RelativeLayout fd,td,bs,rl,contentView;
    TextView func;
    Animation func_back,func_anim;

    ImageButton menuIcon;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_functions);

        contentView = findViewById(R.id.content);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu__icon);

        navigationDrawer();

        func_back = AnimationUtils.loadAnimation(this,R.anim.func_background);
        func_anim = AnimationUtils.loadAnimation(this,R.anim.mid3_animation);
        func = (TextView)findViewById(R.id.func);

        fd = (RelativeLayout)findViewById(R.id.fd);
        td = (RelativeLayout)findViewById(R.id.td);
        bs = (RelativeLayout)findViewById(R.id.bs);
        rl = (RelativeLayout)findViewById(R.id.rl);

        rl.setAnimation(func_back);
        func.setAnimation(func_anim);

        fd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Functions.this,FaceActivity.class);
                startActivity(I);
            }
        });

        td.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Functions.this, TextActivity.class);
                startActivity(I);
            }
        });

        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Functions.this, BarcodeActivity.class);
                startActivity(I);
            }
        });


    }

    private void navigationDrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_func);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {

        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                final float xOffset  = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.nav_face){
            Intent intent = new Intent(this,FaceActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.nav_text){
            Intent intent = new Intent(this,TextActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.nav_barcode){
            Intent intent = new Intent(this,BarcodeActivity.class);
            startActivity(intent);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}