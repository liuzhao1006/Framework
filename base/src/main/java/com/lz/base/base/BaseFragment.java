package com.lz.base.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * 作者      : 刘朝
 * 创建日期  : 2018/5/5 下午1:57
 * 描述     : fragment基类
 */
public abstract class BaseFragment extends Fragment {

    protected View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), container, false);
        initView(savedInstanceState);
        return view;
    }

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    protected abstract void initView(@Nullable Bundle savedInstanceState);


    /**
     * 加载布局文件
     * @return
     */
    protected abstract int getLayoutId();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
