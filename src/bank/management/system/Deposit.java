package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class Deposit extends JFrame implements ActionListener{ 
	
	JTextField amount;
	JButton deposit,back;
	String pinnumber;
	
    Deposit(String pinnumber){
    	this.pinnumber=pinnumber;
    	setLayout(null);
    	JLabel text=new JLabel("Enter the amount ypu want to deposit");
    	text.setFont(new Font("System",Font.BOLD,16));
    	text.setBounds(190,50,700,40);
    	add(text);
    	
        amount=new JTextField("");
    	amount.setFont(new Font("System",Font.BOLD,16));
    	amount.setBounds(170,120,320,20);
    	add(amount);
   	
   	    deposit =new JButton("Deposit");
    	deposit.setBounds(270,170,150,30);
     	deposit.addActionListener(this);
    	add(deposit);
    	
    	back =new JButton("Back");
    	back.setBounds(530,300,150,30);
    	back.addActionListener(this);
    	add(back);
    	
    	setSize(700,400);
		setLocation(300,0);
		setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource()==deposit) {
    		String number=amount.getText();
    		Date date=new Date();
    		 SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
    		if(number.equals("")) {
    			JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposite");	
    		}
    		else {
    			try {
    			Conn conn=new Conn();
    			System.out.println(pinnumber);
    			
    			String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
    			conn.s.executeUpdate(query);
    			JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
    		    setVisible(false);
    		    new Transactions(pinnumber).setVisible(true);
    			}
    			catch(Exception e) {
    				System.out.println(e);
    			}
    		}
    	}
    	else if(ae.getSource()==back) {
    		setVisible(false);
    	new Transactions(pinnumber).setVisible(true);	
    	}
    }
	public static void main(String[] args) {

        new Deposit("");
	}

}
