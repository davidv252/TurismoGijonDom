package com.example.merche.asociacionesgijondom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;


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
        ListView lista=findViewById(R.id.listView);
        String[] from= Directorio.getClaves();
        int[] to={R.id.tv_imagen,R.id.tv_nombre, R.id.tv_tipo};
        adaptador=new SimpleAdapter(this,gestora,R.layout.para_list_view,from,to);
        lista.setAdapter(adaptador);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
