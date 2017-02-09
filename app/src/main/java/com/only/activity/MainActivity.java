package com.only.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;

import com.only.R;
import com.only.entity.ShowFragment;
import com.only.fragment.FragmentCart;
import com.only.fragment.FragmentFavorable;
import com.only.fragment.FragmentMy;
import com.only.fragment.FragmentWeb;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private LinearLayout mWxb;
    private LinearLayout mFavorable;
    private LinearLayout mCart;
    private LinearLayout mMy;
    private FragmentManager manager;
    private FragmentWeb fragmentWeb;
    private FragmentFavorable fragmentFavorable;
    private FragmentCart fragmentCart;
    private FragmentMy fragmentMy;
    private ShowFragment showFragment;
    ArrayList<ShowFragment> fragmentArrayList = new ArrayList<>();
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initHeader();
        initWidget();
        inittHeaderWidget();
        setWidgetState();

    }

    @Override
    public void initHeader() {

        //加载头部
        inittHeaderWidget();
        Title("月光茶人");

    }

    @Override
    public void initWidget() {

        mWxb = (LinearLayout) findViewById(R.id.btn_main_wxb);
        mFavorable = (LinearLayout) findViewById(R.id.btn_main_favorable);
        mCart = (LinearLayout) findViewById(R.id.btn_main_cart);
        mMy = (LinearLayout) findViewById(R.id.btn_main_my);

        //获得管理者
        manager = getSupportFragmentManager();

        fragmentWeb = new FragmentWeb();
        fragmentFavorable = new FragmentFavorable();
        fragmentCart = new FragmentCart();
        fragmentMy = new FragmentMy();
        
        addlist();
        addFragment(0);

    }

    private void addFragment(int position) {

        transaction = manager.beginTransaction();

        for (int i = 0; i < fragmentArrayList.size(); i++) {
            //判断是否首页,如果不是则隐藏
            if (i != position){
                transaction.hide(fragmentArrayList.get(i).fragment);
            }
        }

        //判断是否首页
        if (fragmentArrayList.get(position).statue == 0){
            //如果是添加到FramLayout里并把标识改成1,展示
            transaction.add(R.id.fram_main_content,fragmentArrayList.get(position).fragment,position+"");
            fragmentArrayList.get(position).statue = 1;
            transaction.show(fragmentArrayList.get(position).fragment);
        }else {

            transaction.show(fragmentArrayList.get(position).fragment);
        }
        transaction.commit();
    }

    private void addlist() {

        for (int i = 0; i < 4; i++) {

            showFragment = new ShowFragment();

            switch (i){
                case 0 :
                    showFragment.fragment = fragmentWeb;
                    break;
                case 1 :
                    showFragment.fragment = fragmentFavorable;
                    break;
                case 2 :
                    showFragment.fragment = fragmentCart;
                    break;
                case 3 :
                    showFragment.fragment = fragmentMy;
                    break;
            }

            fragmentArrayList.add(showFragment);

        }

    }

    @Override
    public void setWidgetState() {

        mWxb.setOnClickListener(this);
        mFavorable.setOnClickListener(this);
        mCart.setOnClickListener(this);
        mMy.setOnClickListener(this);

        //设置默认点击的模块
        SetStaute(R.id.btn_main_wxb);
        //设置默认点击的图片
        setTitleStatue(LEFT_NO_RIGHT_NO);

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);

        switch (view.getId()){

            case R.id.btn_main_wxb:
                SetStaute(R.id.btn_main_wxb);
                setTitleStatue(LEFT_NO_RIGHT_NO);
                addFragment(0);
                break;
            case R.id.btn_main_favorable:
                SetStaute(R.id.btn_main_favorable);
                setTitleStatue(LEFT_NO_RIGHT_NO);
                addFragment(1);
                break;
            case R.id.btn_main_cart:
                SetStaute(R.id.btn_main_cart);
                setTitleStatue(LEFT_IMAGE_RIGHT_NO);
                addFragment(2);
                break;
            case R.id.btn_main_my:
                SetStaute(R.id.btn_main_my);
                setTitleStatue(LEFT_NO_RIGHT_NO);
                addFragment(3);
                break;

        }
    }

    private void SetStaute(int id) {

        switch (id){

            case R.id.btn_main_wxb ://主页
                mWxb.setSelected(true);
                mFavorable.setSelected(false);
                mCart.setSelected(false);
                mMy.setSelected(false);
                Title("月光茶人");
                break;

            case R.id.btn_main_favorable ://优惠
                mWxb.setSelected(false);
                mFavorable.setSelected(true);
                mCart.setSelected(false);
                mMy.setSelected(false);
                Title("优惠");
                break;

            case R.id.btn_main_cart ://购物车
                mWxb.setSelected(false);
                mFavorable.setSelected(false);
                mCart.setSelected(true);
                mMy.setSelected(false);
                Title("购物车");
                break;

            case R.id.btn_main_my ://我的
                mWxb.setSelected(false);
                mFavorable.setSelected(false);
                mCart.setSelected(false);
                mMy.setSelected(true);
                Title("我的");
                break;

        }

    }

}
