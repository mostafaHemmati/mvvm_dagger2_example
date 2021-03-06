package com.hemmati.mvvmrxjavadagger2example.ui.main;

import android.os.Bundle;

import com.hemmati.mvvmrxjavadagger2example.R;
import com.hemmati.mvvmrxjavadagger2example.base.BaseActivity;
import com.hemmati.mvvmrxjavadagger2example.ui.list.ListFragment;


public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(R.id.screenContainer, new ListFragment()).commit();
    }
}
