package com.sky.wechatheader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.abbott.mutiimgloader.qq.QqMerge;
import com.abbott.mutiimgloader.util.JImageLoader;
import com.abbott.mutiimgloader.weixin.WeixinMerge;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：sky on 2020/3/17 11:38.
 * Email：xcode126@126.com
 * Desc：
 * 方案3、还是使用原生的控件，对群图像进行合并后生成一个新的图像，原后进行缓存。将合并算法抽象成接口。
 * 优点：易扩展，体验更好
 * 缺点：多花一些时间
 */

public class ThirdActivity extends Activity {

    private ImageView ivLeft,ivRight;
    private EditText etNum;
    private JImageLoader imageLoader;

    public static Intent getIntent(Context mContext) {
        return new Intent(mContext, ThirdActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        initView();

        setListener();
    }

    /**
     *
     */
    private void initView() {
        ivLeft = findViewById(R.id.iv_left);
        ivRight = findViewById(R.id.iv_right);
        etNum = findViewById(R.id.et_num);

        imageLoader = new JImageLoader(this); //初始化
        imageLoader.configDefaultPic(R.drawable.ic_launcher_round);//设置默认加载图
        imageLoader.displayImages(ImageUtil.getInstance().getImageList(), ivLeft, new WeixinMerge());
        imageLoader.displayImages(ImageUtil.getInstance().getImageList(), ivRight, new QqMerge());
    }

    /**
     * setListener
     */
    private void setListener() {
        findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = etNum.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    Toast.makeText(ThirdActivity.this, "请输入显示图片数量", Toast.LENGTH_SHORT).show();
                    return;
                }
                int num = Integer.parseInt(trim);
                imageLoader.displayImages(getImage(num), ivLeft, new WeixinMerge());
                imageLoader.displayImages(getImage(num), ivRight, new QqMerge());
            }
        });
    }

    /**
     * 根据数据获取指定的图片资源
     * @param index
     * @return
     */
    private List<String> getImage(int index) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            list.add(ImageUtil.getInstance().getImageList().get(i));
        }
        return list;
    }
}
