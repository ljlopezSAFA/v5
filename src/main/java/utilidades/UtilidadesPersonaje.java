package utilidades;

import modelos.*;

import java.util.*;
import java.util.stream.Collectors;

public class UtilidadesPersonaje {


    public Personaje levelUp(Personaje personaje){

        personaje.setNivel(personaje.getNivel()+1);
        personaje.setVida(personaje.getVidaBase() + personaje.getEscalabilidad().getIncrementoSaludNivel() * personaje.getNivel());
        personaje.setMana(personaje.getManaBase() + personaje.getEscalabilidad().getIncrementoManaNivel() * personaje.getNivel());
        personaje.setDefensa(personaje.getDefensaBase() + personaje.getEscalabilidad().getIncrementoDefensaNivel() * personaje.getNivel());
        personaje.setAtaque(personaje.getAtaqueBase() + personaje.getEscalabilidad().getIncrementoDañoNivel() * personaje.getNivel());

        return personaje;
    }

    public void levelTo(Personaje personaje, Integer nivelDeseado){

        personaje.setNivel(nivelDeseado);
        personaje.setVida(personaje.getVidaBase() + personaje.getEscalabilidad().getIncrementoSaludNivel() *nivelDeseado);
        personaje.setMana(personaje.getManaBase() + personaje.getEscalabilidad().getIncrementoManaNivel() * nivelDeseado);
        personaje.setDefensa(personaje.getDefensaBase() + personaje.getEscalabilidad().getIncrementoDefensaNivel() * nivelDeseado);
        personaje.setAtaque(personaje.getAtaqueBase() + personaje.getEscalabilidad().getIncrementoDañoNivel() * nivelDeseado);
    }



    public Map<Region, List<Personaje>> getPersonajesPorRegion(List<Personaje> personajes){

        return personajes
                .stream()
                .collect(Collectors.groupingBy(Personaje::getRegion));

    }

    public Personaje getMasPoderosoStream(List<Personaje> personajes){

            //subir al 18
            personajes.forEach(p-> levelTo(p,18));

            //obtener el más poderoso
            return personajes.stream().max(Comparator.comparing(p-> p.getAtaque() + p.getDefensa() + p.getMana() + p.getVida())).orElse(null);

    }


    public Map<Region, List<Personaje>> getMasPoderosoPorRegionStream(List<Personaje> personajes){

        //Mapa de personajes por region
        Map<Region, List<Personaje>> personajesPorRegion = getPersonajesPorRegion(personajes);

        //Quitamos todos los que no son el más poderoso
        personajesPorRegion.keySet().forEach(region -> personajesPorRegion.get(region).retainAll(List.of(getMasPoderosoStream(personajesPorRegion.get(region)))));

        return personajesPorRegion;

    }

    public double sumaStats(Personaje personaje){
        return personaje.getAtaque() + personaje.getDefensa() + personaje.getVida() + personaje.getMana();
    }


    public Personaje getMasPoderos(List<Personaje> personajes){

        Personaje elMasPoderoso = null;

        for(Personaje personaje: personajes){

            //Subirlo al 18
            levelTo(personaje,18);

            //Sumar sus estadisticas y ver si la suma > suma(elMasPoderoso)
            double sumaStats = sumaStats(personaje);

            //Comparamos que la suma es mayor que la del mas poderoso
            if(elMasPoderoso == null || sumaStats > sumaStats(elMasPoderoso)){
                elMasPoderoso = personaje;
            }
        }

        return elMasPoderoso;

    }


    public Map<Region, List<Personaje>> getMasPoderosoPorRegion(List<Personaje> personajes){

        //Agrupar los personajes por region
        Map<Region, List<Personaje>> mapa = getPersonajesPorRegion(personajes);


        for(Region region: mapa.keySet()){

            List<Personaje> personajesDeMiRegion = mapa.get(region);

            Personaje elMasPoderosoRegion = getMasPoderos(personajesDeMiRegion);

            mapa.get(region).retainAll(List.of(elMasPoderosoRegion));

        }

        return mapa;

    }




}
