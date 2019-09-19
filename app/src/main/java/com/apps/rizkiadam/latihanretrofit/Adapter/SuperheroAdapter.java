package com.apps.rizkiadam.latihanretrofit.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.rizkiadam.latihanretrofit.R;
import com.apps.rizkiadam.latihanretrofit.model.SuperheroModel;

import java.util.List;

public class SuperheroAdapter extends RecyclerView.Adapter<SuperheroAdapter.MyHolder> {
    List<SuperheroModel> mList ;
    Context ctx;

    public SuperheroAdapter(Context ctx, List<SuperheroModel> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }




    @Override
    public SuperheroAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;

    }

    @Override
    public void onBindViewHolder(SuperheroAdapter.MyHolder holder, final int position) {
        SuperheroModel superheroModel = mList.get(position);
        holder.nama.setText(superheroModel.getNama());
        holder.tahun.setText(superheroModel.getTahun());
        holder.kekuatan.setText(superheroModel.getKekuatan());


    }

    @Override
    public int getItemCount()
    {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView nama, kekuatan, tahun;
        SuperheroModel SuperheroModel;
        public MyHolder(View v)
        {
            super(v);

            nama  = (TextView) v.findViewById(R.id.txtNama);
            tahun = (TextView) v.findViewById(R.id.txtKekuatan);
            kekuatan = (TextView) v.findViewById(R.id.txtTahun);


        }

    }
}