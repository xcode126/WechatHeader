package com.sky.wechatheader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Author：sky on 2020/3/17 11:38.
 * Email：xcode126@126.com
 * Desc：方案2、自定义一个控件，还是通过异步的方式下载所有图片。在控件里面加一个计数器，确保所有图片下载完成后，一起同步显示出来。
 * 优点：难度适中
 * 缺点：扩展性差，哪天产品想换一个合成方案呢
 */

public class SecondActivity extends Activity {

    public static Intent getIntent(Context mContext) {
        return new Intent(mContext, SecondActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
