package com.example.elvilla.tallerlistview;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class DatosGuardados extends AppCompatActivity {
    private TableLayout tabla;
    private String aux;
    private ArrayList<Operaciones> operacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_guardados);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        tabla = (TableLayout)findViewById(R.id.tblOperaciones);
        operacion = Informacion.getOperaciones();

        for (int i = 0;  i < operacion.size(); i++){
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);

            c1.setText(""+(i+1));
            c2.setText(operacion.get(i).getOpera());
            c3.setText(operacion.get(i).getDato());
            c4.setText(operacion.get(i).getResult());

            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);

            tabla.addView(fila);
        }
    }
}

