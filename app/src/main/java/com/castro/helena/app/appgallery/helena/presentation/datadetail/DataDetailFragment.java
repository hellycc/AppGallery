package com.castro.helena.app.appgallery.helena.presentation.datadetail;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.castro.helena.app.appgallery.helena.databinding.FragmentDataDetailPortraitBinding;
import com.castro.helena.app.appgallery.helena.domain.model.DataDetail;
import com.castro.helena.app.appgallery.helena.domain.model.Image;
import com.castro.helena.app.appgallery.helena.presentation.dataagg.DataAggViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ActivityScoped;

@ActivityScoped
public class DataDetailFragment extends Fragment {

    DataAggViewModel viewModel;
    GetDataDetailAdapter mAdapter;
    DataDetail dataDetail;
    FragmentDataDetailPortraitBinding portraitBinding;

    public DataDetailFragment() {
        // Required empty public constructor
    }

    @Inject
    public DataDetailFragment(DataAggViewModel viewModel, GetDataDetailAdapter mAdapter, DataDetail dataDetail) {
        this.viewModel = viewModel;
        this.mAdapter = mAdapter;
        this.dataDetail = dataDetail;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateDataDetail();
    }

    private void populateDataDetail() {
        List<Image> images = new ArrayList<>();
        images.addAll(dataDetail.getImages());
        GetDataDetailAdapter detailAdapter = new GetDataDetailAdapter(requireContext(), dataDetail);
        portraitBinding.rvImageDetail.setAdapter(detailAdapter);
    }

}
