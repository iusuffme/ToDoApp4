package com.geektech.todoapp4.database.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.geektech.todoapp4.Model.Task;

import java.util.List;

@Dao
public interface RoomDao {
    @Query("SELECT * FROM task")
    List<Task> gelAll ();

    @Insert
    void addList(Task task);

    @Delete
    void delete (Task task);
}
