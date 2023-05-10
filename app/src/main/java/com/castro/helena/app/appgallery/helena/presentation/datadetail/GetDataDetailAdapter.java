package com.castro.helena.app.appgallery.helena.presentation.datadetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.castro.helena.app.appgallery.helena.R;
import com.castro.helena.app.appgallery.helena.databinding.ImageDetailItemBinding;
import com.castro.helena.app.appgallery.helena.domain.model.DataDetail;
import com.castro.helena.app.appgallery.helena.domain.model.Image;
import com.castro.helena.app.appgallery.helena.domain.model.Tag;

import javax.inject.Inject;

import dagger.hilt.android.WithFragmentBindings;
import dagger.hilt.android.qualifiers.ActivityContext;

@WithFragmentBindings
public class GetDataDetailAdapter extends RecyclerView.Adapter<GetDataDetailAdapter.DataDetailViewHolder> implements ItemDetailClickListener {

    Context context;
    DataDetail dataDetail;

    @Inject
    public GetDataDetailAdapter(@ActivityContext Context context, DataDetail dataDetail) {
        this.context = context;
        this.dataDetail = dataDetail;
    }

    private static void configureItems(@NonNull DataDetailViewHolder holder, DataDetail detail) {
        if (detail.getTags() != null && detail.getImages() != null) {
            for (Tag tag : detail.getTags()) {
                holder.imageDetailItemBinding.tvFollowers.setText(String.valueOf(tag.getFollowers()));
            }
            for (Image image : detail.getImages()) {
                Glide.with(holder.imageDetailItemBinding.imageView).load(image.getImageUrl())
                        .placeholder(R.drawable.image_search_placeholder)
                        .error(R.drawable.image_search_placeholder)
                        .fitCenter()
                        .into(holder.imageDetailItemBinding.imageView);
            }
        }
    }

    @NonNull
    @Override
    public DataDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataDetailViewHolder(ImageDetailItemBinding.inflate(
                LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataDetailViewHolder holder, int position) {
        holder.imageDetailItemBinding.tvTitle.setText(dataDetail.getTitle());
        holder.imageDetailItemBinding.tvDescription.setText(dataDetail.getDescription());
        configureItems(holder, dataDetail);
        holder.imageDetailItemBinding.setItemClickListener(this);
    }

    @Override
    public int getItemCount() {
        return dataDetail.getImages().size();
    }

    @Override
    public void onItemClicked(DataDetail dataDetail) {
        Toast.makeText(context, "Image detail clicked!", Toast.LENGTH_SHORT).show();
    }

    public static class DataDetailViewHolder extends RecyclerView.ViewHolder {
        ImageDetailItemBinding imageDetailItemBinding;

        public DataDetailViewHolder(@NonNull ImageDetailItemBinding imageDetailItemBinding) {
            super(imageDetailItemBinding.getRoot());
            this.imageDetailItemBinding = imageDetailItemBinding;
        }
    }

}
