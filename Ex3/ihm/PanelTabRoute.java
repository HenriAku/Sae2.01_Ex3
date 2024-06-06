/**************************
 * @auther Rougeolle Henri
 * @auther Yachir    Yanis
 * @auther Bouquet   Jules
 **************************/
package Ex3.ihm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Ex3.controleur.*;
import Ex3.metier.*;
import java.awt.BorderLayout;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class PanelTabRoute extends JPanel 
{
	private Controleur ctrl     ;
	private FrameRoute frame    ;
      
	private JTable            tblRoute       ;
    private JScrollPane       spGrilleDonnees;
	private DefaultTableModel tableModel     ;

	public PanelTabRoute(Controleur ctrl,FrameRoute frame)
	{
        this.setLayout(new BorderLayout());

		//Creation des composants
		this.ctrl 	   = ctrl;
		this.frame 	   = frame;

        this.tableModel      = new DefaultTableModel(this.frame.getTabDonnees(), this.frame.getTabEntetes());
		this.tblRoute        = new JTable     (this.tableModel);
        this.spGrilleDonnees = new JScrollPane( this.tblRoute );
        this.tblRoute.setFillsViewportHeight(true);
        
		//Positionnement des composants
        this.add(this.spGrilleDonnees, BorderLayout.CENTER);
	}

	public int  getLigneSelectioner   (){return this.tblRoute.getSelectedRow   ();} //Retourne un int ligne selectionner
	public int  getColonneSelectionner(){return this.tblRoute.getSelectedColumn();} //Retourne un int colonne selectionner

	public DefaultTableModel getTableModel() {return this.tableModel;}
	public void              majTabDonnees() {this.tblRoute.setModel(new GrilleDonneesModelR(ctrl));}

	
}
