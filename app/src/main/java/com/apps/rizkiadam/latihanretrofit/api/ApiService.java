package com.apps.rizkiadam.latihanretrofit.api;

import com.apps.rizkiadam.latihanretrofit.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("tambah.php")
    Call<ResponseModel> postSuperhero(@Field("nama") String nama,
                                        @Field("kekuatan") String kekuatan,
                                        @Field("tahun") String tahun);

    //read
    @GET("lihat.php")
    Call<ResponseModel> getSuperhero();
}
