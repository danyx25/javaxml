
package javaapplication3;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
/**
 *
 * @author danyx25
 */
public class javaxml {

    
    public static void main(String[] args) {
       Conexion c = new Conexion();
       c.leerXML();
    }
}
