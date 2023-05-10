package com.castro.helena.app.appgallery.helena.presentation.dataagg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.castro.helena.app.appgallery.helena.R;
import com.castro.helena.app.appgallery.helena.databinding.ImageListItemBinding;
import com.castro.helena.app.appgallery.helena.domain.model.DataAgg;
import com.castro.helena.app.appgallery.helena.domain.model.DataDetail;

import javax.inject.Inject;

import dagger.hilt.android.WithFragmentBindings;
import dagger.hilt.android.qualifiers.ActivityContext;

@WithFragmentBindings
public class GetDataAggAdapter extends RecyclerView.Adapter<GetDataAggAdapter.DataAggViewHolder> implements ItemDataAggClickListener {

    final Context context;
    final DataAgg dataAgg;

    @Inject
    public GetDataAggAdapter(@ActivityContext Context context, DataAgg dataAgg) {
        this.context = context;
        this.dataAgg = dataAgg;
    }

    @NonNull
    @Override
    public DataAggViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataAggViewHolder(ImageListItemBinding.inflate(
                LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataAggViewHolder holder, int position) {
        if (dataAgg.getImageList() != null) {
            for (DataDetail d : dataAgg.getImageList()) {
                Glide.with(holder.binding.imageView).load(d.getImageUrl())
                        .placeholder(R.drawable.image_search_placeholder)
                        .error(R.drawable.image_search_placeholder)
                        .fitCenter()
                        .into(holder.binding.imageView);
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataAgg.getImageList().size();
    }

    @Override
    public void onItemClicked(DataAgg dataAgg) {
        // TODO navigate to DataDetailFragment;

    }

    public static class DataAggViewHolder extends RecyclerView.ViewHolder {
        ImageListItemBinding binding;
        public DataAggViewHolder(@NonNull ImageListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
