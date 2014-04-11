package com.muratyuksel.ogrenciler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class main extends Activity {

    Button buttonAra;
    Button buttonKaydet;
    EditText textAra;
    EditText textIsim;
    EditText textOgrenciNo;
    EditText textDogumTarihi;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    buttonAra = (Button) findViewById(R.id.buttonAra);
    buttonKaydet = (Button) findViewById(R.id.buttonKaydet);

    textAra = (EditText) findViewById(R.id.aramaText);
    textIsim = (EditText) findViewById(R.id.textIsim);
    textOgrenciNo = (EditText) findViewById(R.id.textOgrenciNo);
    textDogumTarihi = (EditText) findViewById(R.id.textDogumTarihi);

    buttonKaydet.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            //buttonKaydet.setText("selam");
        }
    });

    }
}
