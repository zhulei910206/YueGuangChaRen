package com.only.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.only.R;

/**
 * Created by Administrator on 2017/2/8.
 */

public class FragmentWeb extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_web,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initHeader();
        initWidget();
        setWidgetState();
    }

    @Override
    public void initHeader() {

    }

    @Override
    public void initWidget() {

    }

    @Override
    public void setWidgetState() {

    }
}
