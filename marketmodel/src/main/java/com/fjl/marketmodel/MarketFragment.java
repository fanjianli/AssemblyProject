package com.fjl.marketmodel;

import com.alibaba.android.arouter.facade.annotation.Route;

import assembly.fjl.com.basiclib.base.BaseLazyFragment;
import com.fjl.marketmodel.R;
@Route(path = "/market/main")
public class MarketFragment extends BaseLazyFragment {
    @Override
    protected int setLayoutId() {
        return R.layout.market_fragment_layout;
    }
}
