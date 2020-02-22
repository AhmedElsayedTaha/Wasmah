package com.example.wasmah.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.wasmah.Adapters.RepoAdapter;
import com.example.wasmah.Models.OurBaseClass;
import com.example.wasmah.Network.APIClient;
import com.example.wasmah.Network.APIService;
import com.example.wasmah.R;
import com.example.wasmah.ViewModels.RepoViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class JKRFragment extends Fragment {


    public JKRFragment() {
        // Required empty public constructor
    }

    private View view;
    @BindView(R.id.myRec)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_jeff_kelly_repo, container, false);
        ButterKnife.bind(this,view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        RepoAdapter adapter = new RepoAdapter(getActivity());

        RepoViewModel repoViewModel = ViewModelProviders.of(this).get(RepoViewModel.class);
        repoViewModel.getRepoPagedListLiveData().observe(this, ourBaseClasses -> {

            adapter.submitList(ourBaseClasses);
            recyclerView.setAdapter(adapter);

        });


        repoViewModel.repoDataSourceFactory.repoDataSource.getIsLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoading) {
                if(isLoading)
                    startProgress();
                else
                    stopProgress();
            }
        });

        return view;
    }

    private void startProgress(){
        progressBar.setVisibility(View.VISIBLE);
    }
    private void stopProgress(){
        progressBar.setVisibility(View.GONE);
    }

}
