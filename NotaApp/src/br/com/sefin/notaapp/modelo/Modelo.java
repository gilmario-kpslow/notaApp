/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sefin.notaapp.modelo;

import android.content.ContentValues;
import android.database.Cursor;

/**
 *
 * @author gilmario
 */
public abstract class Modelo {

    public abstract String[] getColunas();

    public abstract String getTableName();

    public abstract void instanciar(Cursor c);

    public abstract ContentValues getValues();

    public boolean isNull(Object o) {
        return o == null;
    }

}
