package com.example.mlkit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TO = 2000;

    View l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    ImageView mlogo;
    TextView m,l;
    Animation tanim, banim,m1anim,m2anim,m3anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        tanim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        banim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        m3anim = AnimationUtils.loadAnimation(this,R.anim.mid3_animation);
        m1anim = AnimationUtils.loadAnimation(this,R.anim.mid1_animation);
        m2anim = AnimationUtils.loadAnimation(this,R.anim.mid2_animation);

        mlogo = (ImageView)findViewById(R.id.main_logo);

        m = findViewById(R.id.M);
        l = findViewById(R.id.L);

        l1 = findViewById(R.id.fl);
        l2 = findViewById(R.id.sl);
        l3 = findViewById(R.id.tl);
        l4 = findViewById(R.id.fol);
        l5 = findViewById(R.id.fil);
        l6 = findViewById(R.id.sil);
        l7 = findViewById(R.id.sel);
        l8 = findViewById(R.id.el);
        l9 = findViewById(R.id.nl);
        l10 = findViewById(R.id.tel);

        m.setAnimation(m1anim);
        l.setAnimation(m2anim);


        l1.setAnimation(tanim);
        l2.setAnimation(tanim);
        l3.setAnimation(tanim);
        l4.setAnimation(tanim);
        l5.setAnimation(tanim);

        l6.setAnimation(banim);
        l7.setAnimation(banim);
        l8.setAnimation(banim);
        l9.setAnimation(banim);
        l10.setAnimation(banim);

        mlogo.setAnimation(m3anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,BoardingScreen.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TO);
    }
}

/*
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
	private String[] classNames;
	private static final Class<?>[] CLASSES = new Class<?>[]{
			TextActivity.class,
			BarcodeActivity.class,
			FaceActivity.class
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		classNames = getResources().getStringArray(R.array.class_name);

		ListView listView = findViewById(R.id.list_view);
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, classNames);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
		Intent intent = new Intent(this, CLASSES[position]);
		intent.putExtra(BaseActivity.ACTION_BAR_TITLE, classNames[position]);
		startActivity(intent);
	}
}
*/