package com.hemmati.mvvmrxjavadagger2example.viewModel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.hemmati.mvvmrxjavadagger2example.model.profile.ProfileModel;
import com.hemmati.mvvmrxjavadagger2example.repository.AparatRepository;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Single;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProfileDetailsViewModelTest extends TestCase {
    @Mock
    private ProfileDetailsViewModel detailsViewModel;

    @Rule
    public InstantTaskExecutorRule executorRule = new InstantTaskExecutorRule();

    @Mock
    private AparatRepository aparatRepository;

    @Mock
    private Observer<ProfileModel> profileModelObserver;

    @Before
    public void setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> Schedulers.trampoline());
        aparatRepository = mock(AparatRepository.class);
        detailsViewModel = new ProfileDetailsViewModel(aparatRepository);
    }

    @Test
    public void test_getProfile_shouldReturn_success() {
        ProfileModel profileModel = new ProfileModel();
        Single<ProfileModel> expectedResponse = Single.just(profileModel);
        when(aparatRepository.getProfile("")).thenReturn(expectedResponse);
        detailsViewModel.getSelectedProfile().observeForever(profileModelObserver);
        detailsViewModel.loadProfile("");
        verify(profileModelObserver).onChanged(profileModel);
        detailsViewModel.getSelectedProfile().removeObserver(profileModelObserver);
    }


}