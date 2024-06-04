/**************************
 * Rougeolle Henri
 * Yachir    Yanis
 * Bouquet   Jules
 **************************/

package Ex3.ihm;

import Ex3.controleur.*;
import javax.swing.*;
import java.awt.LayoutManager;
import java.awt.BorderLayout;

public class FrameRoute extends JFrame 
{


    private PanelRoute panelRoute;
    private Controleur ctrl;
    
    private JTable tblVille;
    private JScrollPane spGrilleDonnees;

    public FrameRoute(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setTitle("Ajouter Ville");
        this.setSize(500, 700);

        this.setLayout(new BorderLayout());

        this.panelRoute = new PanelRoute(ctrl);

        this.add(this.panelRoute);
        /*

        this.tblVille = new JTable(tabDonnees, tabEntete);
        this.spGrilleDonnees     = new JScrollPane( this.tblVille );
        this.tblVille.setFillsViewportHeight(true); 
        
        this.add(this.panelElement, BorderLayout.CENTER);
        this.add(this.spGrilleDonnees, BorderLayout.SOUTH);*/
        this.setVisible(true);
    }

}
