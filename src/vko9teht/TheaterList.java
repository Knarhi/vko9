/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vko9teht;


import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import static java.lang.Integer.parseInt;


/**
 *
 * @author Qnaerhi
 */
public class TheaterList {
    public static ArrayList<Theater> theaters = new ArrayList<>();
    
    public void getList(String url, String tag1, String tag2) throws Exception {
        
        PageReader pr = new PageReader();
        Document doc;
        doc = (Document) PageReader.loadTestDocument(url, tag1, tag2);
        doc.getDocumentElement().normalize();

        
    }
    

}
