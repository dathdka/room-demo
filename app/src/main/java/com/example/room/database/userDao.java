package com.example.room.database;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface userDao {
    @Insert
    void insertUser(user u);

    @Query("DELETE FROM users")
    void deleteAll();

    @Query("SELECT * FROM users")
    public List<user> getAllUser();
}
