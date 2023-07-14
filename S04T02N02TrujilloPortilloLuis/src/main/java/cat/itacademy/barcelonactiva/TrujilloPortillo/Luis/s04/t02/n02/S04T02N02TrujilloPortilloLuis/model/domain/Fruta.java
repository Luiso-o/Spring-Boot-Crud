package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n02.S04T02N02TrujilloPortilloLuis.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int cantidadKilos;

    public Fruta(){
    }

    public Fruta(String nombre, int cantidadKilos) {
        this.nombre = nombre;
        this.cantidadKilos = cantidadKilos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadKilos() {
        return cantidadKilos;
    }

    public void setCantidadKilos(int cantidadKilos) {
        this.cantidadKilos = cantidadKilos;
    }
}


