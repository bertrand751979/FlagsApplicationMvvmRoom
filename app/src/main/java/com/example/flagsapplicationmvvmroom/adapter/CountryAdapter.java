package com.example.flagsapplicationmvvmroom.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flagsapplicationmvvmroom.OnDeleteBtnActionClicked;
import com.example.flagsapplicationmvvmroom.OnMatCardActionClicked;
import com.example.flagsapplicationmvvmroom.R;
import com.example.flagsapplicationmvvmroom.model.Country;
import com.example.flagsapplicationmvvmroom.viewHolder.CountryViewHolder;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    private ArrayList<Country> listCountryAdapter = new ArrayList<>();
    private OnDeleteBtnActionClicked onDeleteBtnActionClicked;
    private OnMatCardActionClicked onMatCardActionClicked;

    public CountryAdapter(OnDeleteBtnActionClicked onDeleteBtnActionClicked, OnMatCardActionClicked onMatCardActionClicked) {
        this.onDeleteBtnActionClicked = onDeleteBtnActionClicked;
        this.onMatCardActionClicked = onMatCardActionClicked;
    }

    public void setListCountryAdapter(ArrayList<Country> listCountryAdapter) {
        this.listCountryAdapter = listCountryAdapter;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_country,parent,false);
        return new CountryViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(listCountryAdapter.get(position),onMatCardActionClicked,onDeleteBtnActionClicked );
    }

    @Override
    public int getItemCount() {
        return listCountryAdapter.size();
    }
}
