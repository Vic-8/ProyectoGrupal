
package com.mycompany.proyecto;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ariana
 */
public class Registro {

    //ESTA CLASE ES UTILIZADA UNICAMENTE PARA LA CREACION, ALMACENAMIENTO, ELIMINACION Y LECTURA DE REQUERIMIENTOS, ITERACIONES Y DESARROLLADORES  // es mucho no?
   
    //CREACION DE LOS ARRAYLISTS
    ArrayList<Requerimiento> listadoRequerimientos = new ArrayList();
    ArrayList<Iteracion> listadoIteraciones = new ArrayList();
    ArrayList<Desarrollador> listadoDesarrolladores = new ArrayList();
    
    //Creacion variables
    //INICIO METODOS REQUERIMIENTOS

    
    public void agregarRequerimiento() {
        Requerimiento requerimiento = new Requerimiento();
        requerimiento.registroRequerimiento();
        for (int i = 0; i < listadoRequerimientos.size(); i++) {
            if (requerimiento.getIdRequerimiento() == listadoRequerimientos.get(i).getIdRequerimiento()) {
                while (requerimiento.getIdRequerimiento() == listadoRequerimientos.get(i).getIdRequerimiento()) {
                    JOptionPane.showMessageDialog(null, "Lo sentimos, ya existe un requerimiento creado asociado al ID de requerimiento ingresado");
                    requerimiento.registroRequerimiento();
                }
            }
        }
        listadoRequerimientos.add(requerimiento);
    }

    public String leerRequerimiento() {
        String almacenar = "";

        for (int i = 0; i < listadoRequerimientos.size(); i++) {
            almacenar += "ID requerimiento: " + listadoRequerimientos.get(i).getIdRequerimiento() + " // Nombre requerimiento: " + listadoRequerimientos.get(i).getNombreRequerimiento()
                    + " // Esfuerzo necesario: " + listadoRequerimientos.get(i).getEsfuerzoNecesario() + " // Estado: " + listadoRequerimientos.get(i).getEstado() + "\n";
        }
        //JOptionPane.showMessageDialog(null, almacenar);
        return almacenar;
    }
    
    
    //INICIO METODOS PARA LAS ITERACIONES
    
       public void agregarIteracion() {
        Iteracion iteracion = new Iteracion();
        iteracion.registroIteracion();
        for (int i = 0; i < listadoIteraciones.size(); i++) {
            if (iteracion.getIdIteracion() == listadoIteraciones.get(i).getIdIteracion()) {
                while (iteracion.getIdIteracion() == listadoIteraciones.get(i).getIdIteracion()) {
                    JOptionPane.showMessageDialog(null, "Lo sentimos, ya existe una iteración asociada a ese ID de iteración.");
                    iteracion.registroIteracion();
                }
            }
        }
        listadoIteraciones.add(iteracion);
    }
       
        public String leerIteracion() {
        String almacenar = "";
        for (int i = 0; i < listadoIteraciones.size(); i++) {
            almacenar += "ID iteración: " + listadoIteraciones.get(i).getIdIteracion() + " || "
                    + "Cantidad de semanas: " + listadoIteraciones.get(i).getCantidadaSemanas() + " || "
                    + "Estado: " + listadoIteraciones.get(i).getEstado()+"\n";
        }
        //JOptionPane.showMessageDialog(null, almacenar);
        return almacenar;
    }
        
        
        
        // Pablo
        //INICIO METODOS PARA DESARROLLADORES
    
       public void agregarDesarrollador() {
        Desarrollador desarrollador = new Desarrollador();
        desarrollador.registroDesarrollador();
        desarrollador.setIdDesarrollador((int)(Math.random()*1000));
        for (int i = 0; i < listadoDesarrolladores.size(); i++) {
            if (desarrollador.getIdDesarrollador()== listadoDesarrolladores.get(i).getIdDesarrollador()) {
                while (desarrollador.getIdDesarrollador()== listadoDesarrolladores.get(i).getIdDesarrollador()) {
                    desarrollador.setIdDesarrollador((int)(Math.random()*1000));
                }
            }
        }
        listadoDesarrolladores.add(desarrollador);
        String text = ("Su ID de desarrollador es: "+desarrollador.getIdDesarrollador()); 
        JOptionPane.showMessageDialog(null, text);
    }
        // Add to main PENDING!!
        public String leerDesarrollador() {
        String almacenar = "";
        for (int i = 0; i < listadoDesarrolladores.size(); i++) {
            almacenar += "\nID desarrollador: " + listadoDesarrolladores.get(i).getIdDesarrollador()+ " || "
                    + "Nombre: " + listadoDesarrolladores.get(i).getNombreDesarrollador()+ " || "
                    + "Siglas: " + listadoDesarrolladores.get(i).getSiglasDesarrollador()+" || "
                    + "Costo por día: "+listadoDesarrolladores.get(i).getCostoDiario()+"\n";
        }
        //JOptionPane.showMessageDialog(null, almacenar);
        return almacenar;
    }
    
                  
}
