package com.fjl.xiachufangmodel;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.fjl.xiachufangmodel.R;
import assembly.fjl.com.basiclib.base.BaseLazyFragment;

@Route(path = "/xiachufang/main")
public class XiachufangFragment extends BaseLazyFragment {

    @Override
    protected int setLayoutId() {
        return R.layout.xiachufang_layout;
    }
}
