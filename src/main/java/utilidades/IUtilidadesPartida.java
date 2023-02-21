package utilidades;

import modelos.Jugador;
import modelos.Partida;
import modelos.Personaje;

import java.util.List;

public interface IUtilidadesPartida {


    /**
     * Este método inicializa los datos de una partida
     *
     * @param partida
     * @param personajesDisponibles
     * @return
     */
     void inicializarPartida(Partida partida, List<Jugador> participantes, List<Personaje> personajesDisponibles);

    /**
     * Este método finaliza los datos de una partida
     *
     * @param partida
     * @param equipoVencedor
     */
    void finalizarPartida(Partida partida, Integer equipoVencedor);

}
