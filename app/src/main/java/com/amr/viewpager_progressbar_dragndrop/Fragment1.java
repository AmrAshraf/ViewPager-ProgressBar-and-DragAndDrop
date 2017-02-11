package com.amr.viewpager_progressbar_dragndrop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.math.BigInteger;

public class Fragment1 extends Fragment {

    private EditText numberBefore;
    private Button calculateButtonBefore;
    private Button resetButtonBefore;
    private ProgressBar progressBarBefore;
    private ProgressBar progressBar2Before;
    private TextView resultBefore;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        if (numberBefore == null)//for first time only
        {
            progressBarBefore = (ProgressBar) view.findViewById(R.id.progressBarBefore);
            progressBar2Before = (ProgressBar) view.findViewById(R.id.progressBar2Before);
            calculateButtonBefore = (Button) view.findViewById(R.id.calculateButtonBefore);
            resetButtonBefore = (Button) view.findViewById(R.id.resetButtonBefore);
            numberBefore = (EditText) view.findViewById(R.id.numberEditTextBefore);
            resultBefore = (TextView) view.findViewById(R.id.resultBefore);
            resetButtonBefore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resultBefore.setText("");
                    progressBarBefore.setProgress(0);
                    progressBar2Before.setVisibility(View.INVISIBLE);
                }
            });
            calculateButtonBefore.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    progressBar2Before.setVisibility(View.VISIBLE);
                    BigInteger result = MainActivity.factorialBefore(Integer.valueOf(numberBefore.getText().toString()), progressBarBefore);
                    resultBefore.setText(result.toString());
                    progressBar2Before.setVisibility(View.INVISIBLE);
                }
            });
        }

        return view;
    }
}