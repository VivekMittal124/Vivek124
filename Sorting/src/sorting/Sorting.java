package sorting;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Students{
	@Override
	public String toString() {
		return "Students [roll=" + roll + ", name=" + name + ", marks=" + marks + "]";
	}
	int roll;
	String name;
	double marks;
	public Students(int roll, String name, double marks) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	
}

class NameComparator implements Comparator{  
public int compare(Object o1,Object o2){  
Students s1=(Students)o1;  
Students s2=(Students)o2;  
  
return s1.name.compareTo(s2.name);  
}  
}   
class RollComparator implements Comparator{  
public int compare(Object o1,Object o2){  
Students s1=(Students)o1;  
Students s2=(Students)o2;  
  
if(s1.roll==s2.roll)  
return 0;  
else if(s1.roll>s2.roll)  
return 1;  
else  
return -1;  
}  
}  
class MarksComparator implements Comparator{  
public int compare(Object o1,Object o2){  
Students s1=(Students)o1;  
Students s2=(Students)o2;  
  
if(s1.marks==s2.marks)  
return 0;  
else if(s1.marks>s2.marks)  
return 1;  
else  
return -1;  
}  
}  

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f;
		JLabel l;
      ArrayList<Students> al=new ArrayList<Students>();
      Students o1=new Students(1,"Vivek",34.3);
      Students o2=new Students(2,"Vishal",34.67);
      Students o3=new Students(3,"Arvind",34.83);
      
      al.add(o1);
      al.add(o2);
      al.add(o3);
      
     f=new JFrame("Sorting");
     l=new JLabel("CHOOSE YOUR SORTING OPTION");
     l.setBounds(20,50,300,40);
     String options[]= {"ROLL NO","Name","Marks"};
     JComboBox cb=new JComboBox(options);
     cb.setBounds(250,50,100,40);
     JTextArea area=new JTextArea();
     area.setBounds(20,100,300,200);
     cb.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String value=String.valueOf(cb.getItemAt(cb.getSelectedIndex()));
			String res=" ";
			String newline="\n";
			 if(value=="ROLL NO")
			 {
				 Collections.sort(al,new RollComparator());  
				 for(Students st: al){  
				 res+=String.valueOf(st+newline); 
					 area.setText(res);
				 } }
				 if(value=="Name")
				 {
					 Collections.sort(al,new NameComparator());  
					 for(Students st: al){  
						 res+=String.valueOf(st+newline); 
						 area.setText(res);  
					 } }
					 if(value=="Marks")
					 {
						 Collections.sort(al,new MarksComparator());  
						 for(Students st: al){  
							 res+=String.valueOf(st+newline); 
							 area.setText(res);  
						 } 
			 }
				 }
    	 
     });
     f.setSize(400,400);
     f.setLayout(null);
     f.setVisible(true);
     f.add(l);f.add(cb);f.add(area);
	}

}
