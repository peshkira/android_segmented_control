package com.petpet.sc.listeners;

import android.view.View;
import android.view.View.OnClickListener;

import com.petpet.sc.widget.SegmentedControl;

public class SCStateChangedListener implements OnClickListener {

    private SegmentedControl sc;
    
    public SCStateChangedListener(SegmentedControl sc) {
        this.sc = sc;
    }
    
    @Override
    public void onClick(View v) {
        this.sc.stateChanged(v);
    }
}
