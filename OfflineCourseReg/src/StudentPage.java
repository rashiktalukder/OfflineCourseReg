import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;

public class StudentPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtSemNo;
	private JTextField txtEnrolledcourse1;
	private JTextField txtEnrolledcourse2;
	private JTextField txtEnrolledcourse3;
	private JTextField txtEnrolledcourse4;
	protected Object sId;
	public Object uId,uName,uPass,uBatch,uPhone,uProgram;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentPage frame = new StudentPage();
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
	public StudentPage() {
		
		InitializeStudPage();
		ConnectionStudPage();
		
	}

	Connection conn;
	PreparedStatement prepStatement;
	ResultSet resSet;
	private JTextField txtUname;
	private JTextField txtBatch;
	private JTextField txtProg;
	private JTextField txtPhone;
	private JTextField txtStudID;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private void ConnectionStudPage() {
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

	public void InitializeStudPage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Courses Enrolled", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(515, 103, 464, 355);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(195, 22, 259, 40);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Semester No.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 98, 20);
		panel_2.add(lblNewLabel);
		
		txtSemNo = new JTextField();
		txtSemNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String semNo=txtSemNo.getText();
				String StudID=txtStudID.getText();
				try {
					
					prepStatement=conn.prepareStatement("select course1,course2,course3,course4 from student where studsemester=? and stdid=?");
					prepStatement.setString(1,semNo);
					prepStatement.setString(2,StudID);
					
					resSet = prepStatement.executeQuery();
					
					if(resSet.next()==true)
					{
						String enrolledCourse1=resSet.getString(1);
						String enrolledcourse2=resSet.getString(2);
						String enrolledcourse3=resSet.getString(3);
						String enrolledcourse4=resSet.getString(4);
						
						txtEnrolledcourse1.setText(enrolledCourse1);
						txtEnrolledcourse2.setText(enrolledcourse2);
						txtEnrolledcourse3.setText(enrolledcourse3);
						txtEnrolledcourse4.setText(enrolledcourse4);
					}
					else {
						
						txtEnrolledcourse1.setText("");
						txtEnrolledcourse2.setText("");
						txtEnrolledcourse3.setText("");
						txtEnrolledcourse4.setText("");
						
					}	
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		txtSemNo.setBounds(118, 10, 131, 22);
		panel_2.add(txtSemNo);
		txtSemNo.setColumns(10);
		
		txtEnrolledcourse1 = new JTextField();
		txtEnrolledcourse1.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnrolledcourse1.setEditable(false);
		txtEnrolledcourse1.setBounds(32, 90, 400, 40);
		panel_1.add(txtEnrolledcourse1);
		txtEnrolledcourse1.setColumns(10);
		
		txtEnrolledcourse2 = new JTextField();
		txtEnrolledcourse2.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnrolledcourse2.setEditable(false);
		txtEnrolledcourse2.setColumns(10);
		txtEnrolledcourse2.setBounds(32, 140, 400, 40);
		panel_1.add(txtEnrolledcourse2);
		
		txtEnrolledcourse3 = new JTextField();
		txtEnrolledcourse3.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnrolledcourse3.setEditable(false);
		txtEnrolledcourse3.setColumns(10);
		txtEnrolledcourse3.setBounds(32, 190, 400, 40);
		panel_1.add(txtEnrolledcourse3);
		
		txtEnrolledcourse4 = new JTextField();
		txtEnrolledcourse4.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnrolledcourse4.setEditable(false);
		txtEnrolledcourse4.setColumns(10);
		txtEnrolledcourse4.setBounds(32, 241, 400, 40);
		panel_1.add(txtEnrolledcourse4);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				StudentLogin stdLogin=new StudentLogin();
				stdLogin.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(804, 21, 175, 49);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Student Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 103, 464, 362);
		contentPane.add(panel);
		panel.setLayout(null);
		
		setTxtUname(new JTextField());
		getTxtUname().setBounds(73, 107, 289, 34);
		panel.add(getTxtUname());
		getTxtUname().setColumns(10);
		
		setTxtBatch(new JTextField());
		getTxtBatch().setColumns(10);
		getTxtBatch().setBounds(73, 169, 289, 34);
		panel.add(getTxtBatch());
		
		setTxtProg(new JTextField());
		getTxtProg().setColumns(10);
		getTxtProg().setBounds(73, 235, 289, 34);
		panel.add(getTxtProg());
		
		setTxtPhone(new JTextField());
		getTxtPhone().setColumns(10);
		getTxtPhone().setBounds(73, 297, 289, 34);
		panel.add(getTxtPhone());
		
		setTxtStudID(new JTextField());
		getTxtStudID().setColumns(10);
		getTxtStudID().setBounds(73, 46, 289, 34);
		panel.add(getTxtStudID());
		
		lblNewLabel_1 = new JLabel("Welcome To AIUB");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(30, 26, 454, 35);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Where Leaders are Created;");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(30, 50, 187, 26);
		contentPane.add(lblNewLabel_2);
		
	}

	public JTextField getTxtUname() {
		return txtUname;
	}

	public void setTxtUname(JTextField txtUname) {
		this.txtUname = txtUname;
		txtUname.setEditable(false);
	}

	public JTextField getTxtBatch() {
		return txtBatch;
	}

	public void setTxtBatch(JTextField txtBatch) {
		this.txtBatch = txtBatch;
		txtBatch.setEditable(false);
	}

	public JTextField getTxtProg() {
		return txtProg;
	}

	public void setTxtProg(JTextField txtProg) {
		this.txtProg = txtProg;
		txtProg.setEditable(false);
	}

	public JTextField getTxtPhone() {
		return txtPhone;
	}

	public void setTxtPhone(JTextField txtPhone) {
		this.txtPhone = txtPhone;
		txtPhone.setEditable(false);
	}

	public JTextField getTxtStudID() {
		return txtStudID;
	}

	public void setTxtStudID(JTextField txtStudID) {
		this.txtStudID = txtStudID;
		txtStudID.setEditable(false);
	}
}
