package com.fjl.favmodel;

import com.alibaba.android.arouter.facade.annotation.Route;

import assembly.fjl.com.basiclib.base.BaseLazyFragment;

@Route(path = "/fav/main")
public class FavFragment extends BaseLazyFragment {
    @Override
    protected int setLayoutId() {
        return R.layout.fav_fragment_layout;
    }
}
