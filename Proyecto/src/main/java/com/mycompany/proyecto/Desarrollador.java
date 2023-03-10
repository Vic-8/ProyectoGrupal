package com.mycompany.proyecto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Pablo M
 */

// PARA REGISTRO DE DESARROLLADORES;

public class Desarrollador {
    
    //AT
    private int idDesarrollador;                    // ID (0021)
    private String primerNombreDesarrollador;       // Nombre(Pablo)
    private String primerApellidoDesarrollador;     // Apellido 1 (Mendez)
    private String segundoApellidoDesarrollador;    // Apellodp 2 (Hidalgo)
    private String nombreDesarrollador;             // Nombre completo (Pablo Mendez Hidalgo) *Auto
    private String siglasDesarrollador;             // Iniciales (PMH) *Auto
    private int costoDiario;                        // Costo por dia (no se para que es esto /Ver enunciado del caso)
    
    //Class
    private int nuevo = 0;                          // Validar while
    public static int numeroDesarrolladores = 0;     // Contador (Max 5.)

    
    //Constructor
    public Desarrollador(int idDesarrollador, String primerNombreDesarrollador, String primerApellidoDesarrollador, String segundoApellidoDesarrollador, String nombreDesarrollador, String siglasDesarrollador, int costoDiario) {
        this.idDesarrollador = idDesarrollador;
        this.primerNombreDesarrollador = primerNombreDesarrollador;
        this.primerApellidoDesarrollador = primerApellidoDesarrollador;
        this.segundoApellidoDesarrollador = segundoApellidoDesarrollador;
        this.nombreDesarrollador = nombreDesarrollador;
        this.siglasDesarrollador = siglasDesarrollador;
        this.costoDiario = costoDiario;
    }
    public Desarrollador() {
    }
    
    //METODO CREAR DESARROLLADOR
    public void registroDesarrollador() {
        this.idDesarrollador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del desarrollador: ")); 
        //PENDIENTE CREAR EL ID DESARROLLADOR AUTOMATICO, PORQUE DICE ASIGNARLE NO SOLICITARLE
        
        this.primerNombreDesarrollador = JOptionPane.showInputDialog("Ingrese el primer nombre del desarrollador: ");
        this.primerApellidoDesarrollador = JOptionPane.showInputDialog("Ingrese el primer apellido del desarrollador: ");
        this.segundoApellidoDesarrollador = JOptionPane.showInputDialog("Ingrese el segundo apellido del desarrollador: ");
        this.nombreDesarrollador = (this.primerNombreDesarrollador+" "+this.primerApellidoDesarrollador+" "+ this.segundoApellidoDesarrollador);
        this.siglasDesarrollador = (this.primerNombreDesarrollador.substring(0, 1).toUpperCase()+this.primerApellidoDesarrollador.substring(0, 1).toUpperCase()+ this.segundoApellidoDesarrollador.substring(0, 1).toUpperCase());
        this.costoDiario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el costo por dia del desarrollador: "));     // PENDING!!
        
        String text = (this.nombreDesarrollador+" "+this.siglasDesarrollador)+" "+this.idDesarrollador; // Todo junto (casi)
        JOptionPane.showMessageDialog(null, text);                                   // MOSTRAR LA INFORMACION, ES PARA PRUEBAS
    }
    
    //Getter & Setter
    public int getIdDesarrollador() {
        return idDesarrollador;
    }

    public void setIdDesarrollador(int idDesarrollador) {
        this.idDesarrollador = idDesarrollador;
    }

    public String getPrimerNombreDesarrollador() {
        return primerNombreDesarrollador;
    }

    public void setPrimerNombreDesarrollador(String primerNombreDesarrollador) {
        this.primerNombreDesarrollador = primerNombreDesarrollador;
    }

    public String getPrimerApellidoDesarrollador() {
        return primerApellidoDesarrollador;
    }

    public void setPrimerApellidoDesarrollador(String primerApellidoDesarrollador) {
        this.primerApellidoDesarrollador = primerApellidoDesarrollador;
    }

    public String getSegundoApellidoDesarrollador() {
        return segundoApellidoDesarrollador;
    }

    public void setSegundoApellidoDesarrollador(String segundoApellidoDesarrollador) {
        this.segundoApellidoDesarrollador = segundoApellidoDesarrollador;
    }

    public String getNombreDesarrollador() {
        return nombreDesarrollador;
    }

    public void setNombreDesarrollador(String nombreDesarrollador) {
        this.nombreDesarrollador = nombreDesarrollador;
    }

    public String getSiglasDesarrollador() {
        return siglasDesarrollador;
    }

    public void setSiglasDesarrollador(String siglasDesarrollador) {
        this.siglasDesarrollador = siglasDesarrollador;
    }

    public int getCostoDiario() {
        return costoDiario;
    }

    public void setCostoDiario(int costoDiario) {
        this.costoDiario = costoDiario;
    }

    public int getNuevo() {
        return nuevo;
    }

    public void setNuevo(int nuevo) {
        this.nuevo = nuevo;
    }

    public static int getNumeroDesarrolladores() {
        return numeroDesarrolladores;
    }

    public static void setNumeroDesarrolladores(int numeroDesarrolladores) {
        Desarrollador.numeroDesarrolladores = numeroDesarrolladores;
    }
    
}
