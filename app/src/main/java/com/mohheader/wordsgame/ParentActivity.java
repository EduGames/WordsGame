package com.mohheader.wordsgame;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

import java.util.Locale;

/**
 * Created by thedreamer on 7/4/14.
 */
public class ParentActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = getBaseContext().getResources().getConfiguration();
        String lang = "ar";
        if (! "".equals(lang) && ! config.locale.getLanguage().equals(lang)) {
            locale = new Locale(lang);
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }
    }

    private Locale locale = null;
    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        if (locale != null) {
            newConfig.locale = locale;
            Locale.setDefault(locale);
            getBaseContext().getResources().updateConfiguration(newConfig, getBaseContext().getResources().getDisplayMetrics());
        }
    }
}
