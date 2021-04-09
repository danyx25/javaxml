
package javaapplication3;

/**
 *
 * @author danyx25
 */
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import java.io.File;
import java.lang.reflect.Array;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javaapplication3.Docente;
/**
 *
 * @author danyx25
 */
public class Conexion {
    
    private ObjectContainer oc;
    private Docente Docente;
    
    private void open(){
        //creamos la conexion y el archivo almacenara los datos
        this.oc=Db4o.openFile("database.yap");
    }
    
    Docente objet;
    @SuppressWarnings("empty-statement")
    public boolean Insertar(Docente objeto){
    try{
        //buscamos si existe el objeto, si no insertamos el obejoto recibido.
        this.open();
        oc.set(objeto);
        this.oc.close();
        objet=objeto;
        System.out.println("Se ha guardado el objeto");
        return true;
    }catch(DatabaseClosedException e){
        System.out.println("bdoo.Controlador.InsertarPersona() : "+e);
        return false;
    }
    }
   
    public Docente[] insertarXML(Docente objeto){
        
        //si el objeto se encuentra ya guardado colocar un mensaje 
        //y si el objeto no se encuentra entonces guardelo al objeto
        leerXML(objeto);
        
       return null;
    }
    
    public Docente[] leerXML(Docente objeto){
        Docente[] docentes =new Docente[10];
             try{
            Docente docentexml=null;
            File archivo = new File("datos.xml");
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d=db.parse(archivo);
            d.getDocumentElement().normalize();
            //System.out.println("elemento principal:"+d.getDocumentElement().getNodeName());//el nombre primera etiqueta
            //cargando todos los docentes en una coleccion de tipo nodo
            NodeList listDocentes = d.getElementsByTagName("docente");//Con esto sacamos el número total que tenemos en base al nombre
            for(int i=0;i<listDocentes.getLength();i++){
                Node nodo=listDocentes.item(i);
               // System.out.println("Docente:"+nodo.getNodeName()+i);
                if(nodo.getNodeType()==Node.ELEMENT_NODE){
                    Element element =(Element)nodo;
                    String id=element.getAttribute("id");
                    String nombre=element.getElementsByTagName("nombre").item(0).getTextContent();
                    String username=element.getElementsByTagName("username").item(0).getTextContent();
                    String password=element.getElementsByTagName("password").item(0).getTextContent();

                  docentexml=new Docente (id, nombre, username, password);
                  docentes[i]=docentexml;
                   
                  //Insertar(docentexml);
                   /* System.out.println("id:"+id);
                    System.out.println("Nombre:"+nombre);
                    System.out.println("username:"+username);
                    System.out.println("password: " +password);*/
                  
                  
                }              
                    int a=Integer.parseInt(objeto.getId());
                    int b=Integer.parseInt(docentexml.getId());
                  if(a==b){
                      System.out.println("Este Docente ya esta ingresado");
                      return null;
                  }
            }
            Insertar(objeto);
                 
        }catch (Exception e) {
            e.printStackTrace();
        }
    return docentes;

    }

    
    
    }