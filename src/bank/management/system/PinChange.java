package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener {
     String pinnumber;
     JPasswordField pin,repin;
     JButton change,back;
	PinChange(String pinnumber){
		setLayout(null);
		this.pinnumber=pinnumber;
		
        JLabel text=new JLabel("CHANGE YOUR PIN") ;
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(260,50,700,40);
        add(text);
        
        JLabel pintext=new JLabel("NEW PIN") ;
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(120,150,180,25);
        add(pintext);
        pin=new JPasswordField();
        pin.setFont(new Font("System",Font.BOLD,15));
        pin.setBounds(330,150,180,25);
        add(pin);
        
        JLabel repintext=new JLabel("Re-Enter NEW PIN") ;
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(120,200,180,25);
        add(repintext);
        repin=new JPasswordField();
        repin.setFont(new Font("System",Font.BOLD,15));
        repin.setBounds(330,200,180,25);
        add(repin);
        
         change=new JButton("CHANGE");
        change.setBounds(500,300,150,30);
        change.addActionListener(this);
        add(change);
        
         back=new JButton("Back");
        back.setBounds(330,300,150,30);
        back.addActionListener(this);
        add(back);
        
		
    	setSize(700,400);
		setLocation(300,0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==change) {
		try {
			String npin=pin.getText();
			String rpin=repin.getText();
			if(!npin.equals(rpin)) {
				JOptionPane.showMessageDialog(null,"Entered PIN doen't matched");
				return;
			}
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null,"Please Enter NEW PIN ");
				return;
			}
			if(rpin.equals("")) {
				JOptionPane.showMessageDialog(null,"Please Enter RE-ENTER NEW PIN ");
				return;	
			}
			Conn conn=new Conn();
			String query1="update bank set pinnumber ='"+rpin+"' where pinnumber='"+pinnumber+"'";
			String query2="update login set pin ='"+rpin+"' where pin='"+pinnumber+"'";
			String query3="update signupthree set pin ='"+rpin+"' where pin='"+pinnumber+"'";
		    conn.s.executeUpdate(query1);
		    conn.s.executeUpdate(query2);
		    conn.s.executeUpdate(query3);
		    JOptionPane.showMessageDialog(null,"PIN changed successfully");
		    setVisible(false);
		    new Transactions(rpin).setVisible(true);
		}
		catch(Exception e) {
		System.out.println(e);	
		}
		}
		else {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		
        new PinChange("").setVisible(true);  
		
	}

}
