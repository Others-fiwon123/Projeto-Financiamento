package com.example.atividadefinanciamento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Veiculos extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculos);

        Intent thisIntent= getIntent();
        nome = thisIntent.getStringExtra("nome");
        ((TextView) findViewById(R.id.textName)).setText(nome);

        ((RadioButton) findViewById(R.id.radioNovo)).setChecked(true);
    }

    private double calcularValorDoTipoDoCarro(int radioId, double valor, double entrada){

        switch(radioId) {
            case R.id.radioNovo:
                return 0.01f*valor + 0.04f*valor + valor;
            case R.id.radioUsado:
                return valor;
        }

        return -1;
    }

    private double calcularJuros(double renda){

        if (renda >= 0 && renda <= 3500f){
            return 0.06f;
        }else if (renda >= 3501f && renda <= 5000f){
            return 0.05f;
        }else if (renda > 5000f) {
            return 0.04f;
        }

        return -1;
    }

    private void showResumoFinanciamento(double valorTotal, double valorParcela, double valor, double entrada, double qtsParcelas, double renda){
        Intent intent = intent = new Intent(Veiculos.this, ResultadoResumo.class);;
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        intent.putExtra("valorTotal", valorTotal);
        intent.putExtra("valorParcela", valorParcela);
        intent.putExtra("valor", valor);
        intent.putExtra("entrada", entrada);
        intent.putExtra("parcelas", qtsParcelas);
        intent.putExtra("renda", renda);
        intent.putExtra("nome", nome);

        startActivity(intent);
    }

    public void calcularFinanciamento(View view){
        RadioGroup group = findViewById(R.id.radioGroupOpcoes);
        int radioId = group.getCheckedRadioButtonId();

        try {
            double valor = Double.parseDouble(((EditText) findViewById(R.id.editTextValor)).getText().toString());
            double entrada = Double.parseDouble(((EditText) findViewById(R.id.editTextEntrada)).getText().toString());
            double qtsParcelas = Double.parseDouble(((EditText) findViewById(R.id.editTextQtsParcelas)).getText().toString());
            double renda = Double.parseDouble(((EditText) findViewById(R.id.editTextRenda)).getText().toString());

            if (entrada >= valor * 0.05) {

                double valorResult = calcularValorDoTipoDoCarro(radioId, valor, entrada);
                double juros = calcularJuros(renda);

                double coef = juros / (1 - Math.pow(1 / (1 + juros), qtsParcelas));
                double valorParcela = (valorResult - entrada) * coef;

                double valorTotal = valorParcela * qtsParcelas;

                if (valorParcela > 0.3f * renda) {

                    String texto = "Valor da parcela deve ser menor que 30% da renda líquida.";

                    Toast toast = Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    showResumoFinanciamento(valorTotal, valorParcela, valor, entrada, qtsParcelas, renda);
                }
            } else {
                String texto = "A entrada deve ser no mínimo 5% sobre o valor do Veículo.";

                Toast toast = Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT);
                toast.show();
            }
        }catch(Exception e){
            String texto = "Preencha todos os campos presentes.";

            Toast toast = Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
