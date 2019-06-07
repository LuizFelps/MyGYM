package com.example.bdsimples;

public class CadastroPersonal {
    String nome, idade, usuario, senha;

    public CadastroPersonal(){

    }

    public CadastroPersonal(String nome, String idade, String usuario, String senha){
        this.nome = nome;
        this.idade = idade;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return  "nome = " + nome + "\n" +
                "idade = " + idade + "\n";
    }
}