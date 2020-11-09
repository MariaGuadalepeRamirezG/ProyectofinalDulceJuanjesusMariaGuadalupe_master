package com.xymind.ProyectofinalDulceJuanjesusMariaGuadalupe;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;



public class BDNotas extends SQLiteOpenHelper {

    public BDNotas(Context ctx){
        super(ctx, "Notas", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        String q = "CREATE TABLE notas(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "titulo TEXT, " +
                "content TEXT )";
        bd.execSQL(q);

    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int va, int vn) {
        bd.execSQL("DROP TABLE IF EXIST notas");
        onCreate(bd);
    }

    public void addNota (String titulo, String content){
        ContentValues vals = new ContentValues();
        vals.put("titulo", titulo);
        vals.put("content", content);
        this.getWritableDatabase().insert("notas", null, vals);
    }

    public Cursor getNotas(){
        String [] cols = {"ID", "titulo", "content"};
        Cursor c = this.getReadableDatabase().query("notas", null, null, null, null,null, null);
        return c;
    }

    public void removerNota(String titulo ){
        this.getWritableDatabase().delete("notas", "titulo = "+ titulo, null);
    }
    public void cerrar() {
        this.close();
    }
}

