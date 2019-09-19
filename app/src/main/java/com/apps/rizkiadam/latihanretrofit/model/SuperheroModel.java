package com.apps.rizkiadam.latihanretrofit.model;

import com.google.gson.annotations.SerializedName;

public class SuperheroModel {


    @SerializedName("nama")
    private String nama;
    @SerializedName("kekuatan")
    private String kekuatan;
    @SerializedName("tahun")
    private String tahun;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKekuatan() {
        return kekuatan;
    }

    public void setKekuatan(String kekuatan) {
        this.kekuatan = kekuatan;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }
}
