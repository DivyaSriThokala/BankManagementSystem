package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{

	JButton deposit,withdrawl,ministatement,pinchange,fastcash,balancequiry,exit;
	String pinnumber;
	FastCash(String pinnumber){
		System.out.println("1 "+pinnumber);
		this.pinnumber=pinnumber;
		setLayout(null);
		
		JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(230,50,700,35);
		text.setFont(new Font("System",Font.BOLD,16));
		add(text);
		
		deposit=new JButton("Rs 100");
		deposit.setBounds(140,100,150,30);
		deposit.addActionListener(this);
		add(deposit);
		
		withdrawl=new JButton("Rs 500");
		withdrawl.setBounds(400,100,150,30);
		withdrawl.addActionListener(this);
		add(withdrawl);
		
		fastcash=new JButton("Rs 10000");
		fastcash.setBounds(140,140,150,30);
		fastcash.addActionListener(this);
		add(fastcash);
		
		ministatement=new JButton("Rs 2000");
		ministatement.setBounds(400,140,150,30);
		ministatement.addActionListener(this);
		add(ministatement);
		
		pinchange=new JButton("Rs 5000");
		pinchange.setBounds(140,180,150,30);
		pinchange.addActionListener(this);
		add(pinchange);
	   
		balancequiry=new JButton("Rs 10000");
		balancequiry.setBounds(400,180,150,30);
		balancequiry.addActionListener(this);
		add(balancequiry);
		
		exit=new JButton("BACK");
		exit.setBounds(270,220,150,30);
		exit.addActionListener(this);
		add(exit);
		
		setSize(700,400);
		setLocation(300,0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
	if(ae.getSource()==exit) {
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
	}
	else {
        String amount=((JButton)ae.getSource()).getText().substring(3);
        Conn c=new Conn();
        try {
        	ResultSet rs=c.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
        	int balance=0;
        	int i=0;
        	while(rs.next()) {
        		System.out.println(i++);
        		if(rs.getString("type").equals("Deposit")){
        				balance+=Integer.parseInt(rs.getString("amount"));
        				System.out.println(balance+" "+i);
        	    }
        		else {
        		      
        			balance-=Integer.parseInt(rs.getString("amount"));	
        			System.out.println(balance+" "+i);
        		}
        	}
             System.out.println(ae.getSource()+" "+balance +" "+Integer.parseInt(amount));
        	if(ae.getSource()!= exit && balance < Integer.parseInt(amount)) {
        		JOptionPane.showMessageDialog(null,"Insufficient Balance");
        		return;
        	}
        	Date date=new Date();
        	String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Rs"+amount+"Debited Successfully");
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
        
	}
        catch(Exception e) {
        	System.out.println(e);
        }
        
	}
	}

	
	public static void main(String[] args) {
		System.out.println("3");
	new FastCash("");

	}

}
