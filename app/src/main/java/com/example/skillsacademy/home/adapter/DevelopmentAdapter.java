package com.example.skillsacademy.home.adapter;

import android.content.Context;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.skillsacademy.R;
import com.example.skillsacademy.databinding.LayoutDevelopmentBinding;
import com.example.skillsacademy.home.pojo.Devolopment;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.LayoutInflater.from;

public class DevelopmentAdapter extends RecyclerView.Adapter<DevelopmentAdapter.DevelopmentViewHolder> {
 public Context context;
 public List<Devolopment> devolopmentList;
 public LayoutDevelopmentBinding developmentBinding;

    public DevelopmentAdapter(Context context, List<Devolopment> devolopmentList) {
        this.context = context;
        this.devolopmentList = devolopmentList;
    }

    @NonNull
    @Override
    public DevelopmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        developmentBinding= DataBindingUtil.inflate(from(context), R.layout.layout_development,parent,false);
        return new DevelopmentViewHolder(developmentBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DevelopmentViewHolder holder, int position) {
      Devolopment devolopment=devolopmentList.get(position);
      holder.developmentBinding.setDevelopment(devolopment);
    }

    @Override
    public int getItemCount() {
        return devolopmentList.size();
    }

    public class DevelopmentViewHolder extends RecyclerView.ViewHolder {
        public LayoutDevelopmentBinding developmentBinding;
        public DevelopmentViewHolder(@NonNull LayoutDevelopmentBinding developmentBinding) {
            super(developmentBinding.getRoot());
            this.developmentBinding=developmentBinding;
        }
    }
}
