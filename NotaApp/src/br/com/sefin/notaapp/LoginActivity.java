/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sefin.notaapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 *
 * @author gilmario
 */
public class LoginActivity extends Activity {

    public static final String LOGIN_NAME = "LOGIN_NAME";

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        EditText login = (EditText) findViewById(R.id.editLogin);
        login.setText(getIntent().getStringExtra(LOGIN_NAME));

    }

    public void login(View view) {

    }
}
