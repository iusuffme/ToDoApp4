package com.geektech.todoapp4;

import android.app.Application;

import androidx.room.Room;

import com.Prefs;
import com.geektech.todoapp4.database.local.AppDataBase;

public class App  extends Application {
   public static AppDataBase dataBase;
   public static Prefs prefs;
    @Override
    public void onCreate() {
        super.onCreate();
        dataBase= Room.databaseBuilder(getApplicationContext(),AppDataBase.class,"dataBase")
                .fallbackToDestructiveMigration().allowMainThreadQueries().build();
        prefs = new Prefs(this);
    }
}
