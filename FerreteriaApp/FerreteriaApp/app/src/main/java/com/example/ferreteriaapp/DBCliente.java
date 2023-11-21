package com.example.ferreteriaapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.google.android.material.badge.ExperimentalBadgeUtils;

import java.util.ArrayList;
import java.util.List;

public class DBCliente extends AdminBD{

    static Context context;
    public DBCliente(@Nullable Context context){
        super(context);
        this.context = context;
    }

    public List<Cliente> listarClientes () {
        List<Cliente> clientes = new ArrayList<>();

        AdminBD admindb = new AdminBD(context);
        SQLiteDatabase db = admindb.getReadableDatabase();

        Cursor cursor = null;

        try {
            String[] columnas = {
                    "cedula",
                    "nombre",
                    "telefono",
                    "direccion"
            };

            cursor = db.query(
                    TABLE_CLIENTE,
                    columnas,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") int cedula = cursor.getInt(cursor.getColumnIndex("cedula"));
                    @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
                    @SuppressLint("Range") String telefono = cursor.getString(cursor.getColumnIndex("telefono"));
                    @SuppressLint("Range") String direccion = cursor.getString(cursor.getColumnIndex("direccion"));

                    Cliente cliente = new Cliente();
                    cliente.setCedula(cedula);
                    cliente.setNombre(nombre);
                    cliente.setTelefono(telefono);
                    cliente.setDireccion(direccion);

                    clientes.add(cliente);

                } while (cursor.moveToNext());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return clientes;
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
