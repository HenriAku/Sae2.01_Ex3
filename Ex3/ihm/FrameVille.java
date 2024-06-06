/**************************
 * @auther Rougeolle Henri
 * @auther Yachir    Yanis
 * @auther Bouquet   Jules
 **************************/

package Ex3.ihm;

import Ex3.controleur.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Ex3.ihm.*;
import java.awt.BorderLayout;

public class FrameVille extends JFrame 
{
	private PanelElement  panelElement ;
	private PanelTabVille panelTabVille;
	private Controleur    ctrl;
	private GrilleDonneesModel table;

	public FrameVille(Controleur ctrl)
	{
		this.setTitle ("Ajouter Ville");
		this.setLayout(new BorderLayout());

		//creation des composants
		this.ctrl = ctrl;
	
		this.table         = new GrilleDonneesModel(ctrl) ;
		this.panelElement  = new PanelElement (ctrl, this);
		this.panelTabVille = new PanelTabVille(ctrl, this);
		
		//positionement des composan
		this.add(this.panelElement ,BorderLayout.CENTER);
		this.add(this.panelTabVille,BorderLayout.SOUTH );

		this.setResizable(false);
		this.setVisible(true);
		this.pack();
	}
	
	public String[]          getTabEntetes() {return this.table.getTabEntetes ();} //Methodes qui retourne un tableau String nom des colonne 
	public Object[][]        getTabDonnees() {return this.table.getTabDonnees ();} //Methode qui retourne un tableau d'objet (info des villes)
    public void              majTabDonnees() {this.panelTabVille.majTabDonnees();} //Methode pour mettre a jour les info du tableau 
    public DefaultTableModel getTableModel() {return this.panelTabVille.getTableModel();}

}
