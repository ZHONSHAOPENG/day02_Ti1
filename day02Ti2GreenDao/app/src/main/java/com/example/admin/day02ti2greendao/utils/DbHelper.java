package com.example.admin.day02ti2greendao.utils;

import com.example.admin.day02ti2greendao.bean.DbBean;
import com.example.admin.day02ti2greendao.dao.DaoMaster;
import com.example.admin.day02ti2greendao.dao.DaoSession;
import com.example.admin.day02ti2greendao.dao.DbBeanDao;

import java.util.List;

public class DbHelper {
    private static DbHelper dbHelper;
    private final DbBeanDao mDbBeanDao;

    public static DbHelper getDbHelper() {
        if (dbHelper==null){
            synchronized (DbHelper.class){
                if (dbHelper==null){
                    dbHelper=new DbHelper();
                }
            }
        }
        return dbHelper;
    }

    public DbHelper(){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(DbApp.getmDbApp(), "aj.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        mDbBeanDao = daoSession.getDbBeanDao();
    }

    public void insert(List<DbBean> beans){
        mDbBeanDao.insertOrReplaceInTx(beans);
    }

    public List<DbBean> query(){
        return mDbBeanDao.queryBuilder().list();
    }

}
