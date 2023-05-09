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
import com.castro.helena.app.appgallery.helena.databinding.FragmentGallerySearchLandscapeBinding;
import com.castro.helena.app.appgallery.helena.databinding.FragmentGallerySearchPortraitBinding;
import com.castro.helena.app.appgallery.helena.presentation.adapter.GetDataAggAdapter;

import javax.inject.Inject;

import dagger.hilt.android.scopes.FragmentScoped;

@FragmentScoped
public class GallerySearchFragment extends Fragment {

    @Inject
    GetDataAggAdapter mAdapter;
    FragmentGallerySearchPortraitBinding portraitBinding;
    FragmentGallerySearchLandscapeBinding landscapeBinding;

    public GallerySearchFragment() {
        // Required empty public constructor
    }

    public GallerySearchFragment(GetDataAggAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    public static GallerySearchFragment newInstance(String param1, String param2) {
        GallerySearchFragment fragment = new GallerySearchFragment();
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

//        portraitBinding.rvImages.setAdapter(new GetDataAggAdapter());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int orientation = getScreenRotation();
        if (orientation == Surface.ROTATION_90 || orientation == Surface.ROTATION_270) {
            return inflater.inflate(R.layout.fragment_gallery_search_landscape, container, false);
        } else {
            return inflater.inflate(R.layout.fragment_gallery_search_portrait, container, false);
        }
    }

    private int getScreenRotation() {
        Display display = ((WindowManager) requireContext()
                .getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        return display.getRotation();
    }

}
