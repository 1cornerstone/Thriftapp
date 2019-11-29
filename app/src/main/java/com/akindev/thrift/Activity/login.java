package com.akindev.thrift.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.akindev.thrift.R;
import com.akindev.thrift.model.ADMIN;
import com.poovam.pinedittextfield.PinField;
import com.poovam.pinedittextfield.SquarePinField;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.jetbrains.annotations.NotNull;
import org.litepal.LitePal;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class login extends Activity {

    @BindView(R.id.password)
    SquarePinField password;

    String  pass ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        LitePal.initialize(this);

        ADMIN admin = LitePal.findFirst(ADMIN.class);
        pass = admin.getCOLUMN_PASSOWRD();

        password.setOnTextCompleteListener(new PinField.OnTextCompleteListener() {
            @Override
            public boolean onTextComplete(@NotNull String s) {

                if (pass.equalsIgnoreCase(s)) {

                    startActivity(new Intent(login.this,dashboard.class));
                    finish();
                } else {

                    Toasty.error(getApplicationContext(), "Password not Correct", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });



    }
}
