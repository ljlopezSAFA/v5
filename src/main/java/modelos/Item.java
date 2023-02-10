package modelos;

import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {

    private int id;
    private String nombre;
    private Double aumentoDaño;
    private Double aumentoDefensa;
    private Double aumentoSalud;
    private Double aumentoMana;
}
