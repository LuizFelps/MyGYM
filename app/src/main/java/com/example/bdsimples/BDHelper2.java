//BD para personal Trainer
package com.example.bdsimples;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BDHelper2 extends SQLiteOpenHelper {
    private static  final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "cadastroPersonal.db";
    private static final String TABLE_NAME = "cadastroPersonal";
    private static final String COLUNM_ID = "id_personal";
    private static final String COLUNM_NAME = "nome_personal";
    private static final String COLUNM_AGE = "idade_personal";
    private static final String COLUNM_USER = "usuario";
    private static final String COLUNM_PASSWORD = "senha";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table cadastroPersonal" +
            "(id_personal integer primary key autoincrement, nome_personal text not null," +
            "idade_personal text not null, usuario text not null, senha text not null);";

    public BDHelper2(Context contetx){
        super(contetx, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void inserePersonal(CadastroPersonal p){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUNM_NAME, p.getNome());
        values.put(COLUNM_AGE, p.getIdade());
        values.put(COLUNM_USER, p.getUsuario());
        values.put(COLUNM_PASSWORD, p.getSenha());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<CadastroPersonal> selectAllContatos(){
        String[] coluns={COLUNM_NAME, COLUNM_NAME, COLUNM_AGE, COLUNM_USER, COLUNM_PASSWORD};
        Cursor cursor = getWritableDatabase().query(TABLE_NAME,coluns,
                null,null,null,null,
                "upper(nome_aluno)",null);
        ArrayList<CadastroPersonal> listaContato = new ArrayList<CadastroPersonal>();
        while (cursor.moveToNext()){
            CadastroPersonal c = new CadastroPersonal();
            c.setNome(cursor.getString(0));
            c.setIdade(cursor.getString(1));
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
