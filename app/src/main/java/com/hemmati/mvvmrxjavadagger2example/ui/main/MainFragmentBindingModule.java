package com.hemmati.mvvmrxjavadagger2example.ui.main;


import com.hemmati.mvvmrxjavadagger2example.ui.detail.ProfileDetailsFragment;
import com.hemmati.mvvmrxjavadagger2example.ui.list.ListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract ListFragment provideListFragment();

    @ContributesAndroidInjector
    abstract ProfileDetailsFragment provideDetailsFragment();
}
