package com.petpet.segmented.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.petpet.segmented.R;
import com.petpet.segmented.listeners.SCHierarchyChangeListener;

public class SegmentedControl extends LinearLayout {

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
                btn.setBackgroundResource(R.drawable.filter_middle_selected);
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
                        btn.setBackgroundResource(R.drawable.filter_left_selected);
                    } else {
                        btn.setPressed(false);
                        btn.setBackgroundResource(R.drawable.filter_left_unselected);
                    }
                    
                } else if (i == count - 1) {
                    if (clicked) {
                        btn.setPressed(true);
                        btn.setBackgroundResource(R.drawable.filter_right_selected);
                    } else {
                        btn.setPressed(false);
                        btn.setBackgroundResource(R.drawable.filter_right_unselected);
                    }
                    
                } else {
                    if (clicked) {
                        btn.setPressed(true);
                        btn.setBackgroundResource(R.drawable.filter_middle_selected);
                    } else {
                        btn.setPressed(false);
                        btn.setBackgroundResource(R.drawable.filter_middle_unselected);
                    }
                }
            }
        }
    }
    
    private void init() {
        final SCHierarchyChangeListener hierarchyChangeListener = new SCHierarchyChangeListener(this);
        this.setOnHierarchyChangeListener(hierarchyChangeListener);
    }

}
