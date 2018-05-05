package com.lz.base.factory;

import android.content.Context;

import com.apkfuns.logutils.LogUtils;
import com.lz.base.base.BaseFactory;
import com.lz.base.exception.LzException;


/**
 * 作者      : 刘朝
 * 创建日期  : 2018/5/5 下午2:18
 * 描述     :
 */
public class ContextFactory extends BaseFactory {

    public static Context mContext;

    public static void init(Context context){

        LogUtils.i("管理程序的context");
        if(mContext == null){
            mContext = context.getApplicationContext();
        }else {
            throw new LzException("set context duplicate");
        }
    }
    public static  Context get(){
        if(mContext == null){
            throw new LzException("forget init?");
        }else {
            return mContext;
        }
    }
}
