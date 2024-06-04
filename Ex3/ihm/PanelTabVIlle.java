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

		this.ctrl  = ctrl;
		this.frame = frame;
		this.tabEntete = new String[] {"Nom", "PosX", "PosY"};

        this.tableModel = new DefaultTableModel(this.frame.getTabDonnees(), tabEntete);
		this.tblVille        = new JTable(this.tableModel);
        this.spGrilleDonnees = new JScrollPane( this.tblVille );
        this.tblVille.setFillsViewportHeight(true);
        
        this.btnModif = new JButton("Modifier");
        
        this.add(this.spGrilleDonnees, BorderLayout.CENTER);
        this.add(this.btnModif, BorderLayout.SOUTH );

		this.btnModif.addActionListener(this);
	}

	public DefaultTableModel getTableModel() {return this.tableModel;}

    public void majTabDonnees()
    {
		this.tblVille.setModel(new GrilleDonneesModel(ctrl));
    }

	public void modifier(Object value, int row, int col)
	{
		this.tblVille.setValueAt(value, row, col);
	}

	public void actionPerformed(ActionEvent a)
	{

		System.out.println(this.tblVille.getValueAt(0, 0));
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
				if (!tabDonnees[1].equals(this.tblVille.getValueAt(cpt++, 0))) 
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

	public int getLigneSelectioner()
	{
		System.out.println(this.tblVille.getSelectedRow());
		return this.tblVille.getSelectedRow();
	}

	public int getColonneSelectionner()
	{
		System.out.println(this.tblVille.getSelectedColumn());
		return this.tblVille.getSelectedColumn();
	}

}
