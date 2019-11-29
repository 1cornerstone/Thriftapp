package com.akindev.thrift.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akindev.thrift.R;
import com.akindev.thrift.Activity.getloan;
import com.akindev.thrift.Activity.loanrecord;


/**
 * A simple {@link Fragment} subclass.
 */
public class loan extends Fragment {

    View view;

    @BindView(R.id.getloadcard)
    CardView loancard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_loan, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.getloadcard)
    public void loan() {

        startActivity(new Intent(getActivity(), getloan.class));

    }
 @OnClick(R.id.loanrecord)
    public void getloan() {

        startActivity(new Intent(getActivity(), loanrecord.class));

    }


}
