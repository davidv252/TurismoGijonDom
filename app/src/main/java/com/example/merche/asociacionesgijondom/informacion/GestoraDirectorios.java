package com.example.merche.asociacionesgijondom.informacion;

import android.os.AsyncTask;

import com.example.merche.asociacionesgijondom.MainActivity;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by merche on 14/02/2017.
 */

public class GestoraDirectorios extends ArrayList<Directorio> {
    public GestoraDirectorios() {
        CargadoraDOM tarea=new CargadoraDOM(this);
        tarea.execute("http://datos.gijon.es/doc/turismo/turismo.xml");
    }
    class CargadoraDOM extends AsyncTask<String,Integer,Boolean> {
        private Node key=null;
        public CargadoraDOM(GestoraDirectorios gestora) {
            this.gestora = gestora;
        }
        private GestoraDirectorios gestora;
        private Document documento = null;

        protected Boolean doInBackground(String... params) {

            try {
                URL url = new URL(params[0]);
                DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
                DocumentBuilder constructorDeDocumento = factoria.newDocumentBuilder();
                try (InputStream lector = url.openStream()) {
                    documento = constructorDeDocumento.parse(lector);

                }  catch (IOException ex) {
                    Logger.getLogger(GestoraDirectorios.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                } catch (SAXException e) {
                    e.printStackTrace();
                    return false;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return false;
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
                return false;
            }

            return true;
        }

        protected void onPostExecute(Boolean result) {
            if (result) {
                //obtenemos el conjunto de elementos "asociacion"
                NodeList nodo = this.documento.getElementsByTagName("directorio");
                for (int x=0;x<nodo.getLength();x++) {
                    Directorio una = new Directorio(null,null,null,null,null,null);
                    //recorremos todos los elementos de una asociación
                    this.navigateTree(nodo.item(x), una);
                    //añadimos el objeto asociación al arrayList de asociaciones
                    gestora.add(una);
                }
                if (gestora.size()>0 && MainActivity.adaptador!=null){
                    MainActivity.adaptador.notifyDataSetChanged();
                }
            }

        }

        private void navigateTree(Node n, Directorio una) {
            switch (n.getNodeType()) {
//        case Node.DOCUMENT_NODE:
//        {
//            Document doc=(Document) n;
//            System.out.println("Nodo tipo DOCUMENT_NODE"+n.getNodeName());
//        }
//            break;
                case Node.ELEMENT_NODE: {
                    this.key=n;
                    NodeList hijos = n.getChildNodes();
                    //Si el elemento contiene hijos hay que recorrerlos
                    if (hijos != null) {
                        for (int x = 0; x < hijos.getLength(); x++) {
                            this.navigateTree(hijos.item(x),una);
                        }
                    }
                }
                break;
                //si el nodo es de tipo texto puede ser información que nos interesa
                case Node.TEXT_NODE: {
                    this.procesarTexto(n, una);
                }
                break;
            }
        }
        private void procesarTexto(Node n, Directorio a) {
            String valor = n.getNodeValue();
            String nombreClave=this.key.getNodeName();
            //para poner en el objeto Directorio sólo la información que interesa
            if (a.containsKey(nombreClave) && a.get(nombreClave)==null){
                a.put(nombreClave, valor);
            }
        }
    }
}
