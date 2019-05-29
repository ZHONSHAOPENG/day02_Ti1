package com.example.admin.day02ti1mvp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.admin.day02ti1mvp.MainActivity;
import com.example.admin.day02ti1mvp.R;
import com.example.admin.day02ti1mvp.bean.Bean;

import java.util.ArrayList;

public class RlvAdapter extends RecyclerView.Adapter {
    private final MainActivity mContext;
    private final ArrayList<Bean.ResultsBean> mList;

    public RlvAdapter(MainActivity context, ArrayList<Bean.ResultsBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_rlv, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        Glide.with(mContext).load(mList.get(position).getUrl()).apply(new RequestOptions().circleCrop()).into(holder1.mImg);
        holder1.mTv.setText(mList.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView mImg;
        private final TextView mTv;

        public ViewHolder(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.img);
            mTv = itemView.findViewById(R.id.tv);
        }
    }

}
