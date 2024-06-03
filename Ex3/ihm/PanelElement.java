/**************************
 * Rougeolle Henri
 * Yachir    Yanis
 * Bouquet   Jules
 **************************/

package Ex3.ihm;

import Ex3.controleur.*;
import javax.swing.JPanel;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.event.*;

public class PanelElement extends JPanel implements ActionListener
{
    private Controleur ctrl;
    private FrameVille fV;

    private JLabel lblNom;
    private JLabel lblPosX;
    private JLabel lblPosY;

    private JTextField txtNom;
    private JTextField txtPosX;
    private JTextField txtPosY;;

    private JButton btnAdd;
    private JButton btnTer;

	public PanelElement(Controleur ctrl, FrameVille fV)
    {
        this.ctrl = ctrl;
        this.fV = fV;
        this.setLayout(new GridLayout(4, 2, 10,10));

        //Creation des composants
        this.lblNom = new JLabel("Nom :",SwingConstants.RIGHT);
        this.txtNom = new JTextField("Ex : Lyon");


        this.lblPosX = new JLabel("Pos X :",SwingConstants.RIGHT);
        this.txtPosX = new JTextField("[0;1000]");

        this.lblPosY = new JLabel("Pos Y :",SwingConstants.RIGHT);
        this.txtPosY = new JTextField("[0;800]");

        this.btnAdd = new JButton("Ajouter");
        this.btnTer = new JButton("Terminer");

        //positionnement des composants
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
            this.ctrl.ajouterVille(this.txtNom.getText(),Integer.parseInt(this.txtPosX.getText()), Integer.parseInt(this.txtPosY.getText()));
            this.fV.ajouterTabDonnees();
        }
            
        if (e.getSource() == this.btnTer)
        {
            this.ctrl.ecriture();
            this.fV.setVisible(false);
        }
    }
}
