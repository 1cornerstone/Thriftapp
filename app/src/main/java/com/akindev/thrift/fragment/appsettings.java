package com.akindev.thrift.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.akindev.thrift.R;
import com.akindev.thrift.model.ADMIN;
import com.akindev.thrift.model.CREATEUSER;
import com.akindev.thrift.model.PAYMENT;
import com.poovam.pinedittextfield.PinField;
import com.poovam.pinedittextfield.SquarePinField;

import org.jetbrains.annotations.NotNull;
import org.litepal.LitePal;

/**
 * A simple {@link Fragment} subclass.
 */
public class appsettings extends Fragment {

    @BindView(R.id.oldpass)
    SquarePinField oldpass;

    @BindView(R.id.newpass)
    SquarePinField newpass;

    @BindView(R.id.confirmpass)
    SquarePinField confrimpass;

    @BindView(R.id.delete)
    Button delete;

    View view;

    String olpp, newp, conp = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_appsettings, container, false);

        ButterKnife.bind(this, view);

        ADMIN admin = LitePal.findFirst(ADMIN.class);
        olpp = admin.getCOLUMN_PASSOWRD();

        oldpass.setOnTextCompleteListener(new PinField.OnTextCompleteListener() {
            @Override
            public boolean onTextComplete(@NotNull String s) {

                if (olpp.equalsIgnoreCase(s)) {

                    newpass.setVisibility(View.VISIBLE);
                } else {

                    Toasty.error(view.getContext(), "Password not Correct", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });

        newpass.setOnTextCompleteListener(new PinField.OnTextCompleteListener() {
            @Override
            public boolean onTextComplete(@NotNull String s) {
                newp = s;
                confrimpass.setVisibility(View.VISIBLE);

                return false;
            }
        });

        confrimpass.setOnTextCompleteListener(new PinField.OnTextCompleteListener() {
            @Override
            public boolean onTextComplete(@NotNull String s) {

                if (newp.equalsIgnoreCase(s)) {

                    ADMIN admin1 = new ADMIN();
                    admin1.setCOLUMN_PASSOWRD(newp);
                    admin1.updateAll(" TABLE_USER = ?", "thrift");

                    Toasty.success(view.getContext(), "Password Changed Successfully", Toast.LENGTH_SHORT).show();

                    olpp = "";
                    newp="";
                    oldpass.setText(null);
                    newpass.setText(null);
                    confrimpass.setText(null);

                } else {

                    Toasty.error(view.getContext(), "Password donot match", Toast.LENGTH_SHORT).show();

                }

                return false;
            }
        });


        delete.setOnClickListener(e->{

            LitePal.deleteAll(PAYMENT.class, "COLUMN_AMOUNT > ?" , "0");
            LitePal.deleteAll(CREATEUSER.class, "COLUMN_THRIFT_AMOUNT > ?" , "0");


            Toasty.success(view.getContext(), "Deleted", Toast.LENGTH_SHORT).show();

        });


        return view;
    }

}
