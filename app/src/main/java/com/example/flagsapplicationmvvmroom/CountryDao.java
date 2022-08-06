package com.example.flagsapplicationmvvmroom;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.flagsapplicationmvvmroom.model.Country;

import java.util.List;

@Dao
public interface CountryDao {
    @Query("SELECT * FROM Country")
    LiveData<List<Country>> getCountryList();

    @Insert
    void add(Country country);

    @Delete
    void delete(Country country);

    @Update
    void update(Country country);
}
