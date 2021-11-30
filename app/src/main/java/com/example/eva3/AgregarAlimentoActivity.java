package com.example.eva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eva3.modelo.DBalimentos;

public class AgregarAlimentoActivity extends AppCompatActivity {

    private EditText etnombre, etenergia, etproteina, etcarbohidratos, etgrasas, etsodio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_alimento);

        etnombre = (EditText) findViewById(R.id.editTextNombre);
        etenergia = (EditText) findViewById(R.id.editTextEnergia);
        etproteina = (EditText) findViewById(R.id.editTextProteina);
        etcarbohidratos = (EditText) findViewById(R.id.editTextCarbohidratos);
        etgrasas = (EditText) findViewById(R.id.editTextGrasas);
        etsodio = (EditText) findViewById(R.id.editTextSodio);
    }

    public void agregarAlimento(View view){

        DBalimentos dBalimentos = new DBalimentos(this,"administracion", null, 1);
        SQLiteDatabase BaseDeDatos = dBalimentos.getWritableDatabase();

        String nombre = etnombre.getText().toString();
        String Senergia = etnombre.getText().toString();
        String Sproteina = etnombre.getText().toString();
        String Scarbohidrato = etnombre.getText().toString();
        String Sgrasas = etnombre.getText().toString();
        String Ssodio = etnombre.getText().toString();

        if(nombre.isEmpty() || Senergia.isEmpty() || Sproteina.isEmpty() || Scarbohidrato.isEmpty() || Sgrasas.isEmpty() || Ssodio.isEmpty()){
            Toast.makeText(this,"Debes rellenar todos los campos.", Toast.LENGTH_LONG).show();
        }

        else {
            int energia = Integer.parseInt(etenergia.getText().toString());
            int proteina = Integer.parseInt(etproteina.getText().toString());
            int carbohodratos = Integer.parseInt(etcarbohidratos.getText().toString());
            int grasas = Integer.parseInt(etgrasas.getText().toString());
            int sodio = Integer.parseInt(etsodio.getText().toString());

            if(energia < 0 || proteina < 0 || carbohodratos < 0 || grasas < 0 || sodio < 0){
                Toast.makeText(this,"No se aceptan valores negativo, arregle el error.", Toast.LENGTH_LONG).show();
            }

            else{
                ContentValues agregar = new ContentValues();

                agregar.put("nombre", nombre);
                agregar.put("energia", energia);
                agregar.put("proteina", proteina);
                agregar.put("carbohidratos", carbohodratos);
                agregar.put("grasas", grasas);
                agregar.put("sodio", sodio);

                BaseDeDatos.insert("Alimentos",null,agregar);
                BaseDeDatos.close();

                etnombre.setText("");
                etenergia.setText("");
                etproteina.setText("");
                etcarbohidratos.setText("");
                etgrasas.setText("");
                etsodio.setText("");

                Toast.makeText(this,"Se ha agregado un nuevo alimento.", Toast.LENGTH_LONG).show();
            }
        }

    }
}