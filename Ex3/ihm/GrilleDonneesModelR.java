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

		for(int i = 0; i<ctrl.getListeRoutes().size(); i++)
		{
			this.tabDonnees[i][0] = ctrl.getRoute(i).getNbtroncons();
			this.tabDonnees[i][1] = ctrl.getRoute(i).getVilleD() + "";
			this.tabDonnees[i][2] = ctrl.getRoute(i).getVilleA() + ""; 
		}

		this.tabEntetes = new String[] {"Nom", "PosX", "PosY"};
	}
    
	public Object[][] getTabDonnees ()                 {return this.tabDonnees;                 }
	public int        getColumnCount()                 {return this.tabEntetes.length;          }
	public int        getRowCount   ()                 {return this.tabDonnees.length;          }
	public String     getColumnName (int col)          {return this.tabEntetes[col];            }
	public Object     getValueAt    (int row, int col) {return this.tabDonnees[row][col];       }
	public Class      getColumnClass(int c)            {return getValueAt(0, c).getClass(); }
}
