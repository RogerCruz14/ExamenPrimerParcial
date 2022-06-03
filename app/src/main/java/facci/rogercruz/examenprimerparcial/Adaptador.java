package facci.rogercruz.examenprimerparcial;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder>{

    List<Computador> listado;

    public Adaptador(List<Computador> listado) {
        this.listado = listado;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.elemento, null, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //aqui va toda la funcionalidad

        holder.id.setText(listado.get(position).getId().toString());
        holder.nombre.setText(listado.get(position).getNombre());
        holder.descripcion.setText(listado.get(position).getDescripcion());
        holder.precio.setText(listado.get(position).getPrecio());
        Picasso.get().load(listado.get(position).getFoto()).into(holder.foto);

        holder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Computador computador = Computador.findById(Computador.class, listado.get(position).getId());
                computador.delete();

                Log.e("test", "Se elimino el registro" + listado.get(position).getId());
            }
        });



        holder.editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Computador computador = Computador.findById(Computador.class, listado.get(position).getId());
                computador.setNombre(holder.nombre.getText().toString());
                computador.setDescripcion(holder.descripcion.getText().toString());
                computador.save();
                Log.e("test", listado.get(position).getNombre() + " "
                        + listado.get(position).getDescripcion()
                        + "Se cambio por" +
                        holder.nombre.getText().toString() + " "
                        + holder.descripcion.getText().toString());
            }
        });

    }

    @Override
    public int getItemCount() {
        return listado.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView foto;
        EditText id, nombre, descripcion, precio;
        Button eliminar, editar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foto = itemView.findViewById(R.id.foto);
            id = itemView.findViewById(R.id.id);
            nombre = itemView.findViewById(R.id.nombre);
            descripcion = itemView.findViewById(R.id.descripcion);
            precio = itemView.findViewById(R.id.precio);
            eliminar = itemView.findViewById(R.id.eliminar);
            editar = itemView.findViewById(R.id.editar);


        }
    }
}
