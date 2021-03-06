package com.hemmati.mvvmrxjavadagger2example.di.component;


import android.app.Application;

import com.hemmati.mvvmrxjavadagger2example.base.BaseApplication;
import com.hemmati.mvvmrxjavadagger2example.di.module.ActivityBindingModule;
import com.hemmati.mvvmrxjavadagger2example.di.module.ApplicationModule;
import com.hemmati.mvvmrxjavadagger2example.di.module.ContextModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

@Singleton
@Component(modules = {ContextModule.class, ApplicationModule.class, AndroidSupportInjectionModule.class, ActivityBindingModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    void inject(BaseApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }
}