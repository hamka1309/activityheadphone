package com.t3h.customseekbar;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.TextView;

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
    int widthEqualizer;
    int heightEqualizer;
    int widthReverb;
    int heightReverb;
    private Toolbar toolbar;
    private View layouReverb;
    private View layouEqualizer;
    private TextView tvSetEqualiez;
    private TextView tvSetReverb;
    private String[] reverb = {"None", "Smallroom", "Mediumroom", "Largeroom", "Plate", "Mediumhall", "Largehall"};
    private String[] equalizer = {"Flat", "Bass Only", "Treble Only", "Rock", "Grunge", "Metal", "Dance"
            , "Country", "Jazz", "Speech", "Classical", "Blues", "Opera", "Swing", "Acoustic", "New Age"};

    private int[] imageIdEqualizer = {R.drawable.ic_bcm_ic_preset_flat, R.drawable.ic_bcm_ic_preset_bass, R.drawable.ic_bcm_ic_preset_treble, R.drawable.ic_bcm_ic_preset_rock
            , R.drawable.ic_bcm_ic_preset_grunge, R.drawable.ic_bcm_ic_preset_metal, R.drawable.ic_bcm_ic_preset_dance, R.drawable.ic_bcm_ic_preset_country
            , R.drawable.ic_bcm_ic_preset_jazz, R.drawable.ic_bcm_ic_preset_speech, R.drawable.ic_bcm_ic_preset_classical, R.drawable.ic_bcm_ic_preset_blue
            , R.drawable.ic_bcm_ic_preset_opera, R.drawable.ic_bcm_ic_preset_swing, R.drawable.ic_bcm_ic_preset_acoustic, R.drawable.ic_bcm_ic_preset_new_age};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.headphone_activity);
        toolbar = findViewById(R.id.toobal1);
        tvSetEqualiez = findViewById(R.id.tv_dialog_set_equalizer);
        tvSetReverb = findViewById(R.id.tv_dialog_set_reverb);
        tvSetEqualiez.setText(equalizer[0]);
        tvSetReverb.setText(reverb[0]);
        layouReverb = findViewById(R.id.layout_dialog_reverb);
        layouEqualizer = findViewById(R.id.layout_dialog_equalizer);
        layouReverb.setOnClickListener(this);
        layouEqualizer.setOnClickListener(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.profile_ic_arrow_left);

    }

    public void showDialogEqualizer(String[] animals, int[] imageIdArrr) {
        widthEqualizer = (int) (getResources().getDisplayMetrics().widthPixels * 0.90);
        heightEqualizer = (int) (getResources().getDisplayMetrics().heightPixels * 0.80);
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle1);

        List<Map<String, Object>> dialogItemList = new ArrayList<Map<String, Object>>();
        int listItemLen = animals.length;
        for (int i = 0; i < listItemLen; i++) {
            Map<String, Object> itemMap = new HashMap<String, Object>();
            itemMap.put(CUSTOM_ADAPTER_IMAGE, imageIdArrr[i]);
            itemMap.put(CUSTOM_ADAPTER_TEXT, animals[i]);
            dialogItemList.add(itemMap);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, dialogItemList,
                R.layout.item_dialog_equalizer,
                new String[]{CUSTOM_ADAPTER_IMAGE, CUSTOM_ADAPTER_TEXT},
                new int[]{R.id.ib_alertdialog_item_image_equalizer, R.id.tv_alertdialog_item_text_equalizer});

        builder.setAdapter(simpleAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int itemIndex) {
                tvSetEqualiez.setText(equalizer[itemIndex]);
            }
        });

        dialog = builder.create();
        dialog.show();
        dialog.getWindow().setLayout(widthEqualizer, heightEqualizer);
    }

    public void showDialogVerb(String[] animals) {
        widthReverb = (int) (getResources().getDisplayMetrics().widthPixels * 0.90);
        heightReverb = (int) (getResources().getDisplayMetrics().heightPixels * 0.50);

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle1);

        List<Map<String, String>> dialogItemList = new ArrayList<Map<String, String>>();
        int listItemLen = animals.length;
        for (int i = 0; i < listItemLen; i++) {
            Map<String, String> itemMap = new HashMap<String, String>();

            itemMap.put(CUSTOM_ADAPTER_TEXT, animals[i]);
            dialogItemList.add(itemMap);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, dialogItemList,
                R.layout.item_dialog_reverb,
                new String[]{CUSTOM_ADAPTER_TEXT},
                new int[]{R.id.tv_alertdialog_item_text_reverb});

        builder.setAdapter(simpleAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int itemIndex) {
                tvSetReverb.setText(reverb[itemIndex]);
            }
        });

        dialog = builder.create();
        dialog.show();
        dialog.getWindow().setLayout(widthReverb, heightReverb);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_dialog_reverb:
                showDialogVerb(reverb);
                break;
            case R.id.layout_dialog_equalizer:
                showDialogEqualizer(equalizer, imageIdEqualizer);
                break;
        }
    }
}
