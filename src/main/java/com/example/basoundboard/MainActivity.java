package com.example.basoundboard;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fm;
    private NoScrollPager pager;
    private Typeface futura;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        futura = ResourcesCompat.getFont(this, R.font.futura_medium_bt);
        pager = (NoScrollPager)findViewById(R.id.pager);
        setupPager(pager);
    }

    // Attaches our adapter to the viewpager on the main activity
    /* TODO: disable sliding forward */
    private void setupPager(NoScrollPager pager) {
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        adapter.addFragment(new MainFragment());
        adapter.addFragment(new BAFoodEditorFragment.BradFragment());
        adapter.addFragment(new BAFoodEditorFragment.ClaireFragment());
        pager.setAdapter(adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void goToEditorSB(int iEditor) {
        pager.setCurrentItem(iEditor, false);
    }

    public void playSoundByte(int audioId) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, audioId);
        mediaPlayer.start();
    }

    @Override
    public void onBackPressed() {
        pager.setCurrentItem(0, false);
    }

    public Typeface getFutura() {
        return futura;
    }

}
