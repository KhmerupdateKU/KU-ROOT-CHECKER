package com.khmerupdate.ku.kurootchecker;

import android.os.Build;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.khmerupdate.ku.kurootchecker.R.string.rooted;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Admob//

       // AdView mAdView = (AdView) findViewById(R.id.adView);//
       // AdRequest adRequest = new AdRequest.Builder().build();//
        //mAdView.loadAd(adRequest);//


        // end ddmob//
        // all button click //ß
        final Button button2 = (Button) findViewById(R.id.button2);
        // Device Information //
        final TextView Text1 = (TextView) findViewById(R.id.textView3);
        final TextView Text2 = (TextView) findViewById(R.id.textView5);
        final TextView Text3 = (TextView) findViewById(R.id.TextView09);
        final TextView Text4 = (TextView) findViewById(R.id.TextView05);




        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String command[] = {"su", "-c", "ls", "/system"};
                Shell shell = new Shell();
                String text = shell.sendShellCommand(command);
                if ((text.contains("app")) || (text.contains("anr"))
                        || (text.contains("user"))
                        || (text.contains("data"))) {

                    button2.setBackgroundResource(R.drawable.rooted);

                    Toast.makeText(getApplicationContext(), R.string.rooted, Toast.LENGTH_SHORT).show();

                } else {
                    button2.setBackgroundResource(R.drawable.norooted);
                    Toast.makeText(getApplicationContext(), R.string.unroot, Toast.LENGTH_SHORT).show();
                }

                String modelName = Build.MODEL;
                String manfacT = Build.MANUFACTURER;
                String deviceName = Build.DEVICE;
                String versionOS = Build.VERSION.RELEASE;

                Text1.setText(deviceName);
                Text2.setText(modelName);
                Text3.setText(manfacT);
                Text4.setText(versionOS);


            }

        });

        }

    }