import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentOption extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("How will you be paying? ");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentOption frame = new PaymentOption((Double) null, null);
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
	public PaymentOption(double totalPrice, FinalOrder order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 254, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 218, 54);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cash ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinalPayment Final = new FinalPayment(totalPrice, 2, order);
				Final.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 76, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Card");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pizza newpizza = new Pizza();
				if(newpizza.selectCard(order.getNumber()) != "")
				{
					FoundCard found = new FoundCard(totalPrice, order);
					found.setVisible(true);
					dispose();
				}
				
				else 
				{
					NewCard update = new NewCard(totalPrice, order);
					update.setVisible(true);
					dispose();
					
				}
			}
		});
		btnNewButton_1.setBounds(139, 76, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
