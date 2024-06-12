package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Emprestimo implements Serializable{
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    public Emprestimo(Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista){
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public Livro getLivro(){
        return livro;
    }
    public void setLivro(Livro livro){
        this.livro = livro;
    }
    public LocalDate getDataEmprestimo(){
        return dataEmprestimo;
    }
    public void setDataEmprestimo(LocalDate dataEmprestimo){
        this.dataEmprestimo = dataEmprestimo;
    }
    public LocalDate getDataDevolucaoPrevista(){
        return dataDevolucaoPrevista;
    }
    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista){
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }
}
