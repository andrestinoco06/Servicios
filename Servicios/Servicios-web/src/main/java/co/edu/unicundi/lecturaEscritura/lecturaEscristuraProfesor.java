/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.lecturaEscritura;

import co.edu.unicundi.controller.UsuarioController;
import co.edu.unicundi.pojo.Usuario;

import com.sun.corba.se.impl.io.IIOPOutputStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johan
 */
public class lecturaEscristuraProfesor {
    public void crearArchivo(List<Usuario> usuario) {
        System.out.println("ENTRO CREAR PROFESOR");
        try {

            FileOutputStream fos = new FileOutputStream("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion II\\Ejercicio1Servicios\\AProfesor.txt");
            
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(usuario);
            oos.flush();
            oos.close();
            System.out.println("CREO PROFESOR");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(lecturaEscristuraProfesor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(lecturaEscristuraProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void agregarArchivo(List<Usuario> lista) {
        System.out.println("ENTRO CREAR PROFESOR");
        try {

            FileOutputStream fos = new FileOutputStream("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion II\\Ejercicio1Servicios\\AProfesor.txt");
            
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.flush();
            oos.close();
            System.out.println("CREO PROFESOR");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(lecturaEscristuraProfesor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(lecturaEscristuraProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Usuario> verProfesor() {
        List<Usuario> listaL = null;
        FileInputStream fis = null;
        System.out.println("Entro a ver al profesor");
        try {
            fis = new FileInputStream("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion II\\Ejercicio1Servicios\\AProfesor.txt");
            if(fis != null){
                System.out.println("Entro a pesar de que no existe");
                ObjectInputStream listaEntrada = new ObjectInputStream(fis);
                listaL = (List<Usuario>) listaEntrada.readObject();
            }else{
                System.out.println("NO ENCONTRO profesor, NO EXISTE EL ARCHIVO");
            }
        } catch (FileNotFoundException ex) {
                
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(lecturaEscristuraProfesor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("NO ENCONTRO profesor, NO EXISTE EL ARCHIVO, EXCEPCIÓN");
        }
        System.out.println("S");
        return listaL;
    }
}