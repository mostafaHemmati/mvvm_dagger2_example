package com.hemmati.mvvmrxjavadagger2example.viewModel;


import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hemmati.mvvmrxjavadagger2example.model.list.MostViewedVideo;
import com.hemmati.mvvmrxjavadagger2example.model.profile.ProfileModel;
import com.hemmati.mvvmrxjavadagger2example.repository.AparatRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ProfileDetailsViewModel extends ViewModel {
    private static final String TAG = "DetailsViewModel";
    private final AparatRepository aparatRepository;
    private CompositeDisposable disposable;

    private MostViewedVideo mostViewedVideo;

    private final MutableLiveData<ProfileModel> profileModelMutableLiveData = new MutableLiveData<>();

    public LiveData<ProfileModel> getSelectedProfile() {
        return profileModelMutableLiveData;
    }

    @Inject
    public ProfileDetailsViewModel(AparatRepository aparatRepository) {
        this.aparatRepository = aparatRepository;
        disposable = new CompositeDisposable();
    }

    public void setSelectedVideoItem(MostViewedVideo item) {
        this.mostViewedVideo = item;
    }


    public void getSelectedProfileUserName() {
        if(mostViewedVideo!=null)
            loadProfile(mostViewedVideo.getUsername());
    }

    public void loadProfile(String user_name) {
        disposable.add(aparatRepository.getProfile(user_name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<ProfileModel>() {

                    @Override
                    public void onSuccess(@NonNull ProfileModel profileModel) {
                        profileModelMutableLiveData.setValue(profileModel);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                }));

    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}
