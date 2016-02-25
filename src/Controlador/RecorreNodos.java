package Controlador;

import com.mxgraph.model.mxCell;
import Modelo.ModeloNodo;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class RecorreNodos {

    private boolean flag = false;
    private ModeloNodo aux;

    public void preorden(ArrayList<ModeloNodo> listaNodos, ModeloNodo nodo) {
        if(listaNodos.size() == 1){
            System.out.println(nodo.getNodo().getId());
        }
        else if (flag == false) {
            
            if (nodo.getNodoHijoIzq() != null && nodo.getNodoHijoDer() == null) {
                System.out.println("izquierdo");
                System.out.println(nodo.getNodo().getId());
                nodo.setEstado("recorriendo");
                flag = true;
                preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoHijoIzq()));

            } else if (nodo.getNodoHijoIzq() == null && nodo.getNodoHijoDer() != null) {
                System.out.println("derecho");
                System.out.println(nodo.getNodo().getId());
                nodo.setEstado("recorriendo");
                flag = true;
                preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoHijoDer()));

            }
//                else if (nodo.getNodoHijoIzq() == null && nodo.getNodoHijoDer() == null) {
//                System.out.println(nodo.getNodo().getId());
//                System.out.println("ambos");
//                nodo.setEstado("recorrido");
//            }
        } else if (flag) {
            System.out.println("adas");
            if (nodo.getNodoHijoIzq() != null) {
                if ("no recorrido".equals(buscaNodo(listaNodos, nodo.getNodoHijoIzq()).getEstado())) {
                    System.out.println(nodo.getNodo().getId());
                    nodo.setEstado("recorriendo");
                    preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoHijoIzq()));
                } else if ("recorrido".equals(buscaNodo(listaNodos, nodo.getNodoHijoIzq()).getEstado())) {
                    preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoPadre()));
                }
            } else if (nodo.getNodoHijoDer() != null) {
                if ("no recorrido".equals(buscaNodo(listaNodos, nodo.getNodoHijoDer()).getEstado())) {
                    System.out.println(nodo.getNodo().getId());
                    nodo.setEstado("recorriendo");
                    preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoHijoIzq()));
                } else if ("recorrido".equals(buscaNodo(listaNodos, nodo.getNodoHijoDer()).getEstado())) {
                    preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoPadre()));
                }
            } else if (nodo.getNodoHijoDer() == null && nodo.getNodoHijoIzq() == null) {
                nodo.setEstado("recorrido");
                System.out.println(nodo.getNodo().getId());
            } else if ("recorrido".equals(buscaNodo(listaNodos, nodo.getNodoHijoIzq()).getEstado()) && "recorrido".equals(buscaNodo(listaNodos, nodo.getNodoHijoDer()).getEstado())) {
                if (nodo.getNodoPadre() != null) {
                    nodo.setEstado("recorrido");
                    preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoPadre()));
                }

            }
        }

    }

    public ModeloNodo buscaNodo(ArrayList<ModeloNodo> listaNodos, String id) {
        aux = null;
        for (byte i = 0; i < listaNodos.size(); i++) {
            if (listaNodos.get(i).getNodo().getId().equals(id)) {
                aux = listaNodos.get(i);
            }
        }
        return aux;
    }

}
