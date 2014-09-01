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
public class Cadastro extends Modelo {

    private Integer _id;
    private Long codigo;
    private Integer tipo;
    private String nome;
    private String razaoSocial;
    private String documento;
    private String senha;
    private String inscricao;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String municipio;
    private String uf;
    private String email;

    @Override
    public String[] getColunas() {
        return Colunas.COLUNAS;
    }

    @Override
    public String getTableName() {
        return Colunas.TABELA;
    }

    @Override
    public void instanciar(Cursor c) {
        setBairro(c.getString(c.getColumnIndex(Colunas.BAIRRO)));
        setId(c.getInt(c.getColumnIndex(Colunas._ID)));
        setCep(c.getString(c.getColumnIndex(Colunas.CEP)));
        setCodigo(c.getLong(c.getColumnIndex(Colunas.CODIGO)));
        setComplemento(c.getString(c.getColumnIndex(Colunas.COMPLEMENTO)));
        setDocumento(c.getString(c.getColumnIndex(Colunas.DOCUMENTO)));
        setEmail(c.getString(c.getColumnIndex(Colunas.EMAIL)));
        setInscricao(c.getString(c.getColumnIndex(Colunas.INSCRICAO)));
        setLogradouro(c.getString(c.getColumnIndex(Colunas.LOGRADOURO)));
        setMunicipio(c.getString(c.getColumnIndex(Colunas.MUNICIPIO)));
        setNome(c.getString(c.getColumnIndex(Colunas.NOME)));
        setNumero(c.getString(c.getColumnIndex(Colunas.NUMERO)));
        setRazaoSocial(c.getString(c.getColumnIndex(Colunas.RAZAO_SOCIAL)));
        setSenha(c.getString(c.getColumnIndex(Colunas.SENHA)));
        setTipo(c.getInt(c.getColumnIndex(Colunas.TIPO)));
        setUf(c.getString(c.getColumnIndex(Colunas.UF)));
    }

    @Override
    public ContentValues getValues() {
        ContentValues values = new ContentValues();
        if (getCep() != null) {
            values.put(Colunas.CEP, this.getCep());
        }
        if (getBairro() != null) {
            values.put(Colunas.BAIRRO, this.getBairro());
        }
        if (getCodigo() != null) {
            values.put(Colunas.CODIGO, this.getCodigo());
        }
        if (getComplemento() != null) {
            values.put(Colunas.COMPLEMENTO, this.getComplemento());
        }
        if (getDocumento() != null) {
            values.put(Colunas.DOCUMENTO, this.getDocumento());
        }
        if (getEmail() != null) {
            values.put(Colunas.EMAIL, this.getEmail());
        }
        if (getId() != null) {
            values.put(Colunas._ID, this.getId());
        }
        if (getInscricao() != null) {
            values.put(Colunas.INSCRICAO, this.getInscricao());
        }
        if (getLogradouro() != null) {
            values.put(Colunas.LOGRADOURO, this.getLogradouro());
        }
        if (getMunicipio() != null) {
            values.put(Colunas.MUNICIPIO, this.getMunicipio());
        }
        if (getNome() != null) {
            values.put(Colunas.NOME, this.getNome());
        }
        if (getNumero() != null) {
            values.put(Colunas.NUMERO, this.getNumero());
        }
        if (getRazaoSocial() != null) {
            values.put(Colunas.RAZAO_SOCIAL, this.getRazaoSocial());
        }
        if (getSenha() != null) {
            values.put(Colunas.SENHA, this.getSenha());
        }
        return values;
    }

    public static class Colunas {

        public static final String TABELA = "cadastro";
        public static final String _ID = "_id";
        public static final String CODIGO = "codigo";
        public static final String TIPO = "tipo";
        public static final String NOME = "nome";
        public static final String RAZAO_SOCIAL = "razao_social";
        public static final String DOCUMENTO = "documento";
        public static final String SENHA = "senha";
        public static final String INSCRICAO = "inscricao";
        public static final String LOGRADOURO = "logradouro";
        public static final String NUMERO = "numero";
        public static final String COMPLEMENTO = "complemento";
        public static final String BAIRRO = "bairro";
        public static final String CEP = "cep";
        public static final String MUNICIPIO = "municipio";
        public static final String UF = "uf";
        public static final String EMAIL = "email";
        public static final String[] COLUNAS = {_ID, CODIGO, TIPO, NOME, RAZAO_SOCIAL, DOCUMENTO, SENHA, INSCRICAO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CEP, MUNICIPIO, UF, EMAIL};

    }

    public Cadastro() {
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer _id) {
        this._id = _id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cadastro other = (Cadastro) obj;
        return (this.codigo != null && this.codigo.equals(other.codigo));
    }

}
