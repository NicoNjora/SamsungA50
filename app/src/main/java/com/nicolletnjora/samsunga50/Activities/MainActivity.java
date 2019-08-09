package com.nicolletnjora.samsunga50.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nicolletnjora.samsunga50.Adapters.UssdCodesAdapter;
import com.nicolletnjora.samsunga50.Database.UssdCodesDatabase;
import com.nicolletnjora.samsunga50.Fragments.AddUssdFragment;
import com.nicolletnjora.samsunga50.Models.UssdCode;
import com.nicolletnjora.samsunga50.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fab_ussd)
    FloatingActionButton fab;

    @BindView(R.id.ussd_recycler_view)
    RecyclerView recyclerView;

    private UssdCodesAdapter adapter;
    private UssdCodesDatabase db;
    private List<UssdCode> ussdCodeList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // bind the view using butterKnife
        ButterKnife.bind(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new AddUssdFragment());
            }
        });

        db = UssdCodesDatabase.getDatabaseInstance(this);

        ussdCodeList = new ArrayList<>();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        getCodes();
    }

    public void getCodes(){

        ussdCodeList = db.UssdCodeDao().getUssdCodes();

        adapter = new UssdCodesAdapter(this, ussdCodeList);
        recyclerView.setAdapter(adapter);

        // refreshing recycler view
        adapter.notifyDataSetChanged();

    }


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_scan:
                // launch settings activity
                startActivity(new Intent(MainActivity.this, OcrCaptureActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);

    }




}