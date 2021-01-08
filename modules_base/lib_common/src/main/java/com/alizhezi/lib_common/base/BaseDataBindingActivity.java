package com.alizhezi.lib_common.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;

import com.alizhezi.lib_common.life.ActivityLifeObserver;

public class BaseDataBindingActivity<T extends ViewDataBinding> extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        getLifecycle().addObserver(new ActivityLifeObserver());
    }
}