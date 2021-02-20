package com.example.skillsacademy.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skillsacademy.R;
import com.example.skillsacademy.databinding.LayoutTopSearchesBinding;
import com.example.skillsacademy.home.pojo.Featured;
import com.example.skillsacademy.home.pojo.TopSearches;

import java.util.List;

import static android.view.LayoutInflater.from;

public class TopSearchAdapter extends RecyclerView.Adapter<TopSearchAdapter.TopSearchViewHolder> {
    public Context context;
    public List<TopSearches> searchesList;

    public TopSearchAdapter(Context context, List<TopSearches> searchesList) {
        this.context = context;
        this.searchesList = searchesList;
    }

    @NonNull
    @Override
    public TopSearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutTopSearchesBinding topSearchesBinding= DataBindingUtil.inflate(from(context), R.layout.layout_top_searches,parent,false);
        return new TopSearchViewHolder(topSearchesBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TopSearchViewHolder holder, int position) {
        TopSearches topSearches=searchesList.get(position);
        holder.searchesBinding.setTopsearches(topSearches);
    }

    @Override
    public int getItemCount() {
        return searchesList.size();
    }

    public class TopSearchViewHolder extends RecyclerView.ViewHolder {
        public LayoutTopSearchesBinding searchesBinding;
        public TopSearchViewHolder(@NonNull LayoutTopSearchesBinding topSearchesBinding) {
            super(topSearchesBinding.getRoot());
            this.searchesBinding=topSearchesBinding;
        }
    }
}
