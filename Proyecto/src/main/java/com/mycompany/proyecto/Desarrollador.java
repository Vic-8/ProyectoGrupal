package com.mycompany.proyecto;
import javax.swing.JOptionPane;
/**
 *
 * @author Pablo M
 */

// PARA REGISTRO DE DESARROLLADORES;

public class Desarrollador {
    
    //Aributos del objeto desarrollador
    private int idDesarrollador;                    
    private String primerNombreDesarrollador;       
    private String primerApellidoDesarrollador;     
    private String segundoApellidoDesarrollador;    
    private String nombreDesarrollador;             
    private String siglasDesarrollador;             
    private int costoDiario;                                                
    public static int numeroDesarrolladores = 3;  //Contador para la cantidad de desarrolladores                                             
    public static int contadorID = 3; //Contador para los ID de desarrolladores   

    
    //Constructor
    public Desarrollador(int idDesarrollador, String primerNombreDesarrollador, String primerApellidoDesarrollador, String segundoApellidoDesarrollador, int costoDiario) {
        this.idDesarrollador = idDesarrollador;
        this.primerNombreDesarrollador = primerNombreDesarrollador;
        this.primerApellidoDesarrollador = primerApellidoDesarrollador;
        this.segundoApellidoDesarrollador = segundoApellidoDesarrollador;
        this.nombreDesarrollador = (this.primerNombreDesarrollador+" "+this.primerApellidoDesarrollador+" "+ this.segundoApellidoDesarrollador);
        this.siglasDesarrollador = (this.primerNombreDesarrollador.substring(0, 1).toUpperCase()+this.primerApellidoDesarrollador.substring(0, 1).toUpperCase()+ this.segundoApellidoDesarrollador.substring(0, 1).toUpperCase());
        this.costoDiario = costoDiario;
    }
    public Desarrollador() {
    }
    
    //METODO CREAR DESARROLLADOR
    public void registroDesarrollador() {
        this.primerNombreDesarrollador = JOptionPane.showInputDialog("Ingrese el primer nombre del desarrollador: ");
        this.primerApellidoDesarrollador = JOptionPane.showInputDialog("Ingrese el primer apellido del desarrollador: ");
        this.segundoApellidoDesarrollador = JOptionPane.showInputDialog("Ingrese el segundo apellido del desarrollador: ");
        this.nombreDesarrollador = (this.primerNombreDesarrollador+" "+this.primerApellidoDesarrollador+" "+ this.segundoApellidoDesarrollador);
        this.siglasDesarrollador = (this.primerNombreDesarrollador.substring(0, 1).toUpperCase()+this.primerApellidoDesarrollador.substring(0, 1).toUpperCase()+ 
                this.segundoApellidoDesarrollador.substring(0, 1).toUpperCase()); //Crea las siglas del desarrollador automáticamente
        this.costoDiario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el costo por dia del desarrollador: "));
        contadorID++;
        this.idDesarrollador = contadorID;
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

    public String getSiglasDesarrollador() {
        return siglasDesarrollador;
    }

    public int getCostoDiario() {
        return costoDiario;
    }

    public void setCostoDiario(int costoDiario) {
        this.costoDiario = costoDiario;
    }

    public static int getNumeroDesarrolladores() {
        return numeroDesarrolladores;
    }

    public static void setNumeroDesarrolladores(int numeroDesarrolladores) {
        Desarrollador.numeroDesarrolladores = numeroDesarrolladores;
    }
    
}
