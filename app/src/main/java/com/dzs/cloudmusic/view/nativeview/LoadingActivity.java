package com.dzs.cloudmusic.view.nativeview;

import android.view.View;
import android.widget.ImageView;

import com.dzs.cloudmusic.R;
import com.dzs.cloudmusic.common.mvp.BaseActivity;
import com.dzs.cloudmusic.common.mvp.BasePresenter;

import pl.droidsonroids.gif.GifImageView;

public class LoadingActivity extends BaseActivity {


    GifImageView adImagegif;
    ImageView btnSkip;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_loading;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void addEvent() {
        adImagegif = (GifImageView) findViewById(R.id.adImagegif);
        btnSkip = (ImageView) findViewById(R.id.skipBtn);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                nextActivity(MainActivity.class);
            }
        });
    }

    @Override
    protected void loadData() {
        //Glide.with(this).load(Uri.parse("http://img3.duitang.com/uploads/item/201301/08/20130108192528_wuPLf.gif")).into(adImagegif);
    }

    @Override
    protected void onDestroy() {
        adImagegif.destroyDrawingCache();
        adImagegif = null;
        super.onDestroy();
    }
}
