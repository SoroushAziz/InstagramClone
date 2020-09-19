package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("puTtVE3tgMpU4ivJsjdVMGTbk1aMaSofsWjUWr4R")
                // if defined
                .clientKey("dWOOXxSis6t3jCzcWKoiQpZhBVApoLLF3prPWqMv")
                .server("https://parseapi.back4app.com/")
                .build()
        );

    }
}
