/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package albert.m06uf1exjavanio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 *
 * @author Albert
 */
public class M06UF1Ex1JavaNIO {

    public static void main(String[] args) {
                
    Scanner in = new Scanner(System.in);
    
    /***
     * Indicamos las rutas de entrada i salida del fichero.
     */
    System.out.println("Indica Ruta entrada:");
    String rutaEntrada = in.nextLine();
    
    System.out.println("Indica Ruta salida:");
    String rutaSalida = in.nextLine();
    
    /***
     * Iniciamos los archivos de entrada, el de salida y la clave de cifrado.
     */
    File archivoEntrada = new File(rutaEntrada);
    File archivoSalida = new File(rutaSalida);
    String clave = "alb2";

    
        try (FileInputStream fis = new FileInputStream(archivoEntrada);
             FileOutputStream fos = new FileOutputStream(archivoSalida)) {

            /***
             * Iniciamos un buffer de bytes para convertir las letras en bytes. 
             */
            byte[] buffer = new byte[1024];
            int bytesLeidos;
            int i=0;
            while ((bytesLeidos = fis.read(buffer)) != -1) {
                for (int j = 0; j < bytesLeidos; j++) {
                    /***
                     *  Aqui realizamos la operacion XOR de los valores que tenemos almacenados en bytes y el valor de la clave en bytes.
                     */
                    buffer[j] = (byte) (buffer[j] ^ clave.getBytes()[i % clave.length()]);
                    i++;
                }
                fos.write(buffer, 0, bytesLeidos);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
}
