package com.example.merche.asociacionesgijondom.informacion;

import java.util.HashMap;

/**
 * Created by DamLocal on 11/01/2018.
 */

public class Directorio extends HashMap<String, Object> implements Comparable<Directorio>{
    public Directorio(String imagen, String nombre, String categoria) {
        this.put("imagen", imagen);
        this.put("nombre", nombre);
        this.put("categoria", categoria);
    }
    public static String[] getClaves(){
        String[] claves={"imagen","nombre","categoria"};
        return claves;
    }

    @Override
    public int compareTo(Directorio directorio) {

        Object[] directorio1 = {((String) this.get(getClaves()[1].toString())).toLowerCase(), ((String) this.get(getClaves()[2].toString())).toLowerCase(), ((String) this.get(getClaves()[0].toString())).toLowerCase()};
        Object[] directorio2 = {((String) directorio.get(getClaves()[1].toString())).toLowerCase(), ((String) directorio.get(getClaves()[2].toString())).toLowerCase(), ((String) directorio.get(getClaves()[0].toString())).toLowerCase()};
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
