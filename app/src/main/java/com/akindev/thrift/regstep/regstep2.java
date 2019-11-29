package com.akindev.thrift.regstep;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.akindev.thrift.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ernestoyaquello.com.verticalstepperform.Step;
import ernestoyaquello.com.verticalstepperform.VerticalStepperFormView;
import es.dmoral.toasty.Toasty;

public class regstep2 extends Step<String> {

    VerticalStepperFormView formView;

    @BindView(R.id.occup)
    MaterialEditText occup;

    @BindView(R.id.state)
    MaterialEditText state;

    @BindView(R.id.nok)
    MaterialEditText nok;

    @BindView(R.id.date)
    MaterialEditText date;

    @BindView(R.id.month)
    MaterialEditText month;

    @BindView(R.id.year)
    MaterialEditText year;

    @BindView(R.id.next)
    Button next;

    ArrayList<String> data;

    public regstep2(String title, VerticalStepperFormView stepperFormView) {
        super(title);

        formView = stepperFormView;
    }


    @Override
    protected View createStepContentLayout() {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.regstep2,null,false);
        ButterKnife.bind(this,view);

        data = new ArrayList<>();

        next.setOnClickListener(e->{

            if (isempty(occup) || isempty(state)|| isempty(nok) || isempty(date) || isempty(year) || isempty(year)){
                Toasty.error(getContext(),"Incomplete Form").show();
            }else {

                data.add(totxt(occup));
                data.add(totxt(state));
                data.add(totxt(nok));

                String dateofbirth = totxt(date) +"-"+ totxt(month) +"-"+totxt(year);
                data.add(dateofbirth);

                formView.goToNextStep(true);

            }


        });

        return view;
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

    public  ArrayList<String> getdata(){
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
