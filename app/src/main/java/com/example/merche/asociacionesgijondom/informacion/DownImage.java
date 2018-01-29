package com.example.merche.asociacionesgijondom.informacion;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by DamLocal on 18/01/2018.
 */

public class DownImage extends AsyncTask<String, Integer, Bitmap> {

    private ImageView imageView;
    private String imageURL;

    public DownImage(ImageView imageView, String imageURL) {
        this.imageView = imageView;
        this.imageURL = imageURL;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap imagen = null;
        try {
            URL imageUrl = new URL(imageURL);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2; // el factor de escala a minimizar la imagen, siempre
            imagen = BitmapFactory.decodeStream(conn.getInputStream(), new Rect(0, 0, 0, 0), options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imagen;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        imageView.setImageBitmap(result);
    }
}