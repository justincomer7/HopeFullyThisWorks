import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PhoneNumber extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhoneNumber frame = new PhoneNumber();
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
	public PhoneNumber() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter phone number: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(52, 11, 306, 44);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(111, 66, 189, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = textField.getText();
				
				Pizza newpizza = new Pizza();
				
				if(newpizza.selectUser(number) != " ")
				{
					Tester test = new Tester(number, 2);
					test.setVisible(true);
					dispose();
				}
				else
				{
					NotFound not = new NotFound();
					not.setVisible(true);
					dispose();
				}
			}
		});
		btnNext.setBounds(211, 97, 89, 23);
		contentPane.add(btnNext);
		
		JButton btnNewButton = new JButton("New?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformationInput info = new InformationInput();
				info.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(112, 97, 89, 23);
		contentPane.add(btnNewButton);
	}

}
