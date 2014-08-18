package br.com.sefin.notaapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import br.com.sefin.notaapp.util.Mensagem;

public class MainActivity extends Activity implements DialogInterface.OnClickListener {

    /**
     *
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void testaMensagem(View v) {
        Mensagem.mensagemDialogConfirmacao(this, "Hi", this);
    }

    public void selecionaUsuario(View view) {
        Intent i = new Intent(this, SelecionaUsuarioActivity.class);
        startActivity(i);
    }

    public void registrarUsuario(View view) {
        startActivity(new Intent(this, RegistrarUsuarioActivity.class));
    }

    public void sair(View view) {
        finish();
    }

    public void onClick(DialogInterface di, int i) {
        Mensagem.mensagemSimples(this, Integer.toString(i));

    }
}
