package com.castro.helena.app.appgallery.helena.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.castro.helena.app.appgallery.helena.R;
import com.castro.helena.app.appgallery.helena.databinding.ActivityMainBinding;


import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    GallerySearchViewModel viewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = initViewModel();
    }

    private GallerySearchViewModel initViewModel() {
        return new ViewModelProvider(this).get(GallerySearchViewModel.class);
    }


    // TODO inflate GallerySearchFragment according to portrait or landscape;

}
