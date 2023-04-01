
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
    ArrayList<Objeto> listadoAsignacion = new ArrayList<>();
    
    //Creacion variables
    Objeto objeto = new Objeto();
    Asignacion [][] matriz;
     
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
        var repositorio = new DesarrolladorRepositorio();
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
//        var id = repositorio.guardar(desarrollador);
        //desarrollador.setIdDesarrollador(id);
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
    
        
        public void asignacionTrabajo(Registro requerimientos, Registro iteracion, Registro desarollador){
 
            String valido = "x";
            int opcion = 0;
            int continuar = 1;
            boolean validar = false;

                requerimientos.leerRequerimiento();
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione un requerimiento: "));
                for (int i = 0; i < listadoRequerimientos.size(); i++) {
                    if (opcion == listadoRequerimientos.get(i).getIdRequerimiento()) {
                        objeto.setRequerimiento(listadoRequerimientos.get(i).getIdRequerimiento());
                        validar = true;
                        valido="j";
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe ningún requerimiento asociado a ese ID");
                        validar = false;
                    }
                }
            
        
        if (validar == true) {
            while (valido == "x") {
                leerIteracion();
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione una iteración: \n" ));
                for (int i = 0; i < listadoIteraciones.size(); i++) {
                    if (opcion == listadoIteraciones.get(i).getIdIteracion()) {
                        matriz = new Asignacion[listadoIteraciones.get(i).getCantidadaSemanas()][5];
                        valido = "j";
                        validar = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe ninguna iteración asociada a ese ID");
                        valido = "x";
                    }
                }

            }
        }

        if (validar == true) {
            while (valido == "x") {
                leerDesarrollador();
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione un desarrollador: "));
                for (int i = 0; i < listadoDesarrolladores.size(); i++) {
                    if (opcion == listadoDesarrolladores.get(i).getIdDesarrollador()) {
                        objeto.setDesarrollador(listadoDesarrolladores.get(i).getSiglasDesarrollador());
                        valido = "j";
                        validar = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe ningún desarrollador asociado a ese ID");
                        valido = "x";
                    }
                }

            }
        }

        listadoAsignacion.add(objeto);

        for (int i = 0; i < listadoAsignacion.size(); i++) {
            JOptionPane.showMessageDialog(null, "Desarrollador: " + listadoAsignacion.get(i).getDesarrollador() + "\n"
                    + "Requerimiento asignado: " + listadoAsignacion.get(i).getRequerimiento());
        }

    }


        
        
        
        
        
        
        
        
}
