package com.apps.rizkiadam.latihanretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class ResponseModel {

    List<SuperheroModel> result;
    @SerializedName("status_code")
    private String statusCode;
    @SerializedName("message")
    private String message;

    public List<SuperheroModel> getResult() {
        return result;
    }

    public void setResult(List<SuperheroModel> result) {
        this.result = result;
    }

    public ResponseModel(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
