import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FoundCard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoundCard frame = new FoundCard(null);
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
	public FoundCard(FinalOrder order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 272, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Use Same Card? ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 236, 37);
		contentPane.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 59, 236, 27);
		contentPane.add(textPane);
		Pizza newpizza = new Pizza();
		textPane.setText(newpizza.selectCard(order.getNumber()));
		textPane.setEditable(false);
		
		JButton btnYes = new JButton("Yes ");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if card is desired, proceed to final payment 
				FinalPayment Final = new FinalPayment(1 , order);
				Final.setVisible(true);
				dispose();
			}
		});
		btnYes.setBounds(157, 97, 89, 23);
		contentPane.add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//allows user to input new card 
				NewCard card = new NewCard(order);
				card.setVisible(true);
				dispose();
			}
		});
		btnNo.setBounds(10, 97, 89, 23);
		contentPane.add(btnNo);
	}
}
