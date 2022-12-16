package com.example.room.database;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface userDao {
    @Insert(onConflict = IGNORE)
    void insertUser(user u);

    @Insert(onConflict = IGNORE)
    void addUser (user a);

    @Query("SELECT * FROM users")
    List<user> getAllUser();
}
