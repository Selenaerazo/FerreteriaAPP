package com.example.ferreteriaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class editar_Cliente extends AppCompatActivity {

    EditText editTextCedula,editTextNombre,editTextTelefono,editTextDireccion;
    Button btnGurdarCliente;
    FloatingActionButton fabEliminarCliente;

    boolean correcto = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_cliente);

        editTextCedula = findViewById(R.id.editTextCedula);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextDireccion = findViewById(R.id.editTextDireccion);
        btnGurdarCliente = findViewById(R.id.btnGurdarCliente);
        fabEliminarCliente = findViewById(R.id.fabEliminarCliente);

        DBCliente dbCliente = new DBCliente(editar_Cliente.this);
        boolean correcto = dbCliente.EditarCliente(Integer.parseInt(editTextCedula.getText().toString()),
                editTextNombre.getText().toString(), editTextTelefono.getText().toString(),
                editTextDireccion.getText().toString());

        fabEliminarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(editar_Cliente.this);
                builder.setMessage("¿Desea eliminar este cliente?")
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int Cedula) {
                                if(DBCliente.EliminarCliente(Cedula)){
                                    builder.setMessage("El cliente ha sido eliminado");
                                }

                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int Cedula) {

                            }
                        }).show();


            }
        });



    }



}