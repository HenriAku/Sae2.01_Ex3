/**************************
 * @auther Rougeolle Henri
 * @auther Yachir    Yanis
 * @auther Bouquet   Jules
 **************************/
package Ex3.ihm;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Ex3.controleur.*;

public class GrilleDonneesModelR extends AbstractTableModel
{
	private String[]   tabEntetes;

	private Object[][] tabDonnees;

	public GrilleDonneesModelR (Controleur ctrl)
	{
		this.tabDonnees = new Object[15][15];

		//Boucle pour avoir toute les Routes
		for(int i = 0; i<ctrl.getListeRoutes().size(); i++)
		{
			//ajout des donne de la Route ligne par ligne et dans les colonne precise
			this.tabDonnees[i][0] = ctrl.getRoute(i).getNbtroncons();
			this.tabDonnees[i][1] = ctrl.getRoute(i).getVilleD().getNomVille() + "";
			this.tabDonnees[i][2] = ctrl.getRoute(i).getVilleA().getNomVille() + ""; 
		}

		//Tableau pour les noms des colonnes
        this.tabEntetes = new String[] {"Nombre de tronçons", "Ville de départ", "Ville d'arrivée"};
	}
    
	public String[]   getTabEntetes()                  {return tabEntetes;                      } //Retourne le tableau String des nom des Colonne
	public Object[][] getTabDonnees ()                 {return this.tabDonnees;                 } //Retourne un tableau de String (info des Route)
	public int        getColumnCount()                 {return this.tabEntetes.length;          } //Retourne le nombre de colonne
	public int        getRowCount   ()                 {return this.tabDonnees.length;          } //Retourne le nombre de ligne
	public String     getColumnName (int col)          {return this.tabEntetes[col];            } //Retourne le non de la colonne
	public Object     getValueAt    (int row, int col) {return this.tabDonnees[row][col];       } //Retourne l'objet dans le tableau a ligne et collone passer en paramettre
	public Class      getColumnClass(int c)            {return getValueAt(0, c).getClass(); }
}
