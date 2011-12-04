package com.petpet.sc.listeners;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.Button;

import com.petpet.sc.widget.SegmentedControl;

public class SCHierarchyChangeListener implements OnHierarchyChangeListener {

    private SegmentedControl sc;

    private SCTouchListener stateListener;

    public SCHierarchyChangeListener(final SegmentedControl sc) {
        this.sc = sc;
        this.stateListener = new SCTouchListener(this.sc);
    }

    @Override
    public void onChildViewAdded(View parent, View child) {
        this.register(parent, child, true);
    }

    @Override
    public void onChildViewRemoved(View parent, View child) {
        this.register(parent, child, false);
    }

    private void register(View parent, View child, boolean register) {
        if (parent.getId() == this.sc.getId() && child instanceof Button) {

            final Button btn = (Button) child;
            if (register)
                btn.setOnTouchListener(stateListener);
            else
                btn.setOnTouchListener(null);

            addBtnState();
            trimText(btn);
            this.sc.stateChanged(null);
        }
    }

    private void trimText(Button btn) {
        String label = btn.getText().toString();
        int maxLength = this.sc.getMaxLength();
        if (label.length() > maxLength) {
            label = label.substring(0, maxLength - 3);
            label += "...";
            btn.setText(label);
        }
    }

    private void addBtnState() {
        int count = this.sc.getChildCount();

        if (count == 0) {
            return;
        }

        if (count == 1) {
            View v = this.sc.getChildAt(0);
            if (v instanceof Button) {
                ((Button) v).setBackgroundResource(this.sc.getMiddleState());
            }
        }

        for (int i = 0; i < count; i++) {
            View v = this.sc.getChildAt(i);

            if (v instanceof Button) {
                if (i == 0) {
                    ((Button) v).setBackgroundResource(this.sc.getLeftState());

                } else if (i == count - 1) {
                    ((Button) v).setBackgroundResource(this.sc.getRightState());

                } else {
                    ((Button) v).setBackgroundResource(this.sc.getMiddleState());
                }
            }
        }
    }
}
