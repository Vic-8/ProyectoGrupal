
package com.mycompany.proyecto;


import javax.swing.JOptionPane;


//AUTORES ARIANA FALLAS Y JOSE PABLO RAYGADA

public class Requerimiento {

//Declaracion de atributos

    private int idRequerimiento;
    private String nombreRequerimiento;
    private int esfuerzoNecesario;
    private int nuevo = 0; //usada para validar el while
    public static int numeroRequerimientos = 7; //usada como contador
    private Estado estado;


//Constructores
    public Requerimiento(int idRequerimiento, String nombreRequerimiento, int esfuerzoNecesario, Estado estado) {
        this.idRequerimiento=idRequerimiento;
        this.nombreRequerimiento=nombreRequerimiento;
        this.esfuerzoNecesario=esfuerzoNecesario;
        this.estado=estado;
    }

    public Requerimiento() {
    }

 
//METODO PARA CREAR UN NUEVO REQUERIMIENTO
    public void registroRequerimiento() {
        this.idRequerimiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de requerimiento: "));
        this.nombreRequerimiento = JOptionPane.showInputDialog("Ingrese el nombre del requerimiento: ");
        this.esfuerzoNecesario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el esfuerzo necesario para realizar el requerimiento: "));
        estado = Estado.Pendiente;
    }

    
    //GETTERS & SETTERS
    public int getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(int idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    public String getNombreRequerimiento() {
        return nombreRequerimiento;
    }

    public void setNombreRequerimiento(String nombreRequerimiento) {
        this.nombreRequerimiento = nombreRequerimiento;
    }

    public int getEsfuerzoNecesario() {
        return esfuerzoNecesario;
    }

    public void setEsfuerzoNecesario(int esfuerzoNecesario) {
        this.esfuerzoNecesario = esfuerzoNecesario;
    }

    public int getNumeroRequerimientos() {
        return numeroRequerimientos;
    }
    
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


}
