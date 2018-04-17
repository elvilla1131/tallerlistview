package com.example.elvilla.tallerlistview;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoCirculo extends AppCompatActivity {
    private TextView enviado;
    private Bundle b;
    private String resultado, aux;
    private Resources resources;
    private Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_circulo);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        enviado = (TextView)findViewById(R.id.txtResultadoCir);
        b = getIntent().getExtras();
        resultado = b.getString("ResultadoCirculo");
        resources = this.getResources();

        aux = resources.getString(R.string.area)+" "+resultado;

        enviado.setText(aux);
    }
}
