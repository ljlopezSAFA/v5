package modelos;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Personaje {

    private int id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaCreacion;
    private Integer nivel;
    private Double vidaBase;
    private Double manaBase;
    private Double defensaBase;
    private Double ataqueBase;
    private Double defensa;
    private Double ataque;
    private Double vida;
    private Double mana;
    private Region region;
    private List<Habilidad> habilidades = new ArrayList<>();
    private List<Item> equipamiento = new ArrayList<>();
    private Escalabilidad escalabilidad;

}
