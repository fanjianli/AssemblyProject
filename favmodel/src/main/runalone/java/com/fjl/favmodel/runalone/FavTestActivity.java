package com.fjl.favmodel.runalone;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.alibaba.android.arouter.launcher.ARouter;
import com.fjl.favmodel.R;

import assembly.fjl.com.basiclib.base.BaseActivity;

public class FavTestActivity extends BaseActivity {
    @Override
    protected void configViews() {
        Fragment fragment = (Fragment) ARouter.getInstance().build("/fav/main").navigation();
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.tab_content, fragment).commitAllowingStateLoss();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fav_test_activity;
    }
}
