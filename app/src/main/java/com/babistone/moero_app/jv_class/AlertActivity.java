package com.babistone.moero_app.jv_class;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.CompoundButton;


import com.babistone.moero_app.R;

public class AlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Switch myswitch;
        TextView tvswitch, tv_customswitch, tv_mat_switch;
        RadioGroup mat_toggle;
        SwitchCompat switch_custom;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        myswitch = (Switch) findViewById(R.id.switch1);
        tvswitch = (TextView) findViewById(R.id.tvswitch);
        mat_toggle = findViewById(R.id.mat_toggle);
        switch_custom = findViewById(R.id.switch_custom);
        tv_customswitch = findViewById(R.id.tv_customswitch);
        tv_mat_switch = findViewById(R.id.tv_mat_switch);

        tvswitch.setText("not checked");
        tv_mat_switch.setText("not checked");
        tv_customswitch.setText("not checked");

        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tvswitch.setText("checked");

                }
                else {
                    tvswitch.setText("not checked");
                }
            }
        });

        switch_custom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tv_customswitch.setText("checked : true");
                }
                else{
                    tv_customswitch.setText("checked : false");
                }
            }
        });

        mat_toggle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.offers){
                    tv_mat_switch.setText("checked : offers");
                }
                else if (checkedId == R.id.search){
                    tv_mat_switch.setText("checked : search");
                }
            }
        });


    }
}