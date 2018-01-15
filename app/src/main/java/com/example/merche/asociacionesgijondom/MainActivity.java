package com.example.merche.asociacionesgijondom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.merche.asociacionesgijondom.informacion.Asociacion;
import com.example.merche.asociacionesgijondom.informacion.Directorio;
import com.example.merche.asociacionesgijondom.informacion.GestoraDirectorios;

public class MainActivity extends AppCompatActivity {
    private GestoraDirectorios gestora;
    public static SimpleAdapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
       /* if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }*/

        gestora=new GestoraDirectorios();
        ListView lista=(ListView)findViewById(R.id.listView);
        String[] from= Directorio.getClaves();
        int[] to={R.id.tv_nombre,R.id.tv_direccion,R.id.tv_tfno,R.id.tv_fax};
        adaptador=new SimpleAdapter(this,gestora,R.layout.para_list_view,from,to);
        lista.setAdapter(adaptador);
    }
}
