package com.example.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {user.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract userDao uDao();
}