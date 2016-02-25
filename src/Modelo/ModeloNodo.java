/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mxgraph.model.mxCell;

/**
 *
 * @author Gustavo
 */
public class ModeloNodo {
    private mxCell nodo;
    private String nombre;
    private String nodoPadre;
    private String nodoHijoIzquierdo;
    private String nodoHijoDerecho;
    private String estado;

    public ModeloNodo(mxCell cell, String nombre, String nodoPadre, String nodoHijoIzquierdo, String nodoHijoDerecho, String estado) {
        this.nodo = cell;
        this.nombre = nombre;
        this.nodoPadre = nodoPadre;
        this.nodoHijoIzquierdo = nodoHijoIzquierdo;
        this.nodoHijoDerecho = nodoHijoDerecho;
        this.estado = estado;
    }

    public ModeloNodo() {
        this.nodo = null;
        this.nombre = null;
        this.nodoPadre = null;
        this.nodoHijoIzquierdo = null;
        this.nodoHijoDerecho = null;
        this.estado = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNodoPadre() {
        return nodoPadre;
    }

    public void setNodoPadre(String nodoPadre) {
        this.nodoPadre = nodoPadre;
    }

    public String getNodoHijoIzq() {
        return nodoHijoIzquierdo;
    }

    public void setNodoHijoIzq(String nodoHijoIzquierdo) {
        this.nodoHijoIzquierdo = nodoHijoIzquierdo;
    }

    public String getNodoHijoDer() {
        return nodoHijoDerecho;
    }

    public void setNodoHijoDer(String nodoHijoDerecho) {
        this.nodoHijoDerecho = nodoHijoDerecho;
    }

    public mxCell getNodo() {
        return nodo;
    }

    public void setNodo(mxCell nodo) {
        this.nodo = nodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
