import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SAXException {
        XMLFileParser readXMLFile = new XMLFileParser();
        List<Deposit> depositResults = readXMLFile.read();
        Collections.sort(depositResults);
        readXMLFile.WriteInRandomAccessFile(depositResults);
    }

}