package com.example.wasmah.Models;

import android.content.Intent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountriesDetails {

    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("alpha2")
    @Expose
    private String alpha2;
    @SerializedName("alpha3")
    @Expose
    private String alpha3;
    @SerializedName("numeric")
    @Expose
    private Integer numeric;
    @SerializedName("latitude")
    @Expose
    private double  latitude;
    @SerializedName("longitude")
    @Expose
    private double  longitude;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    public String getAlpha3() {
        return alpha3;
    }

    public void setAlpha3(String alpha3) {
        this.alpha3 = alpha3;
    }

    public Integer getNumeric() {
        return numeric;
    }

    public void setNumeric(Integer numeric) {
        this.numeric = numeric;
    }

    public double  getLatitude() {
        return latitude;
    }

    public void setLatitude(double  latitude) {
        this.latitude = latitude;
    }

    public double  getLongitude() {
        return longitude;
    }

    public void setLongitude(double  longitude) {
        this.longitude = longitude;
    }
}
