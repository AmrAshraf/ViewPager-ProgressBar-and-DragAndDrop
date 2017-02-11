package com.amr.viewpager_progressbar_dragndrop;


import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class Fragment3 extends Fragment {

    private TextView text1;
    private TextView text2;
    private EditText text3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);

        if (text1 == null)//for first time only
        {
            text1 = (TextView) view.findViewById(R.id.text1);
            text2 = (TextView) view.findViewById(R.id.text2);
            text3 = (EditText) view.findViewById(R.id.text3);


            View.OnDragListener onDragListener = new View.OnDragListener() {
                @Override
                public boolean onDrag(View view, DragEvent dragEvent) {
                   int dragEventNumber =dragEvent.getAction();
                    final TextView textView= (TextView) dragEvent.getLocalState();
                    switch (dragEventNumber)
                    {

                        case DragEvent.ACTION_DRAG_ENTERED:
                            ((EditText)view).setText("...........");
                            return true;
                        case DragEvent.ACTION_DROP:
                            ((EditText)view).setText(textView.getText().toString());
                            return true;
                    }
                return false;
                }
            };

            View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    ClipData data= ClipData.newPlainText("","");
                    View.DragShadowBuilder dragShadowBuilder=new View.DragShadowBuilder(view);
                    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                       return  view.startDragAndDrop(data,dragShadowBuilder,view,0);
                    }
                   else
                    {
                        return  view.startDrag(data,dragShadowBuilder,view,0);
                    }

                }
            };
            text3.setOnDragListener(onDragListener);
            text1.setOnLongClickListener(onLongClickListener);
            text2.setOnLongClickListener(onLongClickListener);
        }

        return view;
    }
}
