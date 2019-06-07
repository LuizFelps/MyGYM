package com.example.bdsimples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaPersonal extends AppCompatActivity {
    private EditText nome, idade, usuario, senha;
    private Button btSalvar;
    BDHelper2 helper = new BDHelper2(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_personal);

        this.nome = findViewById(R.id.edtNomePersonal);
        this.idade = findViewById(R.id.edtIdadePersonal);
        this.usuario = findViewById(R.id.edtUsuarioPersonal);
        this.senha = findViewById(R.id.edtSenhaPersonal);
        this.btSalvar = findViewById(R.id.bt_salvar);
    }
    public void salvar(View view){
        String pNome = nome.getText().toString();
        String pIdade = idade.getText().toString();
        String pUsuario = usuario.getText().toString();
        String pSenha = usuario.getText().toString();

        CadastroPersonal p = new CadastroPersonal(pNome, pIdade, pUsuario, pSenha);
        helper.inserePersonal(p);
        helper.close();

        Intent intent = new Intent(this, TelaLogin.class);
        startActivity(intent);
    }
    public void voltar(View view){
        Intent intent = new Intent(this, TelaOpcoes.class);
        startActivity(intent);
    }
}
