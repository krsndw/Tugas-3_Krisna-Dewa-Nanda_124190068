package com.example.intentdandata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ClassModel> classModels;

    public ClassAdapter(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<ClassModel> getClassModels() {
        return classModels;
    }

    public void setClassModels(ArrayList<ClassModel> classModels) {
        this.classModels = classModels;
    }

    @NonNull
    @Override
    public ClassAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassAdapter.ViewHolder viewHolder, int i) {
        Glide.with(context).load(getClassModels().get(i).getImageSeries()).into(viewHolder.ivImageSeries);
        viewHolder.tvNameSeries.setText(getClassModels().get(i).getNameSeries());
    }

    @Override
    public int getItemCount() {
        return getClassModels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImageSeries;
        private TextView tvNameSeries;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImageSeries = itemView.findViewById(R.id.ImageSeries);
            tvNameSeries = itemView.findViewById(R.id.NameSeries);
        }
    }

}
