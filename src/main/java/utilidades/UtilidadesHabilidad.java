package utilidades;

import modelos.Habilidad;
import modelos.Item;
import modelos.Personaje;

public class UtilidadesHabilidad {

    public void golpearConHabilidad(Personaje emisor, Personaje receptor,
                                    Habilidad habilidadEmisor) {

        // En primer lugar hay que subir ambos personajes a nivel 18 con las stats actualizadas a dicho nivel.
          UtilidadesPersonaje.levelTo(emisor, 18);
          UtilidadesPersonaje.levelTo(receptor,18);

      //En segundo lugar hay que mirar si dichos personajes
        // llevan items y sumar los atributos proporcionados por el
        //item a sus stats
        // emisor.getEquipamiento().forEach(i-> UtilidadesItem.equiparItem(emisor,i,false));
        for(Item objeto: emisor.getEquipamiento()){
            UtilidadesItem.equiparItem(emisor,objeto,false);
        }

        for(Item objeto: receptor.getEquipamiento()){
            UtilidadesItem.equiparItem(receptor,objeto,false);
        }

        //Calcular potencia de habilidad
        //Daño de habilidad total = Daño Base + (0.2 *
        //DañoPersonajeEmisor) - (0.1 *
        //DefensaPersonajeReceptor)
        Double potenciaAtaque = habilidadEmisor.getDañoBase() + (0.2 * emisor.getAtaque()) -(receptor.getDefensa() * 0.1);


        //Receptor Vida - Daño
        receptor.setVida(receptor.getVida() - potenciaAtaque);

        //Emisor Mana - Coste Mana
        emisor.setMana( emisor.getMana() - habilidadEmisor.getCosteMana());








    }

}
