package com.xiq.androidutils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

/**
 * Created by Tom on 2017/2/10.
 */

public class BitmapUtils {
    /**
     * 不改变透明度的情形下，更改像素点颜色来更改整个图片的颜色（纯色）
     *
     * @param source   原始图片
     * @param newColor 新颜色
     * @return Bitmap 新图片
     */
    public static Bitmap changeBitmapColor(Bitmap source, int newColor) {
        int red = Color.red(newColor);
        int green = Color.green(newColor);
        int blue = Color.blue(newColor);
        Bitmap bitmap = source.copy(Bitmap.Config.ARGB_8888, true);
        for (int i = 0; i < bitmap.getWidth(); i++)
            for (int j = 0; j < bitmap.getHeight(); j++) {
                int color = bitmap.getPixel(i, j);
                int alpha = Color.alpha(color);
                if (alpha != 0)
                    bitmap.setPixel(i, j, Color.argb(alpha, red, green, blue));
            }
        return bitmap;
    }

    /**
     * 将bitmap转为圆形
     *
     * @param source
     * @return
     */
    public static Bitmap getCircleBitmap(Bitmap source) {
        int width = source.getWidth();
        int height = source.getHeight();
        int min = Math.min(width, height);
        Bitmap bitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        float radius = min / 2f;
        canvas.drawCircle(radius, radius, radius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(source, (min - width) / 2f, (min - height) / 2f, paint);
        return bitmap;
    }
}
