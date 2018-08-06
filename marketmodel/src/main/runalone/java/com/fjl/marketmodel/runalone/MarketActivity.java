package com.fjl.marketmodel.runalone;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.alibaba.android.arouter.launcher.ARouter;
import com.fjl.marketmodel.R;

import assembly.fjl.com.basiclib.base.BaseActivity;

public class MarketActivity extends BaseActivity {
    @Override
    protected void configViews() {
        Fragment fragment = (Fragment) ARouter.getInstance().build("/market/main").navigation();
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.tab_content, fragment).commitAllowingStateLoss();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.market_test_activity;
    }
}
