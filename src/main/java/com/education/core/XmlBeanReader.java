package com.education.core;

import com.education.core.business.metier.IBusinessObject;
import com.education.core.io.DefaultDocumentLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/*
*@author Med Mehdi Sarray
*/

public class XmlBeanReader {


    private DocumentLoader documentLoader = new DefaultDocumentLoader();


    /**
     * Actually load bean definitions from the specified XML file.
     *
     * @param inputSource the SAX InputSource to read from
     * @return the number of bean definitions found
     * @see #doLoadDocument
     */
    public void doLoadBeanDefinitions(File inputSource) throws Exception {
        Document doc = doLoadDocument(inputSource);
        registerBeanDefinitions(doc);
    }

    /**
     * Actually load the specified document using the configured DocumentLoader.
     *
     * @param inputSource the SAX InputSource to read from
     * @return the DOM Document
     * @throws Exception when thrown from the DocumentLoader
     * @see DocumentLoader#loadDocument
     */
    public Document doLoadDocument(File inputSource) throws Exception {
        return this.documentLoader.loadDocument(inputSource);
    }

    /**
     * Register the bean definitions contained in the given DOM document.
     * Called by {@code loadBeanDefinitions}.
     * <p>Creates a new instance of the parser class and invokes
     */
    public void registerBeanDefinitions(Document doc) {

        doregisterBeanElement(doc);

    }

    public void doregisterBeanElement(Document doc) {


        System.out.println("[DEBUG] Root element: " + doc.getDocumentElement().getNodeName()); //beans

        List<Object> objects = new ArrayList<>();
        try {

            NodeList nList = doc.getElementsByTagName("bean");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String className = eElement.getAttribute("class");

                    Class<?> clazz = Class.forName(className);
                    Object objectDao = clazz.getConstructor().newInstance();
                    objects.add(objectDao);

                    String setterName = eElement.getAttribute("setterName");
                    String target = eElement.getAttribute("target");

                    if (!setterName.isEmpty() && !target.isEmpty()) {
                        System.out.println("[DEBUG] "+target);
                        Method setter = clazz.getMethod(setterName, new Class[]{Class.forName(target)});
                        setter.invoke(objectDao, new Object[]{objects.get(0)});

                        System.out.println(((IBusinessObject) objectDao).calcul());
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
