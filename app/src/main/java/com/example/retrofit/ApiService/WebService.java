package com.example.retrofit.ApiService;

import com.example.retrofit.Model.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {
    @GET("photos")
    Call<List<Data>> getData();
}
