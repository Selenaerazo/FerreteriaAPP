package com.example.ferreteriaapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminBD extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "Ferreteria.db";
    public static final String TABLE_CLIENTE = "t_cliente";
    public static final String TABLE_PEDIDO = "t_pedido";
    public static final String TABLE_PRODUCTO = "t_producto";
    public static final String TABLE_FACTURA = "t_factura";
    public AdminBD(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDatos) {
        BaseDatos.execSQL("CREATE TABLE " + TABLE_CLIENTE + "(" + " cedula int primary key," + "nombre text," + "telefono text,"+ "direccion text)");
        BaseDatos.execSQL("CREATE TABLE " + TABLE_PEDIDO + "(" + " pedidoid int primary key," + "descripcion text," + "fecha text,"+ "cantidad int)");
        BaseDatos.execSQL("CREATE TABLE " + TABLE_PRODUCTO + "(" + " productoid int primary key," + "descripcion text," + "valor int)");
        BaseDatos.execSQL("CREATE TABLE " + TABLE_FACTURA + "(" + " numeroFactura int primary key," + "fecha text," + "total int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
