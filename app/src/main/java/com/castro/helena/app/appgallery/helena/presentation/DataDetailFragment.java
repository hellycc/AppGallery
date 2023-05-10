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
import com.castro.helena.app.appgallery.helena.databinding.FragmentDataDetailLandscapeBinding;
import com.castro.helena.app.appgallery.helena.databinding.FragmentDataDetailPortraitBinding;
import com.castro.helena.app.appgallery.helena.presentation.adapter.GetDataDetailAdapter;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ActivityScoped;

@ActivityScoped
public class DataDetailFragment extends Fragment {

    @Inject
    DataAggViewModel viewModel;
    @Inject
    GetDataDetailAdapter mAdapter;
    FragmentDataDetailPortraitBinding portraitBinding;
    FragmentDataDetailLandscapeBinding landscapeBinding;

    public DataDetailFragment() {
        // Required empty public constructor
    }

    @Inject
    public DataDetailFragment(DataAggViewModel viewModel, GetDataDetailAdapter mAdapter) {
        this.viewModel = viewModel;
        this.mAdapter = mAdapter;
    }

    public static DataDetailFragment newInstance(String param1, String param2) {
        DataDetailFragment fragment = new DataDetailFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int orientation = getScreenRotation();
        if (orientation == Surface.ROTATION_90 || orientation == Surface.ROTATION_270) {
            return inflater.inflate(R.layout.fragment_data_detail_landscape, container, false);
        } else {
            return inflater.inflate(R.layout.fragment_data_detail_portrait, container, false);
        }
    }

    private int getScreenRotation() {
        Display display = ((WindowManager) requireContext()
                .getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        return display.getRotation();
    }

}
