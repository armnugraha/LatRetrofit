package com.apps.rizkiadam.latihanretrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.rizkiadam.latihanretrofit.api.ApiEndPoint;
import com.apps.rizkiadam.latihanretrofit.api.ApiService;
import com.apps.rizkiadam.latihanretrofit.model.ResponseModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {


    private ProgressDialog progress;

    @BindView(R.id.edt_nama)
    EditText edtNama;
    @BindView(R.id.edt_kekuatan)
    EditText edtKekuatan;
    @BindView(R.id.edt_tahun)
    EditText edtTahun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_tambah)
    void tambah() {
        // progress dialog
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        //Get value to variabel
        String nama = edtNama.getText().toString();
        String kekuatan = edtKekuatan.getText().toString();
        String tahun = edtTahun.getText().toString();


        //Declare Retrofit
        ApiService api = ApiEndPoint.getClient().create(ApiService.class);

        Call<ResponseModel> addSuperheroResponseModelCall = api.postSuperhero(nama, kekuatan, tahun);
        addSuperheroResponseModelCall.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                String statusCode = response.body().getStatusCode();
                String message = response.body().getMessage();

                progress.dismiss();
                edtNama.setText("");
                edtKekuatan.setText("");
                edtTahun.setText("");

                if (statusCode.equals("200")) {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                } else if (statusCode.equals("404")) {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                } else if (statusCode.equals("500")) {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(MainActivity.this, "Oops, your connection is WONGKY! ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.btn_lihat)
    void lihat() {

        Intent i = new Intent(this, TampilActivity.class);
        startActivity(i);
    }

}
