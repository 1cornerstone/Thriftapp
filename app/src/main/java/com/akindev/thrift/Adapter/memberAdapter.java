package com.akindev.thrift.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.akindev.thrift.Activity.Profile;
import com.akindev.thrift.R;
import com.akindev.thrift.model.CREATEUSER;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class memberAdapter extends RecyclerView.Adapter<memberAdapter.ItemHolder> {

    List<CREATEUSER>  createuserList;
    View  view;

    public memberAdapter(List<CREATEUSER> user) {

        createuserList = user;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

              view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.memberlayout, parent, false);

        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {



            if (createuserList.get(position).getCOLUMN_THRIFT_GENDER().equalsIgnoreCase("female")){

                holder.image.setBackgroundResource(R.drawable.fenale);
            }else {
                holder.image.setBackgroundResource(R.drawable.male);

            }

            holder.regid.setText(createuserList.get(position).getCOLUMN_THIFT_REGID());
            holder.namee.setText(createuserList.get(position).getCOLUMN_THIRFT_NAME());

    }

    @Override
    public int getItemCount() {
        return createuserList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView namee;
        private TextView regid;
        private CardView  cardView;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);


           image = itemView.findViewById(R.id.userimg);
           namee = itemView.findViewById(R.id.username);
          regid = itemView.findViewById(R.id.regid);
           cardView = itemView.findViewById(R.id.cardview);

           cardView.setOnClickListener(e->{

               Intent intent = new Intent(itemView.getContext(), Profile.class);
               Bundle   bundle = new Bundle();
               bundle.putString("regid",regid.getText().toString());
               intent.putExtras(bundle);
               itemView.getContext().startActivity(intent);

           });

        }
    }
}

