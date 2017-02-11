package com.amr.viewpager_progressbar_dragndrop;

import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private CustomFragmentStatePagerAdapter viewPageAdapter;

    static BigInteger factorialBefore(int n, ProgressBar progressBar) {
        int eachN = 100;
        BigInteger b = new BigInteger("1");
        BigInteger temp;
        if (n >= 100) {
            eachN = n / 100;
        }
        for (int i = 2; i <= n; i++) {
            temp = new BigInteger(String.valueOf(i));
            b = b.multiply(temp);
            if (i % eachN == 0) {

                progressBar.setProgress((i / eachN));
            }
        }
        progressBar.setProgress(100);
        return b;
    }

    static void factorialAfter(final int n, final ProgressBar progressBar, final ProgressBar progressBar2, final TextView resultText) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //Handler mainHandler = new Handler(context.getMainLooper());
                Handler uiHandler = new Handler(Looper.getMainLooper());
                int eachN = 100;
                BigInteger b = new BigInteger("1");
                BigInteger temp;
                if (n >= 100) {
                    eachN = n / 100;
                }
                for (int i = 2; i <= n; i++) {
                    temp = new BigInteger(String.valueOf(i));
                    b = b.multiply(temp);
                    final int progress = i / eachN;
                    if (i % eachN == 0) {
                        uiHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(progress);
                            }
                        });

                    }
                }
                final BigInteger result = b;
                uiHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        resultText.setText(result.toString());
                        progressBar.setProgress(100);
                        progressBar2.setVisibility(View.INVISIBLE);
                    }
                });

            }
        }).start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);


        viewPageAdapter = new CustomFragmentStatePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPageAdapter);


        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });


    }
}