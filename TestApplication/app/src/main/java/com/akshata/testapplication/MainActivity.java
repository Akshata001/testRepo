package com.akshata.testapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.akshata.testapplication.adapter.VideoAdapter;
import com.akshata.testapplication.bean.Videos;
import com.akshata.testapplication.util.SingletonUtil;
import com.akshata.testapplication.util.networkutil.ApiClient;
import com.akshata.testapplication.util.networkutil.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends ParentActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private List<Videos> videosList;
    private VideoAdapter videoAdapter;
    private int pageNo = 1;
    private RecyclerView recyclerView;
    private SingletonUtil singletonUtil;
    private RelativeLayout relativeLayoutParent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        init();

        //if net connection available, call to api
        if (singletonUtil.isConnectedToInternet(MainActivity.this))
            callToGetVideoList();
        else
            singletonUtil.showSnackBar("Please check internet connection", relativeLayoutParent);
    }

    private void init() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        videosList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewImages);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        singletonUtil = SingletonUtil.getSingletonConfigInstance();
        relativeLayoutParent = (RelativeLayout) findViewById(R.id.relativeLayoutParent);
    }


    /**
     * api call to get video list
     */
    private void callToGetVideoList() {

        final Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiService = retrofit.create(ApiInterface.class);

        Call<List<Videos>> call = apiService.getVideo(pageNo);

        call.enqueue(new Callback<List<Videos>>() {
            @Override
            public void onResponse(Call<List<Videos>> call, Response<List<Videos>> response) {
                Log.d(TAG, "response=" + response.code());

                if (response.isSuccessful()) {
                    onResponseSuccess(response.body());
                } else {
                    //To handle Error response
                }
            }


            @Override
            public void onFailure(Call<List<Videos>> call, Throwable t) {
                // Log error here since request failed
                Log.d(TAG, "onFailure: " + t.getMessage());
//                Toast.makeText(MainActivity.this, "Unable to connect to server at this moment!! Please try again later!!", Toast.LENGTH_SHORT).show();
                singletonUtil.showSnackBar(
                        "Unable to connect to server at this moment!! Please try again later!!",
                        relativeLayoutParent);

            }
        });
    }

    /**
     * handle success response of call
     *
     * @param responseVideosList video list fetched in response
     */
    private void onResponseSuccess(List<Videos> responseVideosList) {

        if (pageNo > 1) {
            //if already 1 page is loaded
            videosList.remove(videosList.size() - 1);
            videoAdapter.notifyItemRemoved(videosList.size());
            videosList.addAll(responseVideosList);
            videoAdapter.notifyDataSetChanged();
            videoAdapter.setLoaded();
        } else {
            //init adapter in case loading first page
            videosList.addAll(responseVideosList);
            videoAdapter = new VideoAdapter(recyclerView, videosList, MainActivity.this);
            recyclerView.setAdapter(videoAdapter);
        }

        pageNo++;

        //set load more listener for the RecyclerView adapter
        videoAdapter.setOnLoadMoreListener(
                new OnLoadMoreListener() {
                    @Override
                    public void onLoadMore() {
                        if (pageNo <= 3) {
                            //on load more, add null item in list to show progressbar
                            videosList.add(null);
                            videoAdapter.notifyItemInserted(videosList.size() - 1);

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    //call again to api for loading next page
                                    callToGetVideoList();
                                }
                            }, 5000);
                        }
                    }
                }

        );
    }


}