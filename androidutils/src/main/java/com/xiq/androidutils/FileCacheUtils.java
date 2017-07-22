package com.xiq.androidutils;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by ziv on 17/3/12.
 */

public class FileCacheUtils {

    static String TAG = "FileCacheUtils";

    /**
     * 将String类型数据写入文件
     * @param context
     * @param obj
     * @param name
     */
    public static void writeFile(Context context, String obj, String name) {
        if (context != null) {
            File file = context.getFilesDir();
            Log.i(TAG, "======writeFile=" + file.getAbsolutePath() + "/" + name);
            FileOutputStream fos = null;
            try {
                File fileDir = new File(file.getAbsolutePath() + "/" + name.substring(0, name.lastIndexOf("/")));
                if (!fileDir.exists()) {
                    fileDir.mkdirs();
                }
                File file1 = new File(file.getAbsolutePath() + "/" + name);
                fos = new FileOutputStream(file1);
                fos.write(obj.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != fos) {
                        fos.close();
                        Log.i(TAG, "=======writeFile.lenth = " + new File(file.getAbsolutePath() + "/" + name).length());
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    /**
     * 读取文件，返回一个String
     * @param context
     * @param fileName
     * @return
     */
    public static String readFile(Context context, String fileName) {
        fileName = context.getFilesDir().getAbsolutePath() + "/" + fileName;
        Log.i(TAG, "======readFile=" + fileName);
        String res = "";
        if (new File(fileName).exists()) {
            try {
                FileInputStream fin = new FileInputStream(new File(fileName));
                // FileInputStream fin = openFileInput(fileName);
                int length = fin.available();
                byte[] buffer = new byte[length];
                fin.read(buffer);
                //res = EncodingUtils.getString(buffer, "UTF-8");
                fin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Log.e(TAG, "file is not exist");
        }
        return res;

    }
}
