
package javaapplication3;

import java.util.Scanner;
import javaapplication3.Docente;
/**
 *
 * @author danyx25
 */
public class javaxml {

    
    public static void main(String[] args) {
       Conexion c = new Conexion();
       /*c.leerXML();
       Docente objeto=new Docente("3","Daniel Iñiguez","Daniel","1234");
       c.Insertar(objeto);*/
       
      /*Scanner ent=new Scanner (System.in);
      String id, nombre,username,password;
        


        System.out.println("Ingrese los datos del docente que desea ingresar");
        System.out.print("Id:");
        id=ent.next();
        System.out.print("Nombre:");
        nombre=ent.next();
        System.out.print("Username:");
        username=ent.next();
        System.out.print("Password: ");
        password=ent.next();*/

    Docente objeto = new Docente ("3", "Mario Palma", "mario", "321423");
    c.leerXML(objeto);
      
    }
}
