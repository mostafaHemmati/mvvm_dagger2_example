package com.hemmati.mvvmrxjavadagger2example.di.module;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.hemmati.mvvmrxjavadagger2example.di.util.ViewModelKey;
import com.hemmati.mvvmrxjavadagger2example.viewModel.ProfileDetailsViewModel;
import com.hemmati.mvvmrxjavadagger2example.viewModel.ListViewModel;
import com.hemmati.mvvmrxjavadagger2example.util.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel.class)
    abstract ViewModel bindListViewModel(ListViewModel listViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProfileDetailsViewModel.class)
    abstract ViewModel bindDetailsViewModel(ProfileDetailsViewModel profileDetailsViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
