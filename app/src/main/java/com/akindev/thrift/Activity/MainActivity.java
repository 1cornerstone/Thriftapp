package com.akindev.thrift.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.akindev.thrift.R;
import com.akindev.thrift.model.ADMIN;

import org.litepal.LitePal;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.logo)
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LitePal.initialize(this);

        ButterKnife.bind(this);

        RotateAnimation rotateAnimation = new RotateAnimation(0, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(1200);
        rotateAnimation.setRepeatCount(Animation.INFINITE);


        firstrun();


       logo.startAnimation(rotateAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

             startActivity(new Intent(MainActivity.this, login.class));
            finish();}
        },3000);

    }




    void firstrun(){

        Boolean  isfirstrun = getSharedPreferences("thrift",MODE_PRIVATE).getBoolean("run",true);
        if (isfirstrun) {

            ADMIN admin = new ADMIN();
            admin.setTABLE_USER("thrift");
            admin.setCOLUMN_PASSOWRD("1234");
            admin.save();

            Toasty.info(getApplicationContext(),"Welcome Boss", Toast.LENGTH_SHORT).show();
            getSharedPreferences("thrift", MODE_PRIVATE).edit().putBoolean("run", false).commit();
        }

    }




}
