/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Ariana
 */
public class Asignacion {

    //crear contador asignaciones para las posiciones
    public static int contadorElementos = 0;

    //Llamado de otras clases
    Registro registro = new Registro();
    //ArrayList<Objeto> listadoAsignacion = new ArrayList();
    ArrayList<Objeto> listadoAsignacion = new ArrayList();

    //Creacion de la matriz
    //Creacion del objeto complejo
    public void creacionObjeto(Registro requerimiento, Registro iteracion, Registro desarrollador) {

        //variables
        Objeto objeto = new Objeto();
        String valido = "x";
        int opcion = 0;
        int continuar = 1;
        int dia = 0;
        int posicionIteracion = 0;
        int semanas = 0;
        int esfuerzoNecesario = 0;
        int diaInicial = 0;
        boolean validarRequerimiento = false;
        boolean validarDesarrollador = true;
        boolean existe = false;
        boolean vacio = false;
        boolean asignado = true;

        //VALIDACIONES
        //1 Seleccion requerimiento
        while (validarRequerimiento == false) {
            validarDesarrollador = true;
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, requerimiento.leerRequerimiento() + "\nSeleccione el requerimiento que desea asignar: "));
            for (int i = 0; i < requerimiento.listadoRequerimientos.size(); i++) {
                if (opcion == requerimiento.listadoRequerimientos.get(i).getIdRequerimiento()) {
                    existe = true;
                    if (requerimiento.listadoRequerimientos.get(i).getEstado() == Estado.Pendiente) { //VALIDA EL ESTADO DEL REQUERIMIENTO
                        objeto.setRequerimiento(requerimiento.listadoRequerimientos.get(i));
                        requerimiento.listadoRequerimientos.get(i).setEstado(Estado.En_Desarollo);
                        validarRequerimiento = true;
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Lo sentimos, el requerimiento ya ha sido asignado.");
                        validarRequerimiento = false;
                        validarDesarrollador = false;
                        valido = "j";
                    }
                }
            }
            if (existe == false) {
                JOptionPane.showMessageDialog(null, "No existe ningún requerimiento asociado a ese ID");
                validarRequerimiento = false;
            }

