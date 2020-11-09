package com.xymind.ProyectofinalDulceJuanjesusMariaGuadalupe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    BDNotas bdNotas = new BDNotas(this);
    BDTareas bdTareas = new BDTareas(this);

    @Override
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View boton = findViewById(R.id.btnAgregar);
        View boton2 = findViewById(R.id.btnAgregarTarea);
        boton.setOnClickListener(this);
        boton2.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void onClick(View btn){
        if(btn.getId()==findViewById(R.id.btnAgregar).getId()){
            EditText t, c;
            t = (EditText)findViewById(R.id.txtAgregarTitulo);
            c = (EditText)findViewById(R.id.txtDescribcion);
            bdNotas.addNota(t.getText().toString(), c.getText().toString());
            Intent i = new Intent(this, ShowNotasActivity.class);
            startActivity(i);
        }else if(btn.getId()==findViewById(R.id.btnAgregarTarea).getId()){
            EditText t, d, f, h;
            t = (EditText)findViewById(R.id.txtTituloTarea);
            d = (EditText)findViewById(R.id.txtDescribcionTarea);
            f = (EditText)findViewById(R.id.txtFechaTarea);
            h = (EditText)findViewById(R.id.txtHoraTarea);
            bdTareas.addtareas(t.getText().toString(), d.getText().toString(), f.getText().toString(), h.getText().toString());
            Intent i = new Intent(this, ShowTareasActivity.class);
            startActivity(i);
        }
    }
}



