package com.example.flagsapplicationmvvmroom.fragments;

import static com.example.flagsapplicationmvvmroom.activities.MainActivity.COUNTRY_EXTRA;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.flagsapplicationmvvmroom.OnDeleteBtnActionClicked;
import com.example.flagsapplicationmvvmroom.OnMatCardActionClicked;
import com.example.flagsapplicationmvvmroom.R;
import com.example.flagsapplicationmvvmroom.activities.CountryDetailsActivity;
import com.example.flagsapplicationmvvmroom.adapter.CountryAdapter;
import com.example.flagsapplicationmvvmroom.model.Country;
import com.example.flagsapplicationmvvmroom.viewModel.DisplayFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

public class DisplayFragment extends Fragment {
    private RecyclerView recyclerView;
    private CountryAdapter countryAdapter;
    private DisplayFragmentViewModel displayFragmentViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayFragmentViewModel = new ViewModelProvider(this).get(DisplayFragmentViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_display,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_country_list);
        setViewCountry();
    }
    private  void setViewCountry(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        OnMatCardActionClicked onMatCardActionClicked = new OnMatCardActionClicked() {
            @Override
            public void goToDetail(Country country) {
                Intent intent = new Intent(DisplayFragment.this.getContext(), CountryDetailsActivity.class);
                intent.putExtra(COUNTRY_EXTRA, country);
                startActivity(intent);
            }
        };

        OnDeleteBtnActionClicked onDeleteBtnActionClicked = new OnDeleteBtnActionClicked() {
            @Override
            public void delete(Country country) {
                displayFragmentViewModel.deleteCountry(country,getContext());
            }
        };
        countryAdapter = new CountryAdapter(onDeleteBtnActionClicked,onMatCardActionClicked);
        recyclerView.setAdapter(countryAdapter);
        displayFragmentViewModel.getDisplayList(getContext()).observe(getViewLifecycleOwner(), new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                countryAdapter.setListCountryAdapter(new ArrayList<>(countries));
            }
        });
    }
}
