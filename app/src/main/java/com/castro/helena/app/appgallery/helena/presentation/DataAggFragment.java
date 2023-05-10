package com.castro.helena.app.appgallery.helena.presentation;

import static android.content.Context.WINDOW_SERVICE;

import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.castro.helena.app.appgallery.helena.R;
import com.castro.helena.app.appgallery.helena.databinding.FragmentDataAggLandscapeBinding;
import com.castro.helena.app.appgallery.helena.databinding.FragmentDataAggPortraitBinding;
import com.castro.helena.app.appgallery.helena.presentation.adapter.GetDataAggAdapter;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ActivityScoped;

@ActivityScoped
public class DataAggFragment extends Fragment {

    @Inject
    DataAggViewModel viewModel;
    @Inject
    GetDataAggAdapter mAdapter;
    FragmentDataAggPortraitBinding portraitBinding;
    FragmentDataAggLandscapeBinding landscapeBinding;

    public DataAggFragment() {
        // Required empty public constructor
    }

    @Inject
    public DataAggFragment(DataAggViewModel viewModel, GetDataAggAdapter mAdapter) {
        this.viewModel = viewModel;
        this.mAdapter = mAdapter;
    }

    public static DataAggFragment newInstance() {
        DataAggFragment fragment = new DataAggFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int orientation = getScreenRotation();
        if (orientation == Surface.ROTATION_90 || orientation == Surface.ROTATION_270) {
            return inflater.inflate(R.layout.fragment_data_agg_landscape, container, false);
        } else {
            return inflater.inflate(R.layout.fragment_data_agg_portrait, container, false);
        }
    }

    private int getScreenRotation() {
        Display display = ((WindowManager) requireContext()
                .getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        return display.getRotation();
    }

    private void getSearchbarQuery(String query) {
        int orientation = getScreenRotation();
        if (orientation == Surface.ROTATION_90 || orientation == Surface.ROTATION_270) {
            viewModel.getDataAgg(query);
//            portraitBinding.searchBar.getText();
        } else {
//            landscapeBinding.searchBar.getText();
        }
    }

}
