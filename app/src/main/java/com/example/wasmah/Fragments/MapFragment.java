package com.example.wasmah.Fragments;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import okhttp3.internal.Util;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wasmah.ClusterItems;
import com.example.wasmah.Models.Countries;
import com.example.wasmah.MyClusterRenderer;
import com.example.wasmah.R;
import com.example.wasmah.Utilies.AppUtilies;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.ui.IconGenerator;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback , GoogleMap.OnMarkerClickListener {


    public MapFragment() {
        // Required empty public constructor
    }

    private View view;
    private GoogleMap gMap;
    private Countries countries;
    private ClusterManager<ClusterItems> mClusterManager;
     List<String> favouriteList = new ArrayList<>();
    boolean flag = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          view= inflater.inflate(R.layout.fragment_map, container, false);


        String myJson=inputStreamToString(this.getResources().openRawResource(R.raw.countrycodeslatlongalpha3));
         countries = new Gson().fromJson(myJson,Countries.class);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        assert supportMapFragment != null;
        supportMapFragment.getMapAsync(this);




         return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

        mClusterManager = new ClusterManager<>(getActivity(),gMap);
        mClusterManager.setRenderer(new MyClusterRenderer(getActivity(),gMap,mClusterManager));
        gMap.setOnCameraIdleListener(mClusterManager);
        gMap.setOnMarkerClickListener(this);

        for(int i=0;i<countries.getRefCountryCodes().size();i++){
           ClusterItems clusterItems = new ClusterItems(countries.getRefCountryCodes().get(i).getLatitude()
                   ,countries.getRefCountryCodes().get(i).getLongitude()
                    ,countries.getRefCountryCodes().get(i).getCountry());
           mClusterManager.addItem(clusterItems);

        }

    }

    private String inputStreamToString(InputStream inputStream) {
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            return new String(bytes);
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
         flag=false;
        favouriteList = AppUtilies.getFavourites(getActivity());
        marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        String title = marker.getTitle();
        if(favouriteList!=null&&favouriteList.size()>0){
            for(int i=0;i<favouriteList.size();i++) {
                if (title!= null) {
                    if (title .equals(favouriteList.get(i))) {
                        Toast.makeText(getActivity(), "This country already exist", Toast.LENGTH_LONG).show();
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag){
               if(title!=null) {
                    favouriteList.add(title);
                    AppUtilies.SaveFavorites(favouriteList, getActivity());
                    Toast.makeText(getActivity(), "Country Added", Toast.LENGTH_LONG).show();
                    flag=false;
                }

            }

        }
        else {
                favouriteList = new ArrayList<>();
                favouriteList.add(marker.getTitle());
                AppUtilies.SaveFavorites(favouriteList,getActivity());
            }


        return false;
    }
}
