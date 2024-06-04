package Ex3.ihm;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Ex3.controleur.*;

public class GrilleDonneesModel extends AbstractTableModel
{


	private String[]   tabEntetes;
	private String[][] tabDonnees;

	public GrilleDonneesModel (Controleur ctrl)
	{

		this.tabDonnees = new String[15][15];

		for(int i = 0; i<ctrl.getListeVille().size(); i++)
		{
			tabDonnees[i][0] = ctrl.getVille(i).getNomVille();
			tabDonnees[i][1] = ctrl.getVille(i).getPosX() + "";
			tabDonnees[i][2] = ctrl.getVille(i).getPosY() + ""; 
		}

		this.tabEntetes = new String[]   {   "Nom"  , "PosX"     , "PosY"};

	}

	public int    getColumnCount()                 { return this.tabEntetes.length;      }
	public int    getRowCount   ()                 { return this.tabDonnees.length;      }
	public String getColumnName (int col)          { return this.tabEntetes[col];        }
	public Object getValueAt    (int row, int col) { return this.tabDonnees[row][col];   }
	public Class  getColumnClass(int c)            { return getValueAt(0, c).getClass(); }

}