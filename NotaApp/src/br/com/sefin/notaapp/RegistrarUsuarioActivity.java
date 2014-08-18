/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sefin.notaapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import br.com.sefin.notaapp.dao.UsuarioDAO;
import br.com.sefin.notaapp.util.HTTPUtil;
import br.com.sefin.notaapp.util.MascaraUtil;
import br.com.sefin.notaapp.util.Mensagem;
import br.com.sefin.notaapp.util.WebService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gilmario
 */
public class RegistrarUsuarioActivity extends Activity {

    private EditText cnpj;
    private EditText senha;
    private UsuarioDAO usuarioDAO;

    /**
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);
        cnpj = (EditText) findViewById(R.id.reg_cnpj);
        cnpj.addTextChangedListener(MascaraUtil.getEditMascaraCnpj(cnpj));
        senha = (EditText) findViewById(R.id.reg_senha);
        usuarioDAO = new UsuarioDAO(this);
    }

    public void registrar(View view) {

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            try {
                new RegistrarUsuarioAcao().execute("");
//                usuarioDAO.registrarUsuario();
            } catch (Exception e) {
//                Toast.makeText(RegistrarUsuarioActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(RegistrarUsuarioActivity.this, "Você não está conectado a internet!", Toast.LENGTH_SHORT).show();
        }
    }

    private class RegistrarUsuarioAcao extends AsyncTask<String, Void, String> {

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(RegistrarUsuarioActivity.this);
            dialog.show();
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                Mensagem.mensagemSimples(RegistrarUsuarioActivity.this, result);
            }
            dialog.dismiss();
        }

        @Override
        protected String doInBackground(String... paramss) {
            try {
                String senhaUsuario = senha.getText().toString();
                String cnpjUsuario = MascaraUtil.removeMascara(cnpj.getText().toString());
                String usuarioXml = "<cadastro><cnpj>06191446000127</cnpj><codigo>1</codigo><nome>QUADROMOR BRASIL</nome></cadastro>";
//                String[] result = new WebService().get("http://10.100.0.48:8080/WebTeste/service/contribuinte/" + "06191446000127");
                String[] result = new WebService().post("http://10.100.0.48:8080/WebTeste/service/contribuinte/", usuarioXml);
                return result[0] + " - " + result[1];
            } catch (Exception ex) {
                Logger.getLogger(RegistrarUsuarioActivity.class.getName()).log(Level.SEVERE, null, ex);
                return ex.getMessage() + "\r\n" + ex.getLocalizedMessage();
            }
        }

    }
}
