package com.example.wasmah.DataSources;

import com.example.wasmah.Models.OurBaseClass;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

public class RepoDataSourceFactory extends DataSource.Factory {

    //Type of our DataSource which is PagedKeyDataSource
    private MutableLiveData<PageKeyedDataSource<Integer, OurBaseClass>> dataSourceMutableLiveData = new MutableLiveData<>();
   public RepoDataSource repoDataSource = new RepoDataSource();

    //This method will return our data source
    @NonNull
    @Override
    public DataSource create() {

        //Now we will post this value to our live data
        dataSourceMutableLiveData.postValue(repoDataSource);
        return repoDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer,OurBaseClass>> getDataSourceMutableLiveData (){
        return dataSourceMutableLiveData;
    }
}
