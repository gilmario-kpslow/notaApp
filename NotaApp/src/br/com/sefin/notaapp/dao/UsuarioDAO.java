/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sefin.notaapp.dao;

import android.content.Context;
import br.com.sefin.notaapp.modelo.Cadastro;

/**
 *
 * @author gilmario
 */
public class UsuarioDAO extends DAO<Cadastro> {

    public UsuarioDAO(Context context) {
        super(context, new Cadastro(), Cadastro.class);
    }

    public void registrarUsuario(Cadastro cadastro) {
        this.inserir(cadastro);
    }

}
