/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sefin.notaapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import br.com.sefin.notaapp.modelo.Cadastro;

/**
 *
 * @author gilmario
 */
public class Conexao extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "NotaApp";
    private static final int VERSAO = 1;

    public Conexao(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqld) {
        //_ID, CODIGO, TIPO, NOME, DOCUMENTO, SENHA, INSCRICAO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, MUNICIPIO, UF, EMAIL
        sqld.execSQL("CREATE TABLE cadastro(_id INTEGER PRIMARY KEY NOT NULL, "
                + "codigo INTEGER unique not null, tipo INTEGER, nome VARCHAR(200),"
                + " razao_social VARCHAR(200), documento VARCHAR(14), senha VARCHAR(255),"
                + " inscricao varchar(7), logradouro varchar(255),"
                + " numero varchar(10), complemento varchar(255), bairro varchar(100),"
                + " cep varchar(8), municipio varchar(10), uf varchar(2), email varchar(50)); ");

        ContentValues values = new ContentValues();
        values.put("nome", "Gilmario");
        values.put("documento", "67096050353");
        values.put("codigo", 1);
        sqld.insert(Cadastro.Colunas.TABELA, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqld, int i, int i1) {
        //
    }

}
