/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ariana
 */
public class Asignacion {

    //Llamado de otras clases
    Registro registro = new Registro();
    ArrayList<Objeto> listadoAsignacion = new ArrayList();

    //Creacion de la matriz
    Objeto objeto = new Objeto();
    Asignacion[][] matriz;
    Iteracion arreglo = new Iteracion();
    //Creacion del objeto complejo
    public void creacionObjeto(Registro requerimiento, Registro iteracion, Registro desarrollador) {

        String valido = "x";
        int opcion = 0;
        int continuar = 1;
        boolean validar = false;

        while (validar == false) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, requerimiento.leerRequerimiento() + "\nSeleccione el requerimiento que desea asignar: "));
            for (int i = 0; i < requerimiento.listadoRequerimientos.size(); i++) {
                if (opcion == requerimiento.listadoRequerimientos.get(i).getIdRequerimiento()) {
                    objeto.setRequerimiento(requerimiento.listadoRequerimientos.get(i).getIdRequerimiento()); //Setea el requerimiento en el objeto
                    requerimiento.listadoRequerimientos.get(i).setEstado(Estado.En_Desarollo); //cambia el estado del requerimiento a En Desarrollo
                    validar = true;
                    break;
                }
            }

            if (validar == false) {
                JOptionPane.showMessageDialog(null, "No existe ningún requerimiento asociado a ese ID");
            }
        }

        if (validar == true) {
            while (valido == "x") {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione el desarrollador: \n" + desarrollador.leerDesarrollador()));
                for (int i = 0; i < desarrollador.listadoDesarrolladores.size(); i++) {
                    if (opcion == desarrollador.listadoDesarrolladores.get(i).getIdDesarrollador()) {
                        objeto.setDesarrollador(desarrollador.listadoDesarrolladores.get(i).getSiglasDesarrollador()); //setea las siglas del desarrollador en el objeto
                        valido = "j";
                        validar = false;
                        break;
                    } 
                }
                
              if (valido == "x") {
                JOptionPane.showMessageDialog(null, "No existe ningún desarrollador asociado a ese ID");
            }  
            }
        }

//        if (validar == true) {
//            while (validar == true) {
//                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione un desarrollador: \n" + desarrollador.leerDesarrollador()));
//                for (int i = 0; i < desarrollador.listadoDesarrolladores.size(); i++) {
//                    if (opcion == desarrollador.listadoDesarrolladores.get(i).getIdDesarrollador()) {
//                        objeto.setDesarrollador(desarrollador.listadoDesarrolladores.get(i).getSiglasDesarrollador());
//                        valido = "j";
//                        validar = false;
//                    } 
//                }
//            if (validar==true){
//                JOptionPane.showMessageDialog(null, "No existe ningún desarrollador asociado a ese ID");
//            }
//            }
//        }

//        listadoAsignacion.add(objeto);

        for (int i = 0; i < listadoAsignacion.size(); i++) {
            JOptionPane.showMessageDialog(null, "Desarrollador: " + listadoAsignacion.get(i).getDesarrollador() + "\n"
                    + "Requerimiento asignado: " + listadoAsignacion.get(i).getRequerimiento());
        }

    }
    
    public void asignarObjetoIteracion(Asignacion asignar, Registro iteracion){
        //Asignarlo a la iteracion
        int opcion = 0;
        int dia = 0;
        int semanas = 0;
        boolean validar = false;

        while (validar == false) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, iteracion.leerIteracion() + "\nSeleccione la iteración: "));
            for (int i = 0; i < iteracion.listadoIteraciones.size(); i++) {
                if (opcion == iteracion.listadoIteraciones.get(i).getIdIteracion()) { //Si la iteracion existe, preguntar por el dia que quiere empezar
                    semanas = iteracion.listadoIteraciones.get(i).getCantidadaSemanas();
                    validar = true;
                    break;
                }
            }
        if (validar==true){
            String almacenar="";
            for (int i = 0; i < semanas; i++) {
                almacenar+="Semana "+i+"\n";
            }
            opcion=Integer.parseInt(JOptionPane.showInputDialog("Seleccione la semana en la que desea iniciar el requerimiento: \n"+almacenar));
            while (opcion<=semanas){
                dia = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el dia en el que desea iniciar el requerimiento: \n0. Lunes \n1. Martes \n2. Miércoles \n3. Jueves \n4. Viernes"));
                if (arreglo.getArrObjetos()[semanas][dia]==null){
                    listadoAsignacion.add(asignar.objeto);
                    arreglo.setArrObjetos(semanas, dia);
                }
            }

        }
        }
        
        //Preguntarle al user que semana y dia desea empezar
        
        
    }
}
