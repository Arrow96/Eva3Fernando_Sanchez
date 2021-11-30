package com.example.eva3.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBalimentos extends SQLiteOpenHelper {

    public DBalimentos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase dbAlimentos) {
        String sqlTxt ="CREATE TABLE Alimentos(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, energia REAL, proteina REAL, " +
                "carbohidratos REAL, grasas REAL, sodio REAL);";
        dbAlimentos.execSQL(sqlTxt);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*
    public Alimentos getAlimentos(String nombre){
        Alimentos a = null;
        SQLiteDatabase db = getReadableDatabase();
        String sqlText = "SELECT nombre, energia, proteina, carbohidratos, grasas, sodio FROM Alimentos WHERE nombre = ?";
        String[] argumento = new String[] {nombre};
        try {
            Cursor cursor = db.rawQuery(sqlText,argumento);
            cursor.moveToFirst();
        } catch (SQLException ex){
            a = null;
        }
        return a;
    }*/
}
