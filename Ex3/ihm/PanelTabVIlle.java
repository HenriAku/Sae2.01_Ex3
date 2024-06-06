/**************************
 * @auther Rougeolle Henri
 * @auther Yachir    Yanis
 * @auther Bouquet   Jules
 **************************/
package Ex3.ihm;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import Ex3.controleur.*;
import Ex3.metier.*;
import java.awt.BorderLayout;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class PanelTabVille extends JPanel implements ActionListener
{
	private Controleur ctrl ;
	private FrameVille frame;
	private String[]   tabEntete;

	private JTable      tblVille;
    private JScrollPane spGrilleDonnees;
	private DefaultTableModel tableModel;
    private JButton     btnModif;

	public PanelTabVille(Controleur ctrl,FrameVille frame)
	{
        this.setLayout(new BorderLayout());

		//Creation des composants
		this.ctrl 	   = ctrl;
		this.frame 	   = frame;

        this.tableModel      = new DefaultTableModel(this.frame.getTabDonnees(),  this.frame.getTabEntetes());
		this.tblVille        = new JTable     (this.tableModel);
        this.spGrilleDonnees = new JScrollPane( this.tblVille );
        this.tblVille.setFillsViewportHeight(true);
        
        this.btnModif = new JButton("Modifier");
        
		//Positionnement des composants
        this.add(this.spGrilleDonnees, BorderLayout.CENTER);
        this.add(this.btnModif       , BorderLayout.SOUTH );

		//Activation des composants
		this.btnModif.addActionListener(this);
	}

	public int  getLigneSelectioner   (){return this.tblVille.getSelectedRow   ();} //Retourne un int ligne selectionner
	public int  getColonneSelectionner(){return this.tblVille.getSelectedColumn();} //Retourne un int Colonne selectionner

	public DefaultTableModel getTableModel() {return this.tableModel;}
	public void              majTabDonnees() {this.tblVille.setModel(new GrilleDonneesModel(ctrl));}

	public void modifier(Object value, int row, int col) {this.tblVille.setValueAt(value, row, col);}

	//Methode pour modifier PosX et PosY du tableau et met a jour la frame puis ecrit les modif dans le .txt
	public void actionPerformed(ActionEvent a)
	{
		Ville villeSelectionnee = this.ctrl.getVille(this.getLigneSelectioner());

        String posXValue = (String) this.tblVille.getValueAt(this.getLigneSelectioner(), 1);
        int posX = Integer.parseInt(posXValue);
        villeSelectionnee.setPosX(posX);

        String posYValue = (String) this.tblVille.getValueAt(this.getLigneSelectioner(), 2);
        int posY = Integer.parseInt(posYValue);
        villeSelectionnee.setPosY(posY);

        ctrl.majIhm();
        ctrl.ecriture();
	}
}
