/**************************
 * Rougeolle Henri
 * Yachir    Yanis
 * Bouquet   Jules
 **************************/
package Ex3.ihm;

import Ex3.controleur.*;
import Ex3.metier.*;

import javax.swing.JPanel;
import java.awt.GridLayout;
import org.graphstream.algorithm.Toolkit ;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerPipe;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.ui.view.ViewerListener;




public class PanelGraphe extends JPanel
{
    private Controleur ctrl;
    public PanelGraphe(Controleur ctrl) {
        this.ctrl = ctrl;

        Graph graph = new SingleGraph("MyGraph");

        Node node1 = graph.addNode("Node1");
        Node node2 = graph.addNode("Node2");
        Node node3 = graph.addNode("Node3");

        graph.addEdge("Edge1", "Node1", "Node2");
        graph.addEdge("Edge2", "Node2", "Node3");
        graph.addEdge("Edge3", "Node3", "Node1");

        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);

        ViewerPipe viewerPipe = viewer.newViewerPipe();
        viewer.enableAutoLayout();
        viewerPipe.addSink(graph);
        viewerPipe.pump();
    
        setLayout(new GridLayout(1, 1));
        add(viewer.addDefaultView(false));
    }
}
