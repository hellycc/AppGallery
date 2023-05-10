package com.castro.helena.app.appgallery.helena.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.castro.helena.app.appgallery.helena.R;
import com.castro.helena.app.appgallery.helena.databinding.ActivityMainBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    public MainActivity() {
        super(R.layout.activity_main);
    }

    DataAggViewModel viewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = initViewModel();
        if (savedInstanceState == null) {
            getFragment();
        }
    }

    private DataAggViewModel initViewModel() {
        return new ViewModelProvider(this).get(DataAggViewModel.class);
    }

    private void getFragment() {
//        // TODO: some initial data to start Fragment...
//        Bundle bundle = new Bundle();
//        bundle.putInt("some_int", 0);
//
//        getSupportFragmentManager().beginTransaction()
//                .setReorderingAllowed(true)
//                .add(R.id.fragment_container_view, DataAggFragment.class, bundle)
//                .commit();
        DataAggFragment.newInstance();
    }

}
