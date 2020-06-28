package com.example.basoundboard;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public abstract class BAFoodEditorFragment extends Fragment {

    protected ArrayList<SoundButton> soundButtons;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        View view = layoutInflater.inflate(R.layout.food_editor_sb, container, false);
        soundButtons = new ArrayList<SoundButton>();
        setupSoundButtons();
        addSoundButtons(view);
        return view;
    }

    abstract protected void setupSoundButtons();

    private void addSoundButtons(View container) {
        LinearLayout outerLinear = container.findViewById(R.id.sound_buttons);
        LinearLayout currentRow = new LinearLayout(getContext());
        for (int i = 0; i < soundButtons.size(); i++) {
            if (i % 2 == 0) { // Create a new row
                if (i > 0)
                    outerLinear.addView(currentRow);
                currentRow = new LinearLayout(getContext());
                currentRow.setOrientation(LinearLayout.HORIZONTAL);
                currentRow.setWeightSum(2);
            }
            currentRow.addView(soundButtons.get(i));
        }
        if (currentRow.getChildCount() > 0)
            outerLinear.addView(currentRow);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void addButton(int rawId, String text) {
        soundButtons.add(new SoundButton(getContext(), getActivity(), rawId, text));
    }

    public static class BradFragment extends BAFoodEditorFragment {

        @RequiresApi(api = Build.VERSION_CODES.O)
        protected void setupSoundButtons() {
            addButton(R.raw.brad_botulism, "Botulism!?");
            addButton(R.raw.brad_english, "Brad's English");
            addButton(R.raw.brad_inappropriate, "In-*-appropriate");
            addButton(R.raw.brad_stop, "Stop");
        }

    }

    public static class ClaireFragment extends BAFoodEditorFragment {

        @RequiresApi(api = Build.VERSION_CODES.O)
        protected void setupSoundButtons() {
            addButton(R.raw.claire_day3, "Day Three Curse");
            addButton(R.raw.claire_i_dont_know,"I don't know...");
            addButton(R.raw.claire_oh_god, "Oh God");
            addButton(R.raw.claire_pathetic, "Pathetic");
            addButton(R.raw.claire_terrible, "Terrible");
            addButton(R.raw.claire_thanks_a_lot_brad, "Thanks, Brad");
            addButton(R.raw.claire_underestimated, "Underestimated");
        }
    }

}
