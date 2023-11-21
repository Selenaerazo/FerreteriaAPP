package com.example.ferreteriaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


public class insertCliente extends AppCompatActivity {

    EditText editTextCedula,editTextNombre,editTextTelefono,editTextDireccion;
    Button btnGurdarCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_cliente);

        editTextCedula = findViewById(R.id.editTextCedula);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextDireccion = findViewById(R.id.editTextDireccion);
        btnGurdarCliente = findViewById(R.id.btnGurdarCliente);

        btnGurdarCliente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DBCliente dbCliente = new DBCliente(insertCliente.this);
                long id = DBCliente.InsertarCliente(Integer.parseInt(editTextCedula.getText().toString()),
                        editTextNombre.getText().toString(),editTextTelefono.getText().toString(),
                        editTextDireccion.getText().toString());

                if (id > 0) {
                    Toast.makeText(insertCliente.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(insertCliente.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();

                }

            }
        });
    }

    private void limpiar(){
        editTextCedula.setText("");
        editTextNombre.setText("");
        editTextTelefono.setText("");
        editTextDireccion.setText("");
    }
}