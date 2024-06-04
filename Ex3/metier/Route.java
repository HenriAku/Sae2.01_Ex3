/**************************
 * Rougeolle Henri
 * Yachir    Yanis
 * Bouquet   Jules
 **************************/
package Ex3.metier;

public class Route
{
	private int   nbtroncons;

	private Ville villeD;
	private Ville villeA;

	//Methodes Factory pour verifier les eventuelle erreur avant de cree la route + retourne la route
	public static Route creerRoute(int nbtroncons, Ville villeD, Ville villeA)
	{
		if (nbtroncons <0 && nbtroncons > 10) 
			return null;
		
		return new Route(nbtroncons, villeD, villeA);
	}

	private Route(int nbtroncons, Ville villeD, Ville villeA)
	{
		this.nbtroncons = nbtroncons;
		this.villeD     = villeD;
		this.villeA     = villeA;
	}

	//Getteur
	public int getNbtroncons() {return nbtroncons;}

	public Ville getVilleD() {return villeD;}
	public Ville getVilleA() {return villeA;}

	//Methodes toString qui retourne une chaine de caractere
	public String toString()
	{
		return "Route\t" + nbtroncons + "\t" + villeD.getNumVille() + "\t" + villeA.getNumVille() + "\n";
	}
}