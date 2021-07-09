package com.omar.getposts.ui.main;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omar.getposts.R;
import com.omar.getposts.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    List<PostModel> postsList = new ArrayList<>();

    @NonNull
    @Override
    public PostAdapter.PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new PostHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_list_item ,parent , false ));
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostHolder holder, int position) {

        holder.titleTv.setText(postsList.get(position).getTitle());
        holder.bodyTv.setText(postsList.get(position).getBody());
        holder.userIDTv.setText(postsList.get(position).getUserId()+"");
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder {
        TextView titleTv , bodyTv , userIDTv;
        public PostHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.title_tv);
            bodyTv  = itemView.findViewById(R.id.body_tv);
            userIDTv = itemView.findViewById(R.id.user_id_tv);
        }
    }

    public void setPostsList(List<PostModel> postsList) {
        this.postsList = postsList;
    }
}
