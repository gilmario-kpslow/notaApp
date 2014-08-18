/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sefin.notaapp.util;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.params.HttpParams;

/**
 *
 * @author gilmario
 */
public class WebService {

    public final String[] get(String url) {

        String[] result = new String[2];
        HttpGet httpget = new HttpGet(url);
        HttpResponse response;
        try {
            response = HttpClienteSingleton.getHttpClientInstace().execute(httpget);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result[0] = String.valueOf(response.getStatusLine().getStatusCode());
                InputStream instream = entity.getContent();
                result[1] = toString(instream);
                instream.close();
                Log.i("get", "Result from post JsonPost : " + result[0] + " : " + result[1]);
            }
        } catch (Exception e) {
            Log.e("NGVL", "Falha ao acessar Web service", e);
            result[0] = "0";
            result[1] = "Falha na rede!";
        }
        return result;
    }

    public final String[] post(String url, String json) {
        String[] result = new String[2];
        try {

            HttpPost httpPost = new HttpPost(new URI(url));
            httpPost.setHeader("content-type", "application/xml");
            StringEntity sEntity = new StringEntity(json);
            httpPost.setEntity(sEntity);

            HttpResponse response;
            response = HttpClienteSingleton.getHttpClientInstace().execute(httpPost);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                result[0] = String.valueOf(response.getStatusLine().getStatusCode());
                InputStream instream = entity.getContent();
                result[1] = toString(instream);
                instream.close();

                Log.d("post", "Result from post JsonPost : " + result[0] + " : " + result[1]);
            }

        } catch (Exception e) {
            Log.e("NGVL", "Falha ao acessar Web service", e);
            result[0] = "0";
            result[1] = "Falha na rede!";
        }
        return result;
    }

    private String toString(InputStream is) throws IOException {

        byte[] bytes = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int lidos;
        while ((lidos = is.read(bytes)) > 0) {
            baos.write(bytes, 0, lidos);
        }
        return new String(baos.toByteArray());
    }

}
