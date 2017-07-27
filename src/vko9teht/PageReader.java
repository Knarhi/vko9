/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vko9teht;

import java.io.IOException;
import java.io.InputStream;
import static java.lang.Integer.parseInt;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;



/**
 * https://stackoverflow.com/questions/22487516/how-to-read-xml-document-from-url
 * https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
 * @author Qnaerhi
 */
public class PageReader {
    
        
        public static Document loadTestDocument(String url, String tag1, String tag2) throws Exception {
        URL u = new URL(url);
        URLConnection connection;
        connection = u.openConnection();

        Document doc = parseXML(connection.getInputStream());
        NodeList idNodes = doc.getElementsByTagName(tag1);
        NodeList nameNodes = doc.getElementsByTagName(tag2);
        
        
        if ("ID".equals(tag1) && "Name".equals(tag2)) {
        
        
        
            for(int i=0; i<idNodes.getLength();i++)
            {
                String id = idNodes.item(i).getTextContent();
                
                int idn = parseInt(id);
                String s = nameNodes.item(i).getTextContent();
                if (s != null) {
                   
                    Theater th = new Theater(idn, s);
                    TheaterList.theaters.add(th);
                }
            }
        }
            
        
        
           
        

        return doc;
        
    }

    private static Document parseXML(InputStream stream)
    throws Exception
    {
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try
        {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);
        }
        catch(Exception ex)
        {
            throw ex;
            
        }       

        return doc;
    }

    public Document LoadShowList (String url, String id, String time, String endTime) throws MalformedURLException, IOException, Exception {
        URL u = new URL(url);
        URLConnection connection;
        connection = u.openConnection();

        Document doc = parseXML(connection.getInputStream());
        NodeList idNodes = doc.getElementsByTagName(id);
        NodeList timeNodes = doc.getElementsByTagName(time);
        NodeList endNodes = doc.getElementsByTagName(endTime);
        String theaterid = url.substring(43,47);
            
            for(int i=0; i<idNodes.getLength();i++)
            {
                String j = idNodes.item(i).getTextContent();
                int idn = parseInt(j);
                String s = timeNodes.item(i).getTextContent();
                String e = endNodes.item(i).getTextContent();
                
                 
                if (s != null) {
                    Show sh = new Show(j,idn,s);
                    
                    
                }
                
            }
        

        return doc;
        /*DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL(url).openStream());
        System.out.println(doc);
        return doc;
        //return (Document) dbf.newDocumentBuilder().parse(new URL(url).openStream()); */
    }
}



