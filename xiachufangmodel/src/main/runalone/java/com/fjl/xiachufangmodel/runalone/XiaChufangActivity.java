package com.fjl.xiachufangmodel.runalone;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.alibaba.android.arouter.launcher.ARouter;
import com.fjl.xiachufangmodel.R;

import assembly.fjl.com.basiclib.base.BaseActivity;

public class XiaChufangActivity extends BaseActivity {
    @Override
    protected void configViews() {
        Fragment fragment = (Fragment) ARouter.getInstance().build("/xiachufang/main").navigation();
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.tab_content, fragment).commitAllowingStateLoss();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.xiachufang_test_activity;
    }
}
