package com.only.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Administrator on 2017/2/8.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener{

    //初始化头部
    public abstract void initHeader();

    //初始化控件
    public abstract void initWidget();

    //设置监听
    public abstract void setWidgetState();

    @Override
    public void onClick(View view) {

    }
}
