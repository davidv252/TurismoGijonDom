package com.example.merche.asociacionesgijondom.informacion;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by DamLocal on 11/01/2018.
 */

public class Directorio extends HashMap<String, Object> implements Comparable<Directorio>{
    public Directorio(String imagen, String nombre, String categoria,String descripcion,String web,String direccion) {
        this.put("foto", imagen);
        this.put("nombre", nombre);
        this.put("categoria", categoria);
        this.put("descripcion", descripcion);
        this.put("web", web);
        this.put("direccion", direccion);

    }


    public static String[] getClaves(){
        String[] claves={"foto","nombre","categoria","descripcion","web","direccion"};
        return claves;
    }

    @Override
    public int compareTo(Directorio directorio) {

        Object[] directorio1 = {((String) this.get(getClaves()[1])).toLowerCase(), ((String) this.get(getClaves()[2])).toLowerCase(), ((String) this.get(getClaves()[0])).toLowerCase()};
        Object[] directorio2 = {((String) directorio.get(getClaves()[1])).toLowerCase(), ((String) directorio.get(getClaves()[2])).toLowerCase(), ((String) directorio.get(getClaves()[0])).toLowerCase()};
        int campos= (int) (int) this.get(getClaves().length);
        for (int x = 0; x < campos; x++) {
            boolean iguales = directorio1[x].equals(directorio2[x]);
            if (!iguales) {
                return directorio1[x].toString().compareTo(directorio2[x].toString());
            }
        }

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Directorio){
            Directorio otro=(Directorio) o;
            return this.compareTo(otro)==0?true:false;
        }
        return super.equals(o);
    }

}
