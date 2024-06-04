/**************************
 * Rougeolle Henri
 * Yachir    Yanis
 * Bouquet   Jules
 **************************/
package Ex3.ihm;

import Ex3.controleur.*;
import Ex3.metier.*;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.util.ArrayList;
import java.awt.event.*;

public class PanelRoute extends JPanel implements ActionListener
{
    private Controleur ctrl ;
    private FrameRoute frame;

    private JLabel lblErreur  ;
    private JLabel lblTroncon ;
    private JLabel lblVilleDep;
    private JLabel lblVilleArv;

    private JTextField txtTroncon;
    private JComboBox<String> cbVilleDep;
    private JComboBox<String> cbVilleArv;

    private JButton btnAdd;
    private JButton btnTer;

    private String[] tabNomVille;
    private ArrayList<Ville> listVille;

    public PanelRoute(Controleur ctrl , FrameRoute frame) 
    {
        this.setLayout(new GridLayout(5, 2, 10, 10));

        //Creation des composants
        this.ctrl  = ctrl;
        this.frame = frame;

        // Initialiser le tableau avec la taille correcte
        tabNomVille = new String[ctrl.getListeVille().size()];

        for (int i = 0; i < ctrl.getListeVille().size(); i++) 
        {
            tabNomVille[i] = ctrl.getVille(i).getNomVille();
        }

        this.lblErreur = new JLabel();
        this.lblErreur.setForeground(new Color(255,0,0));

        this.lblTroncon = new JLabel("Nb Tronçons :", SwingConstants.RIGHT);
        this.txtTroncon = new JTextField("]0;10]");

        this.lblVilleDep = new JLabel("Ville Départ :", SwingConstants.RIGHT);
        this.cbVilleDep  = new JComboBox<String>(tabNomVille);

        this.lblVilleArv = new JLabel("Ville Arrivée :", SwingConstants.RIGHT);
        this.cbVilleArv  = new JComboBox<String>(tabNomVille);

        this.btnAdd = new JButton("Ajouter");
        this.btnTer = new JButton("Terminer");

        //Positionnement des composants
        this.add(this.lblErreur);
        this.add(new JLabel());

        this.add(this.lblTroncon);
        this.add(this.txtTroncon);

        this.add(this.lblVilleDep);
        this.add(this.cbVilleDep);

        this.add(this.lblVilleArv);
        this.add(this.cbVilleArv);

        this.add(this.btnAdd);
        this.add(this.btnTer);

        //Activation des composants
        this.btnAdd.addActionListener(this);
        this.btnTer.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.btnAdd)
        {
            //check si il y une erreur ou que le champs n'est pas remplis
            try {
                int nbtroncons = Integer.parseInt(this.txtTroncon.getText());
    
                if (nbtroncons < 0 || nbtroncons > 10) {
                    this.lblErreur.setText("nbtroncons est Erroné.");
                } else {
                    this.lblErreur.setText("Route");
                    //recupere les ville des JcomboBox
                    Ville depart = this.ctrl.getVille(this.cbVilleDep.getSelectedIndex());
                    Ville arrive = this.ctrl.getVille(this.cbVilleArv.getSelectedIndex());  
                    //ajoute la route dans la list de controleur
                    this.ctrl.ajouterRoute(nbtroncons, depart, arrive);
                    //mise a jour de la table des route 
					DefaultTableModel model = this.frame.getTableModel();
					model.addRow(new Object[]{this.txtTroncon.getText(), depart, arrive});
					frame.majTabDonnees();
                }
            } catch (NumberFormatException ex) {
                this.lblErreur.setText("Nombre de tronçons invalide.");
                System.out.println(Integer.parseInt(this.lblTroncon.getText()));
            }
        } 

        if (e.getSource() == this.btnTer)
        {
            this.ctrl.ecriture();
            this.frame.setVisible(false);
        }
    }
}
