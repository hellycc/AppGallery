package com.castro.helena.app.appgallery.helena.presentation;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.castro.helena.app.appgallery.helena.R;
import com.castro.helena.app.appgallery.helena.databinding.ActivityMainBinding;
import com.castro.helena.app.appgallery.helena.presentation.dataagg.DataAggViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    DataAggViewModel viewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupMainActivityLayout();
        setupNavHost();
        viewModel = initViewModel();
    }

    private void setupMainActivityLayout() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setSupportActionBar(binding.toolbar);
    }

    private void setupNavHost() {
        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
            NavigationUI.setupActionBarWithNavController(this, navController);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }

    private DataAggViewModel initViewModel() {
        return new ViewModelProvider(this).get(DataAggViewModel.class);
    }


}
