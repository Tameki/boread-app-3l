package com.geektech.boredapp3l;

import android.app.Application;

import com.geektech.boredapp3l.utils.AppPreferences;
import com.geektech.boredapp3l.utils.ISharedStorage;
import com.geektech.boredapp3l.utils.SharedStorage;

public class App extends Application {

    private static ISharedStorage sharedStorage;
    public static AppPreferences appPreferences;

    @Override
    public void onCreate() {
        super.onCreate();

        sharedStorage = new SharedStorage(this, "prefs");
        appPreferences = new AppPreferences(sharedStorage);
    }

}
