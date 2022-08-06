package com.example.flagsapplicationmvvmroom.activities;

import static com.example.flagsapplicationmvvmroom.activities.MainActivity.COUNTRY_EXTRA;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.flagsapplicationmvvmroom.R;
import com.example.flagsapplicationmvvmroom.model.Country;
import com.example.flagsapplicationmvvmroom.viewModel.CountryDetailsActivityViewModel;

public class CountryDetailsActivity extends AppCompatActivity {
    private EditText detailCountryName;
    private EditText detailCountryCapital;
    private TextView detailCountryFlag;
    private Button detailBtnUpdate;
    private Button detailBtnCancel;
    private Country country;
    private CountryDetailsActivityViewModel countryDetailsActivityViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        country = (Country) getIntent().getSerializableExtra(COUNTRY_EXTRA);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Description");
        countryDetailsActivityViewModel = new ViewModelProvider(this).get(CountryDetailsActivityViewModel.class);
        detailCountryName = findViewById(R.id.desc_country_name);
        detailCountryCapital = findViewById(R.id.desc_country_capital);
        detailCountryFlag = findViewById(R.id.desc_country_flag);
        detailBtnUpdate = findViewById(R.id.desc_btn_update);
        detailBtnCancel = findViewById(R.id.desc_btn_cancel);
        detailCountryName.setText(country.getName());
        detailCountryCapital.setText(country.getCapital());
        detailCountryFlag.setText(country.getFlag());
        detailBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                country.setName(detailCountryName.getText().toString());
                country.setCapital(detailCountryCapital.getText().toString());
                country.setFlag(detailCountryFlag.getText().toString());
                countryDetailsActivityViewModel.updateCountry(country,CountryDetailsActivity.this);
            }
        });

        detailBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
