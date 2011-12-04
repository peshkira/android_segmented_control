package com.petpet.sc.listeners;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

import com.petpet.sc.widget.SegmentedControl;

public class SCTouchListener implements OnTouchListener {

    private SegmentedControl sc;
    
    public SCTouchListener(SegmentedControl sc) {
        this.sc = sc;
    }
    
    @Override
    public boolean onTouch(View v, MotionEvent e) {
        System.out.println("touched segmented outer");
        boolean processed = false;
        if (e.getAction() == MotionEvent.ACTION_UP) {
            System.out.println("touched segmented");
            this.sc.stateChanged((Button) v);
            v.performClick();
            processed = true;
        }
        
        return processed;
    }
}
