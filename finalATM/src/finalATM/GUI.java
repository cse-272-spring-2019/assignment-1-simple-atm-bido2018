package finalATM;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class GUI extends Application  {
	accounts account;
	int c=0;
//main 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
   launch(args);
	}
// forming gui
	@Override
	public void start(Stage primaryStage) throws Exception {
		account=new accounts();
		
		
		 account.constructor("a", "1", 0,0);
		 
     // creating object in the window
	 primaryStage.setTitle("login");
     Label usernamelabel = new Label() ;
     usernamelabel.setText("  user name");
     Label passwordlabel = new Label() ;
     passwordlabel.setText("  password");
     TextField usernamefield =new TextField();
     PasswordField passwordfield = new PasswordField();
     Button loginbutton = new Button();
     loginbutton.setText("login");
     Label balancelabel = new Label();
     Label wronglabel = new Label();
     wronglabel.setText("WRONG USERNAME OR PASSWORD ");
     Button depositbutton = new Button();
     depositbutton.setText("deposit");
     Button inquerybutton = new Button();
     inquerybutton.setText("inquery");
     Button withdrawbutton = new Button();
     withdrawbutton.setText("withdraw");
     TextField amountfield= new TextField();
     Label amountlabel = new Label();
     amountlabel.setText("the amount you want to do action on it ");
     Alert successdalert = new Alert(Alert.AlertType.INFORMATION);
     Alert successwalert = new Alert(Alert.AlertType.INFORMATION);
     Alert failwalert = new Alert(Alert.AlertType.INFORMATION);
     Alert inqueryalert = new Alert(Alert.AlertType.INFORMATION);
     Alert previousalert1 = new Alert(Alert.AlertType.INFORMATION);
     Alert previousalert2 = new Alert(Alert.AlertType.INFORMATION);
     Button button1 = new Button("1");
     Button button2 = new Button("2");
     Button button3 = new Button("3");
     Button button4 = new Button("4");
     Button button5 = new Button("5");
     Button button6 = new Button("6");
     Button button7 = new Button("7");
     Button button8 = new Button("8");
     Button button9 = new Button("9");
     Button button0 = new Button("0");
     Button logoutbutton= new Button("logout ");
     Button clearbutton = new Button("clear the ammount");
   
     Alert loginalert = new Alert(Alert.AlertType.INFORMATION);
     Button previousbutton = new Button();
     previousbutton.setText("previous transcation");
     Button nextbutton = new Button();
     nextbutton.setText("next transaction");
     Alert nextalert1 = new Alert(Alert.AlertType.INFORMATION);
     Alert nextalert2 = new Alert(Alert.AlertType.INFORMATION);
     Alert faildalert = new Alert(Alert.AlertType.INFORMATION);



 //forming the loginpane     
 GridPane logingrid = new GridPane();
 Scene loginscene = new Scene(logingrid, 300,200);
 logingrid.add(usernamelabel, 0, 0);
 logingrid.add(passwordlabel, 0, 1);
 logingrid.add(usernamefield, 1, 0);
 logingrid.add(passwordfield, 1, 1);
 logingrid.add(loginbutton, 1, 2);
 
 
 //forming the accountpane

 //login button action
loginbutton.setOnAction(new EventHandler<ActionEvent>(){
	public void handle(ActionEvent event ){
		String name= usernamefield.getText();
		String pass= passwordfield.getText();
		Boolean valid = account.login(name, pass);
		if(valid)
		{
			
			GridPane accountgrid = new GridPane();
			//accountgrid.add(child, columnIndex, rowIndex);
			accountgrid.add(depositbutton, 0, 1);
			depositbutton.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event ){
					String str=String.valueOf(amountfield.getText());
					Boolean valid=account.containsOnlyNumbers(str);

					if(valid){
						 int amount = Integer.parseInt(amountfield.getText());
					account.deposit(amount);
					successdalert.setTitle("message");
					successdalert.setHeaderText("thank you mr:"+account.username);
					successdalert.setContentText("you have done successfull deposition !");
					successdalert.showAndWait();
					account.addhistory("deposit" ,+amount);
					
					account.transactioncounter++;
					c=0;
					previousbutton.setDisable(false);

					}
					else{
					
						faildalert.setHeaderText("!!!!!!!!!!!!!!ALERT!!!!!!!!!!!");
					faildalert.setContentText("entre valid ammount !");
					faildalert.showAndWait();}
				
					
				}
			});
			//accountgrid.add(child, columnIndex, rowIndex);

			accountgrid.add(previousbutton, 0,5 );

			previousbutton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event ){
				
				//int cp=account.transactioncounter;

		        if((account.transactioncounter!=0)&&(c<=4)&&(account.transactioncounter-c!=0)){	
				previousalert1.setTitle("message");
				previousalert1.setHeaderText("thank you mr:"+account.username);
				previousalert1.setContentText(""+account.histroy.get(account.transactioncounter-c-1));
				previousalert1.showAndWait();
							c++;
							
							nextbutton.setDisable(false);
						// account.transactioncounter--;
							
				}
				//else if((c>4)||(c==account.transactioncounter)||(account.transactioncounter==0)||(c==0))
		        else /*if(account.transactioncounter-1-c==0)*/
		        { 
				previousalert2.setTitle("message");
				previousalert2.setHeaderText("thank you mr:"+account.username);
				previousalert2.setContentText("there is no more history");
				previousalert2.showAndWait();
				previousbutton.setDisable(true);
				}

				
			}}
		);
			accountgrid.add(nextbutton, 0, 4);
			nextbutton.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event ){
					
					//if((account.transactioncounter!=0)&&(c>4)&&(account.transactioncounter-1==account.histroy.size())){	
					if((account.transactioncounter!= 0) && (c!=0)&&(account.transactioncounter-c!=0)){
						c--;
						nextalert1.setTitle("message");
						nextalert1.setHeaderText("thank you mr:"+account.username);
						nextalert1.setContentText(""+account.histroy.get(account.transactioncounter-Math.abs(c)-1));
						nextalert1.showAndWait();
						previousbutton.setDisable(false);
									//c--;
								// account.transactioncounter--;
									
						}
						//else if((c>4)||(c==account.transactioncounter)||(account.transactioncounter==0)||(c==0))
				        else /*if(account.transactioncounter-10-c==0)*/
				        { 
						nextalert2.setTitle("message");
						nextalert2.setHeaderText("thank you mr:"+account.username);
						nextalert2.setContentText("there is no more history");
						nextalert2.showAndWait();
						nextbutton.setDisable(true);
						
						}

						
					}}
				);
			//accountgrid.add(child, columnIndex, rowIndex);

			accountgrid.add(withdrawbutton, 0, 3);
			withdrawbutton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event ){
				
				String str=String.valueOf(amountfield.getText());
				Boolean valid=account.containsOnlyNumbers(str);
				/*int amount = Integer.parseInt(amountfield.getText());
				 Boolean flag1 =account.validamount(amount);*/ 
				if (valid){	
					int amount = Integer.parseInt(amountfield.getText());
					Boolean flag1 =account.validamount(amount);
					if(flag1){
					account.withdraw(amount);
					successwalert.setTitle("message");
					successwalert.setHeaderText("thank you mr:"+account.username);
					successwalert.setContentText("you have done successfull withdraw process !");
					successwalert.showAndWait();	
					account.addhistory("withdraw",amount);
					account.transactioncounter++;
					previousbutton.setDisable(false);
					c=0;
}
					else{
						failwalert.setTitle("message");
						failwalert.setHeaderText("!!!!!!!!!!!ALERT!!!!!!!!!!");
						failwalert.setContentText("you can't do this transction as your balance less than the amount you entred ");
						failwalert.showAndWait();
					}
					}
				else 
				{
					failwalert.setTitle("message");
					failwalert.setHeaderText("!!!!!!!!!!!ALERT!!!!!!!!!!");
					failwalert.setContentText("entre valid amount");
					failwalert.showAndWait();	

				}
}
				
			
		});
			//accountgrid.add(child, columnIndex, rowIndex);

			accountgrid.add(inquerybutton, 0, 2);
			inquerybutton.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event ){
					inqueryalert.setTitle("message");
					inqueryalert.setHeaderText("thank you mr: " +account.username);
					inqueryalert.setContentText("your balance is  "+account.balance);
					inqueryalert.showAndWait();
					account.addhistory("inquery",+account.balance );
					account.transactioncounter++;
					previousbutton.setDisable(false);
c=0;


					
				}
			});
			accountgrid.add(amountlabel,0, 0);;
			accountgrid.add(amountfield, 1, 0);
			//accountgrid.add(child, columnIndex, rowIndex);

			accountgrid.add(button1, 2, 4);
			button1.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event ){
					amountfield.appendText("1");
				}
			});
			accountgrid.add(button2, 3, 4);
			button2.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event ){
					amountfield.appendText("2");
				}
			});
			accountgrid.add(button3, 4, 4);
			button3.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event ){
					amountfield.appendText("3");
				}
			});
			accountgrid.add(button4, 2, 5);
			button4.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event ){
					amountfield.appendText("4");
				}
			});
			accountgrid.add(button5, 3, 5);
			button5.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event ){
					amountfield.appendText("5");
				}
			});
			accountgrid.add(button6,4, 5);
			button6.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event ){
					amountfield.appendText("6");
				}
			});
			accountgrid.add(button7, 2, 6);
			button7.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event ){
					amountfield.appendText("7");
				}
			});
			accountgrid.add(button8, 3, 6);
			button8.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event ){
					amountfield.appendText("8");
				}
			});
			accountgrid.add(button9, 4, 6);
			button9.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event ){
					amountfield.appendText("9");
				}
			});
			accountgrid.add(button0, 3, 7);
			button0.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event ){
					amountfield.appendText("0");
				}
			});
			accountgrid.add(clearbutton, 4,9);
			clearbutton.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event ){
					amountfield.setText("");
				}
			});
			accountgrid.add(logoutbutton, 0, 8);
			logoutbutton.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event ){
					 primaryStage.setScene(loginscene);

					 
				}
			});
			Scene accountscene = new Scene(accountgrid, 600,400);
			primaryStage.setScene(accountscene);
			primaryStage.show();
		}
		else
		{
			loginalert.setTitle("message");
			loginalert.setHeaderText("!!!!!!!!!!!!!!ALERT!!!!!!!!!!!!!!!!!");
			loginalert.setContentText("USERNAME OR PASSWORD IS WRONG");
			loginalert.showAndWait();
		}

	} 
	
	
	
	
});

 primaryStage.setScene(loginscene);
 primaryStage.show();
 
 
	}

}
