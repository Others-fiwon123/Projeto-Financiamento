package com.example.atividadefinanciamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
    }

    public void checkButton(View view){
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Intent intent = null;

        switch(radioId) {
            case R.id.radioSimuladorResidencia:
                intent = new Intent(MainActivity.this, SimuladorResidencia.class);
                break;
            case R.id.radioVeiculos:
                intent = new Intent(MainActivity.this, Veiculos.class);
                break;
        }

        if (intent != null) {
            EditText editText;
            editText = findViewById(R.id.editText);

            intent.putExtra("nome", editText.getText().toString());
            startActivity(intent);
        }
    }
}
