package com.example.ferreteriaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etc, etn, ett, etd, etcodigopedido, etdescripcionpedido, etcantidadpedido, etcodigoproducto, etdescripcionproducto, etvalorproducto, etcodigofactura, etvalorfactura;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etc = (EditText) findViewById(R.id.etc);
        etn = (EditText) findViewById(R.id.etn);
        ett = (EditText) findViewById(R.id.ett);
        etd = (EditText) findViewById(R.id.etd);
        etcodigopedido = (EditText) findViewById(R.id.etcodigopedido);
        etdescripcionpedido = (EditText) findViewById(R.id.etdescripcionpedido);
        etcantidadpedido = (EditText) findViewById(R.id.etcantidadpedido);
        etcodigoproducto = (EditText) findViewById(R.id.etcodigoproducto);
        etdescripcionproducto = (EditText) findViewById(R.id.etdescripcionproducto);
        etvalorproducto = (EditText) findViewById(R.id.etvalorproducto);
        etcodigofactura = (EditText) findViewById(R.id.etcodigofactura);
        etvalorfactura = (EditText) findViewById(R.id.etvalorfactura);
    }

    public void registrar(View view) {
        AdminBD admin = new AdminBD(this, "BaseDatos", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        String cedula = etc.getText().toString();
        String nombre = etn.getText().toString();
        String telefono = ett.getText().toString();
        String direccion = etd.getText().toString();
        String codigopedido = etcodigopedido.getText().toString();
        String descripcionpedido = etdescripcionpedido.getText().toString();
        String cantidadpedido = etcantidadpedido.getText().toString();
        String codigoproducto = etcodigoproducto.getText().toString();
        String descripcionproducto = etdescripcionproducto.getText().toString();
        String valorproducto = etvalorproducto.getText().toString();
        String codigofactura = etcodigofactura.getText().toString();
        String valorfactura = etvalorfactura.getText().toString();

        if (!cedula.isEmpty() && !nombre.isEmpty() && !telefono.isEmpty() && !direccion.isEmpty() && !codigopedido.isEmpty() && !descripcionpedido.isEmpty() && !cantidadpedido.isEmpty() && !codigoproducto.isEmpty() && !descripcionproducto.isEmpty() && !valorproducto.isEmpty() && !codigofactura.isEmpty() && !valorfactura.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("cedula", cedula);
            registro.put("nombre", nombre);
            registro.put("telefono", telefono);
            registro.put("direccion", direccion);
            registro.put("codigopedido", codigopedido);
            registro.put("descripcionpedido", descripcionpedido);
            registro.put("cantidadpedido", cantidadpedido);
            registro.put("codigoproducto", codigoproducto);
            registro.put("descripcionproducto", descripcionproducto);
            registro.put("valorproducto", valorproducto);
            registro.put("codigofactura", valorproducto);
            registro.put("valorfactura", valorproducto);
            BaseDatos.insert("cliente", null, registro);
            BaseDatos.insert("pedido", null, registro);
            BaseDatos.insert("producto", null, registro);
            BaseDatos.insert("factura", null, registro);
            BaseDatos.close();
            etc.setText("");
            etn.setText("");
            ett.setText("");
            etd.setText("");
            etcodigopedido.setText("");
            etdescripcionpedido.setText("");
            etcantidadpedido.setText("");
            etcodigoproducto.setText("");
            etdescripcionproducto.setText("");
            etvalorproducto.setText("");
            etcodigofactura.setText("");
            etvalorfactura.setText("");
            Toast.makeText(this,"Registro almacenado exitosamente", Toast.LENGTH_LONG).show();
        }

        else{
            Toast.makeText(this,"Ingrese correctamente todos los datos", Toast.LENGTH_LONG).show();
        }

    }


    public void actualizar (View view){
        AdminBD admin = new AdminBD(this, "BaseDatos", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        String cedula = etc.getText().toString(); // Obtén el valor de la cédula a actualizar
        String nuevoNombre = etn.getText().toString(); // Obtén el nuevo valor del nombre
        String nuevoTelefono = ett.getText().toString(); // Obtén el nuevo valor del teléfono
        String nuevaDireccion = etd.getText().toString(); // Obtén el nuevo valor de la dirección
        String nuevoCodigoPedido =  etcodigopedido.getText().toString(); // Obtén el nuevo valor del codigo pedido
        String nuevoDescripcionPedido =  etdescripcionpedido.getText().toString(); // Obtén el nuevo descrpcion del pedido
        String nuevoCantidadPedido =  etcantidadpedido.getText().toString(); // Obtén el nuevo cantidad del pedido
        String nuevoCodigoProducto =  etcodigoproducto.getText().toString(); // Obtén el nuevo valor del codigo producto
        String nuevoDescripcionProducto =  etdescripcionproducto.getText().toString(); // Obtén el nuevo descrpcion del producto
        String nuevoValorProducto =  etvalorproducto.getText().toString(); // Obtén el nuevo valor del producto
        String nuevoCodigoFactura =  etcodigofactura.getText().toString(); // Obtén el nuevo valor del codigo factura
        String nuevoValorFactura =  etvalorfactura.getText().toString(); // Obtén el nuevo valor del factura

        if (!cedula.isEmpty() && !nuevoNombre.isEmpty() && !nuevoTelefono.isEmpty() && !nuevaDireccion.isEmpty() && !nuevoCodigoPedido.isEmpty() && !nuevoDescripcionPedido.isEmpty()  && !nuevoCantidadPedido.isEmpty() && !nuevoCodigoProducto.isEmpty() && !nuevoDescripcionProducto.isEmpty() && !nuevoValorProducto.isEmpty() && !nuevoCodigoFactura.isEmpty() && !nuevoValorFactura.isEmpty()) {
            ContentValues valores = new ContentValues();
            valores.put("nombre", nuevoNombre);
            valores.put("telefono", nuevoTelefono);
            valores.put("direccion", nuevaDireccion);
            valores.put("codigopedido", nuevoCodigoPedido);
            valores.put("descripcionpedido", nuevoDescripcionPedido);
            valores.put("cantidadpedido", nuevoDescripcionPedido);
            valores.put("codigoproducto", nuevoCodigoProducto);
            valores.put("Descripcionproducto", nuevoDescripcionProducto);
            valores.put("valorproducto", nuevoValorProducto);
            valores.put("codigofactura", nuevoCodigoFactura);
            valores.put("ValorFactura", nuevoValorFactura);

            int filasActualizadas = BaseDatos.update("cliente", valores, "cedula=?", new String[]{cedula});

            if (filasActualizadas > 0) {
                Toast.makeText(this, "Registro actualizado exitosamente", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "No se encontró el cliente con la cédula proporcionada", Toast.LENGTH_LONG).show();
            }

            BaseDatos.close();
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_LONG).show();
        }
    }


        public void consultar(View view) {
            AdminBD admin = new AdminBD(this, "BaseDatos", null, 1);
            SQLiteDatabase BasedeDatos = admin.getWritableDatabase();
            String cedula1 = etc.getText().toString();
            if (!cedula1.isEmpty()) {
                Cursor fila = BasedeDatos.rawQuery("select nombre, telefono, direccion, codigopedido, descripcionpedido, cantidadpedido, codigoproducto, descripcionproducto, valorproducto, codigofactura, valorfactura from cliente where cedula=" + cedula1, null);
                if (fila.moveToFirst()) {
                    etn.setText(fila.getString(0));
                    ett.setText(fila.getString(1));
                    etd.setText(fila.getString(2));
                    etcodigopedido.setText(fila.getString(3));
                    etdescripcionpedido.setText(fila.getString(4));
                    etcantidadpedido.setText(fila.getString(5));
                    etcodigoproducto.setText(fila.getString(6));
                    etdescripcionproducto.setText(fila.getString(7));
                    etvalorproducto.setText(fila.getString(8));
                    etcodigofactura.setText(fila.getString(9));
                    etvalorfactura.setText(fila.getString(10));
                    BasedeDatos.close();
                } else {
                    Toast.makeText(this, "No se encontró el cliente", Toast.LENGTH_LONG).show();
                }
            }

        }
}