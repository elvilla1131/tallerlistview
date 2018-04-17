package com.example.elvilla.tallerlistview;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Areas extends AppCompatActivity {
    private ListView lv;
    private Resources resources;
    private String[] opc;
    private Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        lv=(ListView)findViewById(R.id.lvAreas);
        resources = this.getResources();
        opc = resources.getStringArray(R.array.areas);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,opc);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        in = new Intent(Areas.this,Cuadrado.class);
                        startActivity(in);
                        break;
                    case 1:
                        in = new Intent(Areas.this, Rectangulo.class);
                        startActivity(in);
                        break;
                    case 2:
                        in = new Intent(Areas.this, Triangulo.class);
                        startActivity(in);
                        break;
                    case 3:
                        in = new Intent(Areas.this, Circulo.class);
                        startActivity(in);
                        break;
                }
            }
        });
    }
}

