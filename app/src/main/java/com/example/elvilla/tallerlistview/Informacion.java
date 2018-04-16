package com.example.elvilla.tallerlistview;

import java.util.ArrayList;


public class Informacion {
    private static ArrayList<Operaciones> operacion = new ArrayList<>();

    public static void guardar(Operaciones o) { operacion.add(o); }

    public static ArrayList<Operaciones> getOperaciones() {return operacion;}
}
