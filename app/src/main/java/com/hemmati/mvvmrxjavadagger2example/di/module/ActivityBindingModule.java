package com.hemmati.mvvmrxjavadagger2example.di.module;

import com.hemmati.mvvmrxjavadagger2example.ui.main.MainActivity;
import com.hemmati.mvvmrxjavadagger2example.ui.main.MainFragmentBindingModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class})
    abstract MainActivity bindMainActivity();
}
