package com.akindev.thrift.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.akindev.thrift.Adapter.memberAdapter;
import com.akindev.thrift.R;
import com.akindev.thrift.model.CREATEUSER;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import org.litepal.LitePal;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class viewmember extends AppCompatActivity implements MaterialSearchView.OnQueryTextListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.search_view)
    MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmember);
        LitePal.initialize(this);
        ButterKnife.bind(this);



        List<CREATEUSER> user = LitePal.findAll(CREATEUSER.class);

       if (user.size() ==0){

           setContentView(R.layout.emptylayout);

       }else{

           RecyclerView.LayoutManager layoutManager=  new GridLayoutManager(this,2);
           recyclerView.setLayoutManager(layoutManager);
           memberAdapter memberAdapter  = new memberAdapter(user);
           recyclerView.setAdapter(memberAdapter);

       }

       searchView.setOnQueryTextListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {

        List<CREATEUSER> user = LitePal.where("COLUMN_THIRFT_NAME = ?",query.toUpperCase()).find(CREATEUSER.class);

        if (user.size() == 1){

            Intent intent = new Intent(getApplicationContext(), Profile.class);
            Bundle   bundle = new Bundle();
            bundle.putString("regid",user.get(0).getCOLUMN_THIFT_REGID().toString());
            intent.putExtras(bundle);
           startActivity(intent);


        }else {
            Toasty.error(getApplicationContext(), "No User", Toast.LENGTH_SHORT).show();
        }


        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
