/**************************
 * @auther Rougeolle Henri
 * @auther Yachir    Yanis
 * @auther Bouquet   Jules
 **************************/

package Ex3.ihm;

import Ex3.controleur.*;
import javax.swing.JPanel;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

public class PanelElement extends JPanel implements ActionListener
{
	private Controleur ctrl;
	private FrameVille fV  ;

	private JLabel lblErreur;
	private JLabel lblNom   ;
	private JLabel lblPosX  ;
	private JLabel lblPosY  ;

	private JTextField txtNom ;
	private JTextField txtPosX;
	private JTextField txtPosY;

	private JButton btnAdd;
	private JButton btnTer;

	public PanelElement(Controleur ctrl, FrameVille fV)
	{
		this.setLayout(new GridLayout(5, 2, 10,10));

		this.ctrl = ctrl;
		this.fV   = fV;

		//Creation des composants
		this.lblErreur = new JLabel();
		this.lblErreur.setForeground(new Color(255, 0, 0)); //ajoute une couleur au text du JLabel

		this.lblNom = new JLabel("Nom :",SwingConstants.RIGHT);
		this.lblNom = new JLabel("Nom :",SwingConstants.RIGHT);
		this.txtNom = new JTextField("Ex : Lyon");

		this.lblPosX = new JLabel("Pos X :",SwingConstants.RIGHT);
		this.txtPosX = new JTextField("[0;1000]");

		this.lblPosY = new JLabel("Pos Y :",SwingConstants.RIGHT);
		this.txtPosY = new JTextField("[0;800]");

		this.btnAdd = new JButton("Ajouter");
		this.btnTer = new JButton("Terminer");

		//positionnement des composants
		this.add(this.lblErreur);
		this.add(new JLabel()  );

		this.add(this.lblNom);
		this.add(this.txtNom);

		this.add(this.lblPosX);
		this.add(this.txtPosX);

		this.add(this.lblPosY);
		this.add(this.txtPosY);

		this.add(this.btnAdd);
		this.add(this.btnTer);

		//activation des composant
		this.btnAdd.addActionListener(this);
		this.btnTer.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.btnAdd) 
		{
			int posX, posY;
			//si une erreu est intercepter un msg d'erreur s'affiche
			try {
				//convertie le text des JLabel en Integer pour avoir les coords
				posX = Integer.parseInt(this.txtPosX.getText());
				posY = Integer.parseInt(this.txtPosY.getText());
				//check si les coords rentre sont correcte
				if (posX < 0 || posX > 1000 || posY < 0 || posY > 800 ) 
				{
					this.lblErreur.setText("PosX ou PosY est Erroné.");
					this.lblErreur.setForeground(new Color(255,0,0));
					//msg d'erreur afficher sur la frame 
				}else if ( this.txtNom.getText().length()==0) //check si le nom est > 0 == a pas de nom de ville
				{
					this.lblErreur.setText("Un des Champs est manquant.");
					this.lblErreur.setForeground(new Color(255,0,0));
				}else if (this.ctrl.villeExiste(this.txtNom.getText())) 
				{
					this.lblErreur.setText("Nom de ville déja utilisée.");
					this.lblErreur.setForeground(new Color(255,0,0));
				}
				else
				{
					//ajoute une ville 
					this.ctrl.ajouterVille(this.txtNom.getText(),posX, posY);
					DefaultTableModel model = this.fV.getTableModel();
					model.addRow(new Object[]{this.txtNom.getText(), posX, posY});
					fV.majTabDonnees(); //met ajour le tableau des villes
					this.lblErreur.setText("");
				}
			} catch (NumberFormatException a) 
			{
				this.lblErreur.setText("Un des Champs est manquant.");
				this.lblErreur.setForeground(new Color(255,0,0));
			}
		}
		
		if (e.getSource() == this.btnTer)
		{
			this.ctrl.ecriture();        //Ajoute les ville dans le fichier .txt
			this.fV.setVisible(false); //Close la frame
			ctrl.majIhm();				 // met a jour la frame ou dessiner les villes
		}
	}
}
