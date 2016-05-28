import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by DotinSchool2 on 5/28/2016.
 */
public class Main {
    public static  void main(String[] argv) throws ParserConfigurationException, SAXException, IOException {

        ReadXMLFile rd  =   new ReadXMLFile();
        final Document read = rd.Read();



    }
}
