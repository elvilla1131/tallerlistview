package com.example.elvilla.tallerlistview;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cono extends AppCompatActivity {
    private EditText cajaRadio;
    private EditText cajaAltura;
    private Intent in;
    private Bundle b;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cono);

        cajaRadio = findViewById(R.id.txtRadio4);
        cajaAltura = findViewById(R.id.txtAltura3);
        resources = this.getResources();

        in = new Intent(this,ResultadoCono.class);
        b = new Bundle();
    }
    public void cono(View v){
        String operacion, dato, rad,alt, aux="";
        double rad2,alt2,res;


        if(validar()){
            rad = cajaRadio.getText().toString();
            rad2 = Integer.parseInt(rad);
            alt=cajaAltura.getText().toString();
            alt2=Integer.parseInt(alt);

            operacion = resources.getString(R.string.volumenCono);
            dato = resources.getString(R.string.radio2)+" " + rad2 + "\n"+resources.getString(R.string.altura2)+" " + alt2;

            res = (3.14*Math.pow(rad2,2)*alt2)/3;
            aux = aux+res+" mts³";

            b.putString("ResultadoCono", aux);
            in.putExtras(b);
            Operaciones o = new Operaciones(operacion,dato,aux);
            o.guardar();
            startActivity(in);
        }
    }

    public boolean validar(){
        if(cajaAltura.getText().toString().isEmpty()){
            cajaAltura.setError(resources.getString(R.string.errorAltura));
            return false;
        }
        if(cajaRadio.getText().toString().isEmpty()){
            cajaRadio.setError(resources.getString(R.string.errorRadio));
            return false;
        }
        if(cajaAltura.getText().toString().equalsIgnoreCase("0")){
            cajaAltura.setError(resources.getString(R.string.errorCero));
            return false;
        }
        if(cajaRadio.getText().toString().equalsIgnoreCase("0")){
            cajaRadio.setError(resources.getString(R.string.errorCero));
            return false;
        }
        return true;
    }

    public void borrar1(View v){
        limpiar();
    }

    public void limpiar(){
        cajaRadio.setText("");
        cajaAltura.setText("");
        cajaRadio.requestFocus();
    }
}