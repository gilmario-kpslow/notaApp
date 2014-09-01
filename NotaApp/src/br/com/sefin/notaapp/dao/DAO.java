/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sefin.notaapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import br.com.sefin.notaapp.db.Conexao;
import br.com.sefin.notaapp.modelo.Modelo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gilmario
 * @param <T>
 */
public abstract class DAO<T extends Modelo> {

    private final Conexao conexao;
    private SQLiteDatabase db;
    private final Modelo modelo;
    private final Class<T> classe;

    public DAO(Context context, Modelo modelo, Class classe) {
        conexao = new Conexao(context);
        this.modelo = modelo;
        this.classe = classe;
    }

    public void inserir(T t) {

        ContentValues values = new ContentValues();
        values.put("nome", "Gilmario");
        values.put("documento", "67096050353");
        values.put("codigo", 1);
        getDb().insert(modelo.getTableName(), null, values);
    }

    public List<T> listar() throws InstantiationException, IllegalAccessException {
        List<T> lista = new ArrayList<T>();
        Cursor cursor = getDb().query(modelo.getTableName(), modelo.getColunas(), null, null, null, null, null);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            T m = classe.newInstance();
            m.instanciar(cursor);
            lista.add(m);
            cursor.moveToNext();
        }
        cursor.close();
        return lista;
    }

    private SQLiteDatabase getDb() {
        if (db == null) {
            db = conexao.getWritableDatabase();
        }
        return db;
    }

    public void close() {
        conexao.close();
        db = null;
    }

}
