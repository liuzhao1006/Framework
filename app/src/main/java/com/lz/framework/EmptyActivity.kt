package com.lz.framework

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.apkfuns.logutils.LogUtils
import com.lz.base.base.BaseActivity
import com.lz.login.LoginActivity
import kotlinx.android.synthetic.main.activity_empty.*

class EmptyActivity : BaseActivity() {
    override fun initView(savedInstanceState: Bundle?) {

        LogUtils.i("主程序入口...")
        // Example of a call to a native method
        sample_text.text = stringFromJNI()
        btn_login.setOnClickListener({
            LogUtils.i("跳转到登录页面...")
            startActivity(Intent(this, LoginActivity::class.java))
        })
    }

    override fun setLayoutId(): Int = R.layout.activity_empty


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
