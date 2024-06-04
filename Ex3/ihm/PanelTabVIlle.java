package Ex3.ihm;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import Ex3.controleur.*;
import java.awt.BorderLayout;

public class PanelTabVille extends JPanel implements ActionListener
{
	private Controleur ctrl ;
	private FrameVille frame;
	private String[]   tabEntete;

	private JTable      tblVille;
    private JScrollPane spGrilleDonnees;
	private DefaultTableModel tableModel;
    private JButton     btnModif;

	public PanelTabVille(Controleur ctrl,FrameVille frame)
	{
        this.setLayout(new BorderLayout());

		this.ctrl  = ctrl;
		this.frame = frame;
		this.tabEntete = new String[] {"Nom", "PosX", "PosY"};

        this.tableModel = new DefaultTableModel(this.frame.getTabDonnees(), tabEntete);
		this.tblVille        = new JTable(this.tableModel);
        this.spGrilleDonnees = new JScrollPane( this.tblVille );
        this.tblVille.setFillsViewportHeight(true);
        
        this.btnModif = new JButton("Modifier");
        
        this.add(this.spGrilleDonnees, BorderLayout.CENTER);
        this.add(this.btnModif, BorderLayout.SOUTH );

		this.btnModif.addActionListener(this);
	}

	public DefaultTableModel getTableModel() {return this.tableModel;}

    public void majTabDonnees()
    {
		this.tblVille.setModel(new GrilleDonneesModel(ctrl));
    }

	public void actionPerformed(ActionEvent e)
	{
		
	}
}
