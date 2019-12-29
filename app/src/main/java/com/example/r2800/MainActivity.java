package com.example.r2800;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.ConsumerIrManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton volumePlus;
    ImageButton volumeMinus;
    ImageButton auxpc;
    ImageButton optcox;
    ImageButton  mute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        volumePlus = (ImageButton) findViewById(R.id.volume_plus);
        volumeMinus = (ImageButton) findViewById(R.id.volume_minus);
        auxpc = (ImageButton) findViewById(R.id.auxpc);
        optcox = (ImageButton) findViewById(R.id.optcoaxial);
        mute = (ImageButton) findViewById(R.id.mute);
        final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        final String errIr = "The device is not equipped with an IR port";
        final ConsumerIrManager consumerIrManager = (ConsumerIrManager) this.getSystemService(Context.CONSUMER_IR_SERVICE);
        final int frequency = 36000;
        final int[] vplus = new int[]{9022,4498,572,572,572,572,572,572,572,1690,572,1690,572,1690,572,1690,572,572,572,572,572,1690,572,1690,572,1690,572,572,572,572,572,572,572,572,572,1690,572,572,572,572,572,572,572,572,572,572,572,572,572,572,572,572,572,1690,572,1690,572,1690,572,1690,572,1690,572,1690,572,1690,572,39702,9022,2262,572,95992};
        final int[] vminus = new int[]{9022,4498,572,572,572,572,572,572,572,1690,572,1690,572,1690,572,1690,572,572,572,572,572,1690,572,1690,572,1690,572,572,572,572,572,572,572,572,572,572,572,1690,572,572,572,572,572,572,572,572,572,572,572,572,572,1690,572,572,572,1690,572,1690,572,1690,572,1690,572,1690,572,1690,572,39702,9022,2262,572,95992};
        final int[] opt_cox = new int[]{9022,4498,572,572,572,572,572,572,572,1690,572,1690,572,1690,572,1690,572,572,572,572,572,1690,572,1690,572,1690,572,572,572,572,572,572,572,572,572,1690,572,1690,572,572,572,572,572,572,572,572,572,572,572,572,572,572,572,572,572,1690,572,1690,572,1690,572,1690,572,1690,572,1690,572,39702,9022,2262,572,95992};
        final int[] pc_aux = new int[]{9022,4498,572,572,572,572,572,572,572,1690,572,1690,572,1690,572,1690,572,572,572,572,572,1690,572,1690,572,1690,572,572,572,572,572,572,572,572,572,572,572,572,572,572,572,572,572,572,572,572,572,572,572,572,572,1690,572,1690,572,1690,572,1690,572,1690,572,1690,572,1690,572,1690,572,39702,9022,2262,572,95992};
        final int[] mutecode = new int[]{9022,4498,572,572,572,572,572,572,572,1690,572,1690,572,1690,572,1690,572,572,572,572,572,1690,572,1690,572,1690,572,572,572,572,572,572,572,572,572,1690,572,572,572,572,572,1690,572,572,572,572,572,572,572,572,572,572,572,1690,572,1690,572,572,572,1690,572,1690,572,1690,572,1690,572,39702,9022,2262,572,95992};
        volumePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    v.vibrate(400);
                    consumerIrManager.transmit(frequency, vplus);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        volumeMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    consumerIrManager.transmit(frequency, vminus);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        auxpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    consumerIrManager.transmit(frequency, pc_aux);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        optcox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    consumerIrManager.transmit(frequency, opt_cox);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    consumerIrManager.transmit(frequency, mutecode);
                }
                catch(UnsupportedOperationException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            errIr, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
