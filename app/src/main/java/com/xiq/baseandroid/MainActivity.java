package com.xiq.baseandroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.xiq.androidutils.BaseActivity;
import com.xiq.androidutils.BitmapUtils;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity {
    Context mContext;
    LinearLayout colorViewRGB;
    LinearLayout colorViewHSV;
    float progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        imageView1.setImageBitmap(BitmapUtils.changeBitmapColor(bitmap, Color.parseColor("#FFFF00")));
        imageView2.setImageBitmap(bitmap);

        colorViewRGB = (LinearLayout) findViewById(R.id.colorViewRGB);
        colorViewHSV = (LinearLayout) findViewById(R.id.colorViewHSV);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (progress <= 1) {
                            progress += 0.01;
                            View viewRGB = new View(mContext);
                            viewRGB.setBackgroundColor(computeColor(Color.RED, Color.GREEN, progress));
                            LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(colorViewRGB.getWidth()/100,LinearLayout.LayoutParams.MATCH_PARENT);
                            viewRGB.setLayoutParams(layoutParams1);
                            colorViewRGB.addView(viewRGB);

                            View viewHSV = new View(mContext);
                            viewHSV.setBackgroundColor(getGradientColorValue(progress));
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(colorViewHSV.getWidth()/100,LinearLayout.LayoutParams.MATCH_PARENT);
                            viewHSV.setLayoutParams(layoutParams2);
                            colorViewHSV.addView(viewHSV);
                        }
                    }
                });
            }
        }, 2000, 100);
    }


    public static int computeColor(int fromColor, int toColor, float fraction) {
        fraction = Math.max(Math.min(fraction, 1), 0);

        int minColorA = Color.alpha(fromColor);
        int maxColorA = Color.alpha(toColor);
        int resultA = (int) ((maxColorA - minColorA) * fraction) + minColorA;

        int minColorR = Color.red(fromColor);
        int maxColorR = Color.red(toColor);
        int resultR = (int) ((maxColorR - minColorR) * fraction) + minColorR;

        int minColorG = Color.green(fromColor);
        int maxColorG = Color.green(toColor);
        int resultG = (int) ((maxColorG - minColorG) * fraction) + minColorG;

        int minColorB = Color.blue(fromColor);
        int maxColorB = Color.blue(toColor);
        int resultB = (int) ((maxColorB - minColorB) * fraction) + minColorB;

        return Color.argb(resultA, resultR, resultG, resultB);
    }


    //根据起始颜色和结束颜色以及百分比获取具体颜色值
    @SuppressLint("Range")
    public static int getGradientColorValue(float fraction) {
        int startColor = Color.RED;
        int endColor = Color.GREEN;

        if (fraction > 1) fraction = 1;
        float[] startHsv = new float[3];
        float[] endHsv = new float[3];
        float[] outHsv = new float[3];
        // 把 ARGB 转换成 HSV
        Color.colorToHSV(startColor, startHsv);
        Color.colorToHSV(endColor, endHsv);

        // 计算当前动画完成度（fraction）所对应的颜色值
        if (endHsv[0] - startHsv[0] > 180) {
            endHsv[0] -= 360;
        } else if (endHsv[0] - startHsv[0] < -180) {
            endHsv[0] += 360;
        }
        outHsv[0] = startHsv[0] + (endHsv[0] - startHsv[0]) * fraction;
        if (outHsv[0] > 360) {
            outHsv[0] -= 360;
        } else if (outHsv[0] < 0) {
            outHsv[0] += 360;
        }
        outHsv[1] = startHsv[1] + (endHsv[1] - startHsv[1]) * fraction;
        outHsv[2] = startHsv[2] + (endHsv[2] - startHsv[2]) * fraction;

        // 计算当前动画完成度（fraction）所对应的透明度
        int alpha = startColor >> 24 + (int) ((endColor >> 24 - startColor >> 24) * fraction);

        // 把 HSV 转换回 ARGB 返回
        return Color.HSVToColor(alpha, outHsv);
    }
}
