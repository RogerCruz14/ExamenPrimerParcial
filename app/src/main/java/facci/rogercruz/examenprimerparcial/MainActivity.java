package facci.rogercruz.examenprimerparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nombre, descripcion,precio, foto;
    Button guardar, listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.nombre);
        descripcion = findViewById(R.id.descripcion);
        precio = findViewById(R.id.precio);
        foto = findViewById(R.id.foto);

        guardar = findViewById(R.id.guardar);
        listar = findViewById(R.id.listar);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Computador computador = new Computador(nombre.getText().toString(),
                        descripcion.getText().toString(),
                        precio.getText().toString(),
                        foto.getText().toString()
                        );
                computador.save();
                Log.e( "test", "Se creo el registro" );


            }
        });

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Secundaria.class);
                startActivity(intent);
            }
        });
    }
}