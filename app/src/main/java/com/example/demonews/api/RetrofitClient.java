package com.example.demonews.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
        private static Retrofit retrofit = null;

        public static ApiTopheadlines getNewsTop(){
                if(retrofit == null){
                    retrofit = new Retrofit.Builder()
                            .baseUrl(Constants.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }

                return retrofit.create(ApiTopheadlines.class);
        }
}
