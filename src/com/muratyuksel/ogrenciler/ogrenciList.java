package com.muratyuksel.ogrenciler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class ogrenciList extends Activity {

    final dbHandler db = dbHandler.getDb(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ogrencilist);

        final Button hepsiniSil = (Button) findViewById(R.id.buttonSil);
        final Button yenile = (Button) findViewById(R.id.buttonYenile);
        final ListView grid = (ListView) findViewById(R.id.gridView);

        reloadOgrencis();

        hepsiniSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.truncateOgrenci();
            }
        });
        yenile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reloadOgrencis();
            }
        });
    }

    @Override
    protected void onResume() {
        reloadOgrencis();
        super.onResume();
    }

    public void reloadOgrencis()
    {
        ArrayAdapter<Ogrenci> adapter = new ArrayAdapter<Ogrenci>(this,
                R.layout.ogrencilist, R.id.textView, db.getAllOgrencis());

        ListView grid = (ListView) findViewById(R.id.gridView);
        grid.setAdapter(adapter);

        Log.d("adapter", String.valueOf(adapter.isEmpty()));
    }
}