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
    public static ControlNodos getCreaNodos() {
        if (cn == null) {
            cn = new ControlNodos();

        }
        return cn;
    }
    public void crearNodo(GraphDF graph, int x, int y){
        mxCell cell = (mxCell) graph.insertVertex(graph.getDefaultParent(), null, "Nodo", (x-25), (y-25), 50, 50, "shape=ellipse;perimter=ellipsePerimeter;fillColor=#C9CCC7;gradientColor=#7E7F7C");
        listaNodos.add(new ModeloNodo(cell, "Nodo", null, null, null));
        cell.setConnectable(false);
    }
    public void relacionarNodos(String nombre, GraphDF graph, mxCell cel1, mxCell cel2, String tipo) {
        graph.insertEdge(graph.getDefaultParent(), null, nombre, cel1, cel2);
    }
}
