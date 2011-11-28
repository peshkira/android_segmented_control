package com.petpet.sc.listeners;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.Button;

import com.petpet.sc.widget.SegmentedControl;

public class SCHierarchyChangeListener implements OnHierarchyChangeListener {

    private SegmentedControl sc;

    private SCStateChangedListener stateListener;

    public SCHierarchyChangeListener(final SegmentedControl sc) {
        this.sc = sc;
        this.stateListener = new SCStateChangedListener(this.sc);
    }

    @Override
    public void onChildViewAdded(View parent, View child) {
        this.registerChangeListener(parent, child, true);
    }

    @Override
    public void onChildViewRemoved(View parent, View child) {
        this.registerChangeListener(parent, child, false);
    }

    private void registerChangeListener(View parent, View child, boolean register) {
        if (parent.getId() == this.sc.getId() && child instanceof Button) {

            final Button btn = (Button) child;

            if (register)
                btn.setOnClickListener(stateListener);
            else
                btn.setOnClickListener(null);
            
            this.sc.stateChanged(null);
        }
    }
}
