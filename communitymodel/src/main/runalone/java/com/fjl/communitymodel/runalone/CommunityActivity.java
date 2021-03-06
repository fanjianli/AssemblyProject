package com.fjl.communitymodel.runalone;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import com.alibaba.android.arouter.launcher.ARouter;
import com.fjl.communitymodel.R;
import assembly.fjl.com.basiclib.base.BaseActivity;

public class CommunityActivity extends BaseActivity {
    @Override
    protected void configViews() {
        Fragment fragment = (Fragment) ARouter.getInstance().build("/community/main").navigation();
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.tab_content, fragment).commitAllowingStateLoss();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.community_test_activity;
    }
}
