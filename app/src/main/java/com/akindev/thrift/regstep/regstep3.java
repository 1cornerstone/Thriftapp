package com.akindev.thrift.regstep;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.akindev.thrift.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ernestoyaquello.com.verticalstepperform.Step;
import ernestoyaquello.com.verticalstepperform.VerticalStepperFormView;
import es.dmoral.toasty.Toasty;

public class regstep3 extends Step<String> {

    ArrayList<String> data;

    @BindView(R.id.amount)
    MaterialEditText amount;

    @BindView(R.id.answer)
    MaterialEditText answer;

    @BindView(R.id.group)
    RadioGroup group;

    @BindView(R.id.next)
    Button  next;

    VerticalStepperFormView formView;

    int belong =0;

    public regstep3(String title, VerticalStepperFormView stepperFormView) {
        super(title);
        formView = stepperFormView;
    }


    @Override
    protected View createStepContentLayout() {

        data = new ArrayList<>();
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.regstep3,null,false);

        ButterKnife.bind(this,view);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                belong = checkedId;
                System.out.println("this is the checked ID "+ checkedId);
            }
        });

        next.setOnClickListener( e->{

            if (isempty(amount) || isempty(answer) || belong ==0){
                Toasty.error(getContext(),"Incomplete Form").show();
            }else{

                data.add(totxt(amount));
                data.add(totxt(answer));

                RadioButton selectedRadioButton = (RadioButton)view.findViewById(belong);
                String selectedRadioButtonText = selectedRadioButton.getText().toString();

                data.add(selectedRadioButtonText);
                formView.goToNextStep(true);
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

    } @Override
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
