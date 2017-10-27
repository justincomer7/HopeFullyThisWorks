import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tester extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tester frame = new Tester(null, (Integer) null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame
	 */
	public Tester(String string, int win) {
		
		Pizza newpizza = new Pizza();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 414, 153);
		contentPane.add(textArea);
		
		textArea.setText(newpizza.selectUser(string) + "\n" + newpizza.selectAddress(string));
		textArea.setEditable(false);
		
		JButton btnNewButton = new JButton("Yes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FinalOrder order = new FinalOrder();
				order.setNumber(string);
				PizzaBaseSelector base = new PizzaBaseSelector(order);
				base.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("No");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(win == 1)
				{
					//sends back to information input 
					InformationInput info = new InformationInput();
					info.setVisible(true);
					dispose();
				}
				if(win == 2)
				{
					//sends back to phone number input 
					PhoneNumber phone = new PhoneNumber();
					phone.setVisible(true);
					dispose();
				}
				if(win == 3)
				{
					//sends back to updater 
					Update update = new Update(string);
					update.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1.setBounds(236, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Correct?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(236, 175, 188, 41);
		contentPane.add(lblNewLabel);
		
		JButton btnUpdateInfo = new JButton("Update Info");
		btnUpdateInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update update = new Update(string);
				update.setVisible(true);
				dispose();
			}
		});
		btnUpdateInfo.setBounds(10, 175, 116, 23);
		contentPane.add(btnUpdateInfo);
	}
}
