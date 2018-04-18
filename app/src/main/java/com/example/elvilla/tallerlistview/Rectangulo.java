package com.example.elvilla.tallerlistview;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Rectangulo extends AppCompatActivity {
    private EditText cajaBase;
    private EditText cajaAltura;
    private Intent in;
    private Bundle b;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        cajaBase = findViewById(R.id.txtBaseRec);
        cajaAltura = findViewById(R.id.txtAltura);
        resources = this.getResources();

        in = new Intent(this,ResultadoRectangulo.class);
        b = new Bundle();
    }
    public void rectangulo(View v){
        String operacion, dato, base,altura, aux="";
        int base2,altura2;

        if(validar()){
            base = cajaBase.getText().toString();
            base2 = Integer.parseInt(base);
            altura = cajaAltura.getText().toString();
            altura2 = Integer.parseInt(altura);

            operacion = resources.getString(R.string.areaRectangulo);
            dato = resources.getString(R.string.base2)+" " + base2;

            base2 = base2*altura2;
            aux = aux+base2+" mts²";

            b.putString("ResultadoRectangulo", aux);
            in.putExtras(b);
            Operaciones o = new Operaciones(operacion,dato,aux);
            o.guardar();
            startActivity(in);
        }
    }
    public boolean validar(){
        if(cajaBase.getText().toString().isEmpty()){
            cajaBase.setError(resources.getString(R.string.errorLado));
            return false;
        }
        if(cajaBase.getText().toString().equalsIgnoreCase("0")){
            cajaBase.setError(resources.getString(R.string.errorCero));
            return false;
        }
        return true;
    }
    public void borrar1(View v){
        limpiar();
    }

    public void limpiar(){
        cajaBase.setText("");
        cajaBase.requestFocus();
    }
}
