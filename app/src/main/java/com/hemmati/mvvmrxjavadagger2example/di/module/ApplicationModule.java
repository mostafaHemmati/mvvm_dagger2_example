package com.hemmati.mvvmrxjavadagger2example.di.module;

import com.hemmati.mvvmrxjavadagger2example.repository.AparatApiClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class ApplicationModule {

    private static final String BASE_URL = "https://www.aparat.com/";

    @Singleton
    @Provides
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static AparatApiClient provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(AparatApiClient.class);
    }
}
