package com.lz.base.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;


/**
 * 作者      : 刘朝
 * 创建日期  : 2018/5/5 下午2:02
 * 描述     :  自定义viewgroup
 */
public abstract class BaseViewGroup extends ViewGroup {


    public BaseViewGroup(Context context) {
        super(context);
    }

    public BaseViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
