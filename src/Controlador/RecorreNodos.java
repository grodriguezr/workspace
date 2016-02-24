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
        if (flag == false) {
            System.out.println(nodo.getNodo().getId());
            if ((nodo.getNodoHijoIzquierdo() != null) && "no recorrido".equals(buscaNodo(listaNodos, nodo.getNodoHijoIzquierdo()).getEstado())) {
                nodo.setEstado("recorriendo");
                flag = true;
                preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoHijoIzquierdo()));
            } else if ((nodo.getNodoHijoDerecho() != null) && "no recorrido".equals(buscaNodo(listaNodos, nodo.getNodoHijoDerecho()).getEstado())) {
                nodo.setEstado("recorriendo");
                flag = true;
                preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoHijoDerecho()));
            } else if ((nodo.getNodoHijoIzquierdo() == null) && (nodo.getNodoHijoDerecho() == null)) {
                nodo.setEstado("recorrido");
                flag = true;
            }
        } else if (flag) {
            switch (nodo.getEstado()) {
                case "no recorrido":
                    if (nodo.getNodoHijoIzquierdo() != null) {
                        System.out.println(nodo.getNodo().getId());
                        nodo.setEstado("recorriendo");
                        preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoHijoIzquierdo()));
                    } else if (nodo.getNodoHijoDerecho() != null) {
                        System.out.println(nodo.getNodo().getId());
                        nodo.setEstado("recorriendo");
                        preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoHijoDerecho()));
                    } else if (nodo.getNodoHijoIzquierdo() == null && nodo.getNodoHijoDerecho() == null) {
                        System.out.println(nodo.getNodo().getId());
                        nodo.setEstado("recorrido");
                        preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoPadre()));

                    }
                    break;
                case "recorriendo":
                    if (nodo.getNodoHijoIzquierdo() != null
                            && "recorrido".equals(buscaNodo(listaNodos,
                                            nodo.getNodoHijoIzquierdo()).getEstado())) {
                        nodo.setEstado("recorriendo");
                        System.out.println("izquierdo");
                        preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoHijoDerecho()));
                    } else if (nodo.getNodoHijoDerecho() != null
                            && "recorrido".equals(buscaNodo(listaNodos,
                                            nodo.getNodoHijoDerecho()).getEstado())) {
                        nodo.setEstado("recorriendo");
                        System.out.println("derecho");
                        preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoHijoIzquierdo()));
                    } else if (nodo.getNodoHijoIzquierdo() == null && nodo.getNodoHijoDerecho() == null) {
                        nodo.setEstado("recorrido");
                        System.out.println("nulo");
                        preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoPadre()));

                    } else if ("recorrido".equals(buscaNodo(listaNodos,
                            nodo.getNodoHijoIzquierdo()).getEstado())
                            && "recorrido".equals(buscaNodo(listaNodos,
                                            nodo.getNodoHijoDerecho()).getEstado())) {
                        nodo.setEstado("recorrido");
                        System.out.println("recorrido");
                        preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoPadre()));

                    }
                    break;
                case "recorrido":
                    //preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoPadre()));
                    System.out.println("recorrido");
                    break;

            }
//            if (nodo.getNodoHijoIzquierdo() != null
//                    && "no recorrido".equals(buscaNodo(listaNodos,
//                                    nodo.getNodoHijoIzquierdo()).getEstado())) {
//                System.out.println(nodo.getNodo().getId());
//                nodo.setEstado("recorriendo");
//
//                preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoHijoIzquierdo()));
//            } else if (nodo.getNodoHijoDerecho() != null
//                    && "no recorrido".equals(buscaNodo(listaNodos,
//                                    nodo.getNodoHijoDerecho()).getEstado())) {
//                System.out.println(nodo.getNodo().getId());
//                nodo.setEstado("recorriendo");
//                preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoHijoDerecho()));
//            } else if (nodo.getNodoHijoIzquierdo() == null && nodo.getNodoHijoDerecho() == null) {
//                System.out.println(nodo.getNodo().getId());
//                nodo.setEstado("recorrido");
//                preorden(listaNodos, buscaNodo(listaNodos, nodo.getNodoPadre()));
//
//            }
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
