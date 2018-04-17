package com.example.elvilla.tallerlistview;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Rectangulo extends AppCompatActivity {
    private EditText cajaLado;
    private Intent in;
    private Bundle b;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        cajaLado = (EditText)findViewById(R.id.txtLadoRec);
        resources = this.getResources();

        in = new Intent(this,ResultadoRectangulo.class);
        b = new Bundle();
    }
    public void rectangulo(View v){
        String operacion, dato, lad, aux="";
        int lad2;

        if(validar()){
            lad = cajaLado.getText().toString();
            lad2 = Integer.parseInt(lad);

            operacion = resources.getString(R.string.areaRectangulo);
            dato = resources.getString(R.string.lado2)+" " + lad2;

            lad2 = lad2*lad2;
            aux = aux+lad2+" mts²";

            b.putString("ResultadoRectangulo", aux);
            in.putExtras(b);
            Operaciones o = new Operaciones(operacion,dato,aux);
            o.guardar();
            startActivity(in);
        }
    }
    public boolean validar(){
        if(cajaLado.getText().toString().isEmpty()){
            cajaLado.setError(resources.getString(R.string.errorLado));
            return false;
        }
        if(cajaLado.getText().toString().equalsIgnoreCase("0")){
            cajaLado.setError(resources.getString(R.string.errorCero));
            return false;
        }
        return true;
    }
    public void borrar1(View v){
        limpiar();
    }

    public void limpiar(){
        cajaLado.setText("");
        cajaLado.requestFocus();
    }
}
