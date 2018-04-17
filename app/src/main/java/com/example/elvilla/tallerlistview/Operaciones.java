package com.example.elvilla.tallerlistview;

public class Operaciones {
    private String opera;
    private String dato;
    private String result;

    public Operaciones(String opera, String dato, String result) {
        this.opera = opera;
        this.dato = dato;
        this.result = result;
    }

    public String getOpera() {
        return opera;
    }

    public void setOpera(String opera) {
        this.opera = opera;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void guardar(){
        Informacion.guardar(this);
    }
}


