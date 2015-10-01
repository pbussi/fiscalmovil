package com.example.pablo.miaplicacion;

/**
 * Created by pablo on 20/09/15.
 */
public class Lista {
    //private variables
    int _id;
    String _partido;
    String _lista;
    String _partido_nombre;
    String _lista_nombre;
    String _votos;


    // Empty constructor
    public Lista(){

    }

    public Lista(int _id, String _partido, String _lista, String _partido_nombre, String _partido_nombre1, String _votos) {
        this._id = _id;
        this._partido = _partido;
        this._lista = _lista;
        this._partido_nombre = _partido_nombre;
        _partido_nombre = _partido_nombre1;
        this._votos = _votos;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_partido() {
        return _partido;
    }

    public void set_partido(String _partido) {
        this._partido = _partido;
    }

    public String get_lista() {
        return _lista;
    }

    public void set_lista(String _lista) {
        this._lista = _lista;
    }

    public String get_partido_nombre() {
        return _partido_nombre;
    }

    public void set_partido_nombre(String _partido_nombre) {
        this._partido_nombre = _partido_nombre;
    }

    public String get_votos() {
        return _votos;
    }

    public void set_votos(String _votos) {
        this._votos = _votos;
    }
}
