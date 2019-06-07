package com.example.bdsimples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TelaOpcoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_opcoes);
    }

    public void aluno(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void personal(View view){
        Intent intent = new Intent(this, TelaPersonal.class);
        startActivity(intent);
    }
}
