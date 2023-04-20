package com.mycompany.proyecto;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class Proyecto {

    public static void main(String[] args) {

        //Se crean las instancias para el llamado de los objetos en el menú
        
        Registro requerimientos = new Registro();
        Registro iteracion = new Registro();
        Registro desarrollador = new Registro();
        Asignacion asignar = new Asignacion();
        Objeto objeto = new Objeto();
        
        //Se realiza la precarga de requerimientos, desarrolladores e iteraciones
        
        Requerimiento requerimiento1 = new Requerimiento(1, "Req1", 3, Estado.Pendiente);
        Requerimiento requerimiento2 = new Requerimiento(2, "Req2", 2, Estado.Pendiente);
        Requerimiento requerimiento3 = new Requerimiento(3, "Req3", 4, Estado.Pendiente);
        Requerimiento requerimiento4 = new Requerimiento(4, "Req4", 1, Estado.Pendiente);
        Requerimiento requerimiento5 = new Requerimiento(5, "Req5", 5, Estado.Pendiente);
        Requerimiento requerimiento6 = new Requerimiento(6, "Req6", 2, Estado.Pendiente);
        Requerimiento requerimiento7 = new Requerimiento(7, "Req7", 4, Estado.Pendiente);
        Desarrollador desarrollador1 = new Desarrollador(1, "Jonathan", "Blanco", "Brenes", 2000);
        Desarrollador desarrollador2 = new Desarrollador(2, "Susana", "Garcia", "Caldero", 3000);
        Desarrollador desarrollador3 = new Desarrollador(3, "Ricardo", "Calderon", "Montiel", 3000);
        Iteracion iteracion1 = new Iteracion(1, 3, Estado.En_Proceso);
        Iteracion iteracion2 = new Iteracion(2, 2, Estado.En_Proceso);

        requerimientos.listadoRequerimientos.add(requerimiento1);
        requerimientos.listadoRequerimientos.add(requerimiento2);
        requerimientos.listadoRequerimientos.add(requerimiento3);
        requerimientos.listadoRequerimientos.add(requerimiento4);
        requerimientos.listadoRequerimientos.add(requerimiento5);
        requerimientos.listadoRequerimientos.add(requerimiento6);
        requerimientos.listadoRequerimientos.add(requerimiento7);
        desarrollador.listadoDesarrolladores.add(desarrollador1);
        desarrollador.listadoDesarrolladores.add(desarrollador2);
        desarrollador.listadoDesarrolladores.add(desarrollador3);
        iteracion.listadoIteraciones.add(iteracion1);
        iteracion.listadoIteraciones.add(iteracion2);

        //Se llama al menú principal y se le pasan como argumentos los objetos necesarias
        menu(requerimientos, iteracion, desarrollador, asignar, objeto);

    }

    public static void menu(Registro requerimientos, Registro iteracion, Registro desarrollador, Asignacion asignar, Objeto objeto) {
        String texto;
        String valido = "x";
        int opcion = 0; 
        int continuar = 1;
        texto = "MENU PRINCIPAL"
                + "\n-----------------------------------------------------------\n"
                + "(1)=> Registro de desarrolladores"
                + "\n(2)=> Registro de requerimientos en Backlog"
                + "\n(3)=> Registro de iteraciones"
                + "\n(4)=> Asignación de trabajo"
                + "\n(5)=> Cierre de una iteración"
                + "\n(6)=> Ver reportes"
                + "\n(7)=> Salir del programa"
                + "\n-----------------------------------------------------------\n";
        while (valido == "x") {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(texto));
                switch (opcion) {
                    case 1 -> {
                        int nuevo = 0;
                        while (nuevo == 0) {
                            if (Desarrollador.numeroDesarrolladores < 5) { //Contador publico en la clase desarrollador
                                desarrollador.agregarDesarrollador(); //llamada al método de agregar desarrollador
                                Desarrollador.numeroDesarrolladores++; //si el desarrollador se agregó correctamente, se suma 1
                            } else {
                                JOptionPane.showMessageDialog(null, "Lo sentimos, no se pueden agregar más desarrolladores");
                                nuevo = 1;
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
                        int nuevo = 0;
                        while (nuevo == 0) {
                            if (Requerimiento.numeroRequerimientos < 50) {
                                requerimientos.agregarRequerimiento(); //llamada al metodo para agregar requerimientos
                                Requerimiento.numeroRequerimientos++; //aumenta el contador, si el registro se realiza correctamente
                            } else {
                                JOptionPane.showMessageDialog(null, "Lo sentimos, no se pueden agregar más requerimientos");
                                nuevo = 1;
                            }
                            nuevo = JOptionPane.showConfirmDialog(null, "Desea agregar otro requerimiento? ");
                            if (nuevo == JOptionPane.NO_OPTION) {
                                nuevo = 1;
                                Requerimiento.numeroRequerimientos = Requerimiento.numeroRequerimientos;
                            } else {
                                nuevo = 0;
                                Requerimiento.numeroRequerimientos = Requerimiento.numeroRequerimientos;
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
                        int nuevo = 0;
                        while (nuevo == 0) {
                            if (Iteracion.numeroIteraciones < 3) {
                                iteracion.agregarIteracion();
                                Iteracion.numeroIteraciones++;
                            } else {
                                JOptionPane.showMessageDialog(null, "Lo sentimos, no se pueden agregar más iteraciones");
                                nuevo = 1;
                            }
                            nuevo = JOptionPane.showConfirmDialog(null, "Desea agregar otra iteración? ");
                            if (nuevo == JOptionPane.NO_OPTION) {
                                nuevo = 1;
                                Iteracion.numeroIteraciones = Iteracion.numeroIteraciones;
                            } else {
                                nuevo = 0;
                                Iteracion.numeroIteraciones = Iteracion.numeroIteraciones;
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
                        asignar.creacionObjeto(requerimientos, iteracion, desarrollador);
                        continuar = JOptionPane.showConfirmDialog(null, "Desea regresar al menú principal? ", "WARNING", JOptionPane.YES_NO_OPTION);
                        if (continuar == JOptionPane.YES_OPTION) {
                            valido = "x";
                        } else {
                            valido = "j";
                        }
                    }
                    case 5 -> {
                        asignar.cierreIteracion(iteracion);
                        continuar = JOptionPane.showConfirmDialog(null, "Desea regresar al menú principal? ", "WARNING", JOptionPane.YES_NO_OPTION);
                        if (continuar == JOptionPane.YES_OPTION) {
                            valido = "x";
                        } else {
                            valido = "j";
                        }
                    }
                    case 6 -> {
                        menuReportes(requerimientos, iteracion, desarrollador, asignar);
                        continuar = JOptionPane.showConfirmDialog(null, "Desea regresar al menú principal? ", "WARNING", JOptionPane.YES_NO_OPTION);
                        if (continuar == JOptionPane.YES_OPTION) {
                            valido = "x";
                        } else {
                            valido = "j";
                        }
                    }
                    
                    case 7 -> {
                        valido = "j";
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

    
    //MENU PARA LA VISUALIZACION DE REPORTES
      public static void menuReportes(Registro requerimientos, Registro iteracion, Registro desarrollador, Asignacion asignar) {
        String texto;
        String valido = "x";
        int opcion = 0; 
        int continuar = 1;
        texto = "VISUALIZACIÓN DE REPORTES"
                + "\n--------------------------------\n"
                + "(1)=> Reporte de los requerimientos"
                + "\n(2)=> Reporte de los desarrolladores"
                + "\n(3)=> Registro de iteraciones"
                + "\n(4)=> Reporte visual de una iteración"
                + "\n(5)=> Reporte de resumen de iteraciones"
                + "\n(6)=> Regresar al menú principal"
                + "\n--------------------------------\n";
        while (valido == "x") {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(texto));
                switch (opcion) {
                    case 1 -> {
                        JOptionPane.showMessageDialog(null, requerimientos.leerRequerimiento());
                        continuar = JOptionPane.showConfirmDialog(null, "Desea regresar al menú? ", "WARNING", JOptionPane.YES_NO_OPTION);
                        if (continuar == JOptionPane.YES_OPTION) {
                            valido = "x";
                        } else {
                            valido = "j";
                        }
                    }
                    case 2 -> {
                        JOptionPane.showMessageDialog(null, desarrollador.leerDesarrollador());
                        continuar = JOptionPane.showConfirmDialog(null, "Desea regresar al menú? ", "WARNING", JOptionPane.YES_NO_OPTION);
                        if (continuar == JOptionPane.YES_OPTION) {
                            valido = "x";
                        } else {
                            valido = "j";
                        }
                    }
                    case 3 -> {
                        JOptionPane.showMessageDialog(null, iteracion.leerIteracion());
                        continuar = JOptionPane.showConfirmDialog(null, "Desea regresar al menú? ", "WARNING", JOptionPane.YES_NO_OPTION);
                        if (continuar == JOptionPane.YES_OPTION) {
                            valido = "x";
                        } else {
                            valido = "j";
                        }
                    }
                    case 4 -> {
                        asignar.visualizacionMatriz(iteracion);
                        continuar = JOptionPane.showConfirmDialog(null, "Desea regresar al menú? ", "WARNING", JOptionPane.YES_NO_OPTION);
                        if (continuar == JOptionPane.YES_OPTION) {
                            valido = "x";
                        } else {
                            valido = "j";
                        }
                    }
                    case 5 -> {
                        asignar.reporteMensual(iteracion);
                        continuar = JOptionPane.showConfirmDialog(null, "Desea regresar al menú? ", "WARNING", JOptionPane.YES_NO_OPTION);
                        if (continuar == JOptionPane.YES_OPTION) {
                            valido = "x";
                        } else {
                            valido = "j";
                        }
                    }
                    
                    case 6 -> {
                        valido = "j";
                        break;
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null, "Error, opción inválida.");
                    }
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error, entrada inválida. Regresando al menú :)");
            }
        }
    }  
 
}
