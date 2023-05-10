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

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DataAggFragment extends Fragment {

    DataAggViewModel viewModel;

    GetDataAggAdapter mAdapter;
    FragmentDataAggPortraitBinding binding;

    public DataAggFragment() {
        // Required empty public constructor
    }

    @Inject
    public DataAggFragment(DataAggViewModel viewModel, GetDataAggAdapter mAdapter) {
        this.viewModel = viewModel;
        this.mAdapter = mAdapter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_agg_portrait, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupBtnSearchListener();
    }

    private void setupBtnSearchListener() {
        String query = (String) binding.searchBar.getText();
        binding.btnSearch.setOnClickListener(v -> {
            if (query != null && !query.isEmpty()) {
                viewModel.fetchGallerySearch(query);
                viewModel.dataAgg.getValue();
            } else {
                Toast.makeText(requireContext(), "Campo de pesquisa vazio!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupAdapter() {

    }

}
