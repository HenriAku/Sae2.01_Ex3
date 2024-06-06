
/**************************
 * @auther Rougeolle Henri
 * @auther Yachir    Yanis
 * @auther Bouquet   Jules
 **************************/

package Ex3.controleur;

import Ex3.metier.*;
import Ex3.ihm.*;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class Controleur 
{
	private Ville ville;
	private Route route;
	
	private FrameMap fMap;
	private FrameRoute fR;
	private String sFichierImage;

	private ArrayList<Ville> listeVilles = new ArrayList<>(); // Liste des villes
	private ArrayList<Route> listeRoutes = new ArrayList<>(); // Liste des routes

	public Controleur()
	{
		//chemin d'acces de base 
		this.sFichierImage = "./Ex3/controleur/Sauvegarde.txt";
		this.lecture();
		fMap = new FrameMap(this);
	}

	//Methode pour refresh la frame
	public void majIhm(){fMap.majIhm();}

	// Getteurs
	public Ville getVille(int i) {return listeVilles.get(i);}
	public Route getRoute(int i) {return listeRoutes.get(i);}
	public ArrayList<Ville> getListeVille (){return listeVilles;}
	public ArrayList<Route> getListeRoutes(){return listeRoutes;}

	public String getFichierImage(){ return this.sFichierImage;}
	//setteur
	public void   setFichierImage(String fic) 
	{ 
		this.sFichierImage = fic; 
		this.lecture();
		this.ecriture();

		this.majIhm();		
	}

	//Methodes pour modifier la liste des ville 
	public void modifierListeVille(String nomVille, Ville ville)
	{
		for(int i = 0; i<listeVilles.size(); i++)
		{
			//check si dans la list une ville a le meme nom donner en paramettre
			if(listeVilles.get(i).getNomVille().equals(nomVille))
			{
				//enleve de la list et l'ajoute la nouvelle
				listeVilles.remove(i);
				listeVilles.add(i, ville);
			
				return;
			}
		}
	}

	// Methodes pour ajoute une ville à la liste de villes
	public void lecture()
	{
		try {
			// On lit le fichier Sauvegarde.txt
			Scanner scanner; 
				scanner = new Scanner(new File(this.sFichierImage));
				System.out.println("Scan en cours");
				
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] tabDonnees = line.split("\t");

				// En cas de Ville:
				if (tabDonnees[0].equals("Ville")) 
				{
					String nomVille = tabDonnees[1];
					int posX = Integer.parseInt(tabDonnees[2]);
					int posY = Integer.parseInt(tabDonnees[3]);
					
					listeVilles.add(Ville.CreerVille(nomVille, posX, posY)); // Ajoute une nouvelle ville à la liste
				}
				// En cas de Route:
				else if (tabDonnees[0].equals("Route")) 
				{
					int nbtroncons = Integer.parseInt(tabDonnees[1]);
					Ville villeD = (Ville)listeVilles.get(Integer.parseInt(tabDonnees[2]) - 1);
					Ville villeA = (Ville)listeVilles.get(Integer.parseInt(tabDonnees[3]) - 1);
					
					listeRoutes.add(Route.creerRoute(nbtroncons, villeD, villeA)); // Ajoute une nouvelle route à la liste
				}
			}
			scanner.close();
		} 
		catch (FileNotFoundException e) {e.printStackTrace();}
	}

	// methodes pour écrit les données (Liste des Ville et Route) dans le fichier Sauvegarde.txt
	public void ecriture()
	{
		try {
			FileWriter writer = new FileWriter("./Ex3/controleur/Sauvegarde.txt");
			for (int i = 0; i < listeVilles.size(); i++) 
				writer.write(((Ville)listeVilles.get(i)).toString());

			for (int i = 0; i < listeRoutes.size(); i++) 
				writer.write(((Route)listeRoutes.get(i)).toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Ajoute une nouvelle ville à la liste des villes
	public boolean ajouterVille(String nom, int x, int y)
	{
		Ville ville = Ville.CreerVille(nom, x, y);
		if (ville != null) 
		{
			listeVilles.add(ville);
			return true;
		}
		return false;
	}

	// Ajoute une nouvelle route à la liste des routes
	public boolean ajouterRoute(int nbtroncons, Ville villeD, Ville villeA)
	{
		Route route = Route.creerRoute(nbtroncons, villeD, villeA);
		if (route != null) 
		{
			listeRoutes.add(route);
			return true;
		}
		return false;
	}

	public boolean routeExiste(int villeD, int villeA)
    {
        for (int i = 0; i < listeRoutes.size(); i++) 
        {
            if (listeRoutes.get(i).getVilleD().equals(listeVilles.get(villeD)) && listeRoutes.get(i).getVilleA().equals(listeVilles.get(villeA))) 
                return true;
        }
        return false;
    }

	public boolean villeExiste(String nomVille)
    {
        for (int i = 0; i < listeVilles.size(); i++) 
        {
            if (listeVilles.get(i).getNomVille().equals(nomVille)) 
                return true;
        }
        return false;
    }
	
	public static void main(String[] args) 
	{
		new Controleur();
	}
}
