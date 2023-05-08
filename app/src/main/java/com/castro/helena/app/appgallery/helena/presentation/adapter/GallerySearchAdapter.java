package com.castro.helena.app.appgallery.helena.presentation.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.castro.helena.app.appgallery.helena.domain.model.DataAgg;

import javax.inject.Inject;

import dagger.hilt.android.WithFragmentBindings;
import dagger.hilt.android.qualifiers.ActivityContext;

@WithFragmentBindings
public class GallerySearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Context context;
    final DataAgg dataAgg;

    @Inject
    public GallerySearchAdapter(@ActivityContext Context context, DataAgg dataAgg) {
        this.context = context;
        this.dataAgg = dataAgg;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
