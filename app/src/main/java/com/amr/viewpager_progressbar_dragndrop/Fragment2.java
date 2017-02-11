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

public class Fragment2 extends Fragment {
    private Button calculateButtonAfter;
    private Button resetButtonAfter;
    private ProgressBar progressBarAfter;
    private ProgressBar progressBar2After;
    private EditText numberAfter;
    private TextView resultAfter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        if (numberAfter == null)//for first time only
        {
            progressBarAfter = (ProgressBar) view.findViewById(R.id.progressBarAfter);
            progressBar2After = (ProgressBar) view.findViewById(R.id.progressBar2After);
            calculateButtonAfter = (Button) view.findViewById(R.id.calculateButtonAfter);
            resetButtonAfter = (Button) view.findViewById(R.id.resetButtonAfter);
            numberAfter = (EditText) view.findViewById(R.id.numberEditTextAfter);
            resultAfter = (TextView) view.findViewById(R.id.resultAfter);
            resetButtonAfter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resultAfter.setText("");
                    progressBarAfter.setProgress(0);
                    progressBar2After.setVisibility(View.INVISIBLE);
                }
            });
            calculateButtonAfter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    progressBar2After.setVisibility(View.VISIBLE);
                    MainActivity.factorialAfter(Integer.valueOf(numberAfter.getText().toString()), progressBarAfter, progressBar2After, resultAfter);
                }
            });
        }

        return view;
    }
}
