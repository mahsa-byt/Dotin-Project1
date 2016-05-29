import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLFileParser {

    public Document read() throws IOException, SAXException,
            ParserConfigurationException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        File xmlFile = new File("src/sampleXML.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        Element root = doc.getDocumentElement();
        System.out.println("root is:" + root.getNodeName());

        NodeList listOfDeposits = doc.getElementsByTagName("deposit");

        for (int i = 0; i < 3; i++) {
            Node nodeForEachDeposit = listOfDeposits.item(i);
            if (nodeForEachDeposit.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nodeForEachDeposit;
//                System.out.println("customername : "    + eElement.getAttribute("customerNumber"));
//                System.out.println("depositType : "  + eElement.getElementsByTagName("depositType").item(0).getTextContent());
//                System.out.println("depositbalance : "   + eElement.getElementsByTagName("depositBalance").item(0).getTextContent());
//                System.out.println("durationindays : "    + eElement.getElementsByTagName("durationInDays").item(0).getTextContent());

                String depositType = eElement.getElementsByTagName("depositType").item(0).getTextContent();
                String customerNumber = eElement.getElementsByTagName("customerNumber").item(0).getTextContent();
                String depositBalance = eElement.getElementsByTagName("depositBalance").item(0).getTextContent();
                String durationInDays = eElement.getElementsByTagName("durationInDays").item(0).getTextContent();
                Deposit obj = (Deposit) Class.forName(depositType).newInstance();
                obj.customerNumber = Integer.parseInt(customerNumber);
                obj.depositeBalance = Integer.parseInt(depositBalance);
                obj.durationInDays = Integer.parseInt(durationInDays);



/*
                if (depositType.equals("ShortTerm")) {
                    Class<?> SampleOfShortTerm = null;
                    try {
                        SampleOfShortTerm = Class.forName(depositType);
                    } catch (Exception e) {
                        e.printStackTrace(
                        );
                    }
                    //Create instance of ShortTerm class
                    ShortTerm shortTerm_object;
                    try {
                        shortTerm_object = (ShortTerm) SampleOfShortTerm.newInstance();
                        shortTerm_object.interestRate = 10;
                        String customerNumber = eElement.getElementsByTagName("customerNumber").item(0).getTextContent();
                        String depositBalance = eElement.getElementsByTagName("depositBalance").item(0).getTextContent();
                        String durationInDays = eElement.getElementsByTagName("durationInDays").item(0).getTextContent();
                        shortTerm_object.customerNumber = Integer.parseInt(customerNumber);
                        shortTerm_object.depositeBalance = Integer.parseInt(depositBalance);
                        shortTerm_object.durationInDays = Integer.parseInt(durationInDays);
                        System.out.println(shortTerm_object.customerNumber + "  " + shortTerm_object.PayedInterest());
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

                if (depositType.equals("Qarz")) {
                    Class<?> SampleOfQarz = null;
                    try {
                        SampleOfQarz = Class.forName("Qarz");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //Create instance Of Qarz
                    Qarz qarz_object = null;
                    try {
                        qarz_object = (Qarz) SampleOfQarz.newInstance();
                        qarz_object.interestRate = 0;
                        qarz_object.customerNumber = Integer.parseInt(eElement.getElementsByTagName("customerName").item(0).getTextContent());
                        qarz_object.depositeBalance = Integer.parseInt(eElement.getElementsByTagName("depositBalance").item(0).getTextContent());
                        qarz_object.durationInDays = Integer.parseInt(eElement.getElementsByTagName("durationInDays").item(0).getTextContent());
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }//End Of Qarz

                if (depositType.equals("LongTerm")) {
                    Class<?> SampleOfLongTerm = null;
                    try {
                        SampleOfLongTerm = Class.forName("LongTerm");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //Create instance of LongtTerm
                    LongTerm longTerm_object = null;
                    try {
                        longTerm_object = (LongTerm) SampleOfLongTerm.newInstance();
                        longTerm_object.interestRate = 20;
                        longTerm_object.customerNumber = Integer.parseInt(eElement.getElementsByTagName("customerName").item(0).getTextContent());
                        longTerm_object.depositeBalance = Integer.parseInt(eElement.getElementsByTagName("depositBalance").item(0).getTextContent());
                        longTerm_object.durationInDays = Integer.parseInt(eElement.getElementsByTagName("durationInDays").item(0).getTextContent());
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
*/

            }
        }//EndOf for


        return doc;
    }
}
