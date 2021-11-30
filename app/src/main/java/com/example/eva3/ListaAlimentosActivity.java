package com.example.eva3;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.eva3.modelo.Alimentos;
import com.example.eva3.modelo.DBalimentos;

import java.util.ArrayList;
import java.util.List;


public class ListaAlimentosActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Unir lista a un Array
        ListView ListaAlimentos = getListView();
        ArrayAdapter<Alimentos> listaAdapter = new ArrayAdapter<Alimentos>(this, android.R.layout.simple_list_item_1, listaAlimentos());
        ListaAlimentos.setAdapter(listaAdapter);

        //Crear un onItemClickListener

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(ListaAlimentosActivity.this, ModificarAlimentoActivity.class);
                String id_Alimento = (String) ListaAlimentos.getItemAtPosition(position);
                intent.putExtra("idAlimento", id);
                startActivityForResult(intent,1);
            }
        };

        //Agregar el Listener al ListView
        /*
        ListView listView = (ListView) findViewById(R.id.LA);
        listView.setOnItemClickListener(itemClickListener); */
    }

    public List<Alimentos> listaAlimentos(){
        DBalimentos dBalimentos = new DBalimentos(this,"administracion", null, 1);
        SQLiteDatabase BaseDeDatos = dBalimentos.getReadableDatabase();
        List<Alimentos> alimentos = new ArrayList<>();
        Cursor cursor = BaseDeDatos.query("Alimentos",
                new String[]{"id", "nombre"},
                null,null, null,null,null);
        cursor.moveToFirst();

        do{
            alimentos.add(new Alimentos(cursor.getInt(0),
                    cursor.getString(1)));
        }
        while(cursor.moveToNext());
        cursor.close();
        BaseDeDatos.close();
        return alimentos;
    }

}