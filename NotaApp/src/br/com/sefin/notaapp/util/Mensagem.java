/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sefin.notaapp.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * @author gilmario
 */
public class Mensagem {

    public static void mensagemSimples(Context context, String mensagem) {
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }

    public static void mensagemDialogConfirmacao(Context context, String mensagem, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(mensagem);
        builder.setTitle("Confrimação");
        builder.setPositiveButton("Sim", listener);
        builder.setNegativeButton("Não", listener);
        builder.create().show();
    }
}
