/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mosambardi
 */
public class MainMenuWinController implements Initializable {
    
    
    @FXML private ComboBox comboBox1;
    @FXML private ComboBox comboBox2;
    @FXML private ComboBox comboBox3;
    @FXML private TextField tf1cb1;
    @FXML private TextField tf2cb1;
    private List<String> listCb;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listCb = new ArrayList<>();
        listCb.add("algo1");
        listCb.add("algo2");
        listCb.add("algo3");
        comboBox1.getItems().addAll(listCb);
        comboBox1.getItems().
        comboBox1.valueProperty().setValue(listCb.get(0));
        comboBox2.getItems().addAll(listCb);
        comboBox2.valueProperty().setValue(listCb.get(0));
        comboBox3.getItems().addAll(listCb);
        comboBox3.valueProperty().setValue(listCb.get(0));
        
    }    
    
}
