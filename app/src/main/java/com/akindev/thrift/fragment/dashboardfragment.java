package com.akindev.thrift.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akindev.thrift.R;
import com.akindev.thrift.Activity.newmember;
import com.akindev.thrift.Activity.viewmember;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class dashboardfragment extends Fragment {

    @BindView(R.id.add_member_card)
    CardView cardView;

    @BindView(R.id.cardviewmember)
    CardView viewmembercard;

    View  view ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ButterKnife.bind(this,view);

        return view;
    }


   @OnClick(R.id.add_member_card)
    void cardaddmember(){

        view.getContext().startActivity(new Intent(getActivity(), newmember.class));

   }

   @OnClick(R.id.cardviewmember)
    void cardaviewmember(){

        view.getContext().startActivity(new Intent(getActivity(), viewmember.class));

   }

}
