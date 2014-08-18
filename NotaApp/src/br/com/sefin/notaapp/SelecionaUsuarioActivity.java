/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sefin.notaapp;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import br.com.sefin.notaapp.dao.UsuarioDAO;
import br.com.sefin.notaapp.modelo.Cadastro;
import br.com.sefin.notaapp.util.MascaraUtil;
import br.com.sefin.notaapp.util.Mensagem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gilmario
 */
public class SelecionaUsuarioActivity extends ListActivity implements AdapterView.OnItemClickListener {

    private List<Map<String, Object>> usuarioList;
    private int selecionado;
    private UsuarioDAO udao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuarioList = new ArrayList<Map<String, Object>>();
        udao = new UsuarioDAO(this);
        createLayout();
        getListView().setOnItemClickListener(this);
    }

    public List<Map<String, Object>> listarUsuarios() {
        try {
            List<Cadastro> lista = udao.listar();
            for (Cadastro c : lista) {
                Map<String, Object> item = new HashMap<String, Object>();
                item.put("imagem_usuario", R.drawable.conf);
                item.put("doc_usuario", MascaraUtil.criaMascaraCPF(c.getDocumento()));
                item.put("nome_usuario", c.getNome());
                usuarioList.add(item);
            }
        } catch (InstantiationException ex) {
            Logger.getLogger(SelecionaUsuarioActivity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SelecionaUsuarioActivity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarioList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.usuario_menu, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.novo_usuario:
                startActivity(new Intent(this, RegistrarUsuarioActivity.class));
                return true;
            default:
                return super.onMenuItemSelected(featureId, item);
        }
    }

    private void createLayout() {
        String[] colunas = {"imagem_usuario", "doc_usuario", "nome_usuario"};
        int[] views = {R.id.imagem_usuario, R.id.doc_usuario, R.id.nome_usuario};
        SimpleAdapter adapter = new SimpleAdapter(this, listarUsuarios(), R.layout.usuario_lista, colunas, views);
        setListAdapter(adapter);
    }

    public void onItemClick(AdapterView<?> av, View view, int sel, long l) {
        selecionado = sel;
        Mensagem.mensagemDialogConfirmacao(this, "Confirmar Usuário", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface di, int i) {
                if (DialogInterface.BUTTON_POSITIVE == i) {
                    Intent intent = new Intent(SelecionaUsuarioActivity.this, LoginActivity.class);
                    intent.putExtra(LoginActivity.LOGIN_NAME, usuarioList.get(selecionado).get("nome_usuario").toString());
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        udao.close();
    }

}
