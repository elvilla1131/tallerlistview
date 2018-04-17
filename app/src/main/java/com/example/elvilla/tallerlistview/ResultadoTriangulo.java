package com.example.elvilla.tallerlistview;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoTriangulo extends AppCompatActivity {
    private TextView enviado;
    private Bundle b;
    private String resultado, aux;
    private Resources resources;
    private Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_triangulo);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        enviado = (TextView)findViewById(R.id.txtResultadoTri);
        b = getIntent().getExtras();
        resultado = b.getString("ResultadoTriangulo");
        resources = this.getResources();

        aux = resources.getString(R.string.area)+" "+resultado;

        enviado.setText(aux);
    }
}
