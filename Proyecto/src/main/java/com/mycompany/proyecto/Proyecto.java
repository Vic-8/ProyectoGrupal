
package com.mycompany.proyecto;

import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *     
 * @author victo
 */
public class Proyecto {

    public static void main(String[] args) {
       Registros requerimientos = new Registros();
       Registros iteracion = new Registros();
       Registros desarrollador = new Registros();
       menu(requerimientos, iteracion, desarrollador); 
        
    }
   
    
    public static void menu(Registros requerimientos, Registros iteracion, Registros desarrollador){
        String texto;
        String valido = "x";
        int opcion = 0;
        int continuar=1;
        texto = "MENU PRINCIPAL"
                + "\n--------------------------------\n"
                + "(1)=> Registro de desarrolladores"
                + "\n(2)=> Registro de requerimientos en Backlog"
                + "\n(3)=> Registro de iteraciones."
                + "\n(4)=> Asignación de trabajo."
                + "\n(5)=> Ver reportes"
                + "\n(6)=> Salir del programa";
        while (valido == "x") {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(texto));
                switch (opcion) {
                    case 1 -> {
                        int nuevo=0;
                        while (nuevo==0){
                            if (Desarrollador.numeroDesarrolladores<50){
                                desarrollador.agregarDesarrollador();
                                Desarrollador.numeroDesarrolladores++;
                            } else {
                               JOptionPane.showMessageDialog(null, "Lo sentimos, no se pueden agregar más desarrolladores");
                               nuevo=1; 
                            }
                            nuevo = JOptionPane.showConfirmDialog(null, "Desea agregar otro desarrollador? ");
                            if (nuevo == JOptionPane.NO_OPTION) {
                                nuevo = 1;
                                Desarrollador.numeroDesarrolladores = Desarrollador.numeroDesarrolladores;
                            } else {
                                nuevo = 0;
                                Desarrollador.numeroDesarrolladores = Desarrollador.numeroDesarrolladores;
                            }
                        }
                        continuar = JOptionPane.showConfirmDialog(null, "Desea regresar al menú principal? ", "WARNING", JOptionPane.YES_NO_OPTION);
                        if (continuar == JOptionPane.YES_OPTION) {
                            valido = "x";
                        } else {
                            valido = "j";
                        }
                    }
                    case 2 -> { 
                        int nuevo=0;
                        while (nuevo == 0) {
                            if (Requerimiento.numeroRequerimientos < 50) {
                                requerimientos.agregarRequerimiento();
                                Requerimiento.numeroRequerimientos++;
                            } else {
                                JOptionPane.showMessageDialog(null, "Lo sentimos, no se pueden agregar más requerimientos");
                                nuevo=1;
                            }
                            nuevo = JOptionPane.showConfirmDialog(null, "Desea agregar otro requerimiento? ");
                            if (nuevo == JOptionPane.NO_OPTION) {
                                nuevo = 1;
                                Requerimiento.numeroRequerimientos = Requerimiento.numeroRequerimientos;
                            } else {
                                nuevo = 0;
                                Requerimiento.numeroRequerimientos=Requerimiento.numeroRequerimientos;
                            }
                        }
                        continuar = JOptionPane.showConfirmDialog(null, "Desea regresar al menú principal? ", "WARNING", JOptionPane.YES_NO_OPTION);
                        if (continuar == JOptionPane.YES_OPTION) {
                            valido = "x";
                        } else {
                            valido = "j";
                        }
                    }
                    case 3 -> {
                        int nuevo=0;
                        while (nuevo == 0) {
                            if (Iteracion.numeroIteraciones < 3) {
                                iteracion.agregarIteracion();
                                Iteracion.numeroIteraciones++;
                            } else {
                                JOptionPane.showMessageDialog(null, "Lo sentimos, no se pueden agregar más iteraciones");
                                nuevo=1;
                            }
                            nuevo = JOptionPane.showConfirmDialog(null, "Desea agregar otra iteración? ");
                            if (nuevo == JOptionPane.NO_OPTION) {
                                nuevo = 1;
                                Iteracion.numeroIteraciones=Iteracion.numeroIteraciones;
                            } else {
                                nuevo = 0;
                                Iteracion.numeroIteraciones=Iteracion.numeroIteraciones;
                            }
                        }
                        continuar = JOptionPane.showConfirmDialog(null, "Desea regresar al menú principal? ", "WARNING", JOptionPane.YES_NO_OPTION);
                        if (continuar == JOptionPane.YES_OPTION) {
                            valido = "x";
                        } else {
                            valido = "j";
                        }
                    }
                    case 4 -> {
                        iteracion.leerIteracion();
                        continuar = JOptionPane.showConfirmDialog(null, "Desea regresar al menú principal? ", "WARNING", JOptionPane.YES_NO_OPTION);
                        if (continuar == JOptionPane.YES_OPTION) {
                            valido = "x";
                        } else {
                            valido = "j";
                        }
                    }
                    case 5 -> {
                        continuar = JOptionPane.showConfirmDialog(null, "Desea regresar al menú principal? ", "WARNING", JOptionPane.YES_NO_OPTION);
                        if (continuar == JOptionPane.YES_OPTION) {
                            valido = "x";
                        } else {
                            valido = "j";
                        }
                    }
                    case 6 -> {
                        valido="j";
                        break;
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null, "Error, opción inválida.");
                    }
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error, entrada inválida. Regresando al menú principal :)");
            }
        }
    }
   
}
