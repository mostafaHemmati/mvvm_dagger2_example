package com.hemmati.mvvmrxjavadagger2example.ui.detail;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.hemmati.mvvmrxjavadagger2example.R;
import com.hemmati.mvvmrxjavadagger2example.base.BaseFragment;
import com.hemmati.mvvmrxjavadagger2example.util.ViewModelFactory;
import com.hemmati.mvvmrxjavadagger2example.viewModel.ProfileDetailsViewModel;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class ProfileDetailsFragment extends BaseFragment {

    private ImageView profileImage;
    private TextView userNameTextView;
    private TextView urlTextView;

    @Inject
    ViewModelFactory viewModelFactory;
    private ProfileDetailsViewModel profileDetailsViewModel;

    @Override
    protected int layoutRes() {
        return R.layout.layout_profile_details;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(view);
        initViewModel();
        displayProfile();
    }

    private void initViewModel() {
        profileDetailsViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(ProfileDetailsViewModel.class);
        profileDetailsViewModel.getSelectedProfileUserName();
    }

    private void initView(View view) {
        profileImage = view.findViewById(R.id.profileImage);
        userNameTextView = view.findViewById(R.id.userNameTextView);
        urlTextView = view.findViewById(R.id.urlTextView);
    }


    private void displayProfile() {
        profileDetailsViewModel.getSelectedProfile().observe(getViewLifecycleOwner(), profileModel -> {
            if (profileModel != null) {
                Picasso.get().load(profileModel.getProfile().getPicB()).fit().error(R.drawable.ic_baseline_terrain_24).into(profileImage);
                userNameTextView.setText(profileModel.getProfile().getName());
                urlTextView.setText(profileModel.getProfile().getUrl());

            }
        });
    }
}
