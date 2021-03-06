package facci.rogercruz.examenprimerparcial;

import com.orm.SugarRecord;

public class Computador extends SugarRecord<Computador> {

    String nombre;
    String descripcion;
    String precio;
    String foto;

    public Computador() {
    }

    public Computador(String nombre, String descripcion, String precio, String foto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
