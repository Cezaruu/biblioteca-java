package model;

import java.io.Serializable;

public class Livro implements Serializable{
    private String titulo;
    private String autor;
    private String assunto;
    private int anoDeLancamento;
    private int qtdEstoque;
    public Livro(String titulo, String autor, String assunto, int anoDeLancamento, int qtdEstoque){
        this.titulo = titulo;
        this.autor = autor;
        this.assunto = assunto;
        this.anoDeLancamento = anoDeLancamento;
        this.qtdEstoque = qtdEstoque;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public String getAssunto(){
        return assunto;
    }
    public void setAssunto(String assunto){
        this.assunto = assunto;
    }
    public int getAnoDeLancamento(){
        return anoDeLancamento;
    }
    public void setAnoDeLancamento(int anoDeLancamento){
        this.anoDeLancamento = anoDeLancamento;
    }
    public int getQtdEstoque(){
        return qtdEstoque;
    }
    public void setQtdEstoque(int qtdEstoque){
        this.qtdEstoque = qtdEstoque;
    }
}
