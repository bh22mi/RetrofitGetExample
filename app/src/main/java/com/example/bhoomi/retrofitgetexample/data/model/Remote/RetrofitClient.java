package com.example.bhoomi.retrofitgetexample.data.model.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static Retrofit retrofit = null;

    public static Retrofit getClient(String baseurl) {

        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }

}
