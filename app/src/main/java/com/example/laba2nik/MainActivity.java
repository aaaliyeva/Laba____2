package com.example.laba2nik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar bar = findViewById(R.id.seekBar);
        EditText cost = findViewById(R.id.cost);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b)
                    cost.setText(String.valueOf(i));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        cost.addTextChangedListener(new TextWatcher() { //выставление смены позиции ползунка при изменении текста
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = cost.getText().toString();
                text = text.length()!=0?text:"0";

                bar.setProgress(Integer.parseInt(text));
            }
        });
    }
    public void calculate(View view){
        double allOil = Double.parseDouble(((EditText)findViewById(R.id.all)).getText().toString());
        double way = Double.parseDouble(((EditText)findViewById(R.id.way)).getText().toString());
        double cost = Double.parseDouble(((EditText)findViewById(R.id.cost)).getText().toString());
        double oilPer100km = allOil/way*100;
        double costOfKm = cost*allOil/way;
        ((EditText)findViewById(R.id.perKm)).setText(String.format("%s", oilPer100km));
        ((EditText)findViewById(R.id.costPerKm)).setText(String.format("%s", costOfKm));

    }
}