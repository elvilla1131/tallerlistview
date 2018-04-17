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

public class Volumenes extends AppCompatActivity {
    private ListView lv;
    private Resources resources;
    private String[] opc;
    private Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumenes);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        lv=(ListView)findViewById(R.id.lvVolumenes);
        resources=this.getResources();
        opc=resources.getStringArray(R.array.volumenes);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        in=new Intent(Volumenes.this,Esfera.class);
                        startActivity(in);
                        break;
                    case 1:
                        in=new Intent(Volumenes.this,Cilindro.class);
                        startActivity(in);
                        break;
                    case 2:
                        in = new Intent(Volumenes.this,Cono.class);
                        startActivity(in);
                        break;
                    case 3:
                        in=new Intent(Volumenes.this,Cubo.class);
                        startActivity(in);
                        break;
                }
            }
        });
    }
}
