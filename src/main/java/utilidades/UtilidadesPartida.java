package utilidades;

import modelos.Jugador;
import modelos.Partida;
import modelos.Personaje;

import java.time.LocalDateTime;
import java.util.*;

public class UtilidadesPartida implements IUtilidadesPartida {


    @Override
    public void inicializarPartida(Partida partida, List<Jugador> participantes, List<Personaje> personajesDisponibles) {

        //Inicializa el mapa de elecciones de la partida, asignando a cada
        //jugador un personaje de entre los personajesDisponibles,
        //eligiendo preferentemente uno de entre sus favoritos y si no uno
        //aleatorio de los disponibles
        Map<Jugador,Personaje> elecciones = new HashMap<>();

        List<Personaje> personajesRestantes = new ArrayList<>(personajesDisponibles);

        for(Jugador jugador: participantes){

            Personaje personajeSeleccionado;
            List<Personaje> personajesFavoritos = new ArrayList<>(jugador.getPersonajes());
            personajesFavoritos.retainAll(personajesRestantes);

            if(!personajesFavoritos.isEmpty()){
                personajeSeleccionado = personajesFavoritos.get(0);
            }else{
                personajeSeleccionado = personajesRestantes.get(0);
            }

            personajesRestantes.remove(personajeSeleccionado);
            elecciones.put(jugador,personajeSeleccionado);
        }

        partida.setElecciones(elecciones);


        //Inicializa el mapa de jugadoresPorEquipo, asignando
        //aleatoriamente cada jugador a uno de los equipos, sabiendo que el
        //número de jugadores siempre es par y que siempre hay dos
        //equipos
        Map<Integer, Set<Jugador>> jugadoresPorEquipo = new HashMap<>();

        int tamanyoLista = participantes.size(); //8
        int numJugadoresPorEquipo = tamanyoLista/2; //4

        List<Jugador> jugadoresEquipo1 = new ArrayList<>(participantes.subList(0,numJugadoresPorEquipo-1)); //0-3
        List<Jugador> jugadoresEquipo2 = new ArrayList<>(participantes.subList(numJugadoresPorEquipo,tamanyoLista-1)); //4-7

        jugadoresPorEquipo.put(1, new HashSet<>(jugadoresEquipo1));
        jugadoresPorEquipo.put(2, new HashSet<>(jugadoresEquipo2));

        partida.setJugadoresPorEquipo(jugadoresPorEquipo);


        partida.setInicioPartida(LocalDateTime.now());




    }

    @Override
    public void finalizarPartida(Partida partida, Integer equipoVencedor) {

    }
}
