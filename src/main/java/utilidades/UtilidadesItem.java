package utilidades;

import modelos.Item;
import modelos.Personaje;

public class UtilidadesItem {


    public static void equiparItem(Personaje personaje, Item item, boolean anyadirALista){

        //Añadir el item a la lista de items del personaje
        if(anyadirALista) {
            personaje.getEquipamiento().add(item);
        }

        //Actualizar todas las estadisticas del personaje
        personaje.setAtaque(personaje.getAtaque() + item.getAumentoDaño());
        personaje.setDefensa(personaje.getDefensa() + item.getAumentoDefensa());
        personaje.setVida(personaje.getVida() + item.getAumentoSalud());
        personaje.setMana(personaje.getMana() + item.getAumentoMana());
    }




}
