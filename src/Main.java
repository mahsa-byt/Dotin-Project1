import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SAXException {
        XMLFileParser readXMLFile = new XMLFileParser();
        List<Deposit> depositResults = readXMLFile.read();
        for (Deposit depositResult : depositResults) {
            System.out.println("CustomerNumber: " + depositResult.getCustomerNumber() + "    PayedInterest: " + depositResult.calculatePayedInterest());
        }
    }
}
