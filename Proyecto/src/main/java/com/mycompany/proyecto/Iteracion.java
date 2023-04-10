
package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Ariana
 */
public class Iteracion {
    private int idIteracion;
    private int cantidadSemanas;
    private Estado estado;
    public static int numeroIteraciones = 2; //usada como contador
    private Asignacion[][] arrDias; //cambiar a tipo asignacion
    
    public Iteracion() {
    }

    public Iteracion(int idIteracion, int cantidadSemanas, Estado estado) {
        this.idIteracion = idIteracion;
        this.cantidadSemanas = cantidadSemanas;
        this.estado = estado;
        this.arrDias = new Asignacion[cantidadSemanas][5];
    }

    public void registroIteracion() {
        this.idIteracion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de iteración: "));
        this.cantidadSemanas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de semanas: "));
        this.arrDias = new Asignacion[cantidadSemanas][5];
        estado = Estado.En_Proceso;

    }

    //GET Y SET
   
    public int getIdIteracion() {
        return idIteracion;
    }

    public void setIdIteracion(int idIteracion) {
        this.idIteracion = idIteracion;
    }

    public int getCantidadaSemanas() {
        return cantidadSemanas;
    }

    public void setCantidadaSemanas(int cantidadaSemanas) {
        this.cantidadSemanas = cantidadaSemanas;
    }

    public Estado getEstado() {
        return estado;
    }

    public Asignacion[][] getArrDias() {
        return arrDias;
    }

    public void setArrDias(int semana, int dia) {
        this.arrDias = new Asignacion[semana][dia];
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
  
}
