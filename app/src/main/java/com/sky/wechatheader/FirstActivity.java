package com.sky.wechatheader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

/**
 * Author：sky on 2020/3/17 09:44.
 * Email：xcode126@126.com
 * Desc：
 * 方案1、直接写成布局，然后按照不同的布局加载不同张数的图片。而大家通用的图片加载方案都是异步加载的，
 * 这样的话，加载的时候，会一闪一闪的合并成一张图。由于现在的图片框架都有缓存，第二次会好很多。
 * 优点：实现起来快
 * 缺点：很low，不是一个有逼格程序员的做法，而且效果也不好。
 */

public class FirstActivity extends Activity {

    private ImageView ivOne;
    private ImageView ivTwo;
    private ImageView ivThree;
    private ImageView ivFour;
    private ImageView ivFive;
    private ImageView ivSix;
    private ImageView ivSeven;
    private ImageView ivEight;
    private ImageView ivNine;
    private EditText etNum;

    public static Intent getIntent(Context mContext) {
        return new Intent(mContext, FirstActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        initView();

        loadImage();

        setListener();
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
                    Toast.makeText(FirstActivity.this, "请输入显示图片数量", Toast.LENGTH_SHORT).show();
                    return;
                }
                int num = Integer.parseInt(trim);
                setImageShow(num);
            }
        });
    }

    /**
     * set Image show
     *
     * @param num
     */
    private void setImageShow(int num) {
        setAllGone();
        switch (num) {
            case 1:
                ivNine.setVisibility(View.VISIBLE);
                break;
            case 2:
                ivNine.setVisibility(View.VISIBLE);
                ivEight.setVisibility(View.VISIBLE);
                break;
            case 3:
                ivNine.setVisibility(View.VISIBLE);
                ivEight.setVisibility(View.VISIBLE);
                ivSeven.setVisibility(View.VISIBLE);
                break;
            case 4:
                ivNine.setVisibility(View.VISIBLE);
                ivEight.setVisibility(View.VISIBLE);
                ivSeven.setVisibility(View.VISIBLE);
                ivSix.setVisibility(View.VISIBLE);
                break;
            case 5:
                ivNine.setVisibility(View.VISIBLE);
                ivEight.setVisibility(View.VISIBLE);
                ivSeven.setVisibility(View.VISIBLE);
                ivSix.setVisibility(View.VISIBLE);
                ivFive.setVisibility(View.VISIBLE);
                break;
            case 6:
                ivNine.setVisibility(View.VISIBLE);
                ivEight.setVisibility(View.VISIBLE);
                ivSeven.setVisibility(View.VISIBLE);
                ivSix.setVisibility(View.VISIBLE);
                ivFive.setVisibility(View.VISIBLE);
                ivFour.setVisibility(View.VISIBLE);
                break;
            case 7:
                ivNine.setVisibility(View.VISIBLE);
                ivEight.setVisibility(View.VISIBLE);
                ivSeven.setVisibility(View.VISIBLE);
                ivSix.setVisibility(View.VISIBLE);
                ivFive.setVisibility(View.VISIBLE);
                ivFour.setVisibility(View.VISIBLE);
                ivThree.setVisibility(View.VISIBLE);
                break;
            case 8:
                ivNine.setVisibility(View.VISIBLE);
                ivEight.setVisibility(View.VISIBLE);
                ivSeven.setVisibility(View.VISIBLE);
                ivSix.setVisibility(View.VISIBLE);
                ivFive.setVisibility(View.VISIBLE);
                ivFour.setVisibility(View.VISIBLE);
                ivThree.setVisibility(View.VISIBLE);
                ivTwo.setVisibility(View.VISIBLE);
                break;
            case 9:
                ivNine.setVisibility(View.VISIBLE);
                ivEight.setVisibility(View.VISIBLE);
                ivSeven.setVisibility(View.VISIBLE);
                ivSix.setVisibility(View.VISIBLE);
                ivFive.setVisibility(View.VISIBLE);
                ivFour.setVisibility(View.VISIBLE);
                ivThree.setVisibility(View.VISIBLE);
                ivTwo.setVisibility(View.VISIBLE);
                ivOne.setVisibility(View.VISIBLE);
                break;
        }
    }

    /**
     * load image
     */
    private void loadImage() {
        List<String> imageList = ImageUtil.getInstance().getImageList();
        ImageUtil.load(this, ivOne, imageList.get(0), R.mipmap.ic_launcher);
        ImageUtil.load(this, ivTwo, imageList.get(1), R.mipmap.ic_launcher);
        ImageUtil.load(this, ivThree, imageList.get(2), R.mipmap.ic_launcher);
        ImageUtil.load(this, ivFour, imageList.get(3), R.mipmap.ic_launcher);
        ImageUtil.load(this, ivFive, imageList.get(4), R.mipmap.ic_launcher);
        ImageUtil.load(this, ivSix, imageList.get(5), R.mipmap.ic_launcher);
        ImageUtil.load(this, ivSeven, imageList.get(6), R.mipmap.ic_launcher);
        ImageUtil.load(this, ivEight, imageList.get(7), R.mipmap.ic_launcher);
        ImageUtil.load(this, ivNine, imageList.get(8), R.mipmap.ic_launcher);
    }

    /**
     * init view
     */
    private void initView() {
        etNum = findViewById(R.id.et_num);
        ivOne = findViewById(R.id.iv_one);
        ivTwo = findViewById(R.id.iv_two);
        ivThree = findViewById(R.id.iv_three);
        ivFour = findViewById(R.id.iv_four);
        ivFive = findViewById(R.id.iv_five);
        ivSix = findViewById(R.id.iv_six);
        ivSeven = findViewById(R.id.iv_seven);
        ivEight = findViewById(R.id.iv_eight);
        ivNine = findViewById(R.id.iv_nine);
    }

    /**
     * set all image gone
     */
    private void setAllGone() {
        ivOne.setVisibility(View.GONE);
        ivTwo.setVisibility(View.GONE);
        ivThree.setVisibility(View.GONE);
        ivFour.setVisibility(View.GONE);
        ivFive.setVisibility(View.GONE);
        ivSix.setVisibility(View.GONE);
        ivSeven.setVisibility(View.GONE);
        ivEight.setVisibility(View.GONE);
        ivNine.setVisibility(View.GONE);
    }
}
