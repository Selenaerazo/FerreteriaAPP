package com.example.ferreteriaapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnListarClientes;
    private RecyclerView recyclerViewClientes;
    private ClienteAdapter clienteAdapter;
    private List<Cliente> listaClientes;

 
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewClientes = findViewById(R.id.recyclerViewClientes);
        List<Cliente> listaClientes = obtenerListaClientes();
        recyclerViewClientes.setLayoutManager(new LinearLayoutManager(this));
        clienteAdapter = new ClienteAdapter(listaClientes);
        recyclerViewClientes.setAdapter(clienteAdapter);

        btnListarClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Cliente> listaClientes = obtenerListaClientes();
                clienteAdapter.setListaClientes(listaClientes);
                clienteAdapter.notifyDataSetChanged();
            }
        });
    }

    private List<Cliente> obtenerListaClientes() {

        DBCliente dbCliente = new DBCliente(MainActivity.this);
        return dbCliente.listarClientes();

    }









}