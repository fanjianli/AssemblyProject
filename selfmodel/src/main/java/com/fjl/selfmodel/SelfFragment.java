package com.fjl.selfmodel;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.fjl.selfmodel.R;
import assembly.fjl.com.basiclib.base.BaseLazyFragment;
@Route(path = "/self/main")
public class SelfFragment extends BaseLazyFragment {
    @Override
    protected int setLayoutId() {
        return R.layout.self_fragment_layout;
    }
}
