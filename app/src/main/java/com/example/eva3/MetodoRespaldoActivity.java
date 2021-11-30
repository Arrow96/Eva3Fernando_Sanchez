package com.example.eva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eva3.modelo.Alimentos;
import com.example.eva3.modelo.DBalimentos;

public class MetodoRespaldoActivity extends AppCompatActivity {

    private EditText etid, etnombre, etenergia, etproteina, etcarbohidratos, etgrasas, etsodio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodo_respaldo);

        etid = (EditText) findViewById(R.id.editTextId);
        etnombre = (EditText) findViewById(R.id.editTextNombre);
        etenergia = (EditText) findViewById(R.id.editTextEnergia);
        etproteina = (EditText) findViewById(R.id.editTextProteina);
        etcarbohidratos = (EditText) findViewById(R.id.editTextCarbohidratos);
        etgrasas = (EditText) findViewById(R.id.editTextGrasas);
        etsodio = (EditText) findViewById(R.id.editTextSodio);

    }


    public void mostrarAlimento(View view){
        DBalimentos dBalimentos = new DBalimentos(this,"administracion", null, 1);
        SQLiteDatabase BaseDeDatos = dBalimentos.getWritableDatabase();

        String id = etid.getText().toString();

        if (!id.isEmpty()){

            try {
                Cursor fila = BaseDeDatos.rawQuery
                        ("select nombre, energia, proteina, carbohidratos, grasas, sodio from Alimentos where id ="+ id , null);

                if (fila.moveToFirst()){
                    etnombre.setText(fila.getString(0));
                    etenergia.setText(fila.getString(1));
                    etproteina.setText(fila.getString(2));
                    etcarbohidratos.setText(fila.getString(3));
                    etgrasas.setText(fila.getString(4));
                    etsodio.setText(fila.getString(5));

                    BaseDeDatos.close();
                }
                else{
                    Toast.makeText(this,"El elemento no existe.", Toast.LENGTH_LONG).show();
                    BaseDeDatos.close();
                }

            }catch (SQLException ex){
                Toast.makeText(this, ex.toString(), Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this,"Debes rellenar todos los campos.", Toast.LENGTH_LONG).show();

        }
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

    public void modificarAlimento(View view) {
        DBalimentos dBalimentos = new DBalimentos(this,"administracion", null, 1);
        SQLiteDatabase BaseDeDatos = dBalimentos.getWritableDatabase();

        String id = etid.getText().toString();
        String nombre = etnombre.getText().toString();
        String Senergia = etnombre.getText().toString();
        String Sproteina = etnombre.getText().toString();
        String Scarbohidrato = etnombre.getText().toString();
        String Sgrasas = etnombre.getText().toString();
        String Ssodio = etnombre.getText().toString();

        if (nombre.isEmpty() || Senergia.isEmpty() || Sproteina.isEmpty() || Scarbohidrato.isEmpty() || Sgrasas.isEmpty() || Ssodio.isEmpty()) {
            Toast.makeText(this, "Debes rellenar todos los campos.", Toast.LENGTH_LONG).show();
        } else {
            int energia = Integer.parseInt(etenergia.getText().toString());
            int proteina = Integer.parseInt(etproteina.getText().toString());
            int carbohodratos = Integer.parseInt(etcarbohidratos.getText().toString());
            int grasas = Integer.parseInt(etgrasas.getText().toString());
            int sodio = Integer.parseInt(etsodio.getText().toString());

            if (energia < 0 || proteina < 0 || carbohodratos < 0 || grasas < 0 || sodio < 0) {
                Toast.makeText(this, "No se aceptan valores negativo, arregle el error.", Toast.LENGTH_LONG).show();
            } else {
                ContentValues agregar = new ContentValues();

                agregar.put("nombre", nombre);
                agregar.put("energia", energia);
                agregar.put("proteina", proteina);
                agregar.put("carbohidratos", carbohodratos);
                agregar.put("grasas", grasas);
                agregar.put("sodio", sodio);

                try {
                    BaseDeDatos.update("Alimentos", agregar,"id="+id,null);
                    BaseDeDatos.close();
                    Toast.makeText(this, "El registro del alimento se ha modificado exitosamente.", Toast.LENGTH_LONG).show();

                }catch (SQLException ex){
                    Toast.makeText(this, "Posibles Errores: 1)Id incorrecto. 2)EL elemento no existe. 3)Error al ingresasr a la base de datos.", Toast.LENGTH_LONG).show();
                    BaseDeDatos.close();
                }
            }
        }
    }

    public void eliminarAlimento(View view){

        DBalimentos dBalimentos = new DBalimentos(this,"administracion", null, 1);
        SQLiteDatabase BaseDeDatos = dBalimentos.getWritableDatabase();

        String id = etid.getText().toString();

        try {
            BaseDeDatos.delete("Alimentos","id="+id,null);
            BaseDeDatos.close();

            etid.setText("");
            etnombre.setText("");
            etenergia.setText("");
            etproteina.setText("");
            etcarbohidratos.setText("");
            etgrasas.setText("");
            etsodio.setText("");
            Toast.makeText(this, "Se ha eliminado todo registro sobre del alimento.", Toast.LENGTH_LONG).show();

        }catch (SQLException ex){
            Toast.makeText(this, "Posibles Errores: 1)Id incorrecto. 2)EL elemento no existe. 3)Error al ingresasr a la base de datos.", Toast.LENGTH_LONG).show();
            BaseDeDatos.close();
        }
    }
}