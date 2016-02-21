/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloNodo;
import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import java.util.ArrayList;
import Vista.GraphDF;


/**
 *
 * @author Gustavo
 */
public class ControlNodos {

    ArrayList<ModeloNodo> listaNodos = new ArrayList<>();
    private static ControlNodos cn = null;
    private RecorrerNodos rn = null;

    public static ControlNodos getCreaNodos() {
        if (cn == null) {
            cn = new ControlNodos();

        }
        return cn;
    }

    public void crearNodo(GraphDF graph, int x, int y) {
        mxCell cell = (mxCell) graph.insertVertex(graph.getDefaultParent(), null, "Nodo", (x - 25), (y - 25), 50, 50, "shape=ellipse;perimter=ellipsePerimeter;fillColor=#C9CCC7;gradientColor=#7E7F7C");//crea un nodo de forma grafica
        listaNodos.add(new ModeloNodo(cell, "Nodo", null, null, null, null));//crea una nueva instancia de nodo y la agrega a la lista
        cell.setConnectable(false);
    }

    public void relacionarNodos(String lado, GraphDF graph, mxCell cel1, mxCell cel2, String tipo) {
        graph.insertEdge(graph.getDefaultParent(), null, lado, cel1, cel2);//crea la linea de relacion entre dos nodos de forma grafica
        for (byte i = 0; i < listaNodos.size(); i++) {
            if (listaNodos.get(i).getNodo().getId().equals(cel1.getId())) {
                switch (lado) {
                    case "Izq":
                        listaNodos.get(i).setNodoHijoIzquierdo(cel2.getId());
                        for (byte j = 0; j < listaNodos.size(); j++) {
                            if (listaNodos.get(j).getNodo().getId().equals(cel2.getId())) {
                                listaNodos.get(j).setNodoPadre(cel1.getId());
                            }
                        }
                        break;
                    case "Der":
                        listaNodos.get(i).setNodoHijoDerecho(cel2.getId());
                        for (byte j = 0; j < listaNodos.size(); j++) {
                            if (listaNodos.get(j).getNodo().getId().equals(cel2.getId())) {
                                listaNodos.get(j).setNodoPadre(cel1.getId());
                            }
                        }
                        break;
                }
            }
        }
    }

    public void imprimir() {
        for (byte i = 0; i < listaNodos.size(); i++) {
            System.out.println(listaNodos.get(i).getNodo().getValue().toString()
                    + "ID: " + listaNodos.get(i).getNodo().getId() + " IDHijoIzquierdo: "
                    + listaNodos.get(i).getNodoHijoIzquierdo() + " IDHijoDerecho: "
                    + listaNodos.get(i).getNodoHijoDerecho() + " NodoPadre: "
                    + listaNodos.get(i).getNodoPadre());

        }
    }

    public void borrarNodo(mxCell nodo) {
        for (byte i = 0; i < listaNodos.size(); i++) {
            if (nodo.getId().equals(listaNodos.get(i).getNodo().getId())) {
                listaNodos.remove(i);//eliminar el nodo de la lista con el mismo id del nodo que se elimino de forma grafica
            }
        }
    }

    public boolean validaHijos(mxCell nodo) {
        boolean completo = false;
        for (byte i = 0; i < listaNodos.size(); i++) {
            if (listaNodos.get(i).getNodo().getId().equals(nodo.getId())) {
                if ((listaNodos.get(i).getNodoHijoDerecho() != null) && (listaNodos.get(i).getNodoHijoIzquierdo() != null)) {
                    completo = true;
                }
            }
        }
        return completo;
    }

    public void comienzaPreorden() {
        for (byte i = 0; i < listaNodos.size(); i++) {
            if ((listaNodos.get(i).getNodoPadre() == null)
                    && ((listaNodos.get(i).getNodoHijoDerecho() != null)
                    || listaNodos.get(i).getNodoHijoIzquierdo() != null)) {
                rn = new RecorrerNodos();
                rn.Preorden(listaNodos, listaNodos.get(i));
            }else if(listaNodos.size()==1){
                System.out.println(listaNodos.get(i).getNodo().getId());
            }
        }
    }

}
