@echo off

rem Changer de répertoire
cd  %cd%
cd Ex3

rem Compiler les fichiers Java
javac @compile.list

rem Revenir au répertoire parent
cd ..

rem Exécuter le programme Java
java Ex3.controleur.Controleur

rem Mettre en pause pour voir les résultats
pause