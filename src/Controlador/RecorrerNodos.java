package Controlador;

import com.mxgraph.model.mxCell;
import Modelo.ModeloNodo;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class RecorrerNodos {

    private boolean flag = false;
    private ModeloNodo aux;
    public void preorden(ArrayList<ModeloNodo> listaNodos, ModeloNodo nodo) {
        if (flag == false) {
            System.out.println(nodo.getNodo().getId());
            if (nodo.getNodoHijoIzquierdo() != null) {
                nodo.setEstado("recorriendo");
                preorden(listaNodos, nodo);
                flag = true;
            } else if (nodo.getNodoHijoDerecho() != null) {
                nodo.setEstado("recorriendo");
                preorden(listaNodos, nodo);
                flag = true;
            } else if ((nodo.getNodoHijoIzquierdo() == null) && (nodo.getNodoHijoDerecho() == null)) {
                nodo.setEstado("recorrido");
            }
        } else if (flag) {
            for (byte i = 0; i < listaNodos.size(); i++) {

            }
        }

    }
    public ModeloNodo buscaNodo(ArrayList<ModeloNodo> listaNodos, String id){
        aux = null;
        for(byte i = 0; i<listaNodos.size(); i++){
            if(listaNodos.get(i).getNodo().getId().equals(id)){
                //aux =  new ModeloNodo();
                aux = listaNodos.get(i);
            }
        }
        return aux;
    }

}
