/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.examen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "com.juan.examen.SomeAction"
)
@ActionRegistration(
        iconBase = "com/juan/examen/icono.png",
        displayName = "#CTL_SomeAction"
)
@ActionReference(path = "Toolbars/File",position = 0)
@Messages("CTL_SomeAction=Examen")
public final class SomeAction implements ActionListener {
    /**
     * Em este metodo se piden todos los datos necesarios para la creacion de un instalador de un programa de java
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            
            String sistema=JOptionPane.showInputDialog("Para windows introduce exe y para linux deb");
            String categoria=JOptionPane.showInputDialog("Introduce la categoria donde se organizará");
            String carpetaSalida=JOptionPane.showInputDialog("Introduce la ruta de la carpeta de salida");
            String nombreSalida=JOptionPane.showInputDialog("Nombre del instalador");
            String dist=JOptionPane.showInputDialog("Introduce la ruta de la carpeta dist");
            String nombreJar=JOptionPane.showInputDialog("Introduce el nombre de el archivo .jar");
            String claseMain=JOptionPane.showInputDialog("Introduce el nombre completo de la clase main del proyecto");
            String nombre=JOptionPane.showInputDialog("Introduce el nombre");
            String titulo=JOptionPane.showInputDialog("Introduce el titulo");
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("javapackager "
                    + "-deploy "
                    + "-native "+sistema+" -Bcategory="+categoria+" "
                    + "-outdir "+carpetaSalida+" "
                    + "-outfile "+nombreSalida+" "
                    + "-srcdir "+dist+" "
                    + "-srcfiles "+nombreJar+" "
                    + "-appclass "+claseMain+" "
                    + "-name "+nombre+" "
                    + "-title "+titulo);

            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line = null;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
