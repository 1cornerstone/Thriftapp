package com.akindev.thrift.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akindev.thrift.R;
import com.akindev.thrift.model.PAYMENT;

import org.litepal.LitePal;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class wallet extends Fragment {

View  view;
@BindView(R.id.balance)
    TextView balance;

Double total  =0.0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view = inflater.inflate(R.layout.fragment_wallet, container, false);

        ButterKnife.bind(this,view);
        LitePal.initialize(view.getContext());


        List<PAYMENT> payments = LitePal.findAll(PAYMENT.class);

        for (int i =0; i < payments.size(); i++){

           total += Double.parseDouble(payments.get(i).getCOLUMN_AMOUNT());
            System.out.println(payments.get(i).getCOLUMN_AMOUNT());
        }

        balance.setText(" BALANCE IN WALLET: \n #"+String.valueOf(total));
       return view;

    }

}
