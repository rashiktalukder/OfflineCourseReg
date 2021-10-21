import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(523, 110, 489, 328);
		frame.getContentPane().add(scrollPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setViewportView(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(644, 34, 368, 54);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 10, 93, 34);
		panel_1.add(lblNewLabel_1);
		
		txtStdSearchID = new JTextField();
		txtStdSearchID.setBounds(116, 10, 248, 34);
		panel_1.add(txtStdSearchID);
		txtStdSearchID.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(34, 393, 114, 41);
		frame.getContentPane().add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(205, 393, 114, 41);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(355, 393, 138, 41);
		frame.getContentPane().add(btnDelete);
		
		JButton btnNewButton = new JButton("Course Registration");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(34, 468, 289, 47);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(880, 497, 114, 41);
		frame.getContentPane().add(btnBack);
	}
}
