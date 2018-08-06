package assembly.fjl.com.basiclib.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.orhanobut.logger.Logger;

import assembly.fjl.com.basiclib.R;
import assembly.fjl.com.basiclib.rxjava.BaseContract;
import assembly.fjl.com.basiclib.rxutils.RxBus;
import rx.Subscription;
import rx.functions.Action1;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃    神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * <p/>
 * ━━━━━━感觉萌萌哒━━━━━━
 */
public abstract class BaseActivity<T1 extends BaseContract.BasePresenter> extends AppCompatActivity {
    protected T1 mPresenter;

    protected ImmersionBar mImmersionBar;
    private InputMethodManager imm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(getLayoutId(), null);
        setContentView(view);
        if (isImmersionBarEnabled())
            initImmersionBar();
        configViews();
    }
    /**
     * 封装的findViewByID方法
     */
    @SuppressWarnings("unchecked")
    protected <T extends View> T $(@IdRes int id) {
        return (T) super.findViewById(id);
    }

    protected Postcard buildARouter(String path){
        return ARouter.getInstance()
                .build(path)
                .withTransition(R.anim.fade_in,0);
    }
    /**
     * 初始化沉浸式
     */
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this)
                        .statusBarDarkFont(true)
                        .navigationBarWithKitkatEnable(false)
                        .navigationBarEnable(false)
                        .keyboardEnable(true);
        mImmersionBar.init();
    }
    protected boolean isImmersionBarEnabled() {
        return true;
    }
    protected abstract void configViews();

    protected abstract int getLayoutId();

    protected void VISIBLE(View... view){
        for(View v:view){
            v.setVisibility(View.VISIBLE);
        }
    }
    protected void GONE(View... view){
        for(View v:view){
            v.setVisibility(View.GONE);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.detachView();
        }
        this.imm = null;
        if (mImmersionBar != null)
            mImmersionBar.destroy();
    }
    protected int getScreenW(Context aty) {
        DisplayMetrics dm = aty.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }
    protected int getScreenH(Context aty) {
        DisplayMetrics dm = aty.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }
    @Override
    public void finish() {
        super.finish();
        hideSoftKeyBoard();
        this.overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    protected void setTitle(View view){
        if(mImmersionBar!=null)
            mImmersionBar.setTitleBar(this, view);
    }
    public void hideSoftKeyBoard() {
        View localView = getCurrentFocus();
        if (this.imm == null) {
            this.imm = ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE));
        }
        if ((localView != null) && (this.imm != null)) {
            this.imm.hideSoftInputFromWindow(localView.getWindowToken(), 2);
        }
    }


}
