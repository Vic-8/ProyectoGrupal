
package com.mycompany.proyecto;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ariana
 */
public class Registros {

    //ESTA CLASE ES UTILIZADA UNICAMENTE PARA LA CREACION, ALMACENAMIENTO, ELIMINACION Y LECTURA DE REQUERIMIENTOS, ITERACIONES Y DESARROLLADORES  // es mucho no?
   
    //CREACION DE LOS ARRAYLISTS
    ArrayList<Requerimiento> listadoRequerimientos = new ArrayList();
    ArrayList<Iteracion> listadoIteraciones = new ArrayList();
    ArrayList<Desarrollador> listadoDesarrolladores = new ArrayList();

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
       
        public void leerIteracion() {
        String almacenar = "";
        for (int i = 0; i < listadoIteraciones.size(); i++) {
            almacenar += "ID iteración: " + listadoIteraciones.get(i).getIdIteracion() + "\n"
                    + "Cantidad de semanas: " + listadoIteraciones.get(i).getCantidadaSemanas() + "\n"
                    + "Estado: " + listadoIteraciones.get(i).getEstado()+"\n";
        }
        JOptionPane.showMessageDialog(null, almacenar);
    }
        
        
        
        // Pablo
        //INICIO METODOS PARA DESARROLLADORES
    
       public void agregarDesarrollador() {
        var repositorio = new DesarrolladorRepositorio();
        Desarrollador desarrollador = new Desarrollador();
        desarrollador.registroDesarrollador();
        var id = repositorio.guardar(desarrollador);
        desarrollador.setIdDesarrollador(id);
        listadoDesarrolladores.add(desarrollador);
    }
        // Add to main PENDING!!
        public void leerDesarrollador() {
        String almacenar = "";
        for (int i = 0; i < listadoDesarrolladores.size(); i++) {
            almacenar += "ID desarrollador: " + listadoDesarrolladores.get(i).getIdDesarrollador()+ "\n"
                    + "Nombre: " + listadoDesarrolladores.get(i).getNombreDesarrollador()+ "\n"
                    + "Siglas: " + listadoDesarrolladores.get(i).getSiglasDesarrollador()+"\n"
                    + "Costo por día: "+listadoDesarrolladores.get(i).getCostoDiario();
        }
        JOptionPane.showMessageDialog(null, almacenar);
    }
        
}
