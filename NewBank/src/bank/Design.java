package bank;
import javax.swing.*;
import javax.swing.JComboBox;  
import java.awt.*;  
import java.awt.event.*;  

public class Design{
	
	JFrame f=new JFrame("Interest Calculator");
	JFrame SB,FD,RD;
	public Design() {
	JLabel l1,l2,l3,l4;
	l1=new JLabel("SBAccount");
	l1.setBounds(50,50,100,30);
	l2=new JLabel("FDAccount");
	l2.setBounds(50,100,100,30);
	l3=new JLabel("RDAccount");    
	l3.setBounds(50,150,100,30);
    l4=new JLabel("Choose Your Option");
    //JButton b=new JButton("Choose Your Option");  
    l4.setBounds(50,200,300,30); 
    JTextArea area=new JTextArea();
    area.setBounds(50,250,100,60);
    String accounts[]={"1","2","3"};        
    JComboBox cb=new JComboBox(accounts);    
    cb.setBounds(200,200,50,30);    
    cb.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
            String test=String.valueOf(cb.getItemAt(cb.getSelectedIndex()));
            double resultFD,resultSB,resultRD;
            area.setText("");
             if(test=="1")
             {
            	SB=new JFrame();
            	String amount=JOptionPane.showInputDialog(SB,"Enter Amount");
            	String type=JOptionPane.showInputDialog(SB,"Enter Type(Normal,NRI)");
            	SBAccount obj1=new SBAccount(type,Double.valueOf(amount));
            	resultSB=obj1.calculateInterest();
            	area.setText(String.valueOf(resultSB));
             }
             if(test=="2")
             {
            	FD=new JFrame();
            	String amount=JOptionPane.showInputDialog(FD,"Enter Amount");
            	String days=JOptionPane.showInputDialog(FD,"Enter Days");
            	String age=JOptionPane.showInputDialog(FD,"Enter Age");
            	FDAccount obj2=new FDAccount(Double.valueOf(amount),Integer.valueOf(days),Integer.valueOf(age));
            	resultFD=obj2.calculateInterest();
            	area.setText(String.valueOf(resultFD));
             }
             if(test=="3")
             {
            	RD=new JFrame();
            	String amount=JOptionPane.showInputDialog(FD,"Enter Amount");
            	String months=JOptionPane.showInputDialog(RD,"Enter Months");
            	String age=JOptionPane.showInputDialog(RD,"Enter Age");
            	RDAccount obj3=new RDAccount(Double.valueOf(amount),Integer.valueOf(months),Integer.valueOf(age));
            	resultRD=obj3.calculateInterest();
            	area.setText(String.valueOf(resultRD));
             }
        }  
    });  
    f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(cb);f.add(area);
    f.setSize(400,400);
    f.setLayout(null);
    f.setVisible(true);  
}
	public static void main(String[] args) {
		Design obj=new Design();
		}}
