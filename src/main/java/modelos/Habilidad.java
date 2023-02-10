package modelos;

import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Habilidad {


    private int id;
    private String nombre;
    private Double dañoBase;
    private Double daño;
    private Double costeMana;
    private TipoHabilidad habilidad;



}
