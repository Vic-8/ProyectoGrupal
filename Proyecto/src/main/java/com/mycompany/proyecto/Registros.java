
package com.mycompany.proyecto;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ariana
 */
public class Registros {

    //ESTA CLASE ES UTILIZADA UNICAMENTE PARA LA CREACION, ALMACENAMIENTO, ELIMINACION Y LECTURA DE REQUERIMIENTOS E ITERACIONES
   
    //CREACION DE LOS ARRAYLISTS
    ArrayList<Requerimiento> listadoRequerimientos = new ArrayList();
    ArrayList<Iteracion> listadoIteraciones = new ArrayList();

    //INICIO METODOS REQUERIMIENTOS
    
    public void agregarRequerimiento() {
        Requerimiento requerimiento = new Requerimiento();
        requerimiento.registroRequerimiento();
        listadoRequerimientos.add(requerimiento);
    }

    public void leerRequerimiento() {
        String almacenar = "";

        for (int i = 0; i < listadoRequerimientos.size(); i++) {
            almacenar += "ID requerimiento: " + listadoRequerimientos.get(i).getIdRequerimiento() + " // Nombre requerimiento: " + listadoRequerimientos.get(i).getNombreRequerimiento()
                    + " // Esfuerzo necesario: " + listadoRequerimientos.get(i).getEsfuerzoNecesario() + " // Estado: " + listadoRequerimientos.get(i).getEstado() + "\n";
        }
        JOptionPane.showMessageDialog(null, almacenar);
    }
    
    public void eliminarRequerimiento(){
        int idRequerimiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de requerimiento que desea eliminar: "));
          for (int i = 0; i < listadoRequerimientos.size(); i++) {
              if (idRequerimiento==listadoRequerimientos.get(i).getIdRequerimiento()){
                  listadoRequerimientos.remove(i);
              } else {
                  JOptionPane.showMessageDialog(null, "No existe ningún requerimiento asociado a ese ID");
              }
          }   
        
    }
    
    //INICIO METODOS PARA LAS ITERACIONES
    
       public void agregarIteracion() {
        Iteracion iteracion = new Iteracion();
        iteracion.registroIteracion();
        listadoIteraciones.add(iteracion);
    }
        public void leerIteracion() {
        String almacenar = "";
        for (int i = 0; i < listadoIteraciones.size(); i++) {
            almacenar += "ID iteración: " + listadoIteraciones.get(i).getIdIteracion() + "\n"
                    + "Cantidad de semanas: " + listadoIteraciones.get(i).getCantidadaSemanas() + "\n"
                    + "Estado: " + listadoIteraciones.get(i).getEstado()+"\n";
        }
        JOptionPane.showMessageDialog(null, almacenar);
    }
}
