/**************************
 * @auther Rougeolle Henri
 * @auther Yachir    Yanis
 * @auther Bouquet   Jules
 **************************/

package Ex3.ihm;
import Ex3.controleur.*;
import Ex3.metier.*;

import javax.swing.*;

public class FrameMap extends JFrame
{
	private Controleur ctrl     ;
	private PanelMap  pannelMap;
	private PanelCarte panelCarte;

	public FrameMap(Controleur ctrl)
	{
		this.setTitle("Map");
		this.setSize(1105,905);

		this.ctrl = ctrl;
		//Creation des composants
		this.pannelMap  = new PanelMap(ctrl);
		this.panelCarte = new PanelCarte(ctrl);

		//Positionnement des composants
		this.add(panelCarte);  //panel pour le dessin
		this.add(pannelMap );  //panel Pour les menu

		this.setJMenuBar(pannelMap); 

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	//Methodes pour refresh le Panel Carte (le dessin des villes et routes)
	public void majIhm() {panelCarte.majIhm();}
}
