package com.xiq.baseandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.xiq.androidutils.BaseActivity;
import com.xiq.androidutils.BitmapUtils;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView1 = (ImageView)findViewById(R.id.imageView1);
        ImageView imageView2 = (ImageView)findViewById(R.id.imageView2);
        Bitmap bitmap = BitmapFactory.decodeResource (getResources(), R.mipmap.ic_launcher);
        imageView1.setImageBitmap(BitmapUtils.changeBitmapColor(bitmap, Color.parseColor("#FFFF00")));
        imageView2.setImageBitmap(bitmap);
    }
}
