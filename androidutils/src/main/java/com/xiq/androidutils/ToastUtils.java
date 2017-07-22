package com.xiq.androidutils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ziv on 17/3/22.
 */

public class ToastUtils {

    private static Toast mToast;

    public static void showToast(Context context, int id) {
        Toast.makeText(context, id, Toast.LENGTH_SHORT).show();

    }

    public static void showToast(Context context, String string) {

        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }

    public static void showToastLong(Context context, String string) {
        Toast.makeText(context, string, Toast.LENGTH_LONG).show();

    }
}
