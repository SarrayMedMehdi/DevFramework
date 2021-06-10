package com.education.core;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/*
*@author Med Mehdi Sarray
*/

public interface DocumentLoader  {

    Document loadDocument(File inputSource) throws ParserConfigurationException, IOException, SAXException;
}
