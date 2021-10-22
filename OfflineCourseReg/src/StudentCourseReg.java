import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentCourseReg extends JFrame {

	private JPanel contentPane;
	private JTextField txtStdId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentCourseReg frame = new StudentCourseReg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Admin admin=new Admin();

	/**
	 * Create the frame.
	 */
	Connection conn;
	PreparedStatement prepStatement;
	ResultSet resSet;
	private JTextField txtSearchSem;
	private JTextField txtSName;
	private JTextField txtSBatch;
	private JTextField txtSProgram;
	private JTextField txtSSemester;
	
	public StudentCourseReg() {
		InitializeCourseReg();
		Connection();
		
		
	}

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

	private void InitializeCourseReg() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1029, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(589, 50, 416, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(25, 10, 89, 30);
		panel.add(lblNewLabel);
		
		txtStdId = new JTextField();
		txtStdId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String id=txtStdId.getText();
				try {
					
					prepStatement=conn.prepareStatement("select username,batch,program,semester from studentreg where id=?");
					prepStatement.setString(1,id);
					resSet = prepStatement.executeQuery();
					
					if(resSet.next()==true)
					{
						String userName=resSet.getString(1);
						String userBatch=resSet.getString(2);
						String userProgram=resSet.getString(3);
						String userSemester=resSet.getString(4);
						
						txtSName.setText("User Name: "+userName);
						txtSBatch.setText("Batch: "+userBatch);
						txtSProgram.setText("Program: "+userProgram);
						txtSSemester.setText("Semester: "+userSemester);
					}
					else {
						
						txtSName.setText("");
						txtSBatch.setText("");
						txtSProgram.setText("");
						txtSSemester.setText("");
					
					}	
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
				
			}
		});
		txtStdId.setBounds(136, 10, 270, 30);
		panel.add(txtStdId);
		txtStdId.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Courses Offered", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(518, 110, 487, 341);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JCheckBox checkSubject1 = new JCheckBox("");
		checkSubject1.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkSubject1.setBounds(37, 120, 349, 33);
		panel_1.add(checkSubject1);
		
		JCheckBox checkSubject2 = new JCheckBox("");
		checkSubject2.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkSubject2.setBounds(37, 174, 349, 33);
		panel_1.add(checkSubject2);
		
		JCheckBox checkSubject3 = new JCheckBox("");
		checkSubject3.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkSubject3.setBounds(37, 233, 349, 33);
		panel_1.add(checkSubject3);
		
		JCheckBox checkSubject4 = new JCheckBox("");
		checkSubject4.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkSubject4.setBounds(37, 289, 349, 33);
		panel_1.add(checkSubject4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(77, 39, 400, 50);
		panel_1.add(panel_2);
		
		JLabel lblSearchSem = new JLabel("Semester");
		lblSearchSem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSearchSem.setBounds(25, 10, 89, 30);
		panel_2.add(lblSearchSem);
		
		txtSearchSem = new JTextField();
		txtSearchSem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String semester=txtSearchSem.getText();
				try {
					
					prepStatement=conn.prepareStatement("select course1,course2,course3,course4 from aiubcourses where semester=?");
					prepStatement.setString(1,semester);
					resSet = prepStatement.executeQuery();
					
					if(resSet.next()==true)
					{
						String course1=resSet.getString(1);
						String course2=resSet.getString(2);
						String course3=resSet.getString(3);
						String course4=resSet.getString(4);
						
						checkSubject1.setText(course1);
						checkSubject2.setText(course2);
						checkSubject3.setText(course3);
						checkSubject4.setText(course4);
					}
					else {
						
						checkSubject1.setText("");
						checkSubject2.setText("");
						checkSubject3.setText("");
						checkSubject4.setText("");
						
//						txtUserName.requestFocus();
					}	
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
			}
		});
		txtSearchSem.setColumns(10);
		txtSearchSem.setBounds(136, 10, 254, 30);
		panel_2.add(txtSearchSem);
		
		JButton btnConfirm = new JButton("Confirm Registration");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String enStudentId=txtStdId.getText();
				String enSemester= txtSearchSem.getText();
				
				String encourse1 = "",encourse2="",encourse3="",encourse4="";
				
				if(checkSubject1.isSelected())
				{
					encourse1= checkSubject1.getText();
				}
				if(checkSubject2.isSelected())
				{
					encourse2= checkSubject2.getText();
				}
				if(checkSubject3.isSelected())
				{
					encourse3= checkSubject3.getText();
				}
				if(checkSubject4.isSelected())
				{
					encourse4= checkSubject4.getText();
				}
				
				
				try {
					
					prepStatement=conn.prepareStatement("insert into student(stdid,studsemester,course1,course2,course3,course4)values(?,?,?,?,?,?)");
					
					prepStatement.setString(1, enStudentId);
					prepStatement.setString(2, enSemester);
					prepStatement.setString(3, encourse1);
					prepStatement.setString(4, encourse2);
					prepStatement.setString(5, encourse3);
					prepStatement.setString(6, encourse4);
					
					prepStatement.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Registration Done, Jaao r line e dariye thakte hobe na.!");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
				
			
		});
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirm.setBounds(518, 461, 183, 37);
		contentPane.add(btnConfirm);
		
		txtSName = new JTextField();
		txtSName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSName.setEditable(false);
		txtSName.setBounds(39, 161, 395, 50);
		contentPane.add(txtSName);
		txtSName.setColumns(10);
		
		txtSBatch = new JTextField();
		txtSBatch.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSBatch.setEditable(false);
		txtSBatch.setColumns(10);
		txtSBatch.setBounds(39, 239, 395, 50);
		contentPane.add(txtSBatch);
		
		txtSProgram = new JTextField();
		txtSProgram.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSProgram.setEditable(false);
		txtSProgram.setColumns(10);
		txtSProgram.setBounds(39, 320, 395, 50);
		contentPane.add(txtSProgram);
		
		txtSSemester = new JTextField();
		txtSSemester.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSSemester.setEditable(false);
		txtSSemester.setColumns(10);
		txtSSemester.setBounds(39, 400, 395, 50);
		contentPane.add(txtSSemester);
	}
}
