package com.t3h.customseekbar;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private final String CUSTOM_ADAPTER_IMAGE = "image";
    private final String CUSTOM_ADAPTER_TEXT = "text";
    AlertDialog dialog;
    // Each item text.
    String[] equalizer = {"Flat", "Bass Only", "Treble Only", "Rock", "Grunge", "Metal", "Dance", "Country", "Jazz", "Speech", "Classical", "Blues", "Opera", "Swing", "Acoustic", "New Age"};
    private Toolbar toolbar;
    private View layouReverb;
    private View layouEqualizer;
    private int[] imageIdArr = {R.drawable.ic_bcm_ic_preset_flat, R.drawable.ic_bcm_ic_preset_bass, R.drawable.ic_bcm_ic_preset_treble, R.drawable.ic_bcm_ic_preset_rock
            , R.drawable.ic_bcm_ic_preset_grunge, R.drawable.ic_bcm_ic_preset_metal, R.drawable.ic_bcm_ic_preset_dance, R.drawable.ic_bcm_ic_preset_country, R.drawable.ic_bcm_ic_preset_jazz
            , R.drawable.ic_bcm_ic_preset_speech, R.drawable.ic_bcm_ic_preset_classical, R.drawable.ic_bcm_ic_preset_blue, R.drawable.ic_bcm_ic_preset_opera, R.drawable.ic_bcm_ic_preset_swing, R.drawable.ic_bcm_ic_preset_acoustic
            , R.drawable.ic_bcm_ic_preset_new_age};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.headphone_activity);
        toolbar = findViewById(R.id.toobal1);
        layouReverb = findViewById(R.id.layout_reverb);
        layouEqualizer = findViewById(R.id.layout_equalizer);
        layouReverb.setOnClickListener(this);
        layouEqualizer.setOnClickListener(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.profile_ic_arrow_left);

    }

    public void showDialogReverb() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        String[] animals = {"None", "Smallroom", "Mediumroom", "Largeroom", "Plate", "Mediumhall", "Largehall"};
        builder.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:// horse
                    case 1: // cow
                    case 2: // camel
                    case 3: // sheep
                    case 4: // goat
                }
            }
        });

        AlertDialog dialog = builder.create();

        dialog.show();
    }

    public void showDialogEqualizer() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle1);

        List<Map<String, Object>> dialogItemList = new ArrayList<Map<String, Object>>();
        int listItemLen = equalizer.length;
        for (int i = 0; i < listItemLen; i++) {
            Map<String, Object> itemMap = new HashMap<String, Object>();
            itemMap.put(CUSTOM_ADAPTER_IMAGE, imageIdArr[i]);
            itemMap.put(CUSTOM_ADAPTER_TEXT, equalizer[i]);
            dialogItemList.add(itemMap);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, dialogItemList,
                R.layout.item_equalizer,
                new String[]{CUSTOM_ADAPTER_IMAGE, CUSTOM_ADAPTER_TEXT},
                new int[]{R.id.alertDialogItemImageView, R.id.alertDialogItemTextView});

        builder.setAdapter(simpleAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int itemIndex) {

            }
        });
        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.90);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.80);
        dialog = builder.create();
        dialog.show();
        dialog.getWindow().setLayout(width, height);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_reverb:
                showDialogReverb();
                break;
            case R.id.layout_equalizer:
                showDialogEqualizer();
                break;
        }
    }
}
