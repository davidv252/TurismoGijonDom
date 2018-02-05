package com.example.merche.asociacionesgijondom.informacion;

import java.util.Comparator;

/**
 * Created by DamLocal on 01/02/2018.
 */

public class ComparadorAlfabetico implements Comparator<Directorio> {
    @Override
    public int compare(Directorio directorio, Directorio t1) {
        return ((String)directorio.get(Directorio.getClaves()[1])).compareTo((String)t1.get(Directorio.getClaves()[1]));
    }
}
