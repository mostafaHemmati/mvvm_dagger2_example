package com.hemmati.mvvmrxjavadagger2example.repository;

import com.hemmati.mvvmrxjavadagger2example.model.list.MostViewedVideosListModel;
import com.hemmati.mvvmrxjavadagger2example.model.profile.ProfileModel;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AparatApiClient {

    @GET("etc/api/mostviewedvideos")
    Single<MostViewedVideosListModel> getVideoList();

    @GET("etc/api/profile/username/{username}")
    Single<ProfileModel> getProfile(@Path("username") String username);
}
