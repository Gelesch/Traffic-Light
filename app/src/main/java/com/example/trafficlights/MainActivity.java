package com.example.trafficlights;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout b1, b2, b3;
    private Button st;
    private boolean start_stop = false;

    private int count =0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.bulb1);
        b2 = findViewById(R.id.bulb2);
        b3 = findViewById(R.id.bulb3);
        st = findViewById(R.id.button1);

    }

    public void buttonStart(View view) {
        if (!start_stop) {
            start_stop = true;
            st.setText("Stop");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while ( start_stop ) {
                        count++;
                        switch (count) {
                            case 1:
                                b1.setBackgroundColor(getResources().getColor(R.color.red));
                                b2.setBackgroundColor(getResources().getColor(R.color.grey));
                                b3.setBackgroundColor(getResources().getColor(R.color.grey));
                                break;
                            case 2:
                                b1.setBackgroundColor(getResources().getColor(R.color.grey));
                                b2.setBackgroundColor(getResources().getColor(R.color.yellow));
                                b3.setBackgroundColor(getResources().getColor(R.color.grey));
                                break;
                            case 3:
                                b1.setBackgroundColor(getResources().getColor(R.color.grey));
                                b2.setBackgroundColor(getResources().getColor(R.color.grey));
                                b3.setBackgroundColor(getResources().getColor(R.color.green));
                                count=0;

                                break;
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                }
            }).start();
        } else {
            start_stop = false;
            st.setText("Start");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        start_stop = false;
    }


}