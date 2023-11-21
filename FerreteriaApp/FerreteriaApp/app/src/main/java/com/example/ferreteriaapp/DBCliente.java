package com.example.ferreteriaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.google.android.material.badge.ExperimentalBadgeUtils;

public class DBCliente extends AdminBD{

    static Context context;
    public DBCliente(@Nullable Context context){
        super(context);
        this.context = context;
    }

    public static long InsertarCliente(int Cedula, String Nombre, String Telefono, String Direccion){
        long id = 0;

        AdminBD admindb = new AdminBD(context);
        SQLiteDatabase db = admindb.getReadableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put("Cedula", Cedula);
            values.put("Nombre", Nombre);
            values.put("Telefono", Telefono);
            values.put("Direccion", Direccion);

            id = db.insert(TABLE_CLIENTE, null, values);
        } catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public boolean EditarCliente(int Cedula, String Nombre, String Telefono, String Direccion){
        boolean correcto = false;

        AdminBD admindb = new AdminBD(context);
        SQLiteDatabase db = admindb.getReadableDatabase();

        try {
            db.execSQL("UPDATE " + TABLE_CLIENTE + "SET Cedula = '"+Cedula+"', Nombre  = '"+Nombre+"', Telefono = '"+Telefono+"', Direccion = '"+Telefono+"' WHERE Cedula = '"+Cedula+"'");
            correcto = true;
        } catch (Exception ex){
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }
        return correcto;

    }

    public static boolean EliminarCliente(int Cedula){
        boolean correcto = false;
        AdminBD admindb = new AdminBD(context);
        SQLiteDatabase db = admindb.getReadableDatabase();

        try {
            db.execSQL("DELETE FROM " + TABLE_CLIENTE + " WHERE Cedula = '"+Cedula+"'");
            correcto = true;
        } catch (Exception ex){
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }
        return correcto;
    }
}
