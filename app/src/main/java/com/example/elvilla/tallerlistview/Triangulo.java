package com.example.elvilla.tallerlistview;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Triangulo extends AppCompatActivity {
    private EditText cajaBase;
    private EditText cajaAltura;
    private Intent in;
    private Bundle b;
    private Resources resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        cajaBase = (EditText)findViewById(R.id.txtBase);
        cajaAltura = (EditText)findViewById(R.id.txtAltura);
        resources = this.getResources();

        in = new Intent(this,ResultadoTriangulo.class);
        b = new Bundle();
    }
    public void triangulo(View v){
        String operacion, dato, bas,alt, aux="";
        int bas2,alt2,res;

        if(validar()){
            bas = cajaBase.getText().toString();
            alt = cajaAltura.getText().toString();
            bas2 = Integer.parseInt(bas);
            alt2 = Integer.parseInt(alt);

            operacion = resources.getString(R.string.areaTriangulo);
            dato = resources.getString(R.string.base2)+" "+ bas2 + "\n"+resources.getString(R.string.altura2)+" " + alt2;

            res= (bas2*alt2)/2;
            aux = aux+res+" mts²";

            b.putString("ResultadoTriangulo", aux);
            in.putExtras(b);
            Operaciones o = new Operaciones(operacion,dato,aux);
            o.guardar();
            startActivity(in);
        }
    }
    public boolean validar(){
        if(cajaBase.getText().toString().isEmpty()){
            cajaBase.setError(resources.getString(R.string.errorBase));
            return false;
        }
        if(cajaAltura.getText().toString().isEmpty()){
            cajaAltura.setError(resources.getString(R.string.errorAltura));
            return false;
        }
        if(cajaBase.getText().toString().equalsIgnoreCase("0")){
            cajaBase.setError(resources.getString(R.string.errorCero));
            return false;
        }
        if(cajaAltura.getText().toString().equalsIgnoreCase("0")){
            cajaAltura.setError(resources.getString(R.string.errorCero));
            return false;
        }
        return true;
    }
    public void borrar1(View v){
        limpiar();
    }

    public void limpiar(){
        cajaBase.setText("");
        cajaAltura.setText("");
        cajaBase.requestFocus();
    }
}
