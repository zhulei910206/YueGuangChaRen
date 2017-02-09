package com.only.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.only.R;


/**
 * Created by Administrator on 2017/2/8.
 */

public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {

    //宏定义
    public static final int LEFT_IMAEG_RIGHT_IMAGE = 1;//左边图片 和右边图片
    public static final int LEFT_IMAGE_RIGHT_TEXT = 2;//左边图片,右边文字
    public static final int LEFT_IMAGE_RIGHT_NO = 3; //左边图片,右边没有
    public static final int LEFT_TEXT_RIGHT_NO = 4; //左边文字,右边没有
    public static final int LEFT_TEXT_RIGHT_IMAGE = 5; //左边文字右边图片
    public static final int LEFT_TEXT_RIGHT_TEXT = 6; //左边文字右边文字
    public static final int LEFT_NO_RIGHT_IMAGE = 7; //左边没有,右边图片
    public static final int LEFT_NO_RIGHT_TEXT = 8; //左边没有,右边文字
    public static final int LEFT_NO_RIGHT_NO = 9; //左边没有,右边没有

    private TextView tv_main_title_left_return;
    private TextView tv_main_title_textview;
    private TextView tv_main_title_setting;
    private ImageView iv_right_view;
    private ImageView iv_left_view;
    private LinearLayout ll_left_layout;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    //初始化头部
    public abstract void initHeader();

    //初始化控件
    public abstract void initWidget();

    //设置监听
    public abstract void setWidgetState();

    public void inittHeaderWidget() {

        tv_main_title_left_return = (TextView) findViewById(R.id.id_tv_back);
        tv_main_title_textview = (TextView) findViewById(R.id.tv_main_title_textview);
        tv_main_title_setting = (TextView) findViewById(R.id.tv_main_title_setting);
        iv_right_view = (ImageView) findViewById(R.id.iv_right_view);
        iv_left_view = (ImageView) findViewById(R.id.iv_left_view);
        ll_left_layout = (LinearLayout) findViewById(R.id.ll_left_layout);
    }

    public void addImageLeftListener(View.OnClickListener listener) {//设置左边显示为图片
        iv_left_view.setVisibility(View.VISIBLE);
        iv_left_view.setOnClickListener(listener);
    }

    public void addImageLeftListener(View.OnClickListener listener, int id) {//设置左边显示为图片
        iv_left_view.setVisibility(View.VISIBLE);
        iv_left_view.setOnClickListener(listener);
        iv_left_view.setImageResource(id);
    }

    public void addBtnLeftListener(View.OnClickListener listener) {//设置左边显示文字
        tv_main_title_left_return.setVisibility(View.VISIBLE);
        tv_main_title_left_return.setOnClickListener(listener);
    }

    public void addBtnLeftListener(View.OnClickListener listener, String title) {//设置左边显示文字
        tv_main_title_left_return.setVisibility(View.VISIBLE);
        tv_main_title_left_return.setOnClickListener(listener);
        tv_main_title_left_return.setText(title);
    }

    public void addBtnRighListener(View.OnClickListener listener) {//设置右边显示文字
        tv_main_title_setting.setVisibility(View.VISIBLE);
        tv_main_title_setting.setOnClickListener(listener);
    }

    public void addBtnRighListener(View.OnClickListener listener, String title) {//设置右边显示文字
        tv_main_title_setting.setVisibility(View.VISIBLE);
        tv_main_title_setting.setOnClickListener(listener);
        tv_main_title_setting.setText(title);
    }

    public void addImageRightListener(View.OnClickListener listener) {//设置右边显示图片
        iv_right_view.setVisibility(View.VISIBLE);
        iv_right_view.setOnClickListener(listener);
    }

    public void addImageRightListener(View.OnClickListener listener, int id) {//设置右边显示图片
        iv_right_view.setVisibility(View.VISIBLE);
        iv_right_view.setOnClickListener(listener);
        iv_right_view.setImageResource(id);
    }

    public void Title(String title) {//设置中间文字的内容
//        tv_main_title_left_return.setVisibility(View.GONE);
        tv_main_title_setting.setVisibility(View.GONE);
        iv_left_view.setVisibility(View.VISIBLE);
        iv_right_view.setVisibility(View.GONE);
        tv_main_title_textview.setText(title);
    }

    @Override
    public void onClick(View view) {

    }

    public void Left_Image() {
        iv_left_view.setVisibility(View.VISIBLE);
    }

    public void Left_Text() {
        tv_main_title_left_return.setVisibility(View.VISIBLE);
    }

    public void Right_Image() {
        iv_right_view.setVisibility(View.VISIBLE);
    }

    public void Right_Text() {
        tv_main_title_setting.setVisibility(View.VISIBLE);
    }

    public void SetGone() {
        tv_main_title_left_return.setVisibility(View.GONE);
        tv_main_title_setting.setVisibility(View.GONE);
        iv_left_view.setVisibility(View.GONE);
        iv_right_view.setVisibility(View.GONE);
    }

    public void setTitleStatue(int statue) {

        switch (statue) {

            case LEFT_IMAEG_RIGHT_IMAGE:

                Left_Image();
                Right_Image();

                break;
            case LEFT_IMAGE_RIGHT_TEXT:

                Left_Text();
                Right_Text();

                break;
            case LEFT_IMAGE_RIGHT_NO:

                SetGone();
                Left_Image();

                break;
            case LEFT_TEXT_RIGHT_NO:

                SetGone();
                Left_Text();

                break;
            case LEFT_TEXT_RIGHT_IMAGE:

                Left_Text();
                Right_Image();

                break;
            case LEFT_TEXT_RIGHT_TEXT:

                Left_Text();
                Right_Text();

                break;
            case LEFT_NO_RIGHT_IMAGE:

                SetGone();
                Right_Image();

                break;
            case LEFT_NO_RIGHT_TEXT:

                SetGone();
                Right_Text();

                break;
            case LEFT_NO_RIGHT_NO:

                SetGone();

                break;

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Base Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
