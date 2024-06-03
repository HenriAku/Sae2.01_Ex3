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

public class FrameVille extends JFrame 
{
    private String[] tabEntete = {"Nom", "PosX", "PosY"};
    private String[][] tabDonnees;

    private PanelElement panelElement;
    private Controleur ctrl;
    
    private JTable tblVille;
    private JScrollPane spGrilleDonnees;

    public FrameVille(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.tabDonnees = new String[15][15];

        ajouterTabDonnees();
        this.setTitle("Ajouter Ville");
        this.setSize(500, 700);
        
        this.setLayout(new BorderLayout());

        this.panelElement = new PanelElement(ctrl, this);
        
        this.tblVille = new JTable(tabDonnees, tabEntete);
        this.spGrilleDonnees     = new JScrollPane( this.tblVille );
        this.tblVille.setFillsViewportHeight(true); 
        
        this.add(this.panelElement, BorderLayout.CENTER);
        this.add(this.spGrilleDonnees, BorderLayout.SOUTH);
        this.setVisible(true);
        this.pack();
    }

    public void ajouterTabDonnees()
    {
        for(int i = 0; i<ctrl.getListeVille().size(); i++)
        {
            tabDonnees[i][0] = ctrl.getVille(i).getNomVille();
            tabDonnees[i][1] = ctrl.getVille(i).getPosX() + "";
            tabDonnees[i][2] = ctrl.getVille(i).getPosY() + ""; 
        }

        //spGrilleDonnees.repaint();
    }
}
