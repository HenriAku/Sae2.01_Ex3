/**************************
 * Rougeolle Henri
 * Yachir    Yanis
 * Bouquet   Jules
 **************************/
package Ex3.ihm;

import Ex3.controleur.*;
import Ex3.metier.*;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.util.ArrayList;
import java.awt.event.*;

public class PanelRoute extends JPanel implements ActionListener
{
    private Controleur ctrl;

    private JLabel lblTroncon;
    private JLabel lblVilleDep;
    private JLabel lblVilleArv;

    private JTextField txtNom;
    private JComboBox<String> cbVilleDep;
    private JComboBox<String> cbVilleArv;

    private JButton btnAdd;
    private JButton btnTer;

    private String[] tabNomVille;
    private ArrayList<Ville> listVille;

    public PanelRoute(Controleur ctrl) {
        this.ctrl = ctrl;

        // Initialiser le tableau avec la taille correcte
        tabNomVille = new String[ctrl.getListeVille().size()];

        for (int i = 0; i < ctrl.getListeVille().size(); i++) 
        {
            tabNomVille[i] = ctrl.getVille(i).getNomVille();
        }

        this.setLayout(new GridLayout(4, 2, 10, 10));

        this.lblTroncon = new JLabel("Nb Tronçons :", SwingConstants.RIGHT);
        this.txtNom = new JTextField("]0;10]");

        this.lblVilleDep = new JLabel("Ville Départ :", SwingConstants.RIGHT);
        this.cbVilleDep = new JComboBox<>(tabNomVille);

        this.lblVilleArv = new JLabel("Ville Arrivée :", SwingConstants.RIGHT);
        this.cbVilleArv = new JComboBox<>(tabNomVille);

        this.btnAdd = new JButton("Ajouter");
        this.btnTer = new JButton("Terminer");

        this.add(this.lblTroncon);
        this.add(this.txtNom);

        this.add(this.lblVilleDep);
        this.add(this.cbVilleDep);

        this.add(this.lblVilleArv);
        this.add(this.cbVilleArv);

        this.add(this.btnAdd);
        this.add(this.btnTer);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.btnAdd) 
            //this.ctrl.ajouterVille(this.txtNom.getText(),Integer.parseInt(this.txtPosX.getText()), Integer.parseInt(this.txtPosY.getText()));

        if (e.getSource() == this.btnTer)
        {
            this.ctrl.ecriture();
            this.setVisible(false);
        }
    }
}
