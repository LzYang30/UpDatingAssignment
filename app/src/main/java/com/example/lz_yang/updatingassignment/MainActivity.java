package com.example.lz_yang.updatingassignment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageViewAccount;
    ImageView imageViewInfo;
    ImageView imageViewSeacrh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewAccount = (ImageView)findViewById(R.id.imageViewAccount);
        imageViewAccount.setOnClickListener(this);
        imageViewSeacrh = (ImageView)findViewById(R.id.imageViewSeacrh);
        imageViewSeacrh.setOnClickListener(this);
        imageViewInfo = (ImageView)findViewById(R.id.imageViewFrezList);
        imageViewInfo.setOnClickListener(this);
    }

    public void onClick(View view){

        Fragment fragment = null;

        if (view == imageViewAccount) {
            fragment = new FragmentAccount();

        }else if (view == imageViewSeacrh) {
            fragment = new SwipeFragment();

        }else if (view == imageViewInfo) {
            fragment = new FragmentInfo();

        }else{

        }
        //Create instance of Fragment Manager
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
