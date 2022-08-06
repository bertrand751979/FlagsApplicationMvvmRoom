package com.example.flagsapplicationmvvmroom.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flagsapplicationmvvmroom.OnDeleteBtnActionClicked;
import com.example.flagsapplicationmvvmroom.OnMatCardActionClicked;
import com.example.flagsapplicationmvvmroom.R;
import com.example.flagsapplicationmvvmroom.model.Country;
import com.google.android.material.card.MaterialCardView;

public class CountryViewHolder extends RecyclerView.ViewHolder {
    private TextView vhCountryName;
    private TextView vhCountryCapital;
    private TextView vhCountryFlag;
    private ImageView vhDeleteCountry;
    private MaterialCardView vhMatCard;

    public CountryViewHolder(@NonNull View view) {
        super(view);
        vhCountryName = view.findViewById(R.id.raw_country_name);
        vhCountryCapital = view.findViewById(R.id.raw_country_capital);
        vhCountryFlag = view.findViewById(R.id.raw_country_flag);
        vhDeleteCountry = view.findViewById(R.id.raw_btn_delete);
        vhMatCard =  view.findViewById(R.id.raw_mat_card);
    }

    public TextView getVhCountryName() {
        return vhCountryName;
    }

    public void setVhCountryName(TextView vhCountryName) {
        this.vhCountryName = vhCountryName;
    }

    public TextView getVhCountryCapital() {
        return vhCountryCapital;
    }

    public void setVhCountryCapital(TextView vhCountryCapital) {
        this.vhCountryCapital = vhCountryCapital;
    }

    public TextView getVhCountryFlag() {
        return vhCountryFlag;
    }

    public void setVhCountryFlag(TextView vhCountryFlag) {
        this.vhCountryFlag = vhCountryFlag;
    }

    public ImageView getVhDeleteCountry() {
        return vhDeleteCountry;
    }

    public void setVhDeleteCountry(ImageView vhDeleteCountry) {
        this.vhDeleteCountry = vhDeleteCountry;
    }

    public MaterialCardView getVhMatCard() {
        return vhMatCard;
    }

    public void setVhMatCard(MaterialCardView vhMatCard) {
        this.vhMatCard = vhMatCard;
    }

    public void bind (Country country, OnMatCardActionClicked onMatCardActionClicked, OnDeleteBtnActionClicked onDeleteBtnActionClicked){
        vhCountryName.setText(country.getName());
        vhCountryCapital.setText(country.getCapital());
        vhCountryFlag.setText(country.getFlag());
        vhDeleteCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDeleteBtnActionClicked.delete(country);
            }
        });
        vhMatCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMatCardActionClicked.goToDetail(country);
            }
        });
    }
}
