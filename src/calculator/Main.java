package calculator;

import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{
	private String input="";
	boolean setOperator=false;
	
	public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Simple Calculator");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label inputLabel = new Label("");
 
        grid.add(inputLabel, 0, 0, 4, 1);
 
        String[][] buttonLabels = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", "c", "=", "+"}
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Button btn = new Button(buttonLabels[i][j]);
                btn.setMinSize(50, 50);
                grid.add(btn, j, i + 2);
                btn.setOnAction(e -> handleButtonClick(btn.getText(), inputLabel));
            }
        }

        Scene scene = new Scene(grid, 250, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
		
	}
	
	 private void handleButtonClick(String value, Label inputLabel) {
		 if (value.equals("=")) {
			 String inputString=input.toString();
			 String operation = null;
			 
	             
           	 for(int i=0; i<inputString.length(); i++) {
                char currentChar = inputString.charAt(i);
                if (currentChar == '/' || currentChar == '*' || currentChar == '-' || currentChar == '+') {
                    operation = String.valueOf(currentChar);
                    break;
                }
           	 }
           	 
         	
	         String[] parts = inputString.split(Pattern.quote(operation));
	         System.out.println(operation);
	         
	         String num1String = parts[0]; 
	         String num2String = parts[1];
	         double num1=0;
	         double num2=0;
	         double result=0;
	           
	         if(operation==null || num1String==null || num2String==null) {
	        	 inputLabel.setText("error");
	        	 return;
	          }
	         
	         try {
	             num1 = Double.parseDouble(num1String);
	             num2= Double.parseDouble(num2String);
	         }catch(Exception e) {
	        	 System.out.println(e);
	         }
	         
	         
	         switch(operation) {
		         case "+":
		        	 result=num1+num2;
		        	 input=Double.toString(result);
		        	 inputLabel.setText(input);
		        	 break;
		         case "-":
		        	 result=num1-num2;
		        	 input=Double.toString(result);
		        	 inputLabel.setText(input);	
		        	 break;
		         case "*":
		        	 result=num1*num2;
		        	 input=Double.toString(result);
		        	 inputLabel.setText(input);
		        	 break;
		         case "/":
		        	 if(num2==0) {
		        		 inputLabel.setText("error");
		        		 break;
		        	 }
		        	 result=num1/num2;
		        	 input=Double.toString(result);
		        	 inputLabel.setText(input);
		        	 break;
	         	}
	         
	         setOperator=false;
	         
	         return;
	            
 	          }else if(value.equals("c")) {
 	        	  input="";
 	        	  inputLabel.setText(input);
 	        	  
 	        	  return;
 	        	  
 	          } 
		 
		 
		 
            if ((value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/") )&& !setOperator) {
                System.out.println("asd"); 
                System.out.println(setOperator);
            	setOperator = true;
                input += value;
                inputLabel.setText(input);
            } else if(!value.equals("+") &&!value.equals("-") &&!value.equals("*") &&!value.equals("/")  ){
                input += value;
                inputLabel.setText(input);
            }
            
 	        	
 	        	
	         
	 }
	 
	 
}
