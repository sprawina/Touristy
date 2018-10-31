package com.example.sr20022286.touristy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private Handler mWaitHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.DKGRAY));


        mWaitHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //
                try{
                    //

                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                    finish();
                }
                catch (Exception ignored){
                    ignored.printStackTrace();
                }
            }
        },2000);
    }


    @Override
    public void onDestroy(){
        super.onDestroy();

        mWaitHandler.removeCallbacksAndMessages(null);
    }
}
