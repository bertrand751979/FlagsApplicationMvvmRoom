package com.example.flagsapplicationmvvmroom.viewModel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.flagsapplicationmvvmroom.model.Country;
import com.example.flagsapplicationmvvmroom.repository.RepositoryCountry;

public class CountryDetailsActivityViewModel extends ViewModel {
    public void updateCountry(Country country, Context context){
        RepositoryCountry.getInstance().update(country,context);
    }
}
