package finalATM;

import java.util.ArrayList;
import java.util.List;

public class accounts {
	//states of the class
String username;
String password;
int balance ;
ArrayList <String> histroy;
int transactioncounter;


//getters and setters of class 
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
//loginfunction
public Boolean  login(String name,String pass){
	
	if((name.equals(name))&&(pass.equals(this.password)))
		return true ;
	else
		return false;
}
//constructor of classs
public void constructor (String username, String password, int balance,int counter) {
	this.username = username;
	this.password = password;
	this.balance = balance;
	this.histroy = new ArrayList<>();
	this.transactioncounter = counter;
}
public void  deposit (int amount){
	this.balance=this.balance+amount;
}

public void  inquery(){
this.getBalance();
}
public void withdraw(int amount ){
	
	this.balance=this.balance-amount;
}
public Boolean validamount (int amount){
	if(amount<this.balance)
		return true;
	else 
		return false;
}
public void addhistory (int amount){
	this.histroy.add(""+amount);
}
public  boolean containsOnlyNumbers(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (!Character.isDigit(str.charAt(i)))
        return false;
    }
    return true;
  }

	
	

}