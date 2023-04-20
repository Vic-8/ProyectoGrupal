/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author Ariana
 */
public class Objeto {
    
    //Esta es la clase para crear el objeto que se almacena en el array de las iteraciones
    
    private Desarrollador desarrollador; // tipo Desarrollador 
    private Requerimiento requerimiento; // tipo requerimiento

    //Constructores
    
    public Objeto() {
    }

    public Objeto(Desarrollador desarrollador, Requerimiento requerimiento) {
        this.desarrollador = desarrollador;
        this.requerimiento = requerimiento;
    }

    
    //GET & SET
    public Desarrollador getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(Desarrollador desarrollador) {
        this.desarrollador = desarrollador;
    }

    public Requerimiento getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(Requerimiento requerimiento) {
        this.requerimiento = requerimiento;
    }

   
}