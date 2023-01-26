/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package albert.m06uf1exjavanio;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Albert
 */
public class M06UF2Ex2JavaNIO {

    private static int deletedFiles = 0;
    private static int notDeletedFiles = 0;
    private static int analyzedDirectories = 0;

    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        
        //Indico Ruta
        System.out.println("Introduce ruta:");
        String path = in.nextLine();
        
        
        //Introduzco extension
        String extension = "txt";
        
        
        //Creo una fecha especifica a traves de un input.
        System.out.println("Indica fecha valida:");
        String fecha = in.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = format.parse(fecha);
        
        
        //Borra los archivos.
        deleteFiles(new File(path), extension, date);
        
        
        //Muestra Resultados.
        System.out.println("Files deleted: " + deletedFiles);
        System.out.println("Files not deleted: " + notDeletedFiles);
        System.out.println("Directories analyzed: " + analyzedDirectories);
        
    }
    
    
    //Funcion de borrado.
    private static void deleteFiles(File file, String extension, Date date) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                deleteFiles(f, extension, date);
            }
            analyzedDirectories++;
        } else {
            //Compruebo la extension del archivo.
            if (file.getName().endsWith("." + extension)) {
                //Compruebo la fecha de modificacion.
                Date date2 = new Date(file.lastModified());
                if(date2.before(date)){
                    file.delete();
                    deletedFiles++;
                }else{
                    notDeletedFiles++;
                }
                
            }else{
                notDeletedFiles++;
            }
        }
 
    }
}    

