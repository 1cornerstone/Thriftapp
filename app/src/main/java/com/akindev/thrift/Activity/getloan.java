package com.akindev.thrift.Activity;

import android.os.Bundle;

import com.akindev.thrift.R;
import com.akindev.thrift.model.CREATEUSER;
import com.akindev.thrift.model.LOAN;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.rengwuxian.materialedittext.MaterialEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

public class getloan extends AppCompatActivity {

    @BindView(R.id.regid)
    MaterialEditText regid;

    @BindView(R.id.name)
    MaterialEditText name;

    @BindView(R.id.loanamount)
    MaterialEditText amount;

    @BindView(R.id.asseststake)
    MaterialEditText assest;

    @BindView(R.id.valid)
    Button valid;

    @BindView(R.id.loan)
    Button loan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getloan);

        ButterKnife.bind(this);
        LitePal.initialize(this);



        valid.setOnClickListener(e->{
            String  id = name.getText().toString();
            List<CREATEUSER> user = LitePal.where("COLUMN_THIRFT_NAME = ?",id).find(CREATEUSER.class);

            if (user.size() == 1){
                Toasty.info(getApplicationContext(),"User Found", Toast.LENGTH_SHORT).show();
               regid.setText(user.get(0).getCOLUMN_THIFT_REGID());
                amount.setEnabled(true);
                assest.setEnabled(true);
            }else {
                regid.setText("");
                amount.setText("");
                assest.setText("");
                amount.setEnabled(false);
                assest.setEnabled(false);
                Toasty.error(getApplicationContext(), "No User", Toast.LENGTH_SHORT).show();
            }
        });


        loan.setOnClickListener(e->{

            if (isempty(amount) || isempty(assest) || isempty(regid) || isempty(name)){
                Toasty.error(getApplicationContext(), "Incomplete Form, Check well", Toast.LENGTH_SHORT).show();

            }else{

                LOAN loan =  new LOAN();
                loan.setCOLUMN_LOAN_PAID(totxt(regid));
                loan.setCOLUMN_LOAN_UNAME(totxt(name));
                loan.setCOLUMN_LOAN_AMOUNT(totxt(assest));
                loan.setCOLUMN_LOAN_PAID("0");
                loan.setCOLUMN_ASSEST(totxt(assest));
                loan.setCOLUMN_LOAN_DATE("23/04/2019");

                Double topay = Double.parseDouble(totxt(amount)) * 0.1;
                System.out.println(topay);

            }


        });




    }

    private String totxt(MaterialEditText editText){

        return  editText.getText().toString();
    }

    private boolean isempty(MaterialEditText  editText){

        if (editText.getText().toString().equalsIgnoreCase("") || editText.getText().toString().isEmpty()){
            return true;
        }else {
            return false;
        }
    }

}
