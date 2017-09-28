package com.example.administrator.myapplication;

import android.content.res.Configuration;
import android.support.v4.app.FragmentActivity;

import java.util.Locale;

public class Localization {

    private FragmentActivity activity;
    private Configuration configuration;

    private Locale locale;

    public Localization(FragmentActivity activity) {
        this.activity = activity;
        configuration = new Configuration();
    }

    public void init() {
        locale = activity.getResources().getConfiguration().locale;
        if (!locale.toString().equals("en") || !locale.toString().equals("ms"))
            locale = new Locale("en");
        setLocale(locale.toString().toUpperCase());
    }

    public void setLocale(String s) {
        if (s.equals("BM") || s.equals("MS")) {
            locale = new Locale("ms");
        } else if(s.equals("EN")) {
            locale = new Locale("en");
        }
        Locale.setDefault(locale);
        configuration.locale = locale;
        activity.getResources().updateConfiguration(configuration, activity.getResources().getDisplayMetrics());
    }
}
