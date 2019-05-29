package com.example.admin.day02ti2greendao.utils;

import android.app.Application;

public class DbApp extends Application {
    private static DbApp mDbApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mDbApp=this;
    }

    public static DbApp getmDbApp() {
        return mDbApp;
    }
}
