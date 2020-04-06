package com.example.ac_twitterclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("VXVCh5mEoOV1YhjzfeA4xBWOvMqwQL78X9Bypcef")
                .clientKey("XZGriaqldVrmukzwNtb3JJCBlbqtubGrDfIuJahj")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
