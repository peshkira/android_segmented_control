package com.petpet.sc.listeners;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

import com.petpet.sc.widget.SegmentedControl;

public class SCStateChangedListener implements OnTouchListener {

    private SegmentedControl sc;
    
    public SCStateChangedListener(SegmentedControl sc) {
        this.sc = sc;
    }
    
    @Override
    public boolean onTouch(View v, MotionEvent e) {
        this.sc.stateChanged((Button) v);
        return true;
    }
}
