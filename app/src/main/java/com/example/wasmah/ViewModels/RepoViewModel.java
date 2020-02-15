package com.example.wasmah.ViewModels;

import com.example.wasmah.DataSources.RepoDataSource;
import com.example.wasmah.DataSources.RepoDataSourceFactory;
import com.example.wasmah.Models.OurBaseClass;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

public class RepoViewModel extends ViewModel {


    private LiveData<PagedList<OurBaseClass>> repoPagedListLiveData;
   // private LiveData<PageKeyedDataSource<Integer,OurBaseClass>> pageKeyedDataSourceLiveData;

    public RepoViewModel(){
        RepoDataSourceFactory repoDataSourceFactory = new RepoDataSourceFactory();
     //   pageKeyedDataSourceLiveData = repoDataSourceFactory.getDataSourceMutableLiveData();

        PagedList.Config config =
                (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(RepoDataSource.PAGE_SIZE)
                .build();

        repoPagedListLiveData = (new LivePagedListBuilder(repoDataSourceFactory,config)).build();


    }

    public LiveData<PagedList<OurBaseClass>> getRepoPagedListLiveData() {
        return repoPagedListLiveData;
    }
}
