package com.example.atividadefinanciamento;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if (id == R.id.menuitem_inicio){
            Intent intent = intent = new Intent(this, MainActivity.class);;
            intent.putExtra("nome", nome);

            startActivity(intent);
        }else if (id == R.id.menuitem_sobre){
            Intent intent = intent = new Intent(this, Sobre.class);;
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            intent.putExtra("nome", nome);

            startActivity(intent);
        }else if (id == R.id.menuitem_veiculo){
            Intent intent = intent = new Intent(this, Veiculos.class);;
            intent.putExtra("nome", nome);

            startActivity(intent);
        }else if (id == R.id.menuitem_simular_residencia){
            Intent intent = intent = new Intent(this, SimuladorResidencia.class);;
            intent.putExtra("nome", nome);

            startActivity(intent);
        }else if (id == R.id.menuitem_sair){
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }
}
