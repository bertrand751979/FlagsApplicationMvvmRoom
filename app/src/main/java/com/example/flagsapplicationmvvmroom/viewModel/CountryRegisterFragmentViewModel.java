package com.example.flagsapplicationmvvmroom.viewModel;

import android.content.Context;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.flagsapplicationmvvmroom.model.Country;
import com.example.flagsapplicationmvvmroom.repository.RepositoryCountry;

public class CountryRegisterFragmentViewModel extends ViewModel {
    public void addCountry(Country country, Context context){
        RepositoryCountry.getInstance().add(country,context);
    }


}
