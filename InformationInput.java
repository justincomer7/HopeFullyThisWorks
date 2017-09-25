import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InformationInput extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_1;
	private JLabel Phone;
	private JTextField textField_6;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(GraphicsConfiguration String) {
				try {
					InformationInput frame = new InformationInput();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InformationInput() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Name = new JLabel("Name");
		Name.setBounds(10, 40, 70, 24);
		contentPane.add(Name);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 75, 70, 14);
		contentPane.add(lblAddress);
		
		JLabel lblSubdivision = new JLabel("Subdivision");
		lblSubdivision.setBounds(10, 165, 70, 14);
		contentPane.add(lblSubdivision);
		
		JLabel lblIntersection = new JLabel("Intersection ");
		lblIntersection.setBounds(10, 227, 70, 14);
		contentPane.add(lblIntersection);
		
		JLabel lblLandmark = new JLabel("Landmark");
		lblLandmark.setBounds(10, 196, 46, 14);
		contentPane.add(lblLandmark);
		
		JLabel lblOther = new JLabel("Other");
		lblOther.setBounds(10, 258, 46, 14);
		contentPane.add(lblOther);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(100, 41, 255, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(100, 72, 255, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 162, 255, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(100, 224, 255, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(100, 193, 255, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 255, 255, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		Phone = new JLabel("Phone Number ");
		Phone.setBounds(10, 97, 89, 29);
		contentPane.add(Phone);
		
		textField_6 = new JTextField();
		textField_6.setBounds(100, 103, 255, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pizza newpizza = new Pizza();
				
				String name;
				String address;
				String subdivision;
				String intersection;
				String landmark;
				String other;
				String number;
				int option = 1;
				if(textFieldName.getText().trim().isEmpty())
				{
					NotFilled not = new NotFilled(1, " ");
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
					NotFilled not = new NotFilled(1, " ");
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
				
				if(textField_6.getText().trim().isEmpty())
				{
					NotFilled not = new NotFilled(1, " ");
					not.setVisible(true);
					dispose();
					number = " ";
					option = 2;
				}
				else {number = textField_6.getText();}
					
				
				
				if(option == 1)
					if(newpizza.addUser(number, name, address, " ") == "false")
					{
						AlreadyExists ae = new AlreadyExists();
						dispose();
						ae.setVisible(true);
					}
					
					else {
						
						
						
						newpizza.addUser(number,  name,  address, " ");
						newpizza.addAddress(number, subdivision, intersection, landmark, other);
						Tester test = new Tester(number, 1);
						dispose();
						test.setVisible(true);
						
						
					}
				
				}
				
				
				
		});
		btnEnter.setBounds(269, 286, 89, 23);
		contentPane.add(btnEnter);
		
		btnNewButton = new JButton("Not new?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhoneNumber num = new PhoneNumber();
				num.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 283, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Required:");
		lblNewLabel.setBounds(100, 11, 70, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNotRequired = new JLabel("Not Required:");
		lblNotRequired.setBounds(100, 137, 89, 14);
		contentPane.add(lblNotRequired);
		

	}
}
