/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Raygada Monge
 */


/// Registro de requerimientos de Backlog
public class Backlog {
    
    
private String idRequerimiento;
private String nombreRequerimiento;
private int esfuerzoNecesario; /// En dias completos
private String estado;

    //Class
    private int nuevo = 0;                          // Validar while
    public static int numeroDesarrolladores = 0;     // Contador (Max 50.)

// Constructor

    public Backlog(String idRequerimiento, String nombreRequerimiento, int esfuerzoNecesario, String estado) {
        this.idRequerimiento = idRequerimiento;
        this.nombreRequerimiento = nombreRequerimiento;
        this.esfuerzoNecesario = esfuerzoNecesario;
        this.estado = estado;
    }

   public Backlog() {
    }
    
 public void registroRequerimientoBacklog() {    
 
 this.idRequerimiento = JOptionPane.showInputDialog("Ingrese el id del desarrollador: ");
 
 // IF : Si es la primera vez que se ingresa, el estado debe de ser "Pendiente" 
 
  this.nombreRequerimiento = JOptionPane.showInputDialog("Ingrese el id del desarrollador: ");
 
  this.esfuerzoNecesario= Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese el esfuerzo necesario en dias completos: "));
   
  
  JOptionPane.showMessageDialog(null, "El id de Requerimiento es:" + this.idRequerimiento + "\n" + 
          "El nombre del Requerimiento es:" + this.idRequerimiento + "\n" + 
                  "El esfuerzo necesario en dias completos es:" + this.idRequerimiento + "\n" );
  
     
 }

    public String getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(String idRequerimiento) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   
 
 
 
    
}
