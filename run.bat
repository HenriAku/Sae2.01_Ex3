@echo off

rem Changer de répertoire vers Ex3
cd %cd%
cd Ex3

rem Compiler les fichiers Java
javac @compile.list

cd ..
rem Exécuter le programme Java
java Ex3.controleur.Controleur

rem Mettre en pause pour voir les résultats
pause