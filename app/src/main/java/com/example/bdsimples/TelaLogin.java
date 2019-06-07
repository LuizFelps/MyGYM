package com.example.bdsimples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TelaLogin extends AppCompatActivity {
    private EditText usuario, senha;
    BDHelper helper = new BDHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        this.usuario = findViewById(R.id.edt_login);
        this.senha = findViewById(R.id.edt_senha);
    }

    public void conectar(View view){
        /*String user = usuario.getText().toString();
        String password = senha.getText().toString();
        String passwordBD = helper.recuperarSenha(password);
        if(password.equals(passwordBD)) {
            Intent intent = new Intent(this, AlunoCadastrado.class);
            intent.putExtra("nome_usuario", user);
            startActivity(intent);
        }
        /*}else{
            Toast toast = Toast.makeText(TelaLogin.this, "Senha incorreta", Toast.LENGTH_SHORT);
            toast.show();
        }*/
        //String password = senha.getText().toString();
        //if(helper.recuperarSenha(password)){
        Intent intent = new Intent(this, VerBD.class);
        //intent.putExtra("nome_usuario", password);
        startActivity(intent);
        //}
    }

    public void cadastrar(View view){
        Intent intent = new Intent(this, TelaOpcoes.class);
        startActivity(intent);
    }
}
