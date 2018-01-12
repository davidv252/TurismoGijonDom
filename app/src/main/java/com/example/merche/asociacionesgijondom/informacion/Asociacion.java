package com.example.merche.asociacionesgijondom.informacion;

import java.util.HashMap;

/**
 * Created by merche on 14/02/2017.
 */

public class Asociacion extends HashMap<String, Object> {
    public Asociacion(String nombre, String direccion, String tfno,String fax) {
        this.put("nombre", nombre);
        this.put("direccion", direccion);
        this.put("telefono", tfno);
        this.put("fax-o-telefono-2", fax);
    }
    public static String[] getClaves(){
        String[] claves={"nombre","direccion","telefono","fax-o-telefono-2"};
        return claves;
    }
}
