package com.example.admin.day02ti1mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.admin.day02ti1mvp.adapter.RlvAdapter;
import com.example.admin.day02ti1mvp.bean.Bean;
import com.example.admin.day02ti1mvp.model.ImpModelFuli;
import com.example.admin.day02ti1mvp.presenter.ImpPresenterFuli;
import com.example.admin.day02ti1mvp.view.MyView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyView {

    private RecyclerView mRlv;
    private ArrayList<Bean.ResultsBean> mList;
    private RlvAdapter mRlvAdapter;
    private ImpPresenterFuli mImpPresenterFuli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImpPresenterFuli = new ImpPresenterFuli(new ImpModelFuli(), this);
        initData();
        initView();
    }

    private void initData() {
        mImpPresenterFuli.getData();
    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mList = new ArrayList<>();
        mRlvAdapter = new RlvAdapter(this, mList);
        mRlv.setAdapter(mRlvAdapter);
    }

    @Override
    public void onSuccess(Bean bean) {
        if (bean!=null){
            mList.addAll(bean.getResults());
            mRlvAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFail(String error) {
        Log.d("tag",error);
    }
}
