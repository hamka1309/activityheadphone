package com.t3h.customseekbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EqualizerActivity extends AppCompatActivity {
private RecyclerView lvEqualizer;
private EqualizerAdapter adapter;
private List<Equalizer> equalizers;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equalizer);

        lvEqualizer = findViewById(R.id.layout_equalizer);
        adapter = new EqualizerAdapter(this);
        getData();
        lvEqualizer.setAdapter(adapter);

    }

    private void getData() {
        equalizers= new ArrayList<>();
        equalizers.add(new Equalizer("E","ha"));
        equalizers.add(new Equalizer("E","ha1"));
        equalizers.add(new Equalizer("E","ha2"));
        equalizers.add(new Equalizer("E","ha3"));
        adapter.setData(equalizers);
    }
}
