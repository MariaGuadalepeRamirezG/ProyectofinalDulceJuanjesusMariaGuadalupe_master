package com.xymind.ProyectofinalDulceJuanjesusMariaGuadalupe;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowNotasActivity extends Activity {

    BDNotas bdNotas = new BDNotas(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shownotas);
        Cursor c = bdNotas.getNotas();
        String titulos, contenido;
        c.moveToLast();
         titulos = c.getString(c.getColumnIndex("titulo"));
         contenido = c.getString(c.getColumnIndex("content"));
        TextView titulo, content;
        titulo = (TextView)findViewById(R.id.VerTitulo);
        content = (TextView)findViewById(R.id.VerContenido);
         titulo.setText(titulos);
         content.setText(contenido);

    }

}