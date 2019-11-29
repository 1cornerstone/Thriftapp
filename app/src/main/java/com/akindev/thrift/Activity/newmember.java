package com.akindev.thrift.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.akindev.thrift.R;
import com.akindev.thrift.model.CREATEUSER;
import com.akindev.thrift.regstep.regstep1;
import com.akindev.thrift.regstep.regstep2;
import com.akindev.thrift.regstep.regstep3;
import com.akindev.thrift.regstep.regstep4;
import com.victor.loading.book.BookLoading;


import org.litepal.LitePal;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import ernestoyaquello.com.verticalstepperform.VerticalStepperFormView;
import ernestoyaquello.com.verticalstepperform.listener.StepperFormListener;
import es.dmoral.toasty.Toasty;

public class newmember extends AppCompatActivity implements StepperFormListener {

    @BindView(R.id.stepper_form)
    VerticalStepperFormView stepperFormView;

    private regstep1  step1;
    private regstep2 step2;
    private regstep3 step3;
    private regstep4 step4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newmember);

        ButterKnife.bind(this);
      LitePal.initialize(this);

      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        step1 = new regstep1("1",stepperFormView);
        step2 = new regstep2("2",stepperFormView);
        step3 = new regstep3("3",stepperFormView);
        step4 = new regstep4("4",stepperFormView);

        stepperFormView.
                setup(this,step1,step2,step3,step4)
                .displayBottomNavigation(false)
                .lastStepNextButtonText("Create Member")
                .allowNonLinearNavigation(false)
                .allowStepOpeningOnHeaderClick(false)
                .displayStepButtons(false)
                .init();

    }

    @Override
    public void onCompletedForm() {

       LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
       View v = inflater.inflate(R.layout.savingdialog,null);

       ButterKnife.bind(v);

       BookLoading  bookLoading = (BookLoading)v.findViewById(R.id.bookloading);
       bookLoading.start();

        TextView saved = (TextView) v.findViewById(R.id.saved);

        AlertDialog.Builder  builder = new AlertDialog.Builder(this);
        builder.setView(v);
        builder.setCancelable(false);
        builder.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                bookLoading.stop();
                saved.setText("SAVED");

                saveData();

               startActivity(new Intent(newmember.this,viewmember.class));
            }
        },3000);

    }

    @Override
    public void onCancelledForm() {

    }


    void saveData(){

        CREATEUSER createuser = new CREATEUSER();
        createuser.setCOLUMN_THIFT_REGID(step1.getdata().get(0).trim().toUpperCase());
        createuser.setCOLUMN_THIRFT_NAME(step1.getdata().get(1).trim().toUpperCase());
        createuser.setCOLUMN_THIFT_PHONE(step1.getdata().get(2));
        createuser.setCOLUMN_THITFT_ADDRESS(step1.getdata().get(3));
        createuser.setCOLUMN_THRIFT_GENDER(step1.getdata().get(4));
        createuser.setCOLUMN_THRIFT_OCCUP(step2.getdata().get(0));
        createuser.setCOLUMN_THIRFT_STATE(step2.getdata().get(1));
        createuser.setCOLUMN_THIFT_NOK(step2.getdata().get(2));
        createuser.setCOLUMN_THIFT_DOB(step2.getdata().get(3));
        createuser.setCOLUMN_THRIFT_AMOUNT(step3.getdata().get(0));
        createuser.setCOLUMN_THRIFT_REASON(step3.getdata().get(1));
        createuser.setCOLUMN_THRIFT_Q1(step3.getdata().get(2));
        createuser.setCOLUMN_THRIFT_WITNAMME(step4.getdata().get(0).trim().toUpperCase());
        createuser.setCOLUMN_THIFT_DOJ(date());

      //  createuser.saveThrows();

        if (createuser.save()){
            Toasty.success(getApplicationContext(),"SAVED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
        }else{
            Toasty.error(getApplicationContext(),"FAILED ", Toast.LENGTH_SHORT).show();

        }

    }


    String date(){
        Calendar rightNow = Calendar.getInstance();
        return  rightNow.get(Calendar.DATE) +"/"+rightNow.get(Calendar.MONTH)+"/"+rightNow.get(Calendar.YEAR);

    }
}
