package com.example.bdsimples;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class BDHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "cadastroAluno.db";
    private static final String TABLE_NAME = "cadastroAluno";
    private static final String COLUNM_ID = "id_aluno";
    private static final String COLUNM_NAME = "nome_aluno";
    private static final String COLUNM_AGE = "idade_aluno";
    private static final String COLUNM_HEIGHT = "altura_aluno";
    private static final String COLUNM_WEIGHT = "peso_aluno";
    private static final String COLUNM_USER = "usuario";
    private static final String COLUNM_PASSWORD = "senha";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table cadastroAluno" +
            "(id_aluno integer primary key autoincrement, nome_aluno text not null, " +
            "idade_aluno integer not null, altura_aluno text not null, peso_aluno text not null, " +
            "usuario text not null, senha text not null);";

    public BDHelper(Context context){
        super(context, DATABASE_NAME, null,  DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    //inserir novo aluno
    public void insereAluno(CadastroAluno c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUNM_NAME, c.getNome());
        values.put(COLUNM_AGE, c.getIdade());
        values.put(COLUNM_HEIGHT, c.getAltura());
        values.put(COLUNM_WEIGHT, c.getPeso());
        values.put(COLUNM_USER, c.getUsuario());
        values.put(COLUNM_PASSWORD, c.getSenha());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String recuperarSenha(String usuario){
        db = this.getReadableDatabase();
        String query = "select usuario, senha from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b = "não encontrado";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);
                if(a.equals(usuario)){
                    b = cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return b;
    }

    public ArrayList<CadastroAluno> selectAllContatos(){
        String[] coluns={COLUNM_NAME, COLUNM_AGE, COLUNM_HEIGHT, COLUNM_USER, COLUNM_PASSWORD};
        Cursor cursor = getWritableDatabase().query(TABLE_NAME,coluns,
                null,null,null,null,
                "upper(nome_aluno)",null);
        ArrayList<CadastroAluno> listaContato = new ArrayList<CadastroAluno>();
        while (cursor.moveToNext()){
            CadastroAluno c = new CadastroAluno();
            c.setNome(cursor.getString(0));
            c.setIdade(cursor.getString(1));
            c.setAltura(cursor.getString(2));
            c.setPeso(cursor.getString(3));
            c.setUsuario(cursor.getString(4));
            listaContato.add(c);
        }
        return listaContato;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        this.db.execSQL(query);
        this.onCreate(db);
    }
}
