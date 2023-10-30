package com.example.ferreteriaapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminBD extends SQLiteOpenHelper {
    public AdminBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDatos) {
        BaseDatos.execSQL("create table cliente(cedula int primary key, nombre text, telefono int, direccion text)");
        BaseDatos.execSQL("create table pedido(codigopedido int primary key, descripcionpedido text, cantidadpedido int)");
        BaseDatos.execSQL("create table producto(codigoproducto int primary key, descripcionproducto text, valorproducto int)");
        BaseDatos.execSQL("create table factura(codigofactura int primary key, valorfactura int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase dB, int oldVersion, int newVersion) {

    }
}
