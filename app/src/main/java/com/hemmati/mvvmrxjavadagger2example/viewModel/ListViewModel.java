package com.hemmati.mvvmrxjavadagger2example.viewModel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hemmati.mvvmrxjavadagger2example.model.list.MostViewedVideo;
import com.hemmati.mvvmrxjavadagger2example.model.list.MostViewedVideosListModel;
import com.hemmati.mvvmrxjavadagger2example.repository.AparatRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ListViewModel extends ViewModel {

    private final AparatRepository aparatRepository;
    private CompositeDisposable disposable;

    private final MutableLiveData<List<MostViewedVideo>> mostViewLiveData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public ListViewModel(AparatRepository aparatRepository) {
        this.aparatRepository = aparatRepository;
        disposable = new CompositeDisposable();
    }

    public LiveData<List<MostViewedVideo>> getMostViewList() {
        return mostViewLiveData;
    }
    public LiveData<Boolean> getError() {
        return repoLoadError;
    }
    public LiveData<Boolean> getLoading() {
        return loading;
    }

    public void fetchList() {
        loading.setValue(true);
        disposable.add(aparatRepository.getVideoList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<MostViewedVideosListModel>() {
                    @Override
                    public void onSuccess(@NonNull MostViewedVideosListModel videosListModel) {
                        repoLoadError.setValue(false);
                        mostViewLiveData.setValue(videosListModel.getMostViewedVideos());
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        repoLoadError.setValue(true);
                        loading.setValue(false);
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
