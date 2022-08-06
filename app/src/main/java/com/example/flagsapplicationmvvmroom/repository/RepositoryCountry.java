package com.example.flagsapplicationmvvmroom.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.flagsapplicationmvvmroom.ApplicationDataBase;
import com.example.flagsapplicationmvvmroom.model.Country;

import java.util.List;
import java.util.concurrent.Executors;

public class RepositoryCountry {

    private RepositoryCountry(){}
    public static RepositoryCountry INSTANCE = null;
    public static RepositoryCountry getInstance(){
        if(INSTANCE == null){
            INSTANCE = new RepositoryCountry();
        }
        return INSTANCE;
    }

    public void add(Country country, Context context){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ApplicationDataBase.getInstance(context).getCountryDao().add(country);
            }
        });
    }

    public void delete (Country country, Context context){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ApplicationDataBase.getInstance(context).getCountryDao().delete(country);
            }
        });
    }

    public void update (Country country, Context context){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ApplicationDataBase.getInstance(context).getCountryDao().update(country);
            }
        });
    }
    public LiveData<List<Country>> getCountryList (Context context){
        return ApplicationDataBase.getInstance(context).getCountryDao().getCountryList();
    }
}
