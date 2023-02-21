package modelos;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Partida {
    private int id;
    private String codigo;
    private Double server;
    private Map<Jugador,Personaje> elecciones;
    private Map<Integer, Set<Jugador>> jugadoresPorEquipo;
    private LocalDateTime inicioPartida;
    private LocalDateTime finPartida;
    private Integer duracionPartida;
    private Integer equipoVencedor;
}