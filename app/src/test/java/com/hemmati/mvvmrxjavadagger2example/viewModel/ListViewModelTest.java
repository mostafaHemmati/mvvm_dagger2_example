package com.hemmati.mvvmrxjavadagger2example.viewModel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.hemmati.mvvmrxjavadagger2example.model.list.MostViewedVideo;
import com.hemmati.mvvmrxjavadagger2example.model.list.MostViewedVideosListModel;
import com.hemmati.mvvmrxjavadagger2example.repository.AparatRepository;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ListViewModelTest extends TestCase {

    @Mock
    private ListViewModel listViewModel;

    @Rule
    public InstantTaskExecutorRule executorRule = new InstantTaskExecutorRule();

    @Mock
    private AparatRepository aparatRepository;

    @Mock
    private Observer<List<MostViewedVideo>> apiGetVideoList;

    @Before
    public void setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> Schedulers.trampoline());
        aparatRepository = mock(AparatRepository.class);
        listViewModel=new ListViewModel(aparatRepository);
    }

    @Test
    public void test_getVideoList_shouldReturn_success() {
        Single<MostViewedVideosListModel> expectedResponse = Single.just(new MostViewedVideosListModel());
        when(aparatRepository.getVideoList()).thenReturn(expectedResponse);
        listViewModel.getMostViewList().observeForever(apiGetVideoList);
        listViewModel.fetchList();
        verify(apiGetVideoList).onChanged(null);
        listViewModel.getMostViewList().removeObserver(apiGetVideoList);
    }


}