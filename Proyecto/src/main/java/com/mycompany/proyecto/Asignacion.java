/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
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
    ArrayList<Objeto> listadoAsignacion = new ArrayList(); //array para almacenar los objetos

    //Creacion de la matriz
    //Creacion del objeto complejo
    public void creacionObjeto(Registro requerimiento, Registro iteracion, Registro desarrollador) {

        //variables
        Objeto objeto = new Objeto(); //crea el objeto que se almacenará en el array
        String valido = "x";
        int opcion = 0;
        int continuar = 1;
        int dia = 0;
        int posicionIteracion = 0;
        int posicionRequerimiento = 0;
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
                        posicionRequerimiento = i; //almacena posicion del requerimiento
                        validarRequerimiento = true;
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Lo sentimos, el requerimiento ya ha sido asignado.");
                        validarRequerimiento = false;
                        validarDesarrollador = false;
                        valido = "j";
                        break;
                    }
                }
            }
            if (existe == false) {
                JOptionPane.showMessageDialog(null, "No existe ningún requerimiento asociado a ese ID");
                validarRequerimiento = false;
            }

            //2 SELECCION DE LA ITERACION
            while (validarDesarrollador == true) {
                valido="x";
                validarDesarrollador = true;
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, iteracion.leerIteracion() + "\nSeleccione la iteración: "));
                for (int i = 0; i < iteracion.listadoIteraciones.size(); i++) {
                    if (opcion == iteracion.listadoIteraciones.get(i).getIdIteracion()) {
                        existe = false;
                        if (iteracion.listadoIteraciones.get(i).getEstado() != Estado.Finalizado) { //verifica que el estado de la iteracion sea diferente a finalizado
                            existe = false;
                            semanas = iteracion.listadoIteraciones.get(i).getCantidadaSemanas(); //obtiene la cantidad de semanas de la iteracion
                            posicionIteracion = i;
                            validarDesarrollador = false;
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Lo sentimos, la iteración seleccionada ya ha sido cerrada");
                            validarDesarrollador = true;
                            validarRequerimiento = false;
                            valido="j";
                            objeto.getRequerimiento().setEstado(Estado.Pendiente);
                            break;
                        }
                    }
                }
                if (existe == true) {
                    JOptionPane.showMessageDialog(null, "Lo sentimos, no existe ninguna iteración asignada al ID ingresado.");
                    validarDesarrollador = true;   
       
                }

                if (validarDesarrollador == false) { //almacena las semanas de la iteracion seleccionada para mostrarla
                    validarRequerimiento = true;
                    String almacenar = "";
                    for (int i = 0; i < semanas; i++) {
                        almacenar += "Semana " + i + "\n";
                    }
                    while (valido == "x") {
                        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la semana en la que desea iniciar el requerimiento: \n" + almacenar));
                        if (opcion <= semanas) {
                            dia = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el dia en el que desea iniciar el requerimiento: "
                                    + "\n0. Lunes \n1. Martes \n2. Miércoles \n3. Jueves \n4. Viernes"));
                            asignarDesarrollador(desarrollador, objeto); //realiza el proceso de asignacion de desarrollador y lo almacena
                            if (validarDiasDisponibles(iteracion, posicionIteracion, opcion, dia, objeto) >= objeto.getRequerimiento().getEsfuerzoNecesario()) {    //Valida y cuenta si en toda iteracion hay suficientes dias para almacenar el requerimiento, lo compara contra el esfuerzo del req
                                if (verificarDias(iteracion, posicionIteracion, opcion, dia, objeto) >= objeto.getRequerimiento().getEsfuerzoNecesario()) { //Verifica que desde el dia de inicio hasta el final del req esten disponibles los dias
                                    if (validarListadoAsignacion(iteracion, posicionIteracion, opcion, dia, objeto) == false) { //valida si los dias tienen 3 o menos requerimientos asignados, de lo contrario no se asigna
                                        esfuerzoNecesario = dia + objeto.getRequerimiento().getEsfuerzoNecesario(); 
                                        if (validarDiasVacios(iteracion, objeto, dia, opcion, posicionIteracion) == true) { //valida si desde el dia de inicio hasta el final, los dias estan vacios o tienen algo asignado
                                            contadorElementos = 0;
                                            if (dia < objeto.getRequerimiento().getEsfuerzoNecesario()) { //valida si el dia seleccionado es menor al esfuerzo del req
                                                for (int i = 0; i < objeto.getRequerimiento().getEsfuerzoNecesario(); i++) {
                                                    if (dia > 4) { //si el dia es mayor a 4, se suma 1 a las semanas y el dia se inicializa en 0
                                                        opcion++;
                                                        dia = 0;
                                                    }

                                                    iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia] = new Asignacion();
                                                    iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia].listadoAsignacion.add(contadorElementos, objeto);

                                                    dia++;
                                                }
                                                requerimiento.listadoRequerimientos.get(posicionRequerimiento).setEstado(Estado.En_Desarollo);
                                            } else if (dia >= objeto.getRequerimiento().getEsfuerzoNecesario()) {
                                                while (dia < esfuerzoNecesario) {
                                                    if (dia > 4) {
                                                        opcion++;
                                                        esfuerzoNecesario = esfuerzoNecesario - dia;
                                                        dia = 0;
                                                    }
                                                    iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia] = new Asignacion(); //crea una nueva asignacion
                                                    iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia].listadoAsignacion.add(contadorElementos, objeto); //agrega el objeto a la primera posicion del array, porque el dia esta vacio

                                                    dia++;
                                                }
                                                requerimiento.listadoRequerimientos.get(posicionRequerimiento).setEstado(Estado.En_Desarollo); //cambia el estado del requerimiento
                                            }
                                            contadorElementos++; 
                                            valido = "j";
                                            validarDesarrollador = false;
                                            validarRequerimiento = true;
                                          
                                        } else { //si el dia seleccionado no esta vacio
                                            diaInicial = dia;
                                            for (int i = 0; i < objeto.getRequerimiento().getEsfuerzoNecesario(); i++) {
                                                if (diaInicial > 4) {
                                                    opcion++;
                                                    diaInicial = 0;
                                                }
                                                //los siguientes IF son para validar si el desarrollador ya fue asignado, mediante un boolean valida
                                                if (iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][diaInicial].listadoAsignacion.get(0).getDesarrollador() != objeto.getDesarrollador()
                                                        || iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][diaInicial] == null) {
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

                                            if (asignado == false) { //si el desarrollador no esta asignado, procede a asignarlo en nuevo espacio del array
                                                if (dia < objeto.getRequerimiento().getEsfuerzoNecesario()) {
                                                    for (int i = 0; i < objeto.getRequerimiento().getEsfuerzoNecesario(); i++) {
                                                        if (dia > 4) {
                                                            opcion++;
                                                            dia = 0;
                                                        }
                                                        if (iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia] == null) { //si el dia esta vacio, me lo asigna en la primera posicion
                                                            iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia] = new Asignacion();
                                                            iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia].listadoAsignacion.add(objeto);
                                                        } else {
                                                            iteracion.listadoIteraciones.get(posicionIteracion).getArrDias()[opcion][dia].listadoAsignacion.add(objeto); //si ya tiene otros reqs asignados, me lo agrega en la siguiente posicion
                                                        }
                                                        dia++;
                                                    }
                                                    requerimiento.listadoRequerimientos.get(posicionRequerimiento).setEstado(Estado.En_Desarollo); //cambia el estado del req
                                                    valido = "j";
                                                    validarDesarrollador = false;
                                                    validarRequerimiento = true;
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
                                                    requerimiento.listadoRequerimientos.get(posicionRequerimiento).setEstado(Estado.En_Desarollo);
                                                    valido = "j";
                                                    validarDesarrollador = false;
                                                    validarRequerimiento = true;
                                                }

                                            } else {
                                                JOptionPane.showMessageDialog(null, "Lo sentimos este desarrollador ya fue asignado");
                                                valido = "j";
                                                validarDesarrollador = true;
                                            }
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Lo sentimos, no se pueden agregar más requerimientos en este día. Porfavor, seleccione otro día.");
                                        valido = "x";
                                        validarDesarrollador = false;

                                    }

                                } else {
                                    JOptionPane.showMessageDialog(null, "Lo sentimos, no hay espacio disponible desde el dia de inicio hasta el día final.");
                                    validarDesarrollador = true;
                                    valido="j";
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Lo sentimos, no hay espacio suficiente para asignar el requerimiento. Por favor seleccione otra iteración.");
                                validarDesarrollador = true;
                                valido="j";
                            }
                        }
                    }
                }
            }
        }
    }

    public void asignarDesarrollador(Registro desarrollador, Objeto objeto) {
        //metodo usado para asignar el desarollador
        
        
        String valido = "x";
        int opcion = 0;
        while (valido == "x") {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione el desarrollador: \n" + desarrollador.leerDesarrollador()));
            for (int i = 0; i < desarrollador.listadoDesarrolladores.size(); i++) {
                if (opcion == desarrollador.listadoDesarrolladores.get(i).getIdDesarrollador()) { //valida que el desarrollador exista
                    
                    objeto.setDesarrollador(desarrollador.listadoDesarrolladores.get(i)); //setea las siglas del desarrollador en el objeto
                    valido = "j";
                    break;
                }
            }

            if (valido == "x") {
                JOptionPane.showMessageDialog(null, "No existe ningún desarrollador asociado a ese ID");
            }
        }
    }

    public boolean validarDiasVacios(Registro iteracion, Objeto objeto, int dia, int opcion, int posicion) {
        //este metodo verifica que desde el dia del inicio al final del req los dias esten vacios o no, dependendiendo de eso regresa
        //el boolean para indicar como proceder
        
        boolean vacio = false;
        for (int i = 0; i < objeto.getRequerimiento().getEsfuerzoNecesario(); i++) {
            if (dia > 4) { //si el dia es mayor a 4, es decir, si es viernes y aun quedan dias pendientes, debe pasar al lunes de la otra semana
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
    }

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
        int contador = 0;
        boolean validar = true;
        boolean existe = false;
        String almacenarIteracion = "";
        String almacenar = "";
        ArrayList<Desarrollador> almacenarDesarrolladoresTemp = new ArrayList(); //lista de almacenamiento temporal
        ArrayList<Requerimiento> almacenarRequerimientosTemp = new ArrayList(); //lista de almacenamiento temporal

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
                for (int j = 0; j < 5; j++) { //Arreglo que almacena todos los desarrolladores y requerimientos que hay en la iteracion
                    if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j] != null) {
                        almacenarDesarrolladoresTemp.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(0).getDesarrollador());
                        almacenarRequerimientosTemp.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(0).getRequerimiento());
                        if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() == 2) {
                            almacenarDesarrolladoresTemp.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getDesarrollador());
                            almacenarRequerimientosTemp.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getRequerimiento());
                        }
                        if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() == 3) {
                            almacenarDesarrolladoresTemp.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getDesarrollador());
                            almacenarDesarrolladoresTemp.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(2).getDesarrollador());
                            almacenarRequerimientosTemp.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getRequerimiento());
                            almacenarRequerimientosTemp.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(2).getRequerimiento());
                        }

                    }
                }
            }
            
            //estos metodos me ayudan a obtener la lista de desarrolladores que no esten repetidos
            Set<Desarrollador> setDesarrolladores = new LinkedHashSet<>(almacenarDesarrolladoresTemp);
            Set<Requerimiento> setRequerimientos = new LinkedHashSet<>(almacenarRequerimientosTemp);
            //agregamos los desarrolladores que no estan repetidos a una nueva lista
            ArrayList<Desarrollador> almacenarDesarrolladores = new ArrayList<>(setDesarrolladores);
            ArrayList<Requerimiento> almacenarRequerimientos = new ArrayList<>(setRequerimientos);

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
                    almacenar += almacenarDesarrolladores.get(i).getIdDesarrollador() + "                                        " + almacenarDesarrolladores.get(i).getSiglasDesarrollador() + "\n";
                }
            }

            if (existe == true) {
                for (int j = 0; j < iteracion.listadoIteraciones.get(posicion).getCantidadaSemanas(); j++) { //Recorre filas
                    almacenarIteracion+="-----------------------------------------------------------------------\n";
                    almacenarIteracion += "Semana #" + (j + 1) + "\n";
                    for (int i = 0; i < 5; i++) { //Recorre columnas
                        almacenarIteracion+="Día #"+(i+1)+"\n";
                        if (iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i] == null) {
                            almacenarIteracion += "---" + "\n";
                        } else {
                            almacenarIteracion += "Des: " + iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.get(0).getDesarrollador().getSiglasDesarrollador() + "-" + "RQ: "
                                    + iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.get(0).getRequerimiento().getIdRequerimiento()+"\n";
                            if (iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.size() == 2) {
                                almacenarIteracion += "Des: " + iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.get(1).getDesarrollador().getSiglasDesarrollador() + "-" + "RQ: "
                                        + iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.get(1).getRequerimiento().getIdRequerimiento() +"\n";
                            }
                            if (iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.size() == 3) {
                                almacenarIteracion += "Des: " + iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.get(1).getDesarrollador().getSiglasDesarrollador() + "-" + "RQ: "
                                        + iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.get(1).getRequerimiento().getIdRequerimiento() +"\n";
                                almacenarIteracion += "Des: " + iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.get(2).getDesarrollador().getSiglasDesarrollador() + "-" + "RQ: "
                                        + iteracion.listadoIteraciones.get(posicion).getArrDias()[j][i].listadoAsignacion.get(2).getRequerimiento().getIdRequerimiento() +"\n";
                            }
                            if (i>4){
                            almacenarIteracion+="-----------------------------------------------------------------------\n";
                            }
                        }
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(
                null, almacenar);
        JOptionPane.showMessageDialog(
                null, almacenarIteracion);

    }
    //PERMITE VISUALIZAR LAS ITERACIONES

    public boolean validarListadoAsignacion(Registro iteracion, int posicion, int opcion, int dia, Objeto objeto) {
        //valida si los dias seleccionados no tienen mas de 3 requerimientos asignados, de lo contrario, no deja asignar
        boolean lleno = false;
        for (int i = 0; i < objeto.getRequerimiento().getEsfuerzoNecesario(); i++) {
            if (dia>4){
                opcion++;
                dia=0;
            }
        if (iteracion.listadoIteraciones.get(posicion).getArrDias()[opcion][dia] != null) {
            if (iteracion.listadoIteraciones.get(posicion).getArrDias()[opcion][dia].listadoAsignacion.size() < 3) {
                lleno = false;
            } else {
                lleno = true;
                break;
            }

        }
            dia++;

        
    }
        return lleno;
   }

//VALIDA SI EL DIA NO TIENE MÁS DE 3 OBJETOS YA ASIGNADOS

    public int validarDiasDisponibles(Registro iteracion, int posicion, int opcion, int dia, Objeto objeto) {

        boolean disponibles = false;
        int contador = 0;
        int esfuerzo = objeto.getRequerimiento().getEsfuerzoNecesario();

//Cuenta la cantidad de dias vacios o que tienen menos de 3 reqs asignados y lo compara con el esfuerzo del requerimiento, para verificar si hay espacio
        for (int i = 0; i < iteracion.listadoIteraciones.get(posicion).getCantidadaSemanas(); i++) {
            for (int j = 0; j < 5; j++) {
                if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j] == null || iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() < 3) {
                    contador++;
                }
            }
        }

        return contador;
    } //VALIDA SI LA ITERACION ES LO SUFICIENTEMENTE GRANDE PARA ALMACENAR EL REQUERIMIENTO

    public int verificarDias(Registro iteracion, int posicion, int opcion, int dia, Objeto objeto) {
        //Con este metodo se valida que haya dias disponibles desde el inicio del req hasta el final, ademas valida que si eligen el viernes de la ultima semana de la iteracion
        // y si aun quedan dias por asignar me envie un error
        boolean disponibles = false;
        int contador = 0;
        int esfuerzo = iteracion.listadoIteraciones.get(posicion).getCantidadaSemanas() - 1;

        for (int i = 0; i < objeto.getRequerimiento().getEsfuerzoNecesario(); i++) {
            if (opcion == esfuerzo && dia > 4) {
                contador = 0;
                break;
            } 
            if (dia > 4) {
                opcion++;
                dia = 0;
            }
            if (iteracion.listadoIteraciones.get(posicion).getArrDias()[opcion][dia] == null
                    || iteracion.listadoIteraciones.get(posicion).getArrDias()[opcion][dia].listadoAsignacion.size() < 3) {
                contador++;
            }
            dia++;
        }
        return contador;
    }

    public void cierreIteracion(Registro iteracion) {
        
        //Este metodo es para cerrar la iteracion, basicamente selecciona la iteracion que desea cerrar y recorre todos los requerimientos que tenga la iteracion y le cambia el 
        //estado
        
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
                                iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getRequerimiento().setEstado(Estado.Finalizado);
                            }
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lo sentimos, esta iteración ya ha sido cerrada");
        }
    }

    public void reporteMensual(Registro iteracion) {
        //este metodo es para realizar el reporte mensual
        
        
        int opcion = 0;
        int posicion = 0;
        int total = 0;
        int contadorRequerimientos = 0;
        boolean validar = true;
        boolean existe = false;
        String almacenarIteracion = "";
        String mostrarDesarrolladores = "";
        String mostrarRequerimientos = "";
        String texto = "";
        ArrayList<Desarrollador> almacenarDesarrolladoresTemp = new ArrayList();
        ArrayList<Requerimiento> almacenarRequerimientosTemp = new ArrayList();

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
        }
        if (validar == true) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, no existe ninguna iteración asociada a ese ID");
        }

        if (existe == true) { //validacion para obtener los requerimientos y desarrolladores de la iteracion
            for (int i = 0; i < iteracion.listadoIteraciones.get(posicion).getCantidadaSemanas(); i++) {
                for (int j = 0; j < 5; j++) { //Arreglo que almacena todos los desarrolladores y requerimientos que hay en la iteracion
                    if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j] != null) {
                        almacenarDesarrolladoresTemp.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(0).getDesarrollador());
                        almacenarRequerimientosTemp.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(0).getRequerimiento());
                        if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() == 2) {
                            almacenarDesarrolladoresTemp.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getDesarrollador());
                            almacenarRequerimientosTemp.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getRequerimiento());
                        }
                        if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() == 3) {
                            almacenarDesarrolladoresTemp.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getDesarrollador());
                            almacenarDesarrolladoresTemp.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(2).getDesarrollador());
                            almacenarRequerimientosTemp.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getRequerimiento());
                            almacenarRequerimientosTemp.add(iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(2).getRequerimiento());
                        }

                    }
                }
            }
            
            //utilizamos los arrays para poder obtener los desarrolladores y los requerimientos, asi como obtener los costos diarios y poder sumarlos
            Set<Desarrollador> setDesarrolladores = new LinkedHashSet<>(almacenarDesarrolladoresTemp);
            Set<Requerimiento> setRequerimientos = new LinkedHashSet<>(almacenarRequerimientosTemp);
            ArrayList<Desarrollador> almacenarDesarrolladores = new ArrayList<>(setDesarrolladores);
            ArrayList<Requerimiento> almacenarRequerimientos = new ArrayList<>(setRequerimientos);

            if (almacenarDesarrolladores.isEmpty() == false) {
                for (int i = 0; i < almacenarDesarrolladores.size(); i++) {
                    mostrarDesarrolladores += "Nombre: " + almacenarDesarrolladores.get(i).getNombreDesarrollador() + " || "
                            + "Costo por día: " + almacenarDesarrolladores.get(i).getCostoDiario() + "\n";
                }
            }

            if (almacenarRequerimientos.isEmpty() == false) {
                for (int i = 0; i < almacenarRequerimientos.size(); i++) {
                    mostrarRequerimientos += "ID: " + almacenarRequerimientos.get(i).getIdRequerimiento() + " Esfuerzo: "
                            + almacenarRequerimientos.get(i).getEsfuerzoNecesario()+"\n";
                    contadorRequerimientos += almacenarRequerimientos.get(i).getEsfuerzoNecesario();
                }
            }

            //mediante este for, logramos obtener el costo diario, realizando la suma de cada requerimiento 
            for (int i = 0; i < iteracion.listadoIteraciones.get(posicion).getCantidadaSemanas(); i++) {
                for (int j = 0; j < 5; j++) {
                    if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j] != null) {
                        total += iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(0).getDesarrollador().getCostoDiario();
                        if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() == 2) {
                            total += iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getDesarrollador().getCostoDiario();
                        } else if (iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.size() == 3) {
                            {
                                total += iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(1).getDesarrollador().getCostoDiario();
                                total += iteracion.listadoIteraciones.get(posicion).getArrDias()[i][j].listadoAsignacion.get(2).getDesarrollador().getCostoDiario();
                            }
                        }
                    }
                }

            }
            texto = "REPORTE MENSUAL DE LA ITERACIÓN\n--------------------------------------------------------------------------\n\n"
                    + "Cantidad de requerimientos asignados: " + almacenarRequerimientos.size() + "\n"
                    + "Información de los requerimientos \n" + mostrarRequerimientos + "\n"
                    + "--------------------------------------------------------------------------\n\n"
                    + "Cantidad de desarrolladores asignados: " + almacenarDesarrolladores.size() + "\n"
                    + "Información de los desarrollaadores\n" + mostrarDesarrolladores + "\n"
                    + "--------------------------------------------------------------------------\n\n"
                    + "Suma de esfuerzo de los requerimientos: " + contadorRequerimientos + "\n"
                    + "Costo de la iteración: " + ((total * 0.13) + total);
            JOptionPane.showMessageDialog(null, texto);

        }
    }
}

