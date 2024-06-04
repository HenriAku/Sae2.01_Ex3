/**************************
 * Rougeolle Henri
 * Yachir    Yanis
 * Bouquet   Jules
 **************************/

package Ex3.ihm;

import Ex3.controleur.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.LayoutManager;
import java.awt.BorderLayout;

public class FrameRoute extends JFrame 
{
    private GrilleDonneesModelR table;

    private PanelTabRoute panelTabRoute;
    private PanelRoute    panelRoute   ;
    private Controleur    ctrl         ;
    
    private JTable      tblVille       ;
    private JScrollPane spGrilleDonnees;

    public FrameRoute(Controleur ctrl)
    {
        this.setTitle("Ajouter Route");
        this.setLayout(new BorderLayout());

        //creation des composants
        this.ctrl = ctrl;

        this.table         = new GrilleDonneesModelR(ctrl);

        this.panelTabRoute = new PanelTabRoute(ctrl, this);
        this.panelRoute    = new PanelRoute   (ctrl, this);

        //positionnement des composants
        this.add(this.panelRoute   , BorderLayout.CENTER);
        this.add(this.panelTabRoute, BorderLayout.SOUTH );

        this.setResizable(false);
        this.setVisible(true);
        this.pack();
    }

    public Object[][]        getTabDonnees() {return this.table.getTabDonnees ();}
    public void              majTabDonnees() {this.panelTabRoute.majTabDonnees();}
    public DefaultTableModel getTableModel() {return this.panelTabRoute.getTableModel();}
}
