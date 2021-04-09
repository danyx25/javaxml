
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
    
    @SuppressWarnings("empty-statement")
    public boolean Insertar(Docente objeto){
    try{
        //buscamos si existe el objeto, si no insertamos el obejto recibido.
        this.open();
        oc.set(objeto);
        this.oc.close();
        return true;
    }catch(DatabaseClosedException e){
        System.out.println("bdoo.Controlador.InsertarPersona() : "+e);
        return false;
    }
    }
    
    public Docente buscarDocente(Docente objeto){
    this.open();
    Docente encontrado =null;
    ObjectSet resultados = this.oc.get(objeto);
    
    if(resultados.hasNext()){
        encontrado=(Docente) resultados.next();
    
    }
    this.oc.close();
    return encontrado;
    }
    
    public void leerXML(){
        try{
            Docente Docentexml=null;
        File archivo = new File ("datos.xml");
        DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
        Document d = db.parse(archivo);
        d.getDocumentElement().normalize();
            System.out.println("elemento principal: "+d.getDocumentElement().getNodeName());
            
            NodeList listDocentes = d.getElementsByTagName("docente");
            
            for(int i=0;i<listDocentes.getLength();i++){
                Node nodo=listDocentes.item(i);
                System.out.println("Docente: "+nodo.getNodeName()+i);
                if(nodo.getNodeType()==Node.ELEMENT_NODE){
                    Element element=(Element)nodo;
                    Docentexml.setiD(element.getAttribute("id"));
                    Docentexml.setNombre(element.getElementsByTagName("nombre").item(0).getTextContent());
                    Docentexml.setUsername(element.getElementsByTagName("username").item(0).getTextContent());
                    Docentexml.setPassword(element.getElementsByTagName("password").item(0).getTextContent());
                    
                    Insertar(Docentexml);
                    
                    System.out.println("id: "+element.getAttribute("id"));
                    System.out.println("Nombre: "+element.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Username: "+element.getElementsByTagName("username").item(0).getTextContent());
                    System.out.println("password: "+element.getElementsByTagName("password").item(0).getTextContent());
                    
                }
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    }