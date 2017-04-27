package com.example.g572_528r.as0427_banner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;

public class MainActivity extends AppCompatActivity {
    private Banner mBanner;
    String[] images = new String[] {
            "http://img22.mtime.cn/up/2011/11/25/090615.21260306_500.jpg",
            "http://img.weixinyidu.com/160328/c310e69f.jpg",
            "http://img5.duitang.com/uploads/item/201610/15/20161015223831_A2VMy.thumb.700_0.jpeg",
            "http://img32.mtime.cn/up/2013/09/12/115121.92165238_o.jpg"};

    String[] titles = new String[]{"斯嘉丽.约翰逊","盖尔.加朵","盖尔.加朵","安吉丽娜.朱莉"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mBanner = (Banner) findViewById(R.id.banner);

        //设置样式,默认为:Banner.NOT_INDICATOR(不显示指示器和标题)
        //可选样式如下:
        //1. Banner.CIRCLE_INDICATOR    显示圆形指示器
        //2. Banner.NUM_INDICATOR   显示数字指示器
        //3. Banner.NUM_INDICATOR_TITLE 显示数字指示器和标题
        //4. Banner.CIRCLE_INDICATOR_TITLE  显示圆形指示器和标题
        mBanner.setBannerStyle(Banner.CIRCLE_INDICATOR_TITLE);

        //设置轮播样式（没有标题默认为右边,有标题时默认左边）
        //可选样式:
        //Banner.LEFT   指示器居左
        //Banner.CENTER 指示器居中
        //Banner.RIGHT  指示器居右
        mBanner.setIndicatorGravity(Banner.CENTER);

        //设置轮播要显示的标题和图片对应（如果不传默认不显示标题）
        mBanner.setBannerTitle(titles);

        //设置是否自动轮播（不设置则默认自动）
        mBanner.isAutoPlay(true) ;

        //设置轮播图片间隔时间（不设置默认为2000）
        mBanner.setDelayTime(2000);
        //设置图片资源:可选图片网址/资源文件，默认用Glide加载,也可自定义图片的加载框架
        //所有设置参数方法都放在此方法之前执行
        //banner.setImages(images);

        mBanner.setImages(images, new Banner.OnLoadImageListener() {
            @Override
            public void OnLoadImage(ImageView view, Object url) {
                Toast.makeText(MainActivity.this, "加载中", Toast.LENGTH_SHORT).show();
                Glide.with(getApplicationContext()).load(url).into(view);
                Toast.makeText(MainActivity.this, "加载完", Toast.LENGTH_SHORT).show();
            }
        });

        mBanner.setOnBannerClickListener(new Banner.OnBannerClickListener() {
            @Override
            public void OnBannerClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "你点击了"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
