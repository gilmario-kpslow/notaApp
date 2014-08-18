/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sefin.notaapp.util;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/**
 *
 * @author gilmario
 */
public class HttpClienteSingleton {

    private static final int JSON_CONNECTION_TIMEOUT = 3000;
    private static final int JSON_SOCKET_TIMEOUT = 5000;

    private static HttpClienteSingleton instance;
    private HttpParams httpParameters;
    private DefaultHttpClient httpclient;

    private void setTimeOut(HttpParams params) {
        HttpConnectionParams.setConnectionTimeout(params, JSON_CONNECTION_TIMEOUT);
        HttpConnectionParams.setSoTimeout(params, JSON_SOCKET_TIMEOUT);
    }

    private HttpClienteSingleton() {
        httpParameters = new BasicHttpParams();
        setTimeOut(httpParameters);
        httpclient = new DefaultHttpClient(httpParameters);
    }

    public static DefaultHttpClient getHttpClientInstace() {
        if (instance == null) {
            instance = new HttpClienteSingleton();
        }
        return instance.httpclient;
    }

}
