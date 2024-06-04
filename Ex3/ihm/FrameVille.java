/**************************
 * Rougeolle Henri
 * Yachir    Yanis
 * Bouquet   Jules
 **************************/

package Ex3.ihm;

import Ex3.controleur.*;
import javax.swing.*;
import java.awt.GridLayout;

public class FrameVille extends JFrame 
{
    private PanelElement  panelElement ;
    private PanelTabVIlle panelTabVIlle;
    private Controleur    ctrl;

    private String[][] tabDonnees;

    public FrameVille(Controleur ctrl)
    {
        this.setTitle ("Ajouter Ville");
        this.setSize  (500, 700);
        this.setLayout(new GridLayout(2, 1));

        this.ctrl = ctrl;
        this.tabDonnees = new String[15][15];
        
        ajouterTabDonnees();

        this.panelElement  = new PanelElement (ctrl, this);
        this.panelTabVIlle = new PanelTabVIlle(ctrl, this);
        
        this.add(this.panelElement );
        this.add(this.panelTabVIlle);

        this.setVisible(true);
        this.pack();
    }

    public String[][] getTabDonnees() {return tabDonnees;}

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
