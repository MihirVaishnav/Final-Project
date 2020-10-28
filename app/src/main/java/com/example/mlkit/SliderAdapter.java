package com.example.mlkit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){

        this.context = context;
    }

    public int[] image = {
        R.drawable.logo_circle,
        R.drawable.face_detection,
        R.drawable.text_detection,
        R.drawable.barcode_scanner
    };

    public String[] head = {
        "MML",
        "FACE DETECTION",
        "TEXT RECOGNITION",
        "BARCODE SCANNER"
    };

    public String[] dec = {
            "Welcome to MML                                      ( MODULES OF ML-KIT )                                       Lets see our Functionality",
            "Face Detection is One of The Coolest Feature in this App. It identifies Human Faces in Digital Images",
            "Text Recognition is very Use-full Feature in this App. It fetches Text from any Image File",
            "Barcode Scanner is also very use-full for Scanning any Barcode which is printed on Products in Shop"
    };


    @Override
    public int getCount() {
        return head.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView iv = (ImageView)view.findViewById(R.id.iv);
        TextView tv = (TextView)view.findViewById(R.id.tv);
        TextView tv2 = (TextView)view.findViewById(R.id.tv2);

        iv.setImageResource(image[position]);
        tv.setText(head[position]);
        tv2.setText(dec[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
