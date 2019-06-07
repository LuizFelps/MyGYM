package com.example.bdsimples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class VerBD extends AppCompatActivity {
    private TextView txtNome;
    private ListView listaContatos;
    private ArrayList<CadastroAluno> arrayListContato;
    private ArrayAdapter<CadastroAluno> arrayAdapterContato;
    private CadastroAluno contato=new CadastroAluno();
    private int id1,id2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_bd);
        listaContatos = findViewById(R.id.listView);
        registerForContextMenu(listaContatos);
        preenchelista();
        listaContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                CadastroAluno contatoEnviado=(CadastroAluno)
                        arrayAdapterContato.getItem(position);
                Bundle param = new Bundle();
                param.putString("ch_nome", contatoEnviado.getNome());
                Intent intent = new Intent(VerBD.this, MainActivity.class);
                intent.putExtras(param);
                startActivity(intent);
            }
        });
        listaContatos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                contato = arrayAdapterContato.getItem(position);
                return false;
            }
        });

    }

    public void preenchelista(){
        BDHelper contatoBD = new BDHelper(VerBD.this);
        arrayListContato = contatoBD.selectAllContatos();
        contatoBD.close();
        if(listaContatos!=null){
            arrayAdapterContato = new ArrayAdapter<CadastroAluno>(VerBD.this,
                    android.R.layout.simple_list_item_1,arrayListContato);
            listaContatos.setAdapter(arrayAdapterContato);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        preenchelista();
    }
}
