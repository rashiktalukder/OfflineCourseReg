import java.awt.EventQueue;
import java.sql.*;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Admin {

	private JFrame frame;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtBatch;
	private JTextField txtProgram;
	private JTextField txtPhone;
	private JTextField txtSemester;
	private JTextField txtStdSearchID;

	/**
	 * Launch the application.
	 */
	
	String userName, userPassword, userBatch, userProgram, userPhone, userSemester;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin() {
		initialize();
		Connection();
		LoadDataToTable();
	}
	
	

	Connection conn;
	PreparedStatement prepStatement;
	ResultSet resSet;
	private JTable table;
	
	private void Connection() {
		
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
	
	private void LoadDataToTable() {
		
		try {
			prepStatement=conn.prepareStatement("select * from studentreg");
			resSet=prepStatement.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resSet));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1036, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AIUB Student Registration Offline");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(82, 53, 242, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Fresher Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(34, 110, 459, 273);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserName.setBounds(10, 40, 99, 28);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(10, 81, 99, 28);
		panel.add(lblPassword);
		
		JLabel lblBatch = new JLabel("Batch");
		lblBatch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBatch.setBounds(10, 119, 99, 28);
		panel.add(lblBatch);
		
		JLabel lblProgram = new JLabel("Program");
		lblProgram.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProgram.setBounds(10, 157, 99, 28);
		panel.add(lblProgram);
		
		JLabel lblPhNo = new JLabel("Phone No.");
		lblPhNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhNo.setBounds(10, 195, 99, 28);
		panel.add(lblPhNo);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSemester.setBounds(10, 233, 99, 28);
		panel.add(lblSemester);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(119, 40, 235, 26);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(119, 85, 235, 26);
		panel.add(txtPassword);
		
		txtBatch = new JTextField();
		txtBatch.setColumns(10);
		txtBatch.setBounds(119, 123, 235, 26);
		panel.add(txtBatch);
		
		txtProgram = new JTextField();
		txtProgram.setColumns(10);
		txtProgram.setBounds(119, 161, 235, 26);
		panel.add(txtProgram);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(119, 199, 235, 26);
		panel.add(txtPhone);
		
		txtSemester = new JTextField();
		txtSemester.setColumns(10);
		txtSemester.setBounds(119, 237, 235, 26);
		panel.add(txtSemester);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(525, 35, 368, 54);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 10, 93, 34);
		panel_1.add(lblNewLabel_1);
		
		txtStdSearchID = new JTextField();
		txtStdSearchID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String id=txtStdSearchID.getText();
				try {
					
					prepStatement=conn.prepareStatement("select username,password,batch,program,phone,semester from studentreg where id=?");
					prepStatement.setString(1,id);
					resSet = prepStatement.executeQuery();
					
					if(resSet.next()==true)
					{
						String userName=resSet.getString(1);
						String userPassword=resSet.getString(2);
						String userBatch=resSet.getString(3);
						String userProgram=resSet.getString(4);
						String userPhone=resSet.getString(5);
						String userSemester=resSet.getString(6);
						
						txtUserName.setText(userName);
						txtPassword.setText(userPassword);
						txtBatch.setText(userBatch);
						txtProgram.setText(userProgram);
						txtPhone.setText(userPhone);
						txtSemester.setText(userSemester);
					}
					else {
						
						txtUserName.setText("");
						txtPassword.setText("");
						txtBatch.setText("");
						txtProgram.setText("");
						txtPhone.setText("");
						txtSemester.setText("");
					
						txtUserName.requestFocus();
					}	
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
				
			}
		});
		txtStdSearchID.setBounds(116, 10, 248, 34);
		panel_1.add(txtStdSearchID);
		txtStdSearchID.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				  
				
				userName= txtUserName.getText();
				userPassword= txtPassword.getText();
				userBatch= txtBatch.getText();
				userProgram = txtProgram.getText();
				userPhone = txtPhone.getText();
				userSemester= txtSemester.getText();
				
				
				try {
					
					prepStatement=conn.prepareStatement("insert into studentreg(username,password,batch,program,phone,semester)values(?,?,?,?,?,?)");
					
					prepStatement.setString(1, userName);
					prepStatement.setString(2, userPassword);
					prepStatement.setString(3, userBatch);
					prepStatement.setString(4, userProgram);
					prepStatement.setString(5, userPhone);
					prepStatement.setString(6, userSemester);
					prepStatement.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Record added");
					LoadDataToTable();
					
					txtUserName.setText("");
					txtPassword.setText("");
					txtBatch.setText("");
					txtProgram.setText("");
					txtPhone.setText("");
					txtSemester.setText("");
					
					txtUserName.requestFocus();
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(34, 393, 114, 41);
		frame.getContentPane().add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id=txtStdSearchID.getText();
				
				userName= txtUserName.getText();
				userPassword= txtPassword.getText();
				userBatch= txtBatch.getText();
				userProgram = txtProgram.getText();
				userPhone = txtPhone.getText();
				userSemester= txtSemester.getText();
				
				
				try {
					
					prepStatement=conn.prepareStatement("update studentreg set username=?,password=?,batch=?,program=?,phone=?,semester=? where id=?");
					
					prepStatement.setString(1, userName);
					prepStatement.setString(2, userPassword);
					prepStatement.setString(3, userBatch);
					prepStatement.setString(4, userProgram);
					prepStatement.setString(5, userPhone);
					prepStatement.setString(6, userSemester);
					prepStatement.setString(7,id);
					
					prepStatement.executeUpdate();
					
					LoadDataToTable();
					JOptionPane.showMessageDialog(null, "Record Updated!");
					
					
					txtUserName.setText("");
					txtPassword.setText("");
					txtBatch.setText("");
					txtProgram.setText("");
					txtPhone.setText("");
					txtSemester.setText("");
					
					txtUserName.requestFocus();
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
				
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(158, 393, 90, 41);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String id=txtStdSearchID.getText();
					try {
					
					prepStatement=conn.prepareStatement("delete from studentreg where id=?");
					
					prepStatement.setString(1,id);
					
					prepStatement.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "If you delete, You can't be undone..!");
					LoadDataToTable();
					
					
					
//					txtUserName.setText("");
//					txtPassword.setText("");
//					txtBatch.setText("");
//					txtProgram.setText("");
//					txtPhone.setText("");
//					txtSemester.setText("");
//					
//					txtUserName.requestFocus();
//					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(258, 393, 90, 41);
		frame.getContentPane().add(btnDelete);
		
		JButton btnNewButton = new JButton("Course Registration");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentCourseReg sCourseReg=new StudentCourseReg();
				sCourseReg.setVisible(true);
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(34, 468, 289, 47);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Exit");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(898, 48, 114, 41);
		frame.getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(503, 110, 509, 328);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtUserName.setText("");
				txtPassword.setText("");
				txtBatch.setText("");
				txtProgram.setText("");
				txtPhone.setText("");
				txtSemester.setText("");
				txtStdSearchID.setText("");
				
				txtUserName.requestFocus();
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setBounds(358, 393, 95, 41);
		frame.getContentPane().add(btnClear);
	}
}
