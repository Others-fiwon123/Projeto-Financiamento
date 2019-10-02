package com.example.atividadefinanciamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Sobre extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        Intent thisIntent= getIntent();
        nome = thisIntent.getStringExtra("nome");
    }
}
