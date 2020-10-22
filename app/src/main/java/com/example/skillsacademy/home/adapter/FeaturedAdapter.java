package com.example.skillsacademy.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.skillsacademy.R;
import com.example.skillsacademy.databinding.LayoutFeaturedBinding;
import com.example.skillsacademy.home.pojo.Featured;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.LayoutInflater.from;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {
    public Context context;
    public List<Featured> featuredList;

    public FeaturedAdapter(Context context, List<Featured> featuredList) {
        this.context = context;
        this.featuredList = featuredList;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutFeaturedBinding featuredBinding= DataBindingUtil.inflate(from(context), R.layout.layout_featured,parent,false);
        return new FeaturedViewHolder(featuredBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
       Featured featured=featuredList.get(position);
       holder.featuredBinding.setFeatured(featured);
    }

    @Override
    public int getItemCount() {
        return featuredList.size();
    }

    public class FeaturedViewHolder extends RecyclerView.ViewHolder {
        public LayoutFeaturedBinding featuredBinding;
        public FeaturedViewHolder(@NonNull LayoutFeaturedBinding featuredBinding) {
            super(featuredBinding.getRoot());
            this.featuredBinding=featuredBinding;
        }
    }
}