            //2 SELECCION DE LA ITERACION
            while (validarDesarrollador == true) {
                validarDesarrollador = true;
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, iteracion.leerIteracion() + "\nSeleccione la iteración: "));
                for (int i = 0; i < iteracion.listadoIteraciones.size(); i++) {
                    if (opcion == iteracion.listadoIteraciones.get(i).getIdIteracion()) {
                        existe = false;
                        if (iteracion.listadoIteraciones.get(i).getEstado() != Estado.Finalizado) {
                            existe = false;
                            semanas = iteracion.listadoIteraciones.get(i).getCantidadaSemanas();
                            posicionIteracion = i;
                            validarDesarrollador = false;
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Lo sentimos, la iteración seleccionada ya ha sido cerrada");
                            validarDesarrollador = false;
                            validarRequerimiento = false;
                            objeto.getRequerimiento().setEstado(Estado.Pendiente);
                        }
                    }
                }
                if (existe == true) {
                    JOptionPane.showMessageDialog(null, "Lo sentimos, no existe ninguna iteración asignada al ID ingresado.");
                    validarDesarrollador = true;
                }

                if (validarDesarrollador == false) {
                    validarRequerimiento = true;
                    String almacenar = "";
                    for (int i = 0; i < semanas; i++) {
                        almacenar += "Semana " + i + "\n";
                    }
                    while (valido == "x") {
                        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la semana en la que desea iniciar el requerimiento: \n" + almacenar));
                        if (opcion <= semanas) {
                            dia = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el dia en el que desea iniciar el requerimiento: \n0. Lunes \n1. Martes \n2. Miércoles \n3. Jueves \n4. Viernes"));
                            asignarDesarrollador(desarrollador, objeto);
                            if (validarDiasDisponibles(iteracion, posicionIteracion, opcion, dia, objeto) >= objeto.getRequerimiento().getEsfuerzoNecesario()) {
                                if (validarListadoAsignacion(iteracion, posicionIteracion, opcion, dia, objeto) == false) {
                                    esfuerzoNecesario = dia + objeto.getRequerimiento().getEsfuerzoNecesario();
                                    if (validarDias(iteracion, objeto, dia, opcion, posicionIteracion) == true) {
                                        contadorElementos = 0;
                                        if (dia < objeto.getRequerimiento().getEsfuerzoNecesario()) {
                                            while (dia < objeto.getRequerimiento().getEsfuerzoNecesario()) {
                                                iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia] = new Asignacion();
                                                iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia].listadoAsignacion.add(contadorElementos, objeto);
                                                if (dia > 4) {
                                                    opcion++;
                                                    dia = 0;
                                                }
                                                dia++;
                                            }
                                        } else if (dia >= objeto.getRequerimiento().getEsfuerzoNecesario()) {
                                            while (dia < esfuerzoNecesario) {
                                                if (dia > 4) {
                                                    opcion++;
                                                    esfuerzoNecesario = esfuerzoNecesario - dia;
                                                    dia = 0;
                                                }
                                                iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia] = new Asignacion();
                                                iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia].listadoAsignacion.add(contadorElementos, objeto);

                                                dia++;
                                            }
                                        }
                                        contadorElementos++;
                                        valido = "j";
                                        //validar = false;
                                    } else {
                                        diaInicial = dia;
                                        for (int i = 0; i < objeto.getRequerimiento().getEsfuerzoNecesario(); i++) {
                                            if (diaInicial>4){
                                                opcion++;
                                                diaInicial=0;
                                            }
                                            if (iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][diaInicial].listadoAsignacion.get(0).getDesarrollador() != objeto.getDesarrollador()) {
                                                asignado = false;
                                            } else {
                                                asignado = true;
                                            }
                                            if (iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][diaInicial].listadoAsignacion.size() == 2) {
                                                if (iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][diaInicial].listadoAsignacion.get(1).getDesarrollador() != objeto.getDesarrollador()
                                                        || iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][diaInicial].listadoAsignacion.get(1).getDesarrollador() == null) {
                                                    asignado = false;
                                                } else {
                                                    asignado = true;
                                                }
                                            } else if (iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][diaInicial].listadoAsignacion.size() > 2) {
                                                for (int j = 1; j < 3; j++) {
                                                    if (iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][diaInicial].listadoAsignacion.get(j).getDesarrollador() != objeto.getDesarrollador()
                                                            || iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][diaInicial].listadoAsignacion.get(j).getDesarrollador() == null) {
                                                        asignado = false;
                                                    } else {
                                                        asignado = true;
                                                    }
                                                }

                                            }
                                        }

                                        diaInicial++;
                                    }

                                    if (asignado == false) {
                                        if (dia < objeto.getRequerimiento().getEsfuerzoNecesario()) {
                                            while (dia < objeto.getRequerimiento().getEsfuerzoNecesario()) {
                                                if (iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia] == null) {
                                                    iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia] = new Asignacion();
                                                    iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia].listadoAsignacion.add(objeto);
                                                } else {
                                                    iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia].listadoAsignacion.add(objeto);
                                                }
                                                dia++;
                                            }
                                            valido = "j";
                                        } else if (dia >= objeto.getRequerimiento().getEsfuerzoNecesario()) {
                                            for (int i = 0; i < objeto.getRequerimiento().getEsfuerzoNecesario(); i++) {
                                                if (dia > 4) {
                                                    opcion++;
                                                    dia = 0;
                                                }
                                                if (iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia] == null) {
                                                    iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia] = new Asignacion();
                                                    iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia].listadoAsignacion.add(objeto);
                                                } else {
                                                    iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia].listadoAsignacion.add(objeto);
                                                }
                                                dia++;
                                            }
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Lo sentimos este desarrollador ya fue asignado");
                                        valido = "j";
                                        validarDesarrollador = true;
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Lo sentimos, no se pueden agregar más requerimientos en este día. Porfavor, seleccione otro día.");
                                    valido = "x";
                                    validarDesarrollador = false;

                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Lo sentimos, no hay espacio suficiente para asignar el requerimiento. Por favor seleccione otra iteración.");
                                validarDesarrollador = true;
                            }
                        }
                    }
                }
            }
        }
    }

    public void asignarDesarrollador(Registro desarrollador, Objeto objeto) {
        String valido = "x";
        int opcion = 0;
        while (valido == "x") {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione el desarrollador: \n" + desarrollador.leerDesarrollador()));
            for (int i = 0; i < desarrollador.listadoDesarrolladores.size(); i++) {
                if (opcion == desarrollador.listadoDesarrolladores.get(i).getIdDesarrollador()) {
                    objeto.setDesarrollador(desarrollador.listadoDesarrolladores.get(i)); //setea las siglas del desarrollador en el objeto
                    valido = "j";
                    break;
                }
            }

            if (valido == "x") {
                JOptionPane.showMessageDialog(null, "No existe ningún desarrollador asociado a ese ID");
            }
        }
    }//PERMITE ASIGNAR EL DESARROLLADOR

    public boolean validarDias(Registro iteracion, Objeto objeto, int dia, int opcion, int posicion) {
        boolean vacio = false;
        for (int i = 0; i < objeto.getRequerimiento().getEsfuerzoNecesario(); i++) {
            if (dia > 4) {
                opcion++;
                dia = 0;
            }
            if (iteracion.listadoIteraciones.get(posicion).getArrDias()[opcion][dia] != null) {
                vacio = false;
                break;
            } else {
                vacio = true;
            }
            dia++;
        }
        return vacio;
    }//VALIDA SI EL DIA ESTA VACIO O NO

    public boolean validarDesarrollador(Registro iteracion, Objeto objeto, int dia, int opcion, int posicion) {
        boolean asignado = false;
        int contador = 0;
        for (int i = 0; i < objeto.getRequerimiento().getEsfuerzoNecesario(); i++) {
            if (iteracion.listadoIteraciones.get(posicion).getArrDias()[opcion][dia].listadoAsignacion.get(contador).getDesarrollador() == objeto.getDesarrollador()) {
                asignado = true;
            } else {
                asignado = false;
            }
            dia += i;
            contador++;
        }
        return asignado;
    } //VALIDA SI EL DESARROLLADOR NO FUE ASIGNADO A ESE DIA YA

    public void visualizacionMatriz(Registro iteracion) {
        int opcion = 0;
        int posicion = 0;
        boolean validar = true;
        boolean existe = false;
        String almacenarIteracion = "";
        String almacenar = "";
        ArrayList<Desarrollador> almacenarDesarrolladores = new ArrayList();
        ArrayList<Requerimiento> almacenarRequerimientos = new ArrayList();

        while (validar == true) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, iteracion.leerIteracion() + "\nIngrese el ID de la iteración deseada: "));
            for (int i = 0; i < iteracion.listadoIteraciones.size(); i++) {
                if (opcion == iteracion.listadoIteraciones.get(i).getIdIteracion()) {
                    existe = true;
                    posicion = i;
                    validar = false;
                    break;
                }
            }
            if (validar == true) {
                JOptionPane.showMessageDialog(null, "Lo sentimos, no existe ninguna iteración asociada a ese ID");
            }
        }

        if (existe == true) { //validacion para obtener los requerimientos y desarrolladores de la iteracion
            for (int i = 0; i < iteracion.listadoIteraciones.get(posicion).getCantidadaSemanas(); i++) {
                for (int j = 0; j < 5; j++) {
                    if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j] != null) {
                        if (almacenarDesarrolladores.isEmpty() == false) {
                            for (int k = 0; k < almacenarDesarrolladores.size(); k++) {
                                if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(0).getDesarrollador() != almacenarDesarrolladores.get(k)) {
                                    almacenarDesarrolladores.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(0).getDesarrollador());
                                } else if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() == 2) {
                                    if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getDesarrollador() != almacenarDesarrolladores.get(k)) {
                                        almacenarDesarrolladores.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getDesarrollador());
                                    }
                                } else if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() == 3) {
                                    if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(2).getDesarrollador() != almacenarDesarrolladores.get(k)) {
                                        almacenarDesarrolladores.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(2).getDesarrollador());
                                    }
                                }
                            }
                        } else {
                            almacenarDesarrolladores.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(0).getDesarrollador());
                            if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() == 2) {
                                almacenarDesarrolladores.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getDesarrollador());
                            } else if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() == 3) {
                                almacenarDesarrolladores.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(2).getDesarrollador());
                            }
                        }
                        if (almacenarRequerimientos.isEmpty() == false) {
                            for (int k = 0; k < almacenarRequerimientos.size(); k++) {
                                if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(0).getRequerimiento() != almacenarRequerimientos.get(k)) {
                                    almacenarRequerimientos.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(0).getRequerimiento());
                                } else if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() == 2) {
                                    if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getRequerimiento() != almacenarRequerimientos.get(k)) {
                                        almacenarRequerimientos.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getRequerimiento());
                                    }
                                } else if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() == 3) {
                                    if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(2).getRequerimiento() != almacenarRequerimientos.get(k)) {
                                        almacenarRequerimientos.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(2).getRequerimiento());
                                    }
                                }
                            }
                        } else {
                            almacenarRequerimientos.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(0).getRequerimiento());
                            if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() == 2) {
                                almacenarRequerimientos.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getRequerimiento());
                            } else if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() == 3) {
                                almacenarRequerimientos.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(2).getRequerimiento());
                            }
                        }
                    }
                }
            }

            if (almacenarRequerimientos.isEmpty() == false) {
                almacenar += "REQUERIMIENTOS\n----------------------------------------------\n";
                almacenar += "ID req  | Esfuerzo\n";
                for (int i = 0; i < almacenarRequerimientos.size(); i++) {
                    almacenar += almacenarRequerimientos.get(i).getIdRequerimiento() + "                 " + almacenarRequerimientos.get(i).getEsfuerzoNecesario() + "\n";
                }
            }

            if (almacenarDesarrolladores.isEmpty() == false) {
                almacenar += "\nDESARROLLADORES\n--------------------------------------------------------\n";
                almacenar += "ID Desarrollador    |    Siglas\n";
                for (int i = 0; i < almacenarDesarrolladores.size(); i++) {
                    almacenar += almacenarDesarrolladores.get(i).getIdDesarrollador() + "                           " + almacenarDesarrolladores.get(i).getSiglasDesarrollador() + "\n";
                }
            }

            if (existe == true) {
                for (int j = 0; j < iteracion.listadoIteraciones.get(posicion).getCantidadaSemanas(); j++) { //Recorre filas
                    almacenarIteracion += "Semana #" + (j + 1) + "\n----------------------------------------------------------\n";
                    for (int i = 0; i < 5; i++) { //Recorre columnas
                        if (iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i] == null) {
                            almacenarIteracion += "Día #" + (i + 1) + ":\n N/A \n";
                        } else {
                            almacenarIteracion += "Día #" + (i + 1) + "\n";
                            almacenarIteracion += "Desarrollador: " + iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.get(0).getDesarrollador().getSiglasDesarrollador() + "-" + "ID requerimiento: "
                                    + iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.get(0).getRequerimiento().getIdRequerimiento() + "\n";
                            if (iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.size() == 2) {
                                almacenarIteracion += "Desarrollador: " + iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.get(1).getDesarrollador().getSiglasDesarrollador() + "-" + "ID requerimiento: "
                                        + iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.get(1).getRequerimiento().getIdRequerimiento() + "\n";
                            }
                            if (iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.size() == 3) {
                                almacenarIteracion += "Desarrollador: " + iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.get(1).getDesarrollador().getSiglasDesarrollador() + "-" + "ID requerimiento: "
                                        + iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.get(1).getRequerimiento().getIdRequerimiento() + "\n";
                                almacenarIteracion += "Desarrollador: " + iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.get(2).getDesarrollador().getSiglasDesarrollador() + "-" + "ID requerimiento: "
                                        + iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.get(2).getRequerimiento().getIdRequerimiento() + "\n";
                            }

                        }
                    }
                }
            }

        }

        JOptionPane.showMessageDialog(null, almacenar);
        JOptionPane.showMessageDialog(null, almacenarIteracion);

    }//PERMITE VISUALIZAR LAS ITERACIONES

    public boolean validarListadoAsignacion(Registro iteracion, int posicion, int opcion, int dia, Objeto objeto) {
        boolean lleno = false;
//        for (int i = 0; i < objeto.getRequerimiento().getEsfuerzoNecesario(); i++) {
        if (iteracion.listadoIteraciones.get(posicion).getArrDias()[opcion][dia] != null) {
            if (iteracion.listadoIteraciones.get(posicion).getArrDias()[opcion][dia].listadoAsignacion.size() < 3) {
                lleno = false;
            } else {
                lleno = true;
            }

        }
//            dia++;

        return lleno;
    }
