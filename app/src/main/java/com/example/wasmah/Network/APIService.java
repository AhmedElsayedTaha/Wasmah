package com.example.wasmah.Network;

import com.example.wasmah.Models.OurBaseClass;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

   @GET("repos")
  Single<List<OurBaseClass>> getRepo(
          @Query("page") int page,
          @Query("per_page") int perPage
  );

  /*@GET("repos")
 Call<List<OurBaseClass>> LOL (
         @Query("page") int page,
         @Query("per_page") int perPage
 );*/
}
