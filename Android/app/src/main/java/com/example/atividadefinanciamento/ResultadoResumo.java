package com.example.atividadefinanciamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultadoResumo extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_resumo);

        Intent thisIntent= getIntent();
        Bundle bundle = thisIntent.getExtras();

        double valorTotal = bundle.getDouble("valorTotal");
        double valorParcela = bundle.getDouble("valorParcela");
        double valor = bundle.getDouble("valor");
        double entrada = bundle.getDouble("entrada");
        double parcelas = bundle.getDouble("parcelas");
        double renda = bundle.getDouble("renda");

        nome = bundle.getString("nome");
        ((TextView) findViewById(R.id.textViewNome)).setText(nome);


        ((EditText) findViewById(R.id.editTextValorTotal)).setText(String.format("%.2f", valorTotal));
        ((EditText) findViewById(R.id.editTextValorParcela)).setText(String.format("%.2f", valorParcela));
        ((EditText) findViewById(R.id.editTextValor)).setText(String.format("%.2f", valor));
        ((EditText) findViewById(R.id.editTextEntrada)).setText(String.format("%.2f", entrada));
        ((EditText) findViewById(R.id.editTextQtsParcelas)).setText(String.format("%.0f", parcelas));
        ((EditText) findViewById(R.id.editTextRenda)).setText(String.format("%.2f", renda));
    }
}
