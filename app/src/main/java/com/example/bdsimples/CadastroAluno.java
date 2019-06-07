package com.example.bdsimples;

public class CadastroAluno {

    String nome, idade, peso, altura, usuario, senha;

    public CadastroAluno(){

    }

    public CadastroAluno(String nome, String idade, String altura, String peso, String usuario, String senha){
        this.nome = nome;
        this.altura = altura;
        this.idade = idade;
        this.peso = peso;
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

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
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
                "idade = " + idade + "\n" +
                "peso = " + peso + "\n" +
                "altura = " + altura + "\n" +
                "usuario = " + usuario + "\n";
    }
}
