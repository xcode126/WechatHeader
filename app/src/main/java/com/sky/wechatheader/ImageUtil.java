package com.sky.wechatheader;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：sky on 2020/3/17 09:34.
 * Email：xcode126@126.com
 * Desc：
 */

public class ImageUtil {
    private static ImageUtil instance;

    private ImageUtil() {
    }

    public static ImageUtil getInstance() {
        if (instance == null) {
            instance = new ImageUtil();
        }
        return instance;
    }

    /**
     * 加载图片
     *
     * @param context
     * @param view
     * @param url
     * @param placeholder 值为 -1 / 0 表示不加载
     */
    public static void load(Activity context, ImageView view, String url, int placeholder) {
        Glide
                .with(context)
                .load(url)
                .centerCrop()
                .placeholder(placeholder)
                .crossFade()
                .into(view);

    }


    /**
     * 图片资源
     * @return
     */
    public List<String> getImageList(){
        List<String> list = new ArrayList<>();
        list.add("https://img.52z.com/upload/news/image/20200309/20200309013752_85581.jpg");
        list.add("http://pic.17qq.com/img_qqtouxiang/79933197.jpeg");
        list.add("http://img1.imgtn.bdimg.com/it/u=1510541345,530435846&fm=11&gp=0.jpg");
        list.add("http://pic1.zhimg.com/50/v2-22803439944d295594c831bf7a3b1a14_hd.jpg");
        list.add("https://img.52z.com/upload/news/image/20200212/20200212063105_39775.jpg");
        list.add("http://img1.imgtn.bdimg.com/it/u=1575662512,773761383&fm=11&gp=0.jpg");
        list.add("http://image.biaobaiju.com/uploads/20180802/03/1533151823-UnXeKfbjrH.jpg");
        list.add("http://img2.imgtn.bdimg.com/it/u=3553405843,1808460653&fm=26&gp=0.jpg");
        list.add("http://img0.imgtn.bdimg.com/it/u=3035788207,3241155015&fm=26&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=2066480525,3617093258&fm=26&gp=0.jpg");

        return list;
    }
}
