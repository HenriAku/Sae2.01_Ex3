/**************************
 * @auther Rougeolle Henri
 * @auther Yachir    Yanis
 * @auther Bouquet   Jules
 **************************/
package Ex3.ihm;
import Ex3.controleur.*;
import Ex3.ihm.PanelCarte;
import javax.swing.*;

import java.awt.Panel;
import java.awt.event.*;
import java.io.File;

public class PanelMap extends JMenuBar implements ActionListener
{
	private Controleur ctrl;
	private JMenuItem menuItemRoute;
	private JMenuItem menuItemVille;
	private JMenuItem menuItemOuvrir;

	public PanelMap(Controleur ctrl)
	{
		this.ctrl = ctrl;

		//Creation des Composant
		this.menuItemRoute  = new JMenuItem("Route" );
		this.menuItemVille  = new JMenuItem("Ville" );
		this.menuItemOuvrir = new JMenuItem("Ouvrir");

		JMenu    menuAjouter  = new JMenu ("Ajouter");
		JMenu    menuFichier  = new JMenu ("Fichier");

		//Ajout dans le menuBar
		menuFichier.add(this.menuItemOuvrir);
		this.add(menuFichier);

		menuAjouter.add(this.menuItemRoute);
		menuAjouter.add(this.menuItemVille);
		this.add(menuAjouter);

		//Activation des composant
		this.menuItemRoute.addActionListener(this);
		this.menuItemVille.addActionListener(this);
		this.menuItemOuvrir.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		//Ouvre la frame Route
		if (e.getSource() == this.menuItemRoute) 
			new FrameRoute(ctrl);

		//Ouvre la frame Ville
		if (e.getSource() == this.menuItemVille)
			new FrameVille(ctrl);

		if (e.getSource() == this.menuItemOuvrir) 
		{
			JFileChooser fenetre = new JFileChooser();
			fenetre.setCurrentDirectory(new File("./"));
			int oui = fenetre.showOpenDialog(this);
			if (oui == JFileChooser.APPROVE_OPTION) 
				//envoie Le chemin d'acces du fichier demander 
				this.ctrl.setFichierImage (  fenetre.getSelectedFile().getAbsolutePath());
		}
	}
}
