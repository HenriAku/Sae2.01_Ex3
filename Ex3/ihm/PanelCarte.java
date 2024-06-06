/**************************
 * @author Rougeolle Henri
 * @author Yachir    Yanis
 * @author Bouquet   Jules
 **************************/
package Ex3.ihm;

import Ex3.controleur.*;
import Ex3.metier.*;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PanelCarte extends JPanel implements MouseListener, MouseMotionListener
{
    private final int TAILLE_VILLE  = 15;
    private final int LARGEUR_ROUTE = 3 ;
    private final int DECALAGE      = 40;

    private Controleur ctrl;
    private Ville      villeSelectionnee;

    public PanelCarte(Controleur ctrl) 
    {
        this.setSize(1050, 850);

        this.ctrl = ctrl;
        this.villeSelectionnee = null;

        this.addMouseListener      (this);
        this.addMouseMotionListener(this);

        this.setVisible(true);
    }

    //Methode pour mettre a jour le panel
    public void majIhm(){repaint();}

    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        
        //Routes
        g.setColor(Color.BLACK);

        for (Route r : ctrl.getListeRoutes()) 
        {
            Graphics2D g2 = (Graphics2D) g;
            
            double distance = Math.sqrt(Math.pow(r.getVilleA().getPosX() - r.getVilleD().getPosX(), 2) + Math.pow(r.getVilleA().getPosY() - r.getVilleD().getPosY(), 2));

            double tailleSegment = distance / (r.getNbtroncons() * 2 - 1);

            float[] pattern = {(float) tailleSegment, (float) tailleSegment};

            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, pattern, 0.0f));

            g2.drawLine(r.getVilleD().getPosX() + DECALAGE + LARGEUR_ROUTE/2, r.getVilleD().getPosY() + DECALAGE + LARGEUR_ROUTE/2,
                        r.getVilleA().getPosX() + DECALAGE + LARGEUR_ROUTE/2, r.getVilleA().getPosY() + DECALAGE + LARGEUR_ROUTE/2);
        }

        //Villes
        g.setColor(Color.BLUE);
        
        //Prend les coords d'une ville pour la positioner sur la frame
        for (Ville v : ctrl.getListeVille()) {
            int x = v.getPosX();
            int y = v.getPosY();
            g.fillOval(x + DECALAGE - TAILLE_VILLE/2, y + DECALAGE - TAILLE_VILLE/2, TAILLE_VILLE, TAILLE_VILLE);
        }
        
        //Noms des villes
        g.setColor(Color.BLACK);

        //Prend les coords des ville pour placer les nom des villes au dessus
        for (Ville v : ctrl.getListeVille()) {
            int x = v.getPosX();
            int y = v.getPosY();
            g.drawString(v.getNomVille(), x + DECALAGE - TAILLE_VILLE / 2, y + DECALAGE - TAILLE_VILLE);
        }

    }
    
    public void mousePressed(MouseEvent e) 
    {
        int x = e.getX() - DECALAGE;
        int y = e.getY() - DECALAGE;

        for (Ville v : ctrl.getListeVille()) 
        {
            if (Math.abs(v.getPosX() - x) <= TAILLE_VILLE / 2 && Math.abs(v.getPosY() - y) <= TAILLE_VILLE / 2) 
            {
                villeSelectionnee = v;
                break;
            }
        }
    }

    public void mouseDragged(MouseEvent e) 
    {
        if (villeSelectionnee != null) 
        {
            villeSelectionnee.setPosX(e.getX() - DECALAGE);
            villeSelectionnee.setPosY(e.getY() - DECALAGE);
            ctrl.majIhm();
        }
    }

    public void mouseReleased(MouseEvent e) 
    {
        if (villeSelectionnee != null)
            ctrl.ecriture();
        villeSelectionnee = null;
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited (MouseEvent e) {}
    public void mouseMoved  (MouseEvent e) {}
}
