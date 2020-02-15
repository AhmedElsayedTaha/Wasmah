package com.example.wasmah;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

public class ClusterItems implements ClusterItem {

    private LatLng positions;
    private String title;

    public ClusterItems(double lat,double lng,String title){
        positions = new LatLng(lat,lng);
        this.title=title;
    }

    @Override
    public LatLng getPosition() {
        return positions;
    }

    @Override
    public String getTitle() {
        return title;
    }


    @Override
    public String getSnippet() {
        return null;
    }
}
