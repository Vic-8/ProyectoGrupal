
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
    private Objeto[][] arrObjetos;
    
    public Iteracion() {
    }

    public Iteracion(int idIteracion, int cantidadaSemanas, Estado estado) {
        this.idIteracion = idIteracion;
        this.cantidadSemanas = cantidadaSemanas;
        this.estado = estado;
    }

    public void registroIteracion() {
        this.idIteracion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de iteración: "));
        this.cantidadSemanas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de semanas: "));
        this.arrObjetos = new Objeto[cantidadSemanas][5];
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

    public Objeto[][] getArrObjetos() {
        return arrObjetos;
    }

    public void setArrObjetos(int semana, int dia) {
        this.arrObjetos = new Objeto[semana][dia];
    }
  
}
