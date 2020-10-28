package com.example.mlkit;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class BoardingScreen extends AppCompatActivity {

    ViewPager vp;
    LinearLayout ll;

    TextView[] mDots;
    SliderAdapter sliderAdapter;

    Button back,nxt,fin;
    int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_boarding_screen);

        back = (Button)findViewById(R.id.prev);
        nxt = (Button)findViewById(R.id.nxt);
        fin = (Button)findViewById(R.id.fin);

        vp = (ViewPager)findViewById(R.id.vp);
        ll = (LinearLayout)findViewById(R.id.ll);

        sliderAdapter = new SliderAdapter(this);
        vp.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        vp.addOnPageChangeListener(viewListener);

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(mCurrentPage+1);
            }
        });

        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(mCurrentPage-1);
            }
        });
    }

    public void addDotsIndicator(int position){
        mDots = new TextView[4];
        ll.removeAllViews();

        for(int i=0; i< mDots.length; i++){
            mDots[i]= new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.b));

            ll.addView(mDots[i]);
        }

        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.w));
            mDots[position].setTextSize(56);
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;

            if(i == 0){
                nxt.setEnabled(true);
                back.setEnabled(false);
                fin.setEnabled(false);

                nxt.setVisibility(View.VISIBLE);
                back.setVisibility(View.INVISIBLE);
                fin.setVisibility(View.INVISIBLE);

            }
            else if(i == mDots.length-1){
                nxt.setEnabled(false);
                nxt.setVisibility(View.INVISIBLE);
                back.setEnabled(true);
                back.setVisibility(View.VISIBLE);
                fin.setEnabled(true);
                fin.setVisibility(View.VISIBLE);
            }
            else{
                nxt.setEnabled(true);
                nxt.setVisibility(View.VISIBLE);
                back.setEnabled(true);
                back.setVisibility(View.VISIBLE);
                fin.setEnabled(false);
                fin.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void openHomePage(){
        Intent I = new Intent(BoardingScreen.this,Functions. class);
        startActivity(I);
    }
}

