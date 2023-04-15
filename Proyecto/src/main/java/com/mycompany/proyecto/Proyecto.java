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

        //Creacion instancias 
        Registro requerimientos = new Registro();
        Registro iteracion = new Registro();
        Registro desarrollador = new Registro();
        Asignacion asignar = new Asignacion();

        //Datos precargados
        Requerimiento requerimiento1 = new Requerimiento(1, "Req1", 3, Estado.Pendiente);
        Requerimiento requerimiento2 = new Requerimiento(2, "Req2", 2, Estado.Pendiente);
        Requerimiento requerimiento3 = new Requerimiento(3, "Req3", 4, Estado.Pendiente);
        Requerimiento requerimiento4 = new Requerimiento(4, "Req4", 1, Estado.Pendiente);
        Desarrollador desarrollador1 = new Desarrollador(204, "Francisco", "Araya", "Ramos`", 2000);
        Desarrollador desarrollador2 = new Desarrollador(304, "Paola", "Araya", "Dobles", 3000);
        Iteracion iteracion1 = new Iteracion(1, 3, Estado.En_Proceso);
        Iteracion iteracion2 = new Iteracion(2, 2, Estado.En_Proceso);

        requerimientos.listadoRequerimientos.add(requerimiento1);
        requerimientos.listadoRequerimientos.add(requerimiento2);
        requerimientos.listadoRequerimientos.add(requerimiento3);
        requerimientos.listadoRequerimientos.add(requerimiento4);
        desarrollador.listadoDesarrolladores.add(desarrollador1);
        desarrollador.listadoDesarrolladores.add(desarrollador2);
        iteracion.listadoIteraciones.add(iteracion1);
        iteracion.listadoIteraciones.add(iteracion2);

        //Llamada menu principal
        menu(requerimientos, iteracion, desarrollador, asignar);

    }

    public static void menu(Registro requerimientos, Registro iteracion, Registro desarrollador, Asignacion asignar) {
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
                                desarrollador.agregarDesarrollador();
                                Desarrollador.numeroDesarrolladores++;
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
                                requerimientos.agregarRequerimiento();
                                Requerimiento.numeroRequerimientos++;
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
//                        asignar.asignarObjetoIteracion(asignar, iteracion);
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
