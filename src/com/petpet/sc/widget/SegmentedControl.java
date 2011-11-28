package com.petpet.sc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.petpet.sc.R;
import com.petpet.sc.listeners.SCHierarchyChangeListener;

public class SegmentedControl extends LinearLayout {

    private int leftState;

    private int middleState;

    private int rightState;

    public SegmentedControl(Context context) {
        super(context);
        this.init();
    }

    public SegmentedControl(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public void stateChanged(Button pressed) {
        int count = this.getChildCount();

        if (count > 0 && pressed == null) {
            View child = this.getChildAt(0);
            if (child instanceof Button) {
                ((Button) child).setPressed(true);
            }
            
            return;
        }
        
        for (int i = 0; i < count; i++) {
            View child = this.getChildAt(i);

            if (child instanceof Button) {
                Button btn = (Button) child;
                boolean clicked = (pressed.getId() == btn.getId()) ? true : false;

                if (clicked) {
                    btn.setPressed(true);
                } else {
                    btn.setPressed(false);
                }
            }
        }
    }

    public void setLeftState(int leftState) {
        this.leftState = leftState;
    }

    public int getLeftState() {
        return leftState;
    }

    public void setMiddleState(int middleState) {
        this.middleState = middleState;
    }

    public int getMiddleState() {
        return middleState;
    }

    public void setRightState(int rightState) {
        this.rightState = rightState;
    }

    public int getRightState() {
        return rightState;
    }

    private void init() {
        final SCHierarchyChangeListener hierarchyChangeListener = new SCHierarchyChangeListener(this);
        this.setOnHierarchyChangeListener(hierarchyChangeListener);

        this.setLeftState(R.drawable.sc_state_left);
        this.setMiddleState(R.drawable.sc_state_middle);
        this.setRightState(R.drawable.sc_state_right);
    }
}
