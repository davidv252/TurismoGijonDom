package com.example.merche.asociacionesgijondom;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import com.example.merche.asociacionesgijondom.informacion.DatosViewBinder;
import com.example.merche.asociacionesgijondom.informacion.Directorio;
import com.example.merche.asociacionesgijondom.informacion.GestoraDirectorios;
import com.example.merche.asociacionesgijondom.informacion.Main2Activity;
import com.example.merche.asociacionesgijondom.informacion.MostrarDatos;

import static com.example.merche.asociacionesgijondom.informacion.Directorio.getClaves;

public class MainActivity extends AppCompatActivity {

    private ListView lista ;

    private GestoraDirectorios gestora;
    public static SimpleAdapter adaptador;

    Notification.Builder caracretisticas;
    int cuentaDirectorios;
    int notiId = 001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lista = (ListView)findViewById(R.id.listView);




        //mostrarNotificacion();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Directorio itemSelected = gestora.get(i);
                //Intent miIntent = new Intent(MainActivity.this, Main2Activity.class);
                //miIntent.putExtra("obj",itemSelected);
                //startActivity(miIntent);

                String[] from = getClaves();
                int[] to = {R.id.finalImagen, R.id.finalImagen, R.id.finalTelefono, R.id.finalDescripcion, R.id.finalLocalizacion};
                adaptador = new SimpleAdapter(MainActivity.this, gestora, R.layout.activity_main2, from, to);
            }

        });

    }

    /*private void mostrarNotificacion() {
        cuentaDirectorios = lista.getAdapter().getCount();

        caracretisticas =
                new Notification.Builder(this).
                        setSmallIcon(android.R.drawable.ic_notification_clear_all).
                        setContentTitle("¡Aviso!").
                        setContentText("Se han cargado un total de " + cuentaDirectorios + " directorios");

        Intent resultIntent = new Intent(this, MostrarDatos.class);

        PendingIntent result = PendingIntent.getActivity(
                this,
                0,
                resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        caracretisticas.setContentIntent(result);

        NotificationManager notMangr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notMangr.notify(notiId, caracretisticas.build());
    }*/

    @Override
    protected void onStart() {
        super.onStart();
       /* if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }*/

        gestora=new GestoraDirectorios();
        lista=findViewById(R.id.listView);
        String[] from= getClaves();
        int[] to={R.id.tv_imagen,R.id.tv_nombre, R.id.tv_tipo};
        adaptador=new SimpleAdapter(this,gestora,R.layout.para_list_view,from,to);
        adaptador.setViewBinder(new DatosViewBinder());
        lista.setAdapter(adaptador);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ordenAlfabetico: {
                this.gestora.ordenaAlfabeticamente();
                this.adaptador.notifyDataSetChanged();
                break;
            }
            case R.id.ordenCategoria: {
                this.gestora.ordenaCategoria();
                this.adaptador.notifyDataSetChanged();
                break;
            }

        }
        return true;
    }






}
