package com.akindev.thrift.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akindev.thrift.R;
import com.akindev.thrift.model.PAYMENT;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class tableAdapter extends RecyclerView.Adapter<tableAdapter.ViewHolder> {

    List<PAYMENT> list;

    public tableAdapter(List<PAYMENT> payments) {

        list = payments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.paymentview, parent, false);

        return new tableAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.amountpaid.setText(list.get(position).getCOLUMN_AMOUNT());
        holder.datepaid.setText(list.get(position).getCOLUMN_DATE());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView datepaid;
        private TextView amountpaid;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            datepaid = itemView.findViewById(R.id.datepaid);
            amountpaid = itemView.findViewById(R.id.amountpaid);
        }
    }
}
