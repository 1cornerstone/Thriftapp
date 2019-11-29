package com.akindev.thrift.regstep;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.akindev.thrift.R;
import com.akindev.thrift.model.CREATEUSER;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.litepal.LitePal;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ernestoyaquello.com.verticalstepperform.Step;
import ernestoyaquello.com.verticalstepperform.VerticalStepperFormView;
import es.dmoral.toasty.Toasty;

public class regstep1 extends Step<String> {

    @BindView(R.id.regid)
    MaterialEditText  regid;

    @BindView(R.id.name)
    MaterialEditText name;

    @BindView(R.id.phone)
    MaterialEditText  phone;

    @BindView(R.id.address)
    MaterialEditText  address;

    @BindView(R.id.group)
    RadioGroup group;

    @BindView(R.id.next)
    Button next;

    View  view;
    VerticalStepperFormView formView;


    int selected=0;
    ArrayList<String> list;

    public regstep1(String title, VerticalStepperFormView stepperFormView) {
        super(title);
        formView = stepperFormView;
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
    protected View createStepContentLayout() {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        view = layoutInflater.inflate(R.layout.regstep1,null,false);
        ButterKnife.bind(this,view);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

               selected = checkedId;
                System.out.println("this is the checked ID "+ checkedId);
            }
        });

        regid.setText(randomAlphaNumeric(12));

        list  = new ArrayList<>();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isempty(name) || isempty(phone) || isempty(address) || selected ==0){

                    Toasty.error(view.getContext(),"Incomplete Form",Toast.LENGTH_LONG).show();

                }else{

                    list.add(regid.getText().toString());
                    list.add(name.getText().toString());
                    list.add(phone.getText().toString());
                    list.add(address.getText().toString());

                    RadioButton selectedRadioButton = (RadioButton)view.findViewById(selected);
                    String selectedRadioButtonText = selectedRadioButton.getText().toString();

                    list.add(selectedRadioButtonText);

                    formView.goToNextStep(true);

                }


            }
        });



        return view;
    }

    @Override
    protected void onStepOpened(boolean animated) {}

    @Override
    protected void onStepClosed(boolean animated) { }

    @Override
    protected void onStepMarkedAsCompleted(boolean animated) {}

    @Override
    protected void onStepMarkedAsUncompleted(boolean animated) {}


   public ArrayList<String> getdata(){
        return list;
    }

    private boolean isempty(MaterialEditText  editText){

        if (editText.getText().toString().equalsIgnoreCase("") || editText.getText().toString().isEmpty()){
            return true;
        }else {
            return false;
        }
    }


    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }



}
