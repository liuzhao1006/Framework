package com.lz.base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


/**
 * 作者      : 刘朝
 * 创建日期  : 2018/5/5 下午1:55
 * 描述     :
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViewBefor();
        setContentView(setLayoutId());
        initView(savedInstanceState);
    }


    /**
     * 初始化控件
     */
    protected abstract void initView(@Nullable Bundle savedInstanceState);


    /**
     * 初始化布局前
     */
    protected void initViewBefor() {

    }

    /**
     * 加载布局文件
     * @return
     */
    protected abstract int setLayoutId();

    /**
     * 弹窗提示,必须得从资源文件中获取.
     * @param resId
     */
    protected void showToast(int resId){
        Toast.makeText(this,this.getResources().getString(resId),Toast.LENGTH_SHORT).show();
    }
}
