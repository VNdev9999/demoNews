package com.example.demonews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.demonews.api.Constants;
import com.example.demonews.api.RetrofitClient;
import com.example.demonews.model.Article;
import com.example.demonews.model.TopHeadlines;
import com.example.demonews.model.TopHeadlinesAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TopHeadlinesAdapter topHeadlinesAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<Article> mListTop = new ArrayList<Article>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rcv_home);
//        topHeadlinesAdapter = new TopHeadlinesAdapter();
//        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//       recyclerView.setLayoutManager(linearLayoutManager);
//       recyclerView.setAdapter(topHeadlinesAdapter);
       
       fetchTopNews();

    }

    private void fetchTopNews() {
        topHeadlinesAdapter = new TopHeadlinesAdapter();
        RetrofitClient.getNewsTop().callArticle(Constants.COUNTRY,Constants.API_KEY).enqueue(new Callback<TopHeadlines>() {
            @Override
            public void onResponse(Call<TopHeadlines> call, Response<TopHeadlines> response) {
                Log.e("huy", "onResponse: " + response.body());
                topHeadlinesAdapter.setArticleList(response.body().getArticles());
                linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(topHeadlinesAdapter);
            }

            @Override
            public void onFailure(Call<TopHeadlines> call, Throwable t) {

            }
        });



    }


}