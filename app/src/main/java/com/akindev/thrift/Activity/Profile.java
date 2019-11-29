package com.akindev.thrift.Activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import com.akindev.thrift.Activity.newmember;
import com.akindev.thrift.Activity.viewmember;
import com.akindev.thrift.R;
import com.akindev.thrift.Table;
import com.akindev.thrift.model.CREATEUSER;
import com.akindev.thrift.model.PAYMENT;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.victor.loading.book.BookLoading;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.Calendar;
import java.util.List;

public class Profile extends AppCompatActivity {

    @BindView(R.id.totalp)
    TextView totalp;

    @BindView(R.id.p_regid)
    TextView p_regid;
    @BindView(R.id.p_name)
    TextView p_name;
    @BindView(R.id.p_phone)
    TextView p_phone;
    @BindView(R.id.p_address)
    TextView p_address;
    @BindView(R.id.p_amount)
    TextView p_amount;

    @BindView(R.id.p_wit)
    TextView p_wit;

    @BindView(R.id.p_pay)
    Button p_pay;
    @BindView(R.id.userimg)
    ImageView imageView;

@BindView(R.id.history)
    Button historybtn;

        long total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        ButterKnife.bind(this);
        LitePal.initialize(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String regid = bundle.getString("regid");




        List<CREATEUSER> user = LitePal.where("COLUMN_THIFT_REGID = ?", regid).find(CREATEUSER.class);

        total =0;

        List<PAYMENT> paymentList = LitePal.where("COLUMN_ID= ?",regid).find(PAYMENT.class);

        for (int i =0; i < paymentList.size(); i++){
            total += Long.parseLong(paymentList.get(i).getCOLUMN_AMOUNT());
        }

      totalp.setText("#"+String.valueOf(total));

        p_regid.setText("Reg.ID: "+user.get(0).getCOLUMN_THIFT_REGID().trim().toUpperCase());
        p_name.setText("NAME: "+user.get(0).getCOLUMN_THIRFT_NAME().trim().toUpperCase());
        p_phone.setText("Phone: "+user.get(0).getCOLUMN_THIFT_PHONE().trim().toUpperCase());
        p_address.setText("Address: "+user.get(0).getCOLUMN_THITFT_ADDRESS().trim().toUpperCase());
        p_amount.setText("Amount: "+user.get(0).getCOLUMN_THRIFT_AMOUNT().trim().toUpperCase());
        p_wit.setText("Wit.NAME: "+user.get(0).getCOLUMN_THRIFT_WITNAMME().trim().toUpperCase());

        p_pay.setOnClickListener(e->{

            PAYMENT payment = new PAYMENT();
            payment.setCOLUMN_ID(user.get(0).getCOLUMN_THIFT_REGID());
            payment.setCOLUMN_AMOUNT(user.get(0).getCOLUMN_THRIFT_AMOUNT());
            payment.setCOLUMN_DATE(date());

            if (payment.save()){
                total += Long.parseLong(user.get(0).getCOLUMN_THRIFT_AMOUNT());
                totalp.setText("#"+String.valueOf(total));
                Toasty.success(getApplicationContext(),"Paid", Toast.LENGTH_LONG).show();
            }else{
                Toasty.error(getApplicationContext(),"FAILED ", Toast.LENGTH_LONG).show();

            }
        });

        historybtn.setOnClickListener(e->{

            Intent intent1 = new Intent(getApplicationContext(), Table.class);
            Bundle   bundle1 = new Bundle();
            bundle1.putString("regid",regid);
            intent1.putExtras(bundle1);
            startActivity(intent1);
        });


        if (user.get(0).getCOLUMN_THIRFT_NAME().equalsIgnoreCase("female")){
            imageView.setBackgroundResource(R.drawable.fenale);
        }else {
            imageView.setBackgroundResource(R.drawable.male);

        }
    }


    String date(){
        Calendar rightNow = Calendar.getInstance();
        return  rightNow.get(Calendar.DATE) +"/"+rightNow.get(Calendar.MONTH)+"/"+rightNow.get(Calendar.YEAR);

    }





}
