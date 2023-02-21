package modelos;

import lombok.*;

import java.util.Map;
import java.util.Set;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Jugador {
    private int id;
    private String nickname;
    private Set<Personaje> personajes;
    private Map<Personaje,Integer> partidasGanadas;
}
