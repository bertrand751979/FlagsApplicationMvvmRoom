package com.example.flagsapplicationmvvmroom.fragments;

import static android.app.Activity.RESULT_OK;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.flagsapplicationmvvmroom.R;
import com.example.flagsapplicationmvvmroom.model.Country;
import com.example.flagsapplicationmvvmroom.viewModel.CountryRegisterFragmentViewModel;


public class CountryRegisterFragment extends Fragment {
    private EditText editCountry;
    private EditText editCapital;
    private EditText editFlag;
    private AppCompatImageView photoImageView;
    private Button  btnTakePicture;
    private Button btnAddCountry;
    private CountryRegisterFragmentViewModel countryRegisterFragmentViewModel;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    //Declarer La variable puis l'instancier dans onCreate
    private ActivityResultLauncher<Intent> startCamera  = null;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Saisie");
        countryRegisterFragmentViewModel = new ViewModelProvider(this).get(CountryRegisterFragmentViewModel.class);
        //Instanciation de la variable
        startCamera = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                           setImageCapture(result);
                        }

                    }

                });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register_country,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editCountry = view.findViewById(R.id.edit_country_name);
        editCapital = view.findViewById(R.id.edit_capital_name);
        editFlag = view.findViewById(R.id.edit_country_flag);
        photoImageView = view.findViewById(R.id.edit_camera_picture);
        btnTakePicture = view.findViewById(R.id.btn_take_picture);
        btnTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();

            }
        });
        btnAddCountry = view.findViewById(R.id.btn_save_country);
        btnAddCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Country country = new Country();
                country.setName(editCountry.getText().toString());
                country.setCapital(editCapital.getText().toString());
                country.setFlag(editFlag.getText().toString());
                countryRegisterFragmentViewModel.addCountry(country,getContext());
                Toast.makeText(CountryRegisterFragment.this.getContext(), "Ajouté", Toast.LENGTH_SHORT).show();
            }
        });

        photoImageView.setImageResource(R.drawable.ic_country);

    }




    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startCamera.launch(takePictureIntent);
           // startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

    }

   /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            photoImageView.setImageBitmap(imageBitmap);
        }
    }*/


    private void setImageCapture(ActivityResult result){
        if(result.getData()!=null){
            Bundle extras = result.getData().getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            photoImageView.setImageResource(R.drawable.ic_flags);
        }

    }
}