//VALIDA SI EL DIA NO TIENE MÁS DE 3 OBJETOS YA ASIGNADOS

    public int validarDiasDisponibles(Registro iteracion, int posicion, int opcion, int dia, Objeto objeto) {
        boolean disponibles = false;
        int contador = 0;

//        contador = iteracion.listadoIteraciones.get(posicion).getCantidadaSemanas() * 5;
//
//        if (objeto.getRequerimiento().getEsfuerzoNecesario() <= contador) {
//            disponibles = true;
//        }
        for (int i = 0; i < iteracion.listadoIteraciones.get(posicion).getCantidadaSemanas(); i++) {
            for (int j = 0; j < 5; j++) {
                if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j] == null || iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() < 3) {
                    contador++;
                }
            }
        }

        return contador;
    } //VALIDA SI LA ITERACION ES LO SUFICIENTEMENTE GRANDE PARA ALMACENAR EL REQUERIMIENTO

    public void cierreIteracion(Registro iteracion) {
        int opcion = 0;
        boolean validar = true;
        boolean existe = false;
        int posicion = 0;
        String almacenar = "";

        while (validar == true) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, iteracion.leerIteracion() + "\nIngrese el ID de la iteración deseada: "));
            for (int i = 0; i < iteracion.listadoIteraciones.size(); i++) {
                if (opcion == iteracion.listadoIteraciones.get(i).getIdIteracion()) {
                    existe = true;
                    posicion = i;
                    validar = false;
                    break;
                }
            }
            if (validar == true) {
                JOptionPane.showMessageDialog(null, "Lo sentimos, no existe ninguna iteración asociada a ese ID");
            }
        }

        if (existe == true) {
            if (iteracion.listadoIteraciones.get(posicion).getEstado() != Estado.Finalizado) {
                iteracion.listadoIteraciones.get(posicion).setEstado(Estado.Finalizado);
                for (int i = 0; i < iteracion.listadoIteraciones.get(posicion).getCantidadaSemanas(); i++) {
                    for (int j = 0; j < 5; j++) {
                        if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j] != null) {
                            iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(0).getRequerimiento().setEstado(Estado.Finalizado);
                            if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() == 2) {
                                iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getRequerimiento().setEstado(Estado.Finalizado);
                            } else if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() == 3) {
                                iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(2).getRequerimiento().setEstado(Estado.Finalizado);
                            }
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lo sentimos, esta iteración ya ha sido cerrada");
        }
    }
}
