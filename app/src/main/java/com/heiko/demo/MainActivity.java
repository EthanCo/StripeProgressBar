package com.heiko.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.heiko.stripeprogressbar.StripeProgressBar;
import com.heiko.stripeprogressbar.demo.R;

public class MainActivity extends AppCompatActivity {

    private StripeProgressBar stripeProgressBar;
    private Button btnStart;
    private TextView tvProgpress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btn_start);
        tvProgpress = findViewById(R.id.tv_progress);
        stripeProgressBar = findViewById(R.id.stripe_progress_bar);
        stripeProgressBar.setMax(100);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ProgressThread().start();
            }
        });
    }

    private class ProgressThread extends Thread {

        private int progress = 0;

        @Override
        public void run() {
            super.run();
            while (!isInterrupted()) {
                progress++;
                if (progress > 100) {
                    progress = 0;
                }
                final int p = progress;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        stripeProgressBar.setProgress(p);
                        tvProgpress.setText(p + "%");
                    }
                });
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}
