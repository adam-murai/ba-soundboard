package com.example.basoundboard;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        //Log.d("debug", "Am I even here?");
        View v = layoutInflater.inflate(R.layout.editor_list_fragment, container, false);
        /* TODO: Create fragments and BAButtons */
        //Log.d("debug", v.toString());
        TableLayout buttonGrid = v.findViewById(R.id.ba_buttons);
        TableRow row1 = new TableRow(getContext());
        // Brad
        BAButton bradButton = new BAButton((MainActivity)this.getContext(), 1, R.drawable.brad_icon);
        row1.addView(bradButton);
        BAButton claireButton = new BAButton((MainActivity)this.getContext(), 2, R.drawable.claire_icon);
        row1.addView(claireButton);
        buttonGrid.addView(row1);
        return v;
    }

}
