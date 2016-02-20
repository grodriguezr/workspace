/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.view.mxGraph;

/**
 *
 * @author Pc-Romero
 */
public class GraphDF extends mxGraph {

    public GraphDF() {
        super();
    }

    // Ports are not used as terminals for edges, they are
    // only used to compute the graphical connection point
    
//    public boolean isPort(Object cell) {
//        mxGeometry geo = getCellGeometry(cell);
//
//        return (geo != null) ? geo.isRelative() : false;
//    }

    // Implements a tooltip that shows the actual
    // source and target of an edge
    public String getToolTipForCell(Object cell) {
        if (model.isEdge(cell)) {
            //con getTerminal() puedo saber cuales son los nodos
            return convertValueToString(model.getTerminal(cell, true)) + " -> "
                    + convertValueToString(model.getTerminal(cell, false));
        }

        return super.getToolTipForCell(cell);
    }

//     Removes the folding icon and disables any folding
    public boolean isCellFoldable(Object cell, boolean collapse) {
        return false;
    }

//    public void addNodos(mxCell[] cells, mxCell cell) {
//        for (int i = 0; i < cells.length; i++) {
//            this.addCell(cells[i], cell);
//        }
//    }
}
