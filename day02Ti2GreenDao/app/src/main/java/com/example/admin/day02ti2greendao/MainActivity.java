package com.example.admin.day02ti2greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.day02ti2greendao.bean.DbBean;
import com.example.admin.day02ti2greendao.utils.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRlv;
    private RlvAdapter mRlvAdapter;
    private List<DbBean> mList;
    private DbHelper mDbHelper;
    private ArrayList<DbBean> mDbBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDbHelper = DbHelper.getDbHelper();
        initData();
        initView();
    }

    private void initData() {
        mDbBeans = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            DbBean dbBean = new DbBean((long) 1,"小明："+i,R.drawable.j);
            mDbBeans.add(dbBean);
        }
        mDbHelper.insert(mDbBeans);
    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mList = DbHelper.getDbHelper().query();
        mRlvAdapter = new RlvAdapter(this, mDbBeans);
        mRlv.setAdapter(mRlvAdapter);
    }
}
