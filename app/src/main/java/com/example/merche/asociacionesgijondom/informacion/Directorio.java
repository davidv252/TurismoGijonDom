package com.example.merche.asociacionesgijondom.informacion;

import java.util.HashMap;

/**
 * Created by DamLocal on 11/01/2018.
 */

public class Directorio extends HashMap<String, Object> {
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
}
