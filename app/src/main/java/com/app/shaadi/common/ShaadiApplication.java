package com.app.shaadi.common;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class ShaadiApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
    }

    private void initialize() {
        Stetho.initializeWithDefaults(this);
    }

}
