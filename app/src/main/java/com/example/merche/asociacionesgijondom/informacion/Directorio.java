package com.example.merche.asociacionesgijondom.informacion;

import java.util.HashMap;

/**
 * Created by DamLocal on 11/01/2018.
 */

public class Directorio extends HashMap<String, Object> {
    public Directorio(String imagen, String nombre, String categoria) {
        this.put("imagen", imagen);
        this.put("nombre", nombre);
        this.put("categoria", categoria);
    }
    public static String[] getClaves(){
        String[] claves={"imagen","nombre","categoria"};
        return claves;
    }
}
