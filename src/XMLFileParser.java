import exception.NegativeBalanceException;
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
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class XMLFileParser {

    public List<Deposit> read() throws IOException, SAXException,
            ParserConfigurationException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        File xmlFile = new File("sampleXML.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        NodeList listOfDeposits = doc.getElementsByTagName("deposit");

        List<Deposit> listForSavingDeposits = new ArrayList<Deposit>();

        for (int i = 0; i < listOfDeposits.getLength(); i++) {
            Node nodeForEachDeposit = listOfDeposits.item(i);
            if (nodeForEachDeposit.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nodeForEachDeposit;
                String depositType = String.valueOf(eElement.getElementsByTagName("depositType").item(0).getTextContent());
                String customerNumber = String.valueOf(eElement.getElementsByTagName("customerNumber").item(0).getTextContent());
                String depositBalance = String.valueOf(eElement.getElementsByTagName("depositBalance").item(0).getTextContent());
                String durationInDays = String.valueOf(eElement.getElementsByTagName("durationInDays").item(0).getTextContent());

                //Fill the Objects
                Deposit deposit = new Deposit();
                deposit.setCustomerNumber(Integer.parseInt(customerNumber));

                try {
                    deposit.setDepositBalance(new BigDecimal(depositBalance));
                    int resultOfComparing = deposit.getDepositBalance().compareTo(BigDecimal.ZERO);
                    if (resultOfComparing <= 0) {
                        throw new NegativeBalanceException();
                    }
                    deposit.setDurationInDays(Integer.parseInt(durationInDays));
                    if (deposit.getDurationInDays() <= 0) {
                        throw new IllegalArgumentException();
                    }
                    deposit.setDepositType((DepositType) Class.forName(depositType).newInstance());
                    listForSavingDeposits.add(deposit);
                } catch (ClassNotFoundException e) {
                    System.out.println("Invalid Deposit Type");
                } catch (NegativeBalanceException e) {
                    System.out.println("Invalid Deposit Balance");
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid DurationInDays");
                }
            }
        }

        return listForSavingDeposits;
    }


    //Write objects in output file
    public void WriteInRandomAccessFile(List<Deposit> inputDepositList) throws IOException {
        RandomAccessFile output = new RandomAccessFile("output.txt", "rw");
        StringBuilder stringBuilder = new StringBuilder();
        for (Deposit deposit : inputDepositList) {
            stringBuilder.append(deposit.getCustomerNumber()).append("#").append(deposit.getPayedInterest().toString()).append("\n");
        }
        output.writeBytes(stringBuilder.toString());
    }
}
