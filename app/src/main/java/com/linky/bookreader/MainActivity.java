package com.linky.bookreader;

import android.os.Bundle;

import com.linky.bookreader.mvp.BaseActivity;
import com.linky.bookreader.mvp.presentation.ReaderFragment;
import com.umeng.update.UmengUpdateAgent;

public class MainActivity extends BaseActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 配置友盟参数；
//        initUmentParams();

        ReaderFragment readerFragment = ReaderFragment.newInstance();
        replaceFragment(R.id.fl_container, readerFragment);
    }

    private void initUmentParams() {
        UmengUpdateAgent.setUpdateOnlyWifi(false);  // 非 wifi 环境下也能检测；
        UmengUpdateAgent.update(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onPageStart(TAG);
//        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onPageEnd(TAG);
//        MobclickAgent.onPause(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
