package com.omar.getposts.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.omar.getposts.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostsViewModel postsViewModel;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel.class);
        postsViewModel.getPosts();
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PostAdapter postAdapter = new PostAdapter();
        recyclerView.setAdapter(postAdapter);
        postsViewModel.postsMutableLiveData.observe(this, new Observer<List>() {
            @Override
            public void onChanged(List list) {
                postAdapter.setPostsList(list);
            }
        });


    }
}