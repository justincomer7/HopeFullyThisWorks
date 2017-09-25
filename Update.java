import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update extends JFrame {
	
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton btnUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update(null);
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
	public Update(String num) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Name = new JLabel("Name");
		Name.setBounds(10, 30, 70, 24);
		contentPane.add(Name);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 65, 70, 14);
		contentPane.add(lblAddress);
		
		JLabel lblSubdivision = new JLabel("Subdivision");
		lblSubdivision.setBounds(10, 120, 70, 14);
		contentPane.add(lblSubdivision);
		
		JLabel lblIntersection = new JLabel("Intersection ");
		lblIntersection.setBounds(10, 151, 70, 14);
		contentPane.add(lblIntersection);
		
		JLabel lblLandmark = new JLabel("Landmark");
		lblLandmark.setBounds(10, 182, 46, 14);
		contentPane.add(lblLandmark);
		
		JLabel lblOther = new JLabel("Other");
		lblOther.setBounds(10, 213, 46, 14);
		contentPane.add(lblOther);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(100, 31, 255, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(100, 62, 255, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 117, 255, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(100, 148, 255, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(100, 179, 255, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 210, 255, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pizza newpizza = new Pizza();
				
				String name;
				String address;
				String subdivision;
				String intersection;
				String landmark;
				String other;
				int option = 1;
				
				if(textFieldName.getText().trim().isEmpty())
				{
					NotFilled not = new NotFilled(2, num);
					not.setVisible(true);
					dispose();
					name = " ";
					option = 2;
				}
				else
				{
					name = textFieldName.getText();
				}
				
				if(textField.getText().trim().isEmpty())
				{
					NotFilled not = new NotFilled(2, num);
					not.setVisible(true);
					dispose();
					address = " ";
					option = 2;
				}
				
				else{address = textField.getText();}
				
				if(textField_2.getText().trim().isEmpty())
				{
					subdivision = " ";
				}
				
				else{subdivision = textField_2.getText();}
				
				if(textField_3.getText().trim().isEmpty())
				{
					intersection = " ";
				}
				
				else{intersection = textField_3.getText();}
				
				if(textField_4.getText().trim().isEmpty())
				{
					landmark = " ";
				}
				
				else {landmark = textField_4.getText();}
				
				if(textField_1.getText().trim().isEmpty())
				{
					other = " ";
				}
				else 
				{
					other = textField_1.getText();
				}
				
				if(option == 1)
				{
					newpizza.updateUser(num, name, address);
					newpizza.updateAddress(num, subdivision, intersection, landmark, other);
				
					Tester test = new Tester(num, 3);
					test.setVisible(true);
					dispose();
				}
				
			}
		});
		btnUpdate.setBounds(100, 241, 89, 23);
		contentPane.add(btnUpdate);
		
		JLabel lblNewLabel = new JLabel("Required: ");
		lblNewLabel.setBounds(100, 11, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Not required: ");
		lblNewLabel_1.setBounds(100, 93, 70, 14);
		contentPane.add(lblNewLabel_1);
		
	}
}
