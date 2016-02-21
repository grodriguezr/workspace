/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.mxgraph.model.mxCell;
import Modelo.ModeloNodo;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class RecorrerNodos {
    public void Preorden(ArrayList<ModeloNodo> listaNodos, ModeloNodo nodo ){
        System.out.println(nodo.getNodo().getId());
    }
    
    enum tipos{
        noRecorrido,
        recorriendo,
        recorrido
    }
    
}
