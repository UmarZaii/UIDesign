package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Locale;

import lib.kingja.switchbutton.SwitchMultiButton;

public class MainActivity extends AppCompatActivity implements SwitchMultiButton.OnSwitchListener {

    private FragmentController frgController;
    private Localization localization;
    private SwitchMultiButton btnLanguange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localization = new Localization(this);
        localization.init();

        frgController = new FragmentController(getSupportFragmentManager());
        frgController.stackFragment(new MainFragment(), R.id.contentMain, "Main");

        btnLanguange = (SwitchMultiButton)findViewById(R.id.btnLanguange);
        btnLanguange.setOnSwitchListener(this);
    }

    @Override
    public void onSwitch(int i, String s) {
        localization.setLocale(s);
        frgController.popBackStack("Main");
        frgController.stackFragment(new MainFragment(), R.id.contentMain, "Main");
    }
}
