package facci.rogercruz.examenprimerparcial;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class Secundaria extends AppCompatActivity {

    RecyclerView listado;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        listado = findViewById(R.id.listado);

        //coleccion de datos
        List<Computador> computadors = Computador.listAll(Computador.class);
        computadors.forEach((item)-> Log.e("test",item.getNombre()));

        //layout
        listado.setLayoutManager(new LinearLayoutManager( this));

        //adaptador
        Adaptador adaptador = new Adaptador(computadors);
        listado.setAdapter(adaptador);

    }
}