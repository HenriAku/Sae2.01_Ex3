
/**************************
 * Rougeolle Henri
 * Yachir    Yanis
 * Bouquet   Jules
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

	private ArrayList<Ville> listeVilles = new ArrayList<>(); // Liste des villes
	private ArrayList<Route> listeRoutes = new ArrayList<>(); // Liste des routes

	public Controleur()
	{
		this.lecture();
		new FrameMap(this);
	}

	// Getteurs
	public Ville getVille(int i) {return listeVilles.get(i);}
	public Route getRoute(int i) {return listeRoutes.get(i);}
	public ArrayList<Ville> getListeVille (){return listeVilles;}
	public ArrayList<Route> getListeRoutes(){return listeRoutes;}

	public void modifierListeVille(String nomVille, Ville ville)
	{
		System.out.println("bbbbb");
		for(int i = 0; i<listeVilles.size(); i++)
		{
			if(listeVilles.get(i).getNomVille().equals(nomVille))
			{
				System.out.println(listeVilles.get(i).getNomVille());
				listeVilles.add(i, ville);
				System.out.println(listeVilles.get(i).getNomVille() + "aaaaaaa");
			}
		}
	}

	public void modifierListeRoute(Ville villeD, Ville villeA, Route route)
	{
		System.out.println("Tets1");
		for(int i = 0; i<listeRoutes.size(); i++)
		{
			if(listeRoutes.get(i).getVilleD().equals(villeD) && listeRoutes.get(i).getVilleD().equals(villeA))
			{
				System.out.println(listeRoutes.get(i).getVilleA() + "Test2");
				listeRoutes.add(i, route);
				System.out.println(listeRoutes.get(i).getVilleA() + "Test3");
			}
		}
	}

	// Ajoute une ville à la liste de villes
	public void lecture()
	{
		try {
			// On lit le fichier Sauvegarde.txt
			Scanner scanner; 
				scanner = new Scanner(new File("./Ex3/controleur/Sauvegarde.txt"));
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
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < listeVilles.size(); i++) {
			System.out.println(listeVilles.get(i));
		}
		for (int i = 0; i < listeRoutes.size(); i++) {
			System.out.println(listeRoutes.get(i));
		}
	}

	// Écrit les données dans le fichier Sauvegarde.txt
	public void ecriture()
	{
		try {
			FileWriter writer = new FileWriter("./Ex3/controleur/Sauvegarde.txt");
			for (int i = 0; i < listeVilles.size(); i++) {
				writer.write(((Ville)listeVilles.get(i)).toString());
			}
			for (int i = 0; i < listeRoutes.size(); i++) {
				writer.write(((Route)listeRoutes.get(i)).toString());
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Ajoute une nouvelle ville à la liste des villes
	public boolean ajouterVille(String nom, int x, int y)
	{
		Ville ville = Ville.CreerVille(nom, x, y);
		if (ville != null) {
			listeVilles.add(ville);
			return true;
		}
		return false;
	}

	// Ajoute une nouvelle route à la liste des routes
	public boolean ajouterRoute(int nbtroncons, Ville villeD, Ville villeA)
	{
		Route route = Route.creerRoute(nbtroncons, villeD, villeA);
		if (route != null) {
			listeRoutes.add(route);
			return true;
		}
		return false;
	}
	

	public static void main(String[] args) 
	{
		new Controleur();
	}
}
