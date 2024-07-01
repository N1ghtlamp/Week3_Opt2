package csc372_week3_CTA2;

import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
import java.time.format.DateTimeFormatter; 
import java.time. LocalDateTime; 
import java.io.*; 

class MenuOptions implements ActionListener{ 
	JMenuItem m1,m2,m3,m4; 
	JMenuBar mb; 
	JTextField txtbox; 
	JMenu menu; 
	JFrame frm; 
	
public MenuOptions(){ 
	frm = new JFrame(); 
	frm.setLayout(null); 
	
	mb = new JMenuBar(); 
	txtbox = new JTextField(); 
	menu=new JMenu("Options"); 

	m1 = new JMenuItem("Print Date and Time"); 
	m2 = new JMenuItem("Save File to Log.txt"); 
	m3 = new JMenuItem("Change Background Color"); 
	m4 = new JMenuItem("Exit");

	menu.add(m1); 
	menu.add(m2); 
	menu.add(m3); 
	menu.add(m4); 

	mb.add(menu); 
	frm.setJMenuBar(mb); 

	m1.addActionListener(this); 
	m2.addActionListener(this); 
	m3.addActionListener(this); 
	m4.addActionListener(this);

	txtbox.setBounds (150, 40, 150, 40); 
	frm.add(txtbox); 
	frm.setVisible(true); 
	frm.setSize(400,300); 
} 
public void actionPerformed(ActionEvent ae){ 
	if(ae.getSource()== m1) { 
		DateTimeFormatter dt = DateTimeFormatter .ofPattern("yyyy/mm/dd hh:mm:ss"); 
		LocalDateTime current = LocalDateTime.now(); 
		txtbox.setText(dt.format(current)+"");  
	}  

	if(ae.getSource()== m2){  
		String s1 = txtbox.getText(); 
		try { 
			FileWriter fw = new FileWriter("Log.txt"); 
			fw.write(s1);  
			fw.close(); 
		} 
		
		catch (Exception e1) { 
			txtbox.setText("Exception is "+e1); 
		} 
	} 
	
	if(ae.getSource() == m3 ){
		frm.getContentPane().setBackground (Color.orange); 
	}

	if(ae.getSource()== m4) { 
		frm.setVisible(false); 
	} 

	frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
}

public static void main(String args[]){ 
	@SuppressWarnings("unused")
	MenuOptions md = new MenuOptions(); 
	} 
}
