package com.socialapp.socialhelpapp.Adapters;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.socialapp.socialhelpapp.Models.ServiceList_Model;
import com.socialapp.socialhelpapp.R;
import com.socialapp.socialhelpapp.ServiceActivity;
import com.socialapp.socialhelpapp.TollFreeNumberActivity;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MainViewHolder> {

    private List<ServiceList_Model> servicelist;

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        private ImageView mImageView;
        private CoordinatorLayout container;
        private MainViewHolder(View view) {
            super(view);
            mTextView = view.findViewById(R.id.service_name_main);
            mImageView = view.findViewById(R.id.service_image);
            container = view.findViewById(R.id.service_bar);
        }
    }

    public HomeAdapter(List<ServiceList_Model> servicelist) {
        this.servicelist = servicelist;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View serviceview = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_bar, parent, false);
        return new MainViewHolder(serviceview);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        ServiceList_Model service = servicelist.get(position);
        holder.mTextView.setText(service.getServicename());
        Glide.with(holder.mImageView.getContext()).load(service.getImageUrl()).into(holder.mImageView);
                holder.container.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent in = new Intent(view.getContext(), TollFreeNumberActivity.class);
                        view.getContext().startActivity(in);
                    }
                });
    }
    @Override
    public int getItemCount() {
        return servicelist.size();
    }
}
