package com.muratyuksel.ogrenciler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class main extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button buttonAra = (Button) findViewById(R.id.buttonAra);
        final Button buttonKaydet = (Button) findViewById(R.id.buttonKaydet);

        final EditText textAra = (EditText) findViewById(R.id.aramaText);
        final EditText textIsim = (EditText) findViewById(R.id.textIsim);
        final EditText textOgrenciNo = (EditText) findViewById(R.id.textOgrenciNo);
        final EditText textDogumTarihi = (EditText) findViewById(R.id.textDogumTarihi);

        final dbHandler db = dbHandler.getDb(this);

        buttonKaydet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                db.addOgrenci(new Ogrenci(textIsim.getText().toString(), textOgrenciNo.getText().toString(), textDogumTarihi.getText().toString()));

                Context context = getApplicationContext();
                CharSequence text = textIsim.getText().toString() + " başarıyla eklendi.";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                textDogumTarihi.setText("");
                textIsim.setText("");
                textOgrenciNo.setText("");
            }
        });

        buttonAra.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(main.this,ogrenciList.class);
                startActivity(intent);
            }
        });

    }

}
