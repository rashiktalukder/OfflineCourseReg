import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtSPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin frame = new StudentLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentLogin() {
		InitializeStdLogin();
		ConnectionStdLogin();
		
		
	}
	Connection conn;
	PreparedStatement prepStatement;
	ResultSet resSet;
	private JTextField txtSName;
	
	StudentPage stdPage=new StudentPage();
	private JLabel lblNewLabel;

	private void ConnectionStdLogin() {
		
		try {
			
			//Class.forName("com.mysql.jdbc.Driver");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/aiubregistration","root","");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException ex)
		{
			//e.printStackTrace();
		}
		
	}

	private void InitializeStdLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(184, 228, 79, 33);
		contentPane.add(lblNewLabel_1);
		
		txtSPassword = new JTextField();
		txtSPassword.setBounds(285, 228, 228, 28);
		contentPane.add(txtSPassword);
		txtSPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Log in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String userName,userPassword;
				userName=txtSName.getText();
				userPassword=txtSPassword.getText();
				
				try {
					
					prepStatement=conn.prepareStatement("select * from studentreg where username=? and password=?");
					//prepStatement.setString(1,id);
//					userName=resSet.getString(1);
//					userPassword=resSet.getString(2);
					
					prepStatement.setString(1,userName);
					prepStatement.setString(2,userPassword);
					resSet = prepStatement.executeQuery();
					
					
					if(resSet.next()==true)
					{	    
					   
  				    	JOptionPane.showMessageDialog(null,"Login Success!!");
  				    	
  				    	//StudentPage stdPage=new StudentPage();
  				    	
  						stdPage.setVisible(true);
  						ShowStudentInfo();
  								
				    }
					else
					{
						JOptionPane.showMessageDialog(null,"Sorry!!");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

			public void ShowStudentInfo() {
				
				//StudentPage stdPage=new StudentPage();
				//stdPage.setVisible(true);
				String userName=txtSName.getText();
					try {
					
					prepStatement=conn.prepareStatement("select id,username,batch,program,phone from studentreg where username=?");
					prepStatement.setString(1,userName);
					resSet = prepStatement.executeQuery();
					
					if(resSet.next())
					{
						String sID=resSet.getString(1);
						String userName1=resSet.getString(2);
						String userBatch=resSet.getString(3);
						String userProg=resSet.getString(4);
						String phoneNo=resSet.getString(5);
						
						stdPage.getTxtStudID().setText(sID);
						stdPage.getTxtUname().setText(userName1);
						stdPage.getTxtBatch().setText(userBatch);
						stdPage.getTxtProg().setText(userProg);
						stdPage.getTxtPhone().setText(phoneNo);
					}
					
					
//					if(resSet.next()==true)
//					{
//						//String userID=resSet.getString(1);
//						//String userName=resSet.getString(2);
//						String userPassword=resSet.getString(1);
//						String userBatch=resSet.getString(2);
//						String userPhone=resSet.getString(3);
//						String userProgram=resSet.getString(4);
//						
//						//((JLabel) stdPage.uId).setText(userID);
//						//((JLabel) stdPage.uName).setText(userName);
//  				    	((JLabel) stdPage.uPass).setText(userPassword);
//						((JLabel) stdPage.uBatch).setText(userBatch);
//						((JLabel) stdPage.uPhone).setText(userPhone);
//						((JLabel) stdPage.uProgram).setText(userProgram);
//						
////						stdPage.sId.setText(userName);
////						txtPassword.setText(userPassword);
////						txtBatch.setText(userBatch);
////						txtProgram.setText(userProgram);
////						txtPhone.setText(userPhone);
////						txtSemester.setText(userSemester);
//					}
//					else {
//						
//						
//					}	
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
				
			}	
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(285, 292, 95, 39);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(184, 154, 79, 33);
		contentPane.add(lblNewLabel_2);
		
		txtSName = new JTextField();
		txtSName.setBounds(285, 154, 228, 33);
		contentPane.add(txtSName);
		txtSName.setColumns(10);
		
		lblNewLabel = new JLabel("Student Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(285, 37, 153, 73);
		contentPane.add(lblNewLabel);
		
	}
}
