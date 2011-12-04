package com.petpet.sc.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.petpet.sc.R;
import com.petpet.sc.listeners.SCHierarchyChangeListener;

public class SegmentedControl extends LinearLayout {
    
    private static final int MAX_LENGTH = 10; 

    private int leftState;

    private int middleState;

    private int rightState;
    
    private int maxLength;
    
    private boolean firstSelected;
    
    public SegmentedControl(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initAttributes(context, attrs);
        this.initState();
    }

    public void stateChanged(Button pressed) {
        int count = this.getChildCount();

        if (count > 0 && pressed == null) {
            View child = this.getChildAt(0);
            if (child instanceof Button && isFirstSelected()) {
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
    
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setFirstSelected(boolean firstSelected) {
        this.firstSelected = firstSelected;
    }

    public boolean isFirstSelected() {
        return firstSelected;
    }

    private void initAttributes(Context context, AttributeSet attrs) {
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SegmentedControl);
        setFirstSelected(a.getBoolean(R.styleable.SegmentedControl_first_selected, true));
        setMaxLength(a.getInt(R.styleable.SegmentedControl_label_maxlength, MAX_LENGTH));   
    }

    private void initState() {
        final SCHierarchyChangeListener hierarchyChangeListener = new SCHierarchyChangeListener(this);
        this.setOnHierarchyChangeListener(hierarchyChangeListener);

        this.setLeftState(R.drawable.sc_state_left);
        this.setMiddleState(R.drawable.sc_state_middle);
        this.setRightState(R.drawable.sc_state_right);
    }
}
