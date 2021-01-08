package com.alizhezi.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = "/app/SplashActivity")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<TextView>(R.id.app_go_home).setOnClickListener {

            ARouter.getInstance().build("").navigation()
        }

        var banner = findViewById<ActionBanner>(R.id.view_banner) as ActionBanner


        findViewById<View>(R.id.btn_start_anim).setOnClickListener {

            banner.startAnimator()
        }
    }
}