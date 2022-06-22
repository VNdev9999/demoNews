package com.example.demonews.model;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.demonews.R;

import java.util.List;

public class TopHeadlinesAdapter extends RecyclerView.Adapter<TopHeadlinesAdapter.TopHeadlinesViewHolder> {

    private List<Article> articleList;

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }




    @NonNull
    @Override
    public TopHeadlinesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);
        return new TopHeadlinesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopHeadlinesViewHolder holder, int position) {
        Article article = articleList.get(position);
        if(articleList == null){
            return;
        }
        Log.e("TAG", "onBindViewHolder: "+article.getUrlToImage() );
        Glide.with(holder.itemView.getContext())
                .load(article.getUrlToImage())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        if (articleList != null){
            return articleList.size();
        }
        return 0;
    }


    public class TopHeadlinesViewHolder extends RecyclerView.ViewHolder {
        ImageView img;

        public TopHeadlinesViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_movie);
        }
    }
}
