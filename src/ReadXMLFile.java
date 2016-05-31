/**
 * Created by DotinSchool2 on 5/28/2016.
 */
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class ReadXMLFile {

    public  Document Read() throws IOException,SAXException,
                                                   ParserConfigurationException{

            File xmlFile                        =   new File("C:\\Users\\DotinSchool2\\Desktop\\Project1\\src\\sampleXML.xml");
            DocumentBuilderFactory dbFactory    =   DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder            =   dbFactory.newDocumentBuilder();
            Document doc                        =   dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            //System.out.println("root element is: " + doc.getDocumentElement().getNodeName());


            return doc;
    }
}
