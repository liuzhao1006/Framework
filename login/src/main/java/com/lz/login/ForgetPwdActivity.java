package com.lz.login;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.apkfuns.logutils.LogUtils;
import com.lz.base.base.BaseActivity;

public class ForgetPwdActivity extends BaseActivity {


    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        LogUtils.i("忘记密码页面");
    }

    @Override
    protected int setLayoutId() {
        return R.layout.login_activity_forget_pwd;
    }
}
