package com.dzs.cloudmusic.common.mvp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.dzs.cloudmusic.R;

import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dzs on 2016/7/11.
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    @Nullable
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    @Nullable
    @BindView(R.id.appbar)
    protected AppBarLayout appbar;

    protected P presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        showStatusBar();
        View rootView = LayoutInflater.from(this).inflate(getLayoutId(), null);
        setContentView(rootView);
        ButterKnife.bind(this);
        presenter = getPresenter();
        addEvent();
        loadData();
    }

    public void fitStatusBar(View view) {
        view.setMinimumHeight(view.getHeight() + getStatusBarHeight());
        view.setPadding(view.getPaddingLeft(), getStatusBarHeight(), view.getPaddingRight(), view.getPaddingBottom());
    }


    protected void setCommonActionBar(String title){
        fitStatusBar(appbar);
        setSupportActionBar(toolbar);
        if(title == null){

        }else {
            toolbar.setNavigationIcon(R.drawable.actionbar_back);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            toolbar.setTitle(title);
        }


    }
    /**
     * 弹窗提示
     */
    private Toast toast;

    @Override
    public void showToast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * 加载窗口
     */
    private ProgressDialog progressDialog;

    @Override
    public void showLoading(String msg) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.setMessage(msg);
        if (progressDialog.isShowing()) {

            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        progressDialog.hide();
    }

    @Override
    public Context getContext() {
        return getBaseContext();
    }

    @Override
    public Intent _getIntent() {
        return getIntent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    public void nextActivity(Class<? extends BaseActivity> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    private void hideStatusBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
    }

    private void showStatusBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
    }
    /**
     * 获取状态栏高度
     * @return
     */
    /**
     * 获状态栏高度
     *
     * @return 通知栏高度
     */
    public int getStatusBarHeight() {
        int statusBarHeight = 0;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object obj = clazz.newInstance();
            Field field = clazz.getField("status_bar_height");
            int temp = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = getResources().getDimensionPixelSize(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }


    /**
     * 获取当前activity的布局id
     */
    protected abstract int getLayoutId();

    /**
     * 获取当前activity的presenter
     */
    protected abstract P getPresenter();

    /**
     * 给当前activity添加控制事件
     */
    protected abstract void addEvent();

    /**
     * 加载数据
     */
    protected abstract void loadData();

}
