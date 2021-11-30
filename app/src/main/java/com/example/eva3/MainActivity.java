package com.example.eva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void verLista(View view){
        Intent intent = new Intent(this, ListaAlimentosActivity.class);
        startActivity(intent);

    }

    public void nuevoAlimento(View view){
        Intent intent = new Intent(this, AgregarAlimentoActivity.class);
        startActivity(intent);

    }

    public void irRespaldo(View view){
        Intent intent = new Intent(this, MetodoRespaldoActivity.class);
        startActivity(intent);

    }

}