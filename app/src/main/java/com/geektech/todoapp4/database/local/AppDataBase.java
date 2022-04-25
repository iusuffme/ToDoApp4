package com.geektech.todoapp4.database.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.geektech.todoapp4.Model.Task;

@Database(entities = {Task.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
  public   abstract  RoomDao roomDao();

}
