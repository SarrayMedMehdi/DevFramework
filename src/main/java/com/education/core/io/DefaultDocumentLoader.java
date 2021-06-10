package com.education.core.io;

import com.education.core.DocumentLoader;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/*
*@author Med Mehdi Sarray
*/

public class DefaultDocumentLoader implements DocumentLoader {


    /**
     * Load the {@link Document} at the supplied {@link InputSource} using the standard JAXP-configured
     * XML parser.
     */
    @Override
    public Document loadDocument(File inputSource) throws ParserConfigurationException, IOException, SAXException {

            DocumentBuilderFactory factory = createDocumentBuilderFactory(0, false);
            DocumentBuilder builder = createDocumentBuilder(factory);
            return builder.parse(inputSource);
    }


    /**
     * Create the {@link DocumentBuilderFactory} instance.
     * @param namespaceAware whether the returned factory is to provide support for XML namespaces
     * @return the JAXP DocumentBuilderFactory
     * @throws ParserConfigurationException if we failed to build a proper DocumentBuilderFactory
     */
    protected DocumentBuilderFactory createDocumentBuilderFactory(int validationMode, boolean namespaceAware)
            throws ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        return factory;
    }


    protected DocumentBuilder createDocumentBuilder(DocumentBuilderFactory factory)
            throws ParserConfigurationException {

        DocumentBuilder docBuilder = factory.newDocumentBuilder();

        return docBuilder;
    }


}
