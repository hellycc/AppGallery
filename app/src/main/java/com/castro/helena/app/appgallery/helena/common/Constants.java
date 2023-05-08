package com.castro.helena.app.appgallery.helena.common;

import javax.inject.Singleton;

@Singleton
public class Constants {

    private static Constants INSTANCE;
    public static final String BASE_URL = "https://api.imgur.com";
    public static final String API_VERSION = "/3/";

    public Constants() {
    }

    public static Constants getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Constants();
        }
        return INSTANCE;
    }

}
