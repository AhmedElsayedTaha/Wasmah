package com.example.wasmah.DataSources;

import android.os.CountDownTimer;
import android.util.Log;
import com.example.wasmah.Models.OurBaseClass;
import com.example.wasmah.Network.APIClient;
import com.example.wasmah.Network.APIService;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class RepoDataSource extends PageKeyedDataSource<Integer, OurBaseClass> {

    public static final int PAGE_SIZE = 15;
    private  static final int FIRST_PAGE = 1;

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    private MutableLiveData<Boolean> isLoading  = new MutableLiveData<>();
    private APIService apiService = APIClient.getRetrofitInstance().create(APIService.class);

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, OurBaseClass> callback) {

        isLoading.postValue(true);
        apiService.getRepo(FIRST_PAGE, PAGE_SIZE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<OurBaseClass>>() {
                    @Override
                    public void onSuccess(List<OurBaseClass> value) {
                        if (value != null)
                            callback.onResult(value, null, FIRST_PAGE + 1);
                        else
                            Log.e("Failed", "initial list null");

                        isLoading.postValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Failed", "failed load init page" + e.getMessage());
                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, OurBaseClass> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, OurBaseClass> callback) {

        isLoading.postValue(true);
        apiService.getRepo(params.key, PAGE_SIZE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<OurBaseClass>>() {
                    @Override
                    public void onSuccess(List<OurBaseClass> value) {
                        if (value != null) {
                        /*    new CountDownTimer(3000,1000){
                                @Override
                                public void onTick(long millisUntilFinished) {
                                }
                                @Override
                                public void onFinish() {
                                    callback.onResult(value, params.key+1);
                                }
                            }.start();*/
                            callback.onResult(value, params.key+1);
                            isLoading.postValue(false);

                        } else
                            Log.e("Failed", "initial list null");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Failed", "failed load after page" + e.getMessage());
                    }
                });
    }
}
