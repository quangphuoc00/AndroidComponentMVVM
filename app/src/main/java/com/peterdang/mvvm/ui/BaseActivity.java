package com.peterdang.mvvm.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.peterdang.mvvm.R;

/**
 * Created by phuoc on 2017-12-02.
 */

public class BaseActivity extends AppCompatActivity {
    ProgressDialog progressDialog;

    protected void showProgressDialog() {
        if(progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setTitle(getString(R.string.please_wait));
        }
        progressDialog.show();
    }

    protected void hideProgressDialog() {
        if(progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setTitle(getString(R.string.please_wait));
        }
        progressDialog.hide();
    }

    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
