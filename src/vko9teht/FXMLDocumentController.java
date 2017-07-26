/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vko9teht;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;


/**
 *
 * @author Qnaerhi
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private Button timeSearchButton;
    @FXML
    private Button nameSearchButton;
    @FXML
    private Label outPutField;
    @FXML
    private TextField dateInputField;
    @FXML
    private TextField startTime;
    @FXML
    private TextField endTime;
    
    private void handleButtonAction(ActionEvent event) {
    }
    //TODO: muuta getlist ja pagereader-olioita niin, että ne lukevat minkä tahansa XML:n annetuilla URL:eilla ja xml-nodetageilla done, kahden tägin argumentit.
    //voisi vielä parannella dynaamiseksi tagien määrän suhteen
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            TheaterList theaterlist = new TheaterList();
            theaterlist.getList("http://www.finnkino.fi/xml/TheatreAreas/","ID","Name");
            for (int i = 1; i<theaterlist.theaters.size(); i++) {
                Theater th = TheaterList.theaters.get(i);
                String s = th.name;
                combo.getItems().addAll(s);
            }

        } catch (Exception ex) {
            Logger.getLogger(Vko9teht.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TODO
    }    

    @FXML
    private void showList(ActionEvent event) {
        
    }

    @FXML
    private void timeSearchButtonPress(ActionEvent event) {
        String theaterID = combo.getValue();
        String date = dateInputField.getText();
        String start = startTime.getText();
        String end = endTime.getText();
    }

    @FXML
    private void nameSearchButtonPress(ActionEvent event) {
    }
    
}
