package com.example.merche.asociacionesgijondom.informacion;

import java.util.Comparator;

/**
 * Created by DamLocal on 15/01/2018.
 */

public class ComparadorCategoria implements Comparator<Directorio> {


    @Override
    public int compare(Directorio directorio, Directorio t1) {
        return (((String)directorio.get(Directorio.getClaves()[2].toString())).toLowerCase()).compareTo(((String)t1.get(Directorio.getClaves()[2].toString())).toLowerCase());
    }
}
