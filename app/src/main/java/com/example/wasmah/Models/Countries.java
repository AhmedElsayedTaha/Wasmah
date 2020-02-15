package com.example.wasmah.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Countries {
    @SerializedName("ref_country_codes")
    @Expose
    private List<CountriesDetails> refCountryCodes = null;

    public List<CountriesDetails> getRefCountryCodes() {
        return refCountryCodes;
    }

    public void setRefCountryCodes(List<CountriesDetails> refCountryCodes) {
        this.refCountryCodes = refCountryCodes;
    }
}
