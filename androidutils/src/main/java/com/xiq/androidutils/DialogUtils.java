package com.xiq.androidutils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by ziv on 2017/7/6.
 */

public class DialogUtils {


    /**
     * 带 OK 和 Cancel 按钮的普通弹出框
     * @param context
     * @param message
     * @param positiveClickListener
     * @param negativeClickListener
     */
    public static void showBasicDialog(Context context, String message, DialogInterface.OnClickListener positiveClickListener, DialogInterface.OnClickListener negativeClickListener) {
        final String TAG = "showDialog";
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        //alertDialogBuilder.setTitle("提示");//设置标题
        //alertDialogBuilder.setIcon();//设置图标

    /*设置下方按钮*/
        alertDialogBuilder.setPositiveButton("OK", positiveClickListener);
        alertDialogBuilder.setNegativeButton("Cancel", negativeClickListener);
        //alertDialogBuilder.setNeutralButton();

    /*对话框内容区域的设置提供了多种方法*/
        alertDialogBuilder.setMessage(message);//设置显示文本
        //setItems();//设置对话框内容为简单列表项
        //setSingleChoiceItems();//设置对话框内容为单选列表项
        //setMultiChoiceItems();//设置对话框内容为多选列表项
        //setAdapter();//设置对话框内容为自定义列表项
        //setView();//设置对话框内容为自定义View

        //设置对话框是否可取消
        alertDialogBuilder.setCancelable(true);
        //setCancelListener(onCancelListener);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();//将dialog显示出来
    }

    /**
     * 只有确认按钮的弹出框
     * @param context
     * @param message
     * @param positiveClickListener
     */
    public static void showConfirmDialog(Context context, String message, DialogInterface.OnClickListener positiveClickListener){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setPositiveButton("OK", positiveClickListener);
        alertDialogBuilder.setMessage(message);//设置显示文本
        //设置对话框是否可取消
        alertDialogBuilder.setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();//将dialog显示出来
    }
}
