/**************************
 * Rougeolle Henri
 * Yachir    Yanis
 * Bouquet   Jules
 **************************/

package Ex3.ihm;
import Ex3.controleur.*;
import javax.swing.*;
public class FrameMap extends JFrame
{
	private Controleur ctrl     ;
	private PanelMap  pannelMap;

	public FrameMap(Controleur ctrl)
	{
		this.setTitle("Map");
		this.setSize(1000,800);

		this.ctrl = ctrl;
		this.pannelMap = new PanelMap(ctrl);

		this.add(pannelMap);
		this.setJMenuBar( pannelMap );


		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
