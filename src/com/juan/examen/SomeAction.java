/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.examen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
}
