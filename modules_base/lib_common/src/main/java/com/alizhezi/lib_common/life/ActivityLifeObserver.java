package com.alizhezi.lib_common.life;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class ActivityLifeObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(LifecycleOwner owner) {

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner owner) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(LifecycleOwner owner) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(LifecycleOwner owner) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner owner) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner owner) {

    }
}
