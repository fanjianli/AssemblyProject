package assembly.fjl.com.assemblyproject;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.List;

import assembly.fjl.com.basiclib.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private RelativeLayout xiachufang, self, community, fav, shopping;
    private ImageView img_xiachufang, img_self, img_community, img_fav, img_shopping;
    private TextView text_xiachufang, text_self, text_community, text_fav, text_shopping;

    @Override
    protected void configViews() {
        initView();
        select(img_xiachufang, text_xiachufang, getResources().getDrawable(R.drawable.xiachufang_selected));
        changeFragment(R.id.xiachufang);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void initView() {
        xiachufang = (RelativeLayout) $(R.id.xiachufang);
        img_xiachufang = (ImageView) $(R.id.img_xiachufang);
        text_xiachufang = (TextView) $(R.id.text_xiachufang);
        self = (RelativeLayout) $(R.id.self);
        img_self = (ImageView) $(R.id.img_self);
        text_self = (TextView) $(R.id.text_self);
        community = (RelativeLayout) $(R.id.community);
        img_community = (ImageView) $(R.id.img_community);
        text_community = (TextView) $(R.id.text_community);
        fav = (RelativeLayout) $(R.id.fav);
        img_fav = (ImageView) $(R.id.img_fav);
        text_fav = (TextView) $(R.id.text_fav);
        shopping = (RelativeLayout) $(R.id.shopping);
        img_shopping = (ImageView) $(R.id.img_shopping);
        text_shopping = (TextView) $(R.id.text_shopping);
        xiachufang.setOnClickListener(this);
        self.setOnClickListener(this);
        community.setOnClickListener(this);
        fav.setOnClickListener(this);
        shopping.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xiachufang:
                select(img_xiachufang, text_xiachufang, getResources().getDrawable(R.drawable.xiachufang_selected));
                changeFragment(R.id.xiachufang);
                break;
            case R.id.self:
                select(img_self, text_self, getResources().getDrawable(R.drawable.self_selected));
                changeFragment(R.id.self);
                break;
            case R.id.community:
                select(img_community, text_community, getResources().getDrawable(R.drawable.community_selected));
                changeFragment(R.id.community);
                break;
            case R.id.fav:
                select(img_fav, text_fav, getResources().getDrawable(R.drawable.faved));
                changeFragment(R.id.fav);
                break;
            case R.id.shopping:
                select(img_shopping, text_shopping, getResources().getDrawable(R.drawable.makert_selected));
                changeFragment(R.id.shopping);
                break;
            default:
                break;
        }
    }

    private void clearSelect() {
        img_xiachufang.setImageDrawable(getResources().getDrawable(R.drawable.xiachufang));
        img_self.setImageDrawable(getResources().getDrawable(R.drawable.self));
        img_fav.setImageDrawable(getResources().getDrawable(R.drawable.myfav));
        img_community.setImageDrawable(getResources().getDrawable(R.drawable.community));
        img_shopping.setImageDrawable(getResources().getDrawable(R.drawable.makert));
        text_self.setTextColor(getResources().getColor(R.color.color_555));
        text_xiachufang.setTextColor(getResources().getColor(R.color.color_555));
        text_fav.setTextColor(getResources().getColor(R.color.color_555));
        text_community.setTextColor(getResources().getColor(R.color.color_555));
        text_shopping.setTextColor(getResources().getColor(R.color.color_555));
    }

    private void select(ImageView imageView, TextView textView, Drawable drawable) {
        clearSelect();
        imageView.setImageDrawable(drawable);
        textView.setTextColor(getResources().getColor(R.color.color_e94d40));
    }

    Fragment xiachufang_fragment, self_fragment, community_fragment, market_fragment, fav_fragment;

    /**
     * 改变fragment的显示
     *
     * @param resId
     */
    private void changeFragment(int resId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//开启一个Fragment事务
        hideFragments(transaction);//隐藏所有fragment
        if (resId == R.id.xiachufang) {
            if (xiachufang_fragment == null) {
                xiachufang_fragment = (Fragment) ARouter.getInstance().build("/xiachufang/main").navigation();
                if(xiachufang_fragment!=null)
                transaction.add(R.id.main_fragment, xiachufang_fragment,xiachufang_fragment.getClass().getSimpleName());
            } else {
                transaction.show(xiachufang_fragment);
            }
        } else if (resId == R.id.self) {
            if (self_fragment == null) {
                self_fragment = (Fragment) ARouter.getInstance().build("/self/main").navigation();
                if(self_fragment!=null)
                transaction.add(R.id.main_fragment, self_fragment,self_fragment.getClass().getSimpleName());
            } else {
                transaction.show(self_fragment);
            }
        } else if (resId == R.id.community) {
            if (community_fragment == null) {
                community_fragment = (Fragment) ARouter.getInstance().build("/community/main").navigation();
                transaction.add(R.id.main_fragment, community_fragment,community_fragment.getClass().getSimpleName());
            } else {
                transaction.show(community_fragment);
            }

        } else if (resId == R.id.shopping) {
            if (market_fragment == null) {
                market_fragment = (Fragment) ARouter.getInstance().build("/market/main").navigation();
                if(market_fragment!=null)
                transaction.add(R.id.main_fragment, market_fragment);
            } else {
                transaction.show(market_fragment);
            }
        } else if(resId == R.id.fav){
            if (fav_fragment == null) {
                fav_fragment = (Fragment) ARouter.getInstance().build("/fav/main").navigation();
                if(fav_fragment!=null)
                    transaction.add(R.id.main_fragment, fav_fragment);
            } else {
                transaction.show(fav_fragment);
            }
        }
        transaction.commit();//一定要记得提交事务
    }

    /**
     * 显示之前隐藏所有fragment
     *
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (fav_fragment != null)//不为空才隐藏,如果不判断第一次会有空指针异常
            transaction.hide(fav_fragment);
        if (self_fragment != null)
            transaction.hide(self_fragment);
        if (community_fragment != null)
            transaction.hide(community_fragment);
        if (market_fragment != null)
            transaction.hide(market_fragment);
        if (xiachufang_fragment != null)
            transaction.hide(xiachufang_fragment);
    }

}
