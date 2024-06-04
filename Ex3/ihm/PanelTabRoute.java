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

public class PanelTabRoute extends JPanel implements ActionListener
{
	private Controleur ctrl ;
	private FrameRoute frame;
	private String[]   tabEntete;

	private JButton     btnModif;
      
	private JTable            tblRoute;
    private JScrollPane       spGrilleDonnees;
	private DefaultTableModel tableModel;
    

	public PanelTabRoute(Controleur ctrl,FrameRoute frame)
	{
        this.setLayout(new BorderLayout());

		//Creation des composants
		this.ctrl 	   = ctrl;
		this.frame 	   = frame;
		this.tabEntete = new String[] {"nbTronçons", "Ville Départ", "Ville Arrivé"};

        this.tableModel      = new DefaultTableModel(this.frame.getTabDonnees(), tabEntete);
		this.tblRoute        = new JTable     (this.tableModel);
        this.spGrilleDonnees = new JScrollPane( this.tblRoute );
        this.tblRoute.setFillsViewportHeight(true);
        
        this.btnModif = new JButton("Modifier");
        
		//Positionnement des composants
        this.add(this.spGrilleDonnees, BorderLayout.CENTER);
        this.add(this.btnModif       , BorderLayout.SOUTH );

		//Activation des composants
		this.btnModif.addActionListener(this);
	}

	public int  getLigneSelectioner   (){return this.tblRoute.getSelectedRow   ();}
	public int  getColonneSelectionner(){return this.tblRoute.getSelectedColumn();}

	public DefaultTableModel getTableModel() {return this.tableModel;}
	public void              majTabDonnees() {this.tblRoute.setModel(new GrilleDonneesModelR(ctrl));}

	public void modifier(Object value, int row, int col) {this.tblRoute.setValueAt(value, row, col);}

	public void actionPerformed(ActionEvent a)
	{
		System.out.println(this.tblRoute.getValueAt(0, 0));
		try {
			Scanner scanner; 
					scanner = new Scanner(new File("Ex3/controleur/Sauvegarde.txt"));
					System.out.println("Scan en cours 3");

			int cpt = 0;

			while (scanner.hasNextLine()) 
			{
				String line = scanner.nextLine();
				String[] tabDonnees = line.split("\t");
				System.out.println(line);
				if (!tabDonnees[1].equals(this.tblRoute.getValueAt(cpt++, 0))) 
				{
					for(int i = 0; i<ctrl.getListeVille().size();i++)
					{
						System.out.println(ctrl.getListeVille().get(i).getNomVille());
					}

					System.out.println("aaaaa");
					ctrl.modifierListeVille(tabDonnees[1], Ville.CreerVille(tabDonnees[1],Integer.parseInt(tabDonnees[2]), Integer.parseInt(tabDonnees[3])));
					ctrl.ecriture();

					
					majTabDonnees();			
					return ;
				} 
			}
			scanner.close();
		}
		catch(Exception e){}
	}
}
