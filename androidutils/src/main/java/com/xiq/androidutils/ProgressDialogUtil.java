package com.xiq.androidutils;

import android.app.ProgressDialog;
import android.content.Context;


public class ProgressDialogUtil {
    static ProgressDialog progressDlg = null;

    /**
     * 显示一个进度条
     *
     * @param strMessage
     * @param ctx
     */
    public static void showProgressDialog(String strMessage, Context ctx) {
        if (null == progressDlg) {
            progressDlg = new ProgressDialog(ctx);
            progressDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDlg.setTitle("Please wait");
            progressDlg.setMessage(strMessage);
            progressDlg.setIndeterminate(false);
            progressDlg.setCancelable(false);
            progressDlg.show();
        }
    }

    /**
     * 显示一个Loading加载框
     *
     * @param ctx
     */
    public static void showProgressDialog(Context ctx) {
        if (null == progressDlg) {
            progressDlg = new ProgressDialog(ctx);
            progressDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDlg.setTitle("Please wait");
            progressDlg.setMessage("Loading...");
            progressDlg.setIndeterminate(false);
            progressDlg.setCancelable(false);
            progressDlg.show();
        }
    }

    /**
     * 结束进度条
     */
    public static void dismissProgressDialog() {
        if (null != progressDlg) {
            progressDlg.dismiss();
            progressDlg = null;
        }
    }
}
