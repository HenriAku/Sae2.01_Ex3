package Ex3.ihm;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Ex3.controleur.*;

public class GrilleDonneesModel extends AbstractTableModel
{
	private String[]   tabEntetes;
	private String[][] tabDonnees;

	//Constructeur , cree le tab avec les donne des villes
	public GrilleDonneesModel (Controleur ctrl)
	{
		this.tabDonnees = new String[100][3];

		//Boucle pour avoir toute les villes
		for(int i = 0; i<ctrl.getListeVille().size(); i++)
		{
			//ajout des donne de la ville ligne par ligne et dans les colonne precise
			tabDonnees[i][0] = ctrl.getVille(i).getNomVille();
			tabDonnees[i][1] = ctrl.getVille(i).getPosX() + "";
			tabDonnees[i][2] = ctrl.getVille(i).getPosY() + ""; 
		}

		//Tableau pour les noms des colonnes
		this.tabEntetes = new String[] {"Nom", "PosX", "PosY"};
	}
    
	public String[]   getTabEntetes()                  {return tabEntetes;                      } //Retourne le tableau String des nom des Colonne
	public String[][] getTabDonnees ()                 {return this.tabDonnees;                 } //Retourne un tableau de String (info des villes)
	public int        getColumnCount()                 {return this.tabEntetes.length;          } //Retourne le nombre de colonne
	public int        getRowCount   ()                 {return this.tabDonnees.length;          } //Retourne le nombre de ligne
	public String     getColumnName (int col)          {return this.tabEntetes[col];            } //Retourne le non de la colonne
	public Object     getValueAt    (int row, int col) {return this.tabDonnees[row][col];       } //Retourne l'objet dans le tableau a ligne et collone passer en paramettre
	public Class      getColumnClass(int c)            {return getValueAt(0, c).getClass(); } 
}