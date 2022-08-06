package com.example.flagsapplicationmvvmroom.viewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.flagsapplicationmvvmroom.model.Country;
import com.example.flagsapplicationmvvmroom.repository.RepositoryCountry;

import java.util.List;

public class DisplayFragmentViewModel extends ViewModel {
    public LiveData<List<Country>> getDisplayList (Context context){
        return RepositoryCountry.getInstance().getCountryList(context);
    }

    public void deleteCountry(Country country, Context context){
        RepositoryCountry.getInstance().delete(country,context);
    }
}
