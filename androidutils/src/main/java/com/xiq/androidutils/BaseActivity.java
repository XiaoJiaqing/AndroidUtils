package com.xiq.androidutils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    protected void showToast(String str) {

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    protected void pushActiviy(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
