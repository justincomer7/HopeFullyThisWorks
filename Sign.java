import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sign extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign frame = new Sign(null);
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
	public Sign(FinalOrder order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Pizza newpizza = new Pizza();
		
		textField = new JTextField();
		
		textField.setBounds(10, 426, 228, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("If correct please sign: ");
		lblNewLabel.setBounds(10, 407, 142, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Place Order ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//ensures a signature is present 
				if(textField.getText().trim().isEmpty())
				{
					NotSigned signed = new NotSigned(order);
					signed.setVisible(true);
					dispose();
				}
				
				else
				{
					
					//at this time, the order will be saved in the database
					Pizza pizza = new Pizza();
					pizza.addReciept(order.getNumber(), order.getOrder());
					
					//the order is complete 
					Signed done = new Signed();
					done.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(248, 425, 113, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Change User");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//all the way back to beginning 
				PhoneNumber num = new PhoneNumber();
				num.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(248, 11, 113, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Change Order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//same user, new order 
				FinalOrder neworder = new FinalOrder();
				PizzaBaseSelector base = new PizzaBaseSelector(neworder);
				base.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(248, 45, 113, 23);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(235, 11, -223, 384);
		contentPane.add(scrollPane);
		
		textField_1 = new JTextPane();
		textField_1.setBounds(10, 12, 228, 384);
		contentPane.add(textField_1);
		textField_1.setText(newpizza.selectUser(order.getNumber()) + "\n" + newpizza.selectAddress(order.getNumber()) + "\n" + 
				newpizza.selectCard(order.getNumber()) + "\n" + order.getOrder() + "\n" + order.getPrice());
		textField_1.setEditable(false);
		
	
	}
}
