package com.example.admin.day02ti1mvp.callback;

import com.example.admin.day02ti1mvp.bean.Bean;

public interface CallBack {
    void onSuccess(Bean bean);
    void onFail(String error);
}
