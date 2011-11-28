package com.petpet.sc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.petpet.sc.R;
import com.petpet.sc.listeners.SCHierarchyChangeListener;

public class SegmentedControl extends LinearLayout {
    
    private int leftSelected;
    
    private int middleSelected;

    private int rightSelected;
    
    private int leftNotSelected;
    
    private int middleNotSelected;
    
    private int rightNotSelected;

    public SegmentedControl(Context context) {
        super(context);
        this.init();
    }

    public SegmentedControl(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }
    
    public void stateChanged(View pressed) {
        int count = this.getChildCount();
        
        if (count == 0) {
            return;
        }
        
        if (count == 1) {
            View child = this.getChildAt(0);
            if (child instanceof Button) {
                Button btn = (Button) child;
                btn.setPressed(true);
                btn.setBackgroundResource(getMiddleSelected());
            }
            
            return;
        }
        
        //auto select 0 if a button gets removed
        if (pressed == null) {
            pressed = this.getChildAt(0);
        }
        
        for (int i = 0; i < count; i++) {
            View child = this.getChildAt(i);
            
            if (child instanceof Button) {
                Button btn = (Button) child;
                boolean clicked = (pressed.getId() == btn.getId()) ? true : false;
                
                if (i == 0) {
                    if (clicked) {
                        btn.setPressed(true);
                        btn.setBackgroundResource(getLeftSelected());
                    } else {
                        btn.setPressed(false);
                        btn.setBackgroundResource(getLeftNotSelected());
                    }
                    
                } else if (i == count - 1) {
                    if (clicked) {
                        btn.setPressed(true);
                        btn.setBackgroundResource(getRightSelected());
                    } else {
                        btn.setPressed(false);
                        btn.setBackgroundResource(getRightNotSelected());
                    }
                    
                } else {
                    if (clicked) {
                        btn.setPressed(true);
                        btn.setBackgroundResource(getMiddleSelected());
                    } else {
                        btn.setPressed(false);
                        btn.setBackgroundResource(getMiddleNotSelected());
                    }
                }
            }
        }
    }

    public void setLeftSelected(int leftSelected) {
        this.leftSelected = leftSelected;
    }

    public int getLeftSelected() {
        return leftSelected;
    }

    public void setMiddleSelected(int middleSelected) {
        this.middleSelected = middleSelected;
    }

    public int getMiddleSelected() {
        return middleSelected;
    }

    public void setRightSelected(int rightSelected) {
        this.rightSelected = rightSelected;
    }

    public int getRightSelected() {
        return rightSelected;
    }

    public void setLeftNotSelected(int leftNotSelected) {
        this.leftNotSelected = leftNotSelected;
    }

    public int getLeftNotSelected() {
        return leftNotSelected;
    }

    public void setMiddleNotSelected(int middleNotSelected) {
        this.middleNotSelected = middleNotSelected;
    }

    public int getMiddleNotSelected() {
        return middleNotSelected;
    }

    public void setRightNotSelected(int rightNotSelected) {
        this.rightNotSelected = rightNotSelected;
    }

    public int getRightNotSelected() {
        return rightNotSelected;
    }
    
    private void init() {
        final SCHierarchyChangeListener hierarchyChangeListener = new SCHierarchyChangeListener(this);
        this.setOnHierarchyChangeListener(hierarchyChangeListener);
        
        this.setLeftSelected(R.drawable.sc_left_selected);
        this.setLeftNotSelected(R.drawable.sc_left_unselected);
        this.setMiddleSelected(R.drawable.sc_middle_selected);
        this.setMiddleNotSelected(R.drawable.sc_middle_unselected);
        this.setRightSelected(R.drawable.sc_right_selected);
        this.setRightNotSelected(R.drawable.sc_right_unselected);
    }
}
