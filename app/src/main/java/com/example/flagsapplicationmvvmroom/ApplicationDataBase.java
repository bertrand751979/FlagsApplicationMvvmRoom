package com.example.flagsapplicationmvvmroom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.flagsapplicationmvvmroom.model.Country;

@Database(entities = {Country.class},version = 1)
public abstract class ApplicationDataBase extends RoomDatabase {
    private static ApplicationDataBase INSTANCE;
    public abstract CountryDao getCountryDao();
    public static synchronized ApplicationDataBase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ApplicationDataBase.class, "user_app").build();
        }
        return INSTANCE;
    }
}
