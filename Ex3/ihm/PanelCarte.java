

/**************************
 * Rougeolle Henri
 * Yachir    Yanis
 * Bouquet   Jules
 **************************/
package Ex3.ihm;

import Ex3.controleur.*;
import Ex3.metier.*;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;



public class PanelCarte extends JPanel
{
    private Controleur ctrl;

    private final int TAILLE_VILLE = 15;
    private final int LARGEUR_ROUTE = 3;

    private final int DECALAGE = 40;

    public PanelCarte(Controleur ctrl) {
        this.ctrl = ctrl;

        this.setSize(1000, 800);

        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //Routes
        g.setColor(Color.BLACK);

        for (Route r : ctrl.getListeRoutes()) {
            int x1 = r.getVilleA().getPosX();
            int y1 = r.getVilleA().getPosY();
            int x2 = r.getVilleD().getPosX();
            int y2 = r.getVilleD().getPosY();
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(LARGEUR_ROUTE));
            g2.drawLine(x1 + DECALAGE, y1 + DECALAGE, x2 + DECALAGE, y2 + DECALAGE);
        }

        //Villes
        g.setColor(Color.BLUE);
        
        for (Ville v : ctrl.getListeVille()) {
            int x = v.getPosX();
            int y = v.getPosY();
            g.fillOval(x + DECALAGE - TAILLE_VILLE/2, y + DECALAGE - TAILLE_VILLE/2, TAILLE_VILLE, TAILLE_VILLE);
        }
        
        //Noms des villes
        g.setColor(Color.BLACK);

        for (Ville v : ctrl.getListeVille()) {
            int x = v.getPosX();
            int y = v.getPosY();
            g.drawString(v.getNomVille(), x + DECALAGE - TAILLE_VILLE / 2, y + DECALAGE - TAILLE_VILLE);
        }

    }
}
