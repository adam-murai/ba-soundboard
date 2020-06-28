package com.example.basoundboard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.res.ResourcesCompat;

// Idk if I need to make this class.  I might just have a building method in the custom fragment
class SoundButton extends AppCompatButton {

    private final int MARGIN_WIDTH = 12;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public SoundButton(Context context, final Activity activity, final int rawId, String text) {
        super(context);
        // Decide on styling
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)activity).playSoundByte(rawId);
            }
        });
        setText(text);
        setTypeface(((MainActivity)activity).getFutura());
        setTransformationMethod(null);
        setTextSize(20);
        setTextColor(Color.WHITE);
        setBackgroundResource(R.drawable.sound_button);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        layoutParams.setMargins(MARGIN_WIDTH, MARGIN_WIDTH, MARGIN_WIDTH, MARGIN_WIDTH);
        setLayoutParams(layoutParams);
        setWidth(0);
    }

}
