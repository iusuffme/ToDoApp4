package com;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    private SharedPreferences preferences;
    private Context context;

    public Prefs(Context context) {
        this.preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
    }

    public void saveBoardState() {
        preferences.edit().putBoolean("isShow", true).apply();
    }

    public boolean isBoardShow() {
        return preferences.getBoolean("isShow", false);
    }



}
