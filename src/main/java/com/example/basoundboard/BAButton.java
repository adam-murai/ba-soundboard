package com.example.basoundboard;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageButton;

import androidx.fragment.app.Fragment;

/* TODO: Decide whether an xml layout (in drawable) is necessary */

public class BAButton extends androidx.appcompat.widget.AppCompatImageButton {

    private int toFragment;

    // Default Constructor
    public BAButton (Context context) {
        super (context);
    }

    public BAButton (final MainActivity mA, final int toFragment, final int resId) {
        super ((Context)mA);
        this.toFragment = toFragment;
        this.setImageResource(resId);
        this.setBackgroundColor(Color.TRANSPARENT);
        this.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                mA.goToEditorSB(toFragment);
            }
        });
    }

    //public BAButton (Context context, Fragment toFragment)

//    public Fragment getToFragment() {
//        return toFragment;
//    }
}