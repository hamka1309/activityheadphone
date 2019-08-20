package com.t3h.customseekbar;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    String[] equalizer={"Flat","Bass Only","Treble Only","Rock","Grunge","Metal","Dance","Country","Jazz","Speech","Classical","Blues","Opera","Swing","Acoustic","New Age"};
    ListView listView;
    TextView textView;
    String[] listItem;
    private Dialog dialog;
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.headphone_activity);
//        toolbar = findViewById(R.id.toobal1);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.profile_ic_arrow_left);


        listView=(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.textView);
        listItem = getResources().getStringArray(R.array.array_technology);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);
    }
    public void showDialog() {
        dialog = new Dialog(MainActivity.this);
        dialog.setTitle("Thangcode.com");
        dialog.setContentView(R.layout.activity_main);
        dialog.show();
    }


}
