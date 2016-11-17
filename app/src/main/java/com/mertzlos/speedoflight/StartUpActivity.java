package com.mertzlos.speedoflight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class StartUpActivity extends AppCompatActivity {
    private String metric;
    static final String MESSAGE_FOR = "com.mertzlos.metricSystem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);
    }

    public void onRadioButtonClick(View view){


        boolean checked =((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.radioKm:
                if(checked){
                    metric = "Km";
                    Intent intent = new Intent(this,MainActivity.class);
                    intent.putExtra(MESSAGE_FOR,metric);
                    startActivity(intent);
                    Log.v("radio","is true");

                }
                break;
            case R.id.radioMiles:
                if(checked){
                    metric = "Miles";
                    Intent intent = new Intent(this,MainActivity.class);
                    intent.putExtra(MESSAGE_FOR,metric);
                    startActivity(intent);
                    Log.v("radio","is false");

                }
                break;

        }


    }

}
