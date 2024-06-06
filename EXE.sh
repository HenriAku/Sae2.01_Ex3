#!/bin/bash

# Changer de répertoire vers 'Ex3' (sous-répertoire du répertoire courant)
cd "$(pwd)"
cd Ex3

# Compiler les fichiers Java
javac @compile.list

# Revenir au répertoire parent
cd ..

# Exécuter le programme Java
java Ex3.controleur.Controleur

# Mettre en pause pour voir les résultats (appuyer sur une touche pour continuer)
read -p "Appuyez sur une touche pour continuer..."