package com.hemmati.mvvmrxjavadagger2example.repository;


import com.hemmati.mvvmrxjavadagger2example.model.list.MostViewedVideosListModel;
import com.hemmati.mvvmrxjavadagger2example.model.profile.ProfileModel;

import javax.inject.Inject;

import io.reactivex.Single;


public class AparatRepository {

    private final AparatApiClient aparatApiClient;

    @Inject
    public AparatRepository(AparatApiClient aparatApiClient) {
        this.aparatApiClient = aparatApiClient;
    }

    public Single<MostViewedVideosListModel> getVideoList() {
        return aparatApiClient.getVideoList();
    }

    public Single<ProfileModel> getProfile(String userName) {
        return aparatApiClient.getProfile(userName);
    }
}
