package com.example.elvilla.tallerlistview;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoCono extends AppCompatActivity {
    private TextView enviado;
    private Bundle b;
    private String resultado, aux;
    private Resources resources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_cono);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        enviado = (TextView)findViewById(R.id.txtResultadoCon);
        b = getIntent().getExtras();
        resultado = b.getString("ResultadoCono");
        resources = this.getResources();

        aux = resources.getString(R.string.volumen)+" "+resultado;

        enviado.setText(aux);
    }
}
