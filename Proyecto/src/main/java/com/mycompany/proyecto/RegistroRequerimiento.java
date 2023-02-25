/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Ariana
 */
public class RegistroRequerimiento {

    public int idRequerimiento;
    public String nombreRequerimiento;
    public int esfuerzoNecesario;
    public String estado;
    public int nuevo = 0;
    public int numeroRequerimientos = 0;

    public void creacionRequerimiento() {
        while (nuevo == 0) {
            if (numeroRequerimientos <= 50) {
                idRequerimiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de requerimiento: "));
                nombreRequerimiento = JOptionPane.showInputDialog("Ingrese el nombre del requerimiento: ");
                esfuerzoNecesario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el esfuerzo necesario para realizar el requerimiento: "));
                estado = "Pendiente";
                numeroRequerimientos++;
            } else {
                JOptionPane.showMessageDialog(null, "El número de requerimientos llegó a su límite.");
                nuevo = 0;
            }
            nuevo = JOptionPane.showConfirmDialog(null, "Desea agregar otro requerimiento? ");
            if (nuevo == JOptionPane.NO_OPTION) {
                nuevo = 1;
            } else {
                nuevo = 0;
            }
        }

    }

    public RegistroRequerimiento() {

    }

}
