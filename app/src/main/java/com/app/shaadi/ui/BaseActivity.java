package com.app.shaadi.ui;

/**
 * Created by Ganesh on 18/10/2021.
 */

import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.app.shaadi.R;
import com.app.shaadi.common.ConnectionLiveData;


public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BasesActivity";
    private ConnectionLiveData connectionLiveData;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connectionLiveData = new ConnectionLiveData(this);
        setCustomProgressBar();
    }

    private void setCustomProgressBar() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage(getResources().getString(R.string.progress_msg));
    }

    protected void showProgressBar() {
        if (mProgressDialog != null && !mProgressDialog.isShowing())
            mProgressDialog.show();
    }

    protected void hideProgressBar() {
        if (mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }
}
