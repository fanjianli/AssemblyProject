package com.fjl.selfmodel.runalone;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.alibaba.android.arouter.launcher.ARouter;
import com.fjl.selfmodel.R;

import assembly.fjl.com.basiclib.base.BaseActivity;

public class SelfTestActivity extends BaseActivity {
    @Override
    protected void configViews() {
        Fragment fragment = (Fragment) ARouter.getInstance().build("/self/main").navigation();
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.tab_content, fragment).commitAllowingStateLoss();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.self_test_activity;
    }
}
