/**************************
 * Rougeolle Henri
 * Yachir    Yanis
 * Bouquet   Jules
 **************************/
package Ex3.metier;

import org.w3c.dom.events.MouseEvent;

public class Ville 
{
	public static int nbVille = 0;
	private int numVille;
	
	private String nomVille;

	private int posX;
	private int posY;

	private Route[] tabRoute;
	private int     nbRoutes;

	//Methodes Factory pour verifier les eventuelle erreur avant de cree la ville + retourne la ville
	public static Ville CreerVille(String nomVille, int posX, int posY)
	{
		if(nomVille == null || posX > 1000 && posX < 0 || posY > 800 && posY < 0) 
			return null;
	
		return new Ville(nomVille, posX, posY);
	}

	public static Ville CreerVille(String nomVille, int posX, int posY, int numVille)
	{
		if(nomVille == null || posX > 1000 && posX < 0 || posY > 800 && posY < 0) 
			return null;
	
		return new Ville(nomVille, posX, posY, numVille);
	}


	private Ville(String nomVille, int posX, int posY, int numVille)
	{
		this.nomVille = nomVille;
		this.posX = posX;
		this.posY = posY;
		this.numVille = numVille;
	}

	private Ville(String nomVille, int posX, int posY)
	{
		this.nomVille = nomVille;
		this.posX = posX;
		this.posY = posY;
		this.numVille = ++nbVille;
	}

	//Getteur
	public int    getNumVille() {return numVille;}
	public String getNomVille() {return nomVille;}

	public int getPosX() {return posX;}
	public int getPosY() {return posY;}

	public Route[] getTabRoute() {return tabRoute;}
	public int     getNbRoutes() {return nbRoutes;}

	//Setteur
	public void setPosX(int posX) {this.posX = posX;}
	public void setPosY(int posY) {this.posY = posY;}
	
	//Methodes toString qui retourne une chaine de caractere
	public String toString()
	{
		return "Ville\t" + nomVille + "\t" + posX + "\t" + posY + "\t" + numVille + "\n";
	}



}
