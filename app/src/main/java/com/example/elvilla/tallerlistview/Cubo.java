package com.example.elvilla.tallerlistview;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cubo extends AppCompatActivity {
    private EditText cajaArista;
    private Intent in;
    private Bundle b;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);

        cajaArista = findViewById(R.id.txtArista);
        resources = this.getResources();

        in = new Intent(this,ResultadoCubo.class);
        b = new Bundle();
    }
    public void cubo(View v){
        String operacion, dato, ari, aux="";
        double ari2,res;

        if(validar()){
            ari = cajaArista.getText().toString();
            ari2 = Integer.parseInt(ari);

            operacion = resources.getString(R.string.volumenCubo);
            dato = resources.getString(R.string.Arista2)+" " + ari2;

            res = Math.pow(ari2,3);
            aux = aux+res+" mts³";

            b.putString("ResultadoCubo", aux);
            in.putExtras(b);
            Operaciones o = new Operaciones(operacion,dato,aux);
            o.guardar();
            startActivity(in);
        }
    }

    public boolean validar(){
        if(cajaArista.getText().toString().isEmpty()){
            cajaArista.setError(resources.getString(R.string.errorArista));
            return false;
        }
        if(cajaArista.getText().toString().equalsIgnoreCase("0")){
            cajaArista.setError(resources.getString(R.string.errorCero));
            return false;
        }
        return true;
    }

    public void borrar1(View v){
        limpiar();
    }

    public void limpiar(){
        cajaArista.setText("");
        cajaArista.requestFocus();
    }
}
