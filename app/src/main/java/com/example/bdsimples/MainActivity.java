package com.example.bdsimples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nome,  idade, altura, peso, usuario, senha;
    private Button btSalvar;
    BDHelper helper = new BDHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nome = findViewById(R.id.edtNomeAluno);
        this.idade = findViewById(R.id.edtIdadeAluno);
        this.altura = findViewById(R.id.edtAlturaAluno);
        this.peso = findViewById(R.id.edtPesoAluno);
        this.usuario = findViewById(R.id.edtUsuarioAluno);
        this.senha = findViewById(R.id.edtSenhaAluno);
        this.btSalvar = findViewById(R.id.bt_salvar);

    }

    public void salvar(View view){
        String alNome = nome.getText().toString();
        String alIdade = idade.getText().toString();
        String alAltura = altura.getText().toString();
        String alPeso = peso.getText().toString();
        String alUsuario = usuario.getText().toString();
        String alSenha = senha.getText().toString();

        CadastroAluno c = new CadastroAluno(alNome, alIdade, alAltura, alPeso, alUsuario, alSenha);
        helper.insereAluno(c);
        helper.close();

        Intent intent = new Intent(this, TelaLogin.class);
        /*intent.putExtra("nome_usuario", alNome);
        intent.putExtra("altura_usuario", alAltura);
        intent.putExtra("idade_usuario", alIdade);
        intent.putExtra("peso_usuario", alPeso);*/
        startActivity(intent);
    }
}
