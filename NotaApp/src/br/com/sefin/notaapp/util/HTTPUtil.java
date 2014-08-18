/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sefin.notaapp.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;

/**
 *
 * @author gilmario
 */
public class HTTPUtil {

    public static String acessar(String endereco, Map<String, String> valores) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(endereco).openConnection();

        if (valores != null) {
            for (Map.Entry<String, String> entry : valores.entrySet()) {
                String chave = entry.getKey();
                String valor = entry.getValue();
                conn.setRequestProperty(chave, valor);
            }
        }
        conn.setRequestMethod("GET");
        conn.connect();
        int cod = conn.getResponseCode();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String conteudo = "";

        conteudo += br.readLine();
        while (br.ready()) {
            conteudo += br.readLine();
        }
        br.close();
        return conteudo;
    }

}
