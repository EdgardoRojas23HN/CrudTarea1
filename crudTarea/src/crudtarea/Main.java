/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudtarea;
import crudtarea.utilities.Layout;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Main {
    // TODO code application logic here
       
        Layout.printHeader("Crud Tarea 1 ");
        String OpcionMenu = "";
        
        Scanner entradaTeclado = new Scanner(System.in);
        
        Aplicacion crudTarea = new Aplicacion(entradaTeclado);
        
        while (!(OpcionMenu.toUpperCase().equals("S"))) {
            Layout.printMenu();
            OpcionMenu = entradaTeclado.nextLine();

            System.out.println("Texto ingresado es igual a " + OpcionMenu);
           
            musicApp.activarEvento(OpcionMenu);
    
}
