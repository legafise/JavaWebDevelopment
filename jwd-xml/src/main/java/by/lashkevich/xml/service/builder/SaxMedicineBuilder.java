package by.lashkevich.xml.service.builder;

import by.lashkevich.xml.service.ServiceException;
import by.lashkevich.xml.service.handler.MedicineSaxHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxMedicineBuilder extends MedicineBuilder {
    private MedicineSaxHandler handler = new MedicineSaxHandler();
    private XMLReader reader;

    public SaxMedicineBuilder() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
            reader.setContentHandler(handler);
        } catch (ParserConfigurationException | org.xml.sax.SAXException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void buildMedicineList(String filePath) {
        try {
            reader.parse(filePath);
            setMedicineList(handler.getMedicines());
        } catch (IOException | SAXException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}