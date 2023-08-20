package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{

	JButton deposit,withdrawl,ministatement,pinchange,fastcash,balancequiry,exit;
	String pinnumber;
	Transactions(String pinnumber){
		System.out.println("1 "+pinnumber);
		this.pinnumber=pinnumber;
		setLayout(null);
		
		JLabel text=new JLabel("Please select your Transaction");
		text.setBounds(230,50,700,35);
		text.setFont(new Font("System",Font.BOLD,16));
		add(text);
		
		deposit=new JButton("Deposit");
		deposit.setBounds(140,100,150,30);
		deposit.addActionListener(this);
		add(deposit);
		
		withdrawl=new JButton("Cash Withdrawl");
		withdrawl.setBounds(400,100,150,30);
		withdrawl.addActionListener(this);
		add(withdrawl);
		
		fastcash=new JButton("Fash Cash");
		fastcash.setBounds(140,140,150,30);
		fastcash.addActionListener(this);
		add(fastcash);
		
		ministatement=new JButton("Mini Statement");
		ministatement.setBounds(400,140,150,30);
		ministatement.addActionListener(this);
		add(ministatement);
		
		pinchange=new JButton("Pin Change");
		pinchange.setBounds(140,180,150,30);
		pinchange.addActionListener(this);
		add(pinchange);
	   
		balancequiry=new JButton("Balance Quiry");
		balancequiry.setBounds(400,180,150,30);
		balancequiry.addActionListener(this);
		add(balancequiry);
		
		exit=new JButton("Exit");
		exit.setBounds(270,220,150,30);
		exit.addActionListener(this);
		add(exit);
		
		setSize(700,400);
		setLocation(300,0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
	if(ae.getSource()==exit) {
	}
	else if(ae.getSource()==deposit) {
		setVisible(false);
		new Deposit(pinnumber).setVisible(true);
	
	}
	else if(ae.getSource()==withdrawl) {
		setVisible(false);
		new withdrawl(pinnumber).setVisible(true); 
	}
	else if(ae.getSource()==fastcash) {
		setVisible(false);
		new FastCash(pinnumber).setVisible(true); 
	}
	else if(ae.getSource()==pinchange) {
		setVisible(false);
		new PinChange(pinnumber).setVisible(true); 
	}
	else if(ae.getSource()==balancequiry) {
		setVisible(false);
		new BalanceEnquiry(pinnumber).setVisible(true); 
	}
	else if(ae.getSource()==ministatement) {
		new MiniStatement(pinnumber).setVisible(true); 
	}
	else if(ae.getSource()==exit){
		setVisible(false);
       new Login().setVisible(true);
	}
	
	}
	
	public static void main(String[] args) {
		System.out.println("3");
	new Transactions("");

	}

}
