package com.hemmati.mvvmrxjavadagger2example.ui.list;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hemmati.mvvmrxjavadagger2example.R;
import com.hemmati.mvvmrxjavadagger2example.base.BaseFragment;
import com.hemmati.mvvmrxjavadagger2example.model.list.MostViewedVideo;
import com.hemmati.mvvmrxjavadagger2example.ui.detail.ProfileDetailsFragment;
import com.hemmati.mvvmrxjavadagger2example.viewModel.ProfileDetailsViewModel;
import com.hemmati.mvvmrxjavadagger2example.util.ViewModelFactory;
import com.hemmati.mvvmrxjavadagger2example.viewModel.ListViewModel;

import javax.inject.Inject;

public class ListFragment extends BaseFragment implements AparatItemSelectedListener {

    private RecyclerView listView;
    private TextView errorTextView;
    private View loadingView;

    @Inject
    ViewModelFactory viewModelFactory;

    private ListViewModel viewModel;
    private VideoListAdapter adapter;

    @Override
    protected int layoutRes() {
        return R.layout.layout_video_list;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(view);
        initViewModel();
        recyclerViewConfig();
        observableViewModel();
    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListViewModel.class);
        viewModel.fetchList();
    }

    private void recyclerViewConfig() {
        adapter = new VideoListAdapter(this);
        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initView(View view) {
        listView = view.findViewById(R.id.recyclerView);
        errorTextView = view.findViewById(R.id.tv_error);
        loadingView = view.findViewById(R.id.loading_view);
    }

    @Override
    public void onItemSelected(MostViewedVideo mostViewedVideo) {
        ProfileDetailsViewModel profileDetailsViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(ProfileDetailsViewModel.class);
        profileDetailsViewModel.setSelectedVideoItem(mostViewedVideo);

        getBaseActivity().getSupportFragmentManager().beginTransaction().replace(R.id.screenContainer, new ProfileDetailsFragment())
                .addToBackStack(null).commit();
    }

    private void observableViewModel() {
        viewModel.getMostViewList().observe(getViewLifecycleOwner(), mostViewedVideosListModel -> {
            if (mostViewedVideosListModel != null) {
                listView.setVisibility(View.VISIBLE);
                adapter.updateList(mostViewedVideosListModel);
            }
        });


        viewModel.getError().observe(getViewLifecycleOwner(), isError -> {
            if (isError != null) if (isError) {
                errorTextView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
                errorTextView.setText(R.string.listResponseError);
            } else {
                errorTextView.setVisibility(View.GONE);
                errorTextView.setText(null);
            }
        });


        viewModel.getLoading().observe(getViewLifecycleOwner(), isLoading -> {
            if (isLoading != null) {
                loadingView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                if (isLoading) {
                    errorTextView.setVisibility(View.GONE);
                    listView.setVisibility(View.GONE);
                }
            }
        });
    }
}
