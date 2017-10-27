import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class NewCard extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCard frame = new NewCard(null);
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
	public NewCard(FinalOrder order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Card Info");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(15, 6, 256, 45);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(15, 67, 256, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Visa ");
		rdbtnNewRadioButton.setActionCommand("Visa");
		rdbtnNewRadioButton.setBounds(10, 99, 127, 29);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Discover");
		rdbtnNewRadioButton_1.setActionCommand("Discover");
		rdbtnNewRadioButton_1.setBounds(144, 99, 127, 29);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnMastercard = new JRadioButton("MasterCard");
		rdbtnMastercard.setActionCommand("MasterCard");
		rdbtnMastercard.setBounds(10, 136, 127, 29);
		contentPane.add(rdbtnMastercard);
		
		JRadioButton rdbtnAmericanExp = new JRadioButton("American Exp");
		rdbtnAmericanExp.setActionCommand("Am Ex");
		rdbtnAmericanExp.setBounds(144, 136, 155, 29);
		contentPane.add(rdbtnAmericanExp);
		
		ButtonGroup card = new ButtonGroup();
		card.add(rdbtnNewRadioButton); card.add(rdbtnNewRadioButton_1);
		card.add(rdbtnMastercard); card.add(rdbtnAmericanExp);
		rdbtnNewRadioButton.setSelected(true);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//goes back to payment option 
				PaymentOption option = new PaymentOption( order);
				option.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 177, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pizza newpizza = new Pizza();
				ButtonModel Card = card.getSelection();
				
				//Will update card type and card number 
				newpizza.updateCard(order.getNumber(), Card.getActionCommand() + " " + textField.getText());
				FinalPayment Final = new FinalPayment(1, order);
				Final.setVisible(true);
				dispose();
			}
		});
		btnUpdate.setBounds(210, 177, 89, 23);
		contentPane.add(btnUpdate);
		

		
		
	}
}
