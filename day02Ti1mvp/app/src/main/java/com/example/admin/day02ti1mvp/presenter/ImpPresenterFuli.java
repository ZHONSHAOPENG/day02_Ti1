package com.example.admin.day02ti1mvp.presenter;

import com.example.admin.day02ti1mvp.bean.Bean;
import com.example.admin.day02ti1mvp.callback.CallBack;
import com.example.admin.day02ti1mvp.model.ModelFuli;
import com.example.admin.day02ti1mvp.view.MyView;

public class ImpPresenterFuli implements PresenterFuli, CallBack {

    private ModelFuli mModelFuli;
    private MyView mMyView;

    public ImpPresenterFuli(ModelFuli modelFuli, MyView myView) {
        mModelFuli = modelFuli;
        mMyView = myView;
    }

    @Override
    public void getData() {
        if (mModelFuli!=null){
            mModelFuli.getData(this);
        }
    }

    @Override
    public void onSuccess(Bean bean) {
        if (mMyView!=null){
            mMyView.onSuccess(bean);
        }
    }

    @Override
    public void onFail(String error) {
        if (mMyView!=null){
            mMyView.onFail(error);
        }
    }
}
