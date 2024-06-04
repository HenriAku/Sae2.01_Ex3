package Ex3.ihm;
import javax.swing.*;
import java.awt.event.*;
import Ex3.controleur.*;
import java.awt.GridLayout;

public class PanelTabVIlle extends JPanel implements ActionListener
{
	private Controleur ctrl ;
	private FrameVille frame;
	private String[]   tabEntete;

	private JTable      tblVille;
    private JScrollPane spGrilleDonnees;
    private JButton     btnModif;

	public PanelTabVIlle(Controleur ctrl,FrameVille frame)
	{
        this.setLayout(new GridLayout(2, 1));

		this.ctrl  = ctrl;
		this.frame = frame;
		this.tabEntete = new String[] {"Nom", "PosX", "PosY"};


		this.tblVille        = new JTable(this.frame.getTabDonnees(), tabEntete);
        this.spGrilleDonnees = new JScrollPane( this.tblVille );
        this.tblVille.setFillsViewportHeight(true);
        
        this.btnModif = new JButton("Modifier");
        
        this.add(this.spGrilleDonnees);
        this.add(this.btnModif);

		this.btnModif.addActionListener(this);
	}



	public void actionPerformed(ActionEvent e)
	{

	}
}
