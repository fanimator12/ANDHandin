package com.example.initialapp.RemoteSource.BucketListGenerator.Endpoint;

import com.example.initialapp.Domain.Idea;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BucketListAPI {
    //endpoint

    @GET("idea/{ideaID}/title/")
    Call<Idea> getIdea(@Path("ideaId") int idea);
}
