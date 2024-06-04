/**************************
 * Rougeolle Henri
 * Yachir    Yanis
 * Bouquet   Jules
 **************************/
package Ex3.ihm;
import Ex3.controleur.*;
import Ex3.ihm.PanelGraphe;
import javax.swing.*;

import java.awt.Panel;
import java.awt.event.*;

public class PanelMap extends JMenuBar implements ActionListener
{
	private Controleur ctrl;
	private JMenuItem menuItemRoute;
	private JMenuItem menuItemVille;
	private PanelGraphe panelGraphe;

	public PanelMap(Controleur ctrl)
	{
		this.ctrl = ctrl;

		//Creation des Composant
		this.menuItemRoute = new JMenuItem("Route");
		this.menuItemVille = new JMenuItem("Ville");

		JMenu    menu      = new JMenu   ("Ajouter");

		panelGraphe = new PanelGraphe(ctrl);

		//Ajout dans le menuBar
		menu.add(this.menuItemRoute);
		menu.add(this.menuItemVille);
		this.add(menu);

		//Ajout du panel
		this.add(panelGraphe);

		//Activation des composant
		this.menuItemRoute.addActionListener(this);
		this.menuItemVille.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.menuItemRoute) 
			new FrameRoute(ctrl);

		if (e.getSource() == this.menuItemVille)
			new FrameVille(ctrl);
	}
}
