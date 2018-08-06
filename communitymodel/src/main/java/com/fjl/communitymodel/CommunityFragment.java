package com.fjl.communitymodel;


import com.alibaba.android.arouter.facade.annotation.Route;

import assembly.fjl.com.basiclib.base.BaseLazyFragment;
@Route(path = "/community/main")
public class CommunityFragment extends BaseLazyFragment{
    @Override
    protected int setLayoutId() {
        return R.layout.community_fragment_layout;
    }
}
