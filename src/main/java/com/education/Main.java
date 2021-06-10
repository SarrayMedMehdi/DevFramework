package com.education;

import com.education.core.XmlBeanReader;

import java.io.File;

/*
 *@author Med Mehdi Sarray
 */

public class Main {

    public static void main(String[] args) {

        try {
            File inputFile = new File("ApplicationContext.xml");

            XmlBeanReader xmlbeanreader = new XmlBeanReader();

            xmlbeanreader.doLoadBeanDefinitions(inputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
