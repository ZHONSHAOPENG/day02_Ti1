package com.example.admin.day02ti2greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DbBean {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private Integer img;
    @Generated(hash = 1717270908)
    public DbBean(Long id, String name, Integer img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }
    @Generated(hash = 1953169116)
    public DbBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getImg() {
        return this.img;
    }
    public void setImg(Integer img) {
        this.img = img;
    }
}
