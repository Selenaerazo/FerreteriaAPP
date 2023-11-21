package com.example.ferreteriaapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ClienteViewHolder>  {

    private List<Cliente> clientes;

    public ClienteAdapter(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public ClienteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cliente, parent, false);
        return new ClienteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClienteViewHolder holder, int position) {
        Cliente cliente = clientes.get(position);
        holder.CedulaTextView.setText(cliente.getCedula());
        holder.NombreTextView.setText(cliente.getNombre());
        holder.TelefonoTextView.setText(cliente.getTelefono());
        holder.DireccionTextView.setText(cliente.getDireccion());
    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    public void setListaClientes(List<Cliente> nuevaListaClientes) {
        this.clientes = nuevaListaClientes;
        notifyDataSetChanged();
    }

    public class ClienteViewHolder extends RecyclerView.ViewHolder {
        TextView CedulaTextView;
        TextView NombreTextView;
        TextView TelefonoTextView;
        TextView DireccionTextView;

        public ClienteViewHolder(View itemView) {
            super(itemView);
            CedulaTextView = itemView.findViewById(R.id.textViewCedula);
            NombreTextView = itemView.findViewById(R.id.textViewNombre);
            TelefonoTextView = itemView.findViewById(R.id.textViewTelefono);
            DireccionTextView = itemView.findViewById(R.id.textViewDireccion);

        }

    }
}
