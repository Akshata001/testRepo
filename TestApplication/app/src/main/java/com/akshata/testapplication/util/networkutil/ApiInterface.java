package com.akshata.testapplication.util.networkutil;

import com.akshata.testapplication.bean.Videos;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("videos.json")
    Call<List<Videos>> getVideo(
            @Query("page") int pageNo
    );

}
