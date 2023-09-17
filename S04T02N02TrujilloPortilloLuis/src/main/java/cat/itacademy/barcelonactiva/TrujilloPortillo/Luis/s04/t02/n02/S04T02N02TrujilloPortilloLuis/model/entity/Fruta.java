package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n02.S04T02N02TrujilloPortilloLuis.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Fruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Fruta")
    private String nombre;
    @Column(name = "Kg")
    private int cantidadKilos;

}


