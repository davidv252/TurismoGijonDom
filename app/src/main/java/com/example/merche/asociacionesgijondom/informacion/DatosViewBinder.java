package com.example.merche.asociacionesgijondom.informacion;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.StrictMode;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by DamLocal on 18/01/2018.
 */

public class DatosViewBinder implements SimpleAdapter.ViewBinder {



    @Override
    public boolean setViewValue(View view, Object data, String textRepresentation) {

        if (view instanceof AppCompatImageView)
        {
            ImageView img=(ImageView)view;
            if (data!=null) {
                new DownImage(img, textRepresentation).execute();
//                try {
//                    URL imageUrl = new URL(textRepresentation);
//                    HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
//                    conn.connect();
//                    Bitmap imagen = BitmapFactory.decodeStream(conn.getInputStream());
//
//                    img.setImageBitmap(imagen);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                return true;
            }
        }

        return false;
    }
}
