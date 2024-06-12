package model;

import java.time.LocalDate;

public class Professor extends Usuario{
    private String departamento;
    public Professor(String nome, String cpf, String matricula, LocalDate dataNascimento, String departamento){
        super(nome, cpf, matricula, dataNascimento);
        this.departamento = departamento;
    }
    public String getDepartamento(){
        return departamento;
    }
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }
}
