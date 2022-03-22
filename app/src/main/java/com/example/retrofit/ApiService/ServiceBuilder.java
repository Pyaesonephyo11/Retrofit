package com.example.retrofit.ApiService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {

    private final  String BASE_URL="https://jsonplaceholder.typicode.com/";
    private OkHttpClient.Builder okHttp=new OkHttpClient.Builder();
    private Retrofit.Builder builder=new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build());

    private Retrofit retrofit=builder.build();

    public  <T> T buildService(Class<T> serviceType){
        return retrofit.create(serviceType);
    }
}
