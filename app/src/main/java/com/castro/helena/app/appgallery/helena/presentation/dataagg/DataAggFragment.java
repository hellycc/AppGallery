package com.castro.helena.app.appgallery.helena.presentation.dataagg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.castro.helena.app.appgallery.helena.R;
import com.castro.helena.app.appgallery.helena.databinding.FragmentDataAggPortraitBinding;
import com.castro.helena.app.appgallery.helena.domain.model.DataAgg;
import com.castro.helena.app.appgallery.helena.domain.model.DataDetail;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DataAggFragment extends Fragment {

    DataAggViewModel viewModel;

    GetDataAggAdapter mAdapter;

    DataAgg dataAgg;
    FragmentDataAggPortraitBinding binding;

    public DataAggFragment() {
        // Required empty public constructor
    }

    @Inject
    public DataAggFragment(DataAggViewModel viewModel, GetDataAggAdapter mAdapter, DataAgg dataAgg) {
        this.viewModel = viewModel;
        this.mAdapter = mAdapter;
        this.dataAgg = dataAgg;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateDataAgg();
        setupBtnSearchListener();
    }

    private void setupBtnSearchListener() {
        String query = (String) binding.searchBar.getText();
        binding.btnSearch.setOnClickListener(v -> {
            if (query != null && !query.isEmpty()) {
                viewModel.fetchGallerySearch(query);
            } else {
                Toast.makeText(requireContext(), "Campo de pesquisa vazio!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateDataAgg() {
        GetDataAggAdapter dataAggAdapter = new GetDataAggAdapter(requireContext(), viewModel.dataAgg.getValue());
        binding.rvImages.setAdapter(dataAggAdapter);
    }

}
