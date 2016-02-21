/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Controlador.ControlNodos;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class Lienzo extends javax.swing.JPanel {

    private GraphDF graph;//objetos necesarios para el uso de la libreria
    private mxGraphComponent graphComponent;//necesario para poder pintar figuras de la libreria sobre el panel
    private boolean creable = false;//esta variable controla la creación de nodos, su estado cambia al presionar el botón "nodo"
    private boolean relacionable = false;//controla si un nodo puede o no puede relacionarse con otro
    private boolean borrable = false;
    private boolean izq = false, der = false;
    private String lado = "";
    private mxCell cel1;//estas dos variables nos ayudarán a generar la relación 
    private mxCell cel2;//entre dos nodos
    private static Lienzo lienzo = null;//instancia de lienzo

    public static Lienzo getLienzo() {//método para generar una instancia de lienzo desde otras clases
        if (lienzo == null) {
            lienzo = new Lienzo();

        }
        return lienzo;
    }

    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
        initComponents();
        graph = new GraphDF();
        graphComponent = new mxGraphComponent(graph);
        this.add(graphComponent);//esto es para que las funciones de esta librería puedan funcionar sobre la clase "Lienzo"
        graphComponent.setSize(663, 535);
        graphComponent.setBackground(Color.white);
        graphComponent.setLocation(0, 0);

        graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {//para saber si hicimos click con el mouse sobre el lienzo
                if (isCreable()) {
                    creaNodo(e.getX(), e.getY());//mandamos como parámetro las coordenadas en X y Y del sitio en que hicimos click con el mouse
                    setCreable(false);//lo hacemos falso para evitar que se sigan creando nodos a medida que hacemos click con el mouse
                } else if (isRelacionable()) {
                    if ((graphComponent.getCellAt(e.getX(), e.getY()) instanceof mxCell)) {
                        if (graphComponent.getCellAt(e.getX(), e.getY()) instanceof mxCell && cel1 == null) {
                            cel1 = (mxCell) graphComponent.getCellAt(e.getX(), e.getY());

                        } else if (graphComponent.getCellAt(e.getX(), e.getY()) instanceof mxCell && cel2 == null) {
                            cel2 = (mxCell) graphComponent.getCellAt(e.getX(), e.getY());

                            if (ControlNodos.getCreaNodos().validaHijos(cel1)) {
                                JOptionPane.showMessageDialog(null, "El nodo ya tiene dos nodos hijos");
                                setRelacionable(false);
                                cel1 = null;
                                cel2 = null;
                            } 
                            else {
                                if (isIzq())
                                    lado = "Izq";
                                else if(isDer())
                                    lado = "Der";
                                ControlNodos.getCreaNodos().relacionarNodos(lado, graph, cel1, cel2, cel1.getValue().toString());
                                setRelacionable(false);
                                cel1 = null;
                                cel2 = null;
                            }
                        }
                    }
                } else if (isBorrable()) {
                    if ((graphComponent.getCellAt(e.getX(), e.getY()) instanceof mxCell)) {
                        cel1 = (mxCell) graphComponent.getCellAt(e.getX(), e.getY());
                        graph.getModel().remove(cel1);
                        ControlNodos.getCreaNodos().borrarNodo(cel1);
                        setBorrable(false);
                    }

                }
            }
        }
        );
    }

    public boolean isCreable() {
        return creable;
    }

    public void setCreable(boolean creable) {
        this.creable = creable;
    }

    public void creaNodo(int x, int y) {
        graph.getModel().beginUpdate();
        ControlNodos.getCreaNodos().crearNodo(graph, x, y);
        graph.getModel().endUpdate();

    }

    public boolean isRelacionable() {
        return relacionable;
    }

    public void setRelacionable(boolean relacionable) {
        this.relacionable = relacionable;
    }

    public boolean isBorrable() {
        return borrable;
    }

    public void setBorrable(boolean borrable) {
        this.borrable = borrable;
    }

    public boolean isIzq() {
        return izq;
    }

    public void setIzq(boolean izq) {
        this.izq = izq;
    }

    public boolean isDer() {
        return der;
    }

    public void setDer(boolean der) {
        this.der = der;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
