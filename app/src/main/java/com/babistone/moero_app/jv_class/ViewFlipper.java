package com.babistone.moero_app.jv_class;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.babistone.moero_app.R;

public class ViewFlipper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);

        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction tManager = fragManager.beginTransaction();
        tManager.replace(R.id.containerView, new Frag_Flipper() ).commit();


    }
}