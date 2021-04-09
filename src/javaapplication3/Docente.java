
package javaapplication3;

/**
 *
 * @author danyx25
 */
public class Docente {
    
    String nombre, username,id, password;
    

    public String getiD() {
        return id;
    }

    public void setiD(String d) {
        this.id = d;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Docente(String id, String password, String nombre, String username) {
        this.id = id;
        this.password = password;
        this.nombre = nombre;
        this.username = username;
    }

   
    
}
