/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author victo
 */
public class DesarrolladorRepositorio {

    private String pathArchivo = "desarrolladores.csv";

    public int guardar(Desarrollador desarollador) {
        var csvUtils = new CsvUtils();
        csvUtils.guardar(pathArchivo, new String[]{
            desarollador.getNombreDesarrollador(),
            desarollador.getPrimerNombreDesarrollador(),
            desarollador.getPrimerApellidoDesarrollador(),
            desarollador.getSegundoApellidoDesarrollador(),
            desarollador.getSiglasDesarrollador(),
            String.valueOf(desarollador.getCostoDiario()),});
        
        return 0;
    }

}



