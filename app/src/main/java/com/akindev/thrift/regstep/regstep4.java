package com.akindev.thrift.regstep;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.akindev.thrift.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ernestoyaquello.com.verticalstepperform.Step;
import ernestoyaquello.com.verticalstepperform.VerticalStepperFormView;
import es.dmoral.toasty.Toasty;

public class regstep4 extends Step<String> {


    ArrayList<String> data;
    @BindView(R.id.witname)
    MaterialEditText witname;

     @BindView(R.id.witregid)
    MaterialEditText witregid;


    @BindView(R.id.next)
    Button  next;

    VerticalStepperFormView  formView;



    public regstep4(String title, VerticalStepperFormView stepperFormView) {
        super(title);
        formView = stepperFormView;
    }

    @Override
    protected View createStepContentLayout() {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.regstep4, null, false);

        ButterKnife.bind(this,view);

        data = new ArrayList<>();




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isempty(witname)){
                    Toasty.error(getContext(),"Incomplete Form", Toast.LENGTH_SHORT).show();
                }else{

                    data.add(totxt(witname));

                   // search for the name in the database and get ID
                 // data.add(totxt(witregid));
                    formView.goToNextStep(true);
                }
            }
        });





        return view;
    }

    @Override
    protected void onStepOpened(boolean animated) {

    }

    @Override
    protected void onStepClosed(boolean animated) {

    }

    @Override
    protected void onStepMarkedAsCompleted(boolean animated) {

    }

    @Override
    protected void onStepMarkedAsUncompleted(boolean animated) {

    }

    @Override
    public String getStepData() {
        return null;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(String data) {

    }

    @Override
    protected IsDataValid isStepDataValid(String stepData) {
        return null;
    }

    public ArrayList<String>  getdata(){
        return data;
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
