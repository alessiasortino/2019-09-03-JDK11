

package it.polito.tdp.food;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import it.polito.tdp.food.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FoodController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtCalorie"
    private TextField txtCalorie; // Value injected by FXMLLoader

    @FXML // fx:id="txtPassi"
    private TextField txtPassi; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnalisi"
    private Button btnAnalisi; // Value injected by FXMLLoader

    @FXML // fx:id="btnCorrelate"
    private Button btnCorrelate; // Value injected by FXMLLoader

    @FXML // fx:id="btnCammino"
    private Button btnCammino; // Value injected by FXMLLoader

    @FXML // fx:id="boxPorzioni"
    private ComboBox<String> boxPorzioni; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCammino(ActionEvent event) {
    	txtResult.clear();
    	txtResult.appendText("Cerco cammino peso massimo...\n");
    	
    	String partenza = this.boxPorzioni.getValue();
    	if(partenza==null) {
    		txtResult.appendText("Selezionare una tipologia");
    		return;
    		
    	}
    	String n= this.txtPassi.getText();
    	Integer N;
    	try {
    		N= Integer.parseInt(n);
    		
    	}catch(NumberFormatException ne) {
    		txtResult.appendText("Inserire un numero");
    		return;
    		
    	}
    	List <String> percorso= model.trovaPercorso(partenza, N);
    	txtResult.appendText("Peso del cammino: "+ model.getPesoMax()+"\n");
    	for(String s: percorso) {
    		this.txtResult.appendText(s.toString()+"\n");
    	}
    	
    }

    @FXML
    void doCorrelate(ActionEvent event) {
    	txtResult.clear();
    	txtResult.appendText("Cerco porzioni correlate...");
    	
    	String sorgente= this.boxPorzioni.getValue();
    	String s= model.getVicini(sorgente);
    	this.txtResult.appendText(s);
    	
    }

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	txtResult.clear();
    	txtResult.appendText("Creazione grafo...");
    	
    	String  c= txtCalorie.getText();
    	Integer C;
    	try {
    		C= Integer.parseInt(c);
    		
    	}catch(NumberFormatException ex) {
    		txtResult.appendText("Inserire un numero");
    		return;
    	}
    	
    	model.creaGrafo(C);
    	txtResult.appendText("Grafo creato!\n");
    	txtResult.appendText("# VERTICI "+ this.model.vertexNumber()+"\n");
    	txtResult.appendText("# ARCHI "+ this.model.edgeNumber());
    	
    	
    	boxPorzioni.getItems().clear();
    	boxPorzioni.getItems().addAll(model.getVertici(C));
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtCalorie != null : "fx:id=\"txtCalorie\" was not injected: check your FXML file 'Food.fxml'.";
        assert txtPassi != null : "fx:id=\"txtPassi\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnAnalisi != null : "fx:id=\"btnAnalisi\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnCorrelate != null : "fx:id=\"btnCorrelate\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnCammino != null : "fx:id=\"btnCammino\" was not injected: check your FXML file 'Food.fxml'.";
        assert boxPorzioni != null : "fx:id=\"boxPorzioni\" was not injected: check your FXML file 'Food.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Food.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	
    }
}
