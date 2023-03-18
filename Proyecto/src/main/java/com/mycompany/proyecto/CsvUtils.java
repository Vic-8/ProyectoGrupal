/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victo
 */
// para referencias futuras: https://stackabuse.com/reading-and-writing-csvs-in-java/
public class CsvUtils {

    public int guardar(String nombreDelArchivo, String[] valores) {
        int id =0;
        try {

            id = calcularSiguienteId(nombreDelArchivo);
            FileWriter csvWriter = new FileWriter(nombreDelArchivo, true);

            csvWriter.append(id + ",");
            for (String valor : valores) {
                csvWriter.append(valor);
                csvWriter.append(",");
            }
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();

        } catch (IOException ex) {
            System.out.println(ex);
        }
        return id;
    }


    private boolean fileExists(String nombreArchivo) {
        File f = new File(nombreArchivo);
        return (f.exists() && !f.isDirectory());
    }

    private int calcularSiguienteId(String nombreArchivo) {
        int id = 0;
        try {
            String ultimoReglon = null;
            String line;
            if (fileExists(nombreArchivo)) {
                var reader = new BufferedReader(new FileReader(nombreArchivo));
                while ((line = reader.readLine()) != null) {
                    if (line != null) {
                        ultimoReglon = line;
                    }
                }
                var valores = ultimoReglon.split(",");
                int ultimoId = Integer.parseInt(valores[0]);
                return ++ultimoId;
            }
        } catch (FileNotFoundException ex) {
            return 0;
        } catch (Exception ex) {
            System.out.println("No se pudo encontrar la ultima linea del csv");
        }
        return id;
    }
}
