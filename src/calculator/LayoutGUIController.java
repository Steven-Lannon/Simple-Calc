package calculator;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author Steven Lannon
 */
public class LayoutGUIController implements Initializable {

    //create variables
    private String crrntArthOp = "DEFAULT";
    private String opd1 = "0";

    @FXML
    private TextField txtBox;
    @FXML
    private Button removeData;
    @FXML
    private Button arthOp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML //switch case to display buttons to text field
    private void addDigit(ActionEvent event) {

        Button btn = (Button) event.getSource();

        switch (btn.getText()) {

            case "1":
                txtBox.setText(txtBox.getText() + "1");
                break;
            case "2":
                txtBox.setText(txtBox.getText() + "2");
                break;
            case "3":
                txtBox.setText(txtBox.getText() + "3");
                break;
            case "4":
                txtBox.setText(txtBox.getText() + "4");
                break;
            case "5":
                txtBox.setText(txtBox.getText() + "5");
                break;
            case "6":
                txtBox.setText(txtBox.getText() + "6");
                break;
            case "7":
                txtBox.setText(txtBox.getText() + "7");
                break;
            case "8":
                txtBox.setText(txtBox.getText() + "8");
                break;
            case "9":
                txtBox.setText(txtBox.getText() + "9");
                break;
            case "0":
                txtBox.setText(txtBox.getText() + "0");
                break;
            case ".":     
                txtBox.setText(txtBox.getText() + ".");
        }
    }
   
    @FXML
    private void arthOp(ActionEvent event) { //switch case to get source for operators 
        switch (((Button) event.getSource()).getText()) {
            case "+":
                opd1 = txtBox.getText();
                crrntArthOp = "ADD";
                txtBox.clear();
                break;
            case "-":
                opd1 = txtBox.getText();
                crrntArthOp = "SUB";
                txtBox.clear();
                break;
            case "x":
                opd1 = txtBox.getText();
                crrntArthOp = "MULT";
                txtBox.clear();
                break;
            case "/":
                opd1 = txtBox.getText();
                crrntArthOp = "DIVIDE";
                txtBox.clear();
                break;         
        }
    }

    @FXML
    private void processResult(ActionEvent event) { //switch case to process the result of each operator
        double num1dec = Double.parseDouble(opd1);
        double num2dec = Double.parseDouble(txtBox.getText());
       
        DecimalFormat df = new DecimalFormat("0.############");
      
            switch (crrntArthOp) {
            case "ADD":   
                txtBox.setText("" + (num1dec+ num2dec));
              //   txtBox.setText("" + (df.format(num1dec + num2dec)));
                break;
            case "SUB":
                txtBox.setText("" + (num1dec - num2dec));
                break;
            case "MULT":
                txtBox.setText("" + (num1dec * num2dec));
                break;
            case "DIVIDE":       
               if (num1dec == 0 || num2dec == 0) { //if else, with statement to user when dividing by 0
                    txtBox.setText("Cannot divide by 0.");
                } 
                
               else {
                   txtBox.setText("" + (num1dec / num2dec));
                  // txtBox.setText("" + (df.format(num1dec/num2dec)));
               }
               
                break;
        }
    }
        
    
    @FXML
    private void removeData(ActionEvent event) {
        if (((Button) event.getSource()).getText().equals("CLEAR")) { //if-else delete/clear statements
            txtBox.clear();
            //  txtBox.setText(String.valueOf(0));
        } else if (((Button) event.getSource()).getText().equals("BACK")) {
            String goBack = txtBox.getText();
            txtBox.setText("");
            for (int i = 0; i < goBack.length() - 1; i++) {

                txtBox.setText(txtBox.getText() + goBack.charAt(i));

            }
        }
    }
}
