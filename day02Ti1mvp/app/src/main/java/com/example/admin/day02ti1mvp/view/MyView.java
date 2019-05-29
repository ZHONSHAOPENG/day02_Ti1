package com.example.admin.day02ti1mvp.view;

import com.example.admin.day02ti1mvp.bean.Bean;

public interface MyView {
    void onSuccess(Bean bean);
    void onFail(String error);
}
