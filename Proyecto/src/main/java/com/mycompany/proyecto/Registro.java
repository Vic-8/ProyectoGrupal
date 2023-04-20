
package com.mycompany.proyecto;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ariana
 */
public class Registro {

//ESTA CLASE ES UTILIZADA UNICAMENTE PARA LA CREACION, ALMACENAMIENTO Y LECTURA DE REQUERIMIENTOS, ITERACIONES Y DESARROLLADORES
   
    //CREACION DE LOS ARRAYLISTS
    ArrayList<Requerimiento> listadoRequerimientos = new ArrayList();
    ArrayList<Iteracion> listadoIteraciones = new ArrayList();
    ArrayList<Desarrollador> listadoDesarrolladores = new ArrayList();
    
   
    //INICIO METODOS REQUERIMIENTOS

    
    public void agregarRequerimiento() {
        Requerimiento requerimiento = new Requerimiento();
        requerimiento.registroRequerimiento();
        for (int i = 0; i < listadoRequerimientos.size(); i++) {
            if (requerimiento.getIdRequerimiento() == listadoRequerimientos.get(i).getIdRequerimiento()) { //Valida si ID del req ya existe
                while (requerimiento.getIdRequerimiento() == listadoRequerimientos.get(i).getIdRequerimiento()) {
                    JOptionPane.showMessageDialog(null, "Lo sentimos, ya existe un requerimiento creado asociado al ID de requerimiento ingresado");
                    requerimiento.registroRequerimiento();
                }
            }
        }
        listadoRequerimientos.add(requerimiento); //añade el requerimiento al array
    }

    public String leerRequerimiento() { //Lee toda la informacion de los requerimientos
        String almacenar = "";

        for (int i = 0; i < listadoRequerimientos.size(); i++) {
            almacenar += "ID requerimiento: " + listadoRequerimientos.get(i).getIdRequerimiento() + " // Nombre requerimiento: " + listadoRequerimientos.get(i).getNombreRequerimiento()
                    + " // Esfuerzo necesario: " + listadoRequerimientos.get(i).getEsfuerzoNecesario() + " // Estado: " + listadoRequerimientos.get(i).getEstado() + "\n";
        }

        return almacenar;
    }
    
    
    //INICIO METODOS PARA LAS ITERACIONES
    
       public void agregarIteracion() {
        Iteracion iteracion = new Iteracion(); //creacion del objeto
        iteracion.registroIteracion(); //registra el objeto
        for (int i = 0; i < listadoIteraciones.size(); i++) {
            if (iteracion.getIdIteracion() == listadoIteraciones.get(i).getIdIteracion()) { //valida si el id de la iteracion existe
                while (iteracion.getIdIteracion() == listadoIteraciones.get(i).getIdIteracion()) {
                    JOptionPane.showMessageDialog(null, "Lo sentimos, ya existe una iteración asociada a ese ID de iteración.");
                    iteracion.registroIteracion();
                }
            }
        }
        listadoIteraciones.add(iteracion); //agrega el objeto al array
    }
       
        public String leerIteracion() { //se usa para leer la iteracion
        String almacenar = "";
        for (int i = 0; i < listadoIteraciones.size(); i++) {
            almacenar += "ID iteración: " + listadoIteraciones.get(i).getIdIteracion() + " || "
                    + "Cantidad de semanas: " + listadoIteraciones.get(i).getCantidadaSemanas() + " || "
                    + "Estado: " + listadoIteraciones.get(i).getEstado()+"\n";
        }

        return almacenar;
    }
        
        
        
        // Pablo
        //INICIO METODOS PARA DESARROLLADORES
    
       public void agregarDesarrollador() {
        Desarrollador desarrollador = new Desarrollador();
        desarrollador.registroDesarrollador();
        desarrollador.setIdDesarrollador((int)(Math.random()*1000)); //genera el id automatico al desarrollador
        for (int i = 0; i < listadoDesarrolladores.size(); i++) { //valida si el ID del desarrollador ya existe
            if (desarrollador.getIdDesarrollador()== listadoDesarrolladores.get(i).getIdDesarrollador()) {
                while (desarrollador.getIdDesarrollador()== listadoDesarrolladores.get(i).getIdDesarrollador()) {
                    desarrollador.setIdDesarrollador((int)(Math.random()*1000));
                }
            }
        }
        
        //agrega el desarrollador al array
        
        listadoDesarrolladores.add(desarrollador);
        String text = ("Su ID de desarrollador es: "+desarrollador.getIdDesarrollador()); 
        JOptionPane.showMessageDialog(null, text);
    }
        //lee toda la info de los desarrolladores 
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
