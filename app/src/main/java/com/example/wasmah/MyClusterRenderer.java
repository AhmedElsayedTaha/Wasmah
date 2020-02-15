package com.example.wasmah;

import android.content.Context;
import android.graphics.Color;

import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.ClusterRenderer;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

public class MyClusterRenderer extends DefaultClusterRenderer<ClusterItems> {
    public MyClusterRenderer(Context context, GoogleMap map, ClusterManager<ClusterItems> clusterManager) {
        super(context, map, clusterManager);
    }

    @Override
    protected int getColor(int clusterSize) {
        return Color.parseColor("#567238");
    }
}
