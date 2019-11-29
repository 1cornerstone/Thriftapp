package com.akindev.thrift;

import android.content.Intent;
import android.os.Bundle;

import com.akindev.thrift.Adapter.tableAdapter;
import com.akindev.thrift.model.PAYMENT;

import org.litepal.LitePal;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Table extends AppCompatActivity {


    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        ButterKnife.bind(this);
        LitePal.initialize(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String regid = bundle.getString("regid");

        List<PAYMENT> paymentList = LitePal.where("COLUMN_ID= ?",regid).find(PAYMENT.class);

        System.out.println(paymentList.size());

        if (paymentList.size() ==0){

            setContentView(R.layout.emptylayout);

        }else{

            RecyclerView.LayoutManager layoutManager=  new GridLayoutManager(this,2);
            recyclerView.setLayoutManager(layoutManager);
           tableAdapter tableAdapter  = new tableAdapter(paymentList);
            recyclerView.setAdapter(tableAdapter);

        }


    }




}
