import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NotFound extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotFound frame = new NotFound();
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
	public NotFound() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 159);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User not found ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 326, 49);
		contentPane.add(lblNewLabel);
		
		JButton btnRetry = new JButton("Retry?");
		btnRetry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sends back to phone number 
				PhoneNumber phone = new PhoneNumber();
				phone.setVisible(true);
				dispose();
			}
		});
		btnRetry.setBounds(67, 71, 89, 23);
		contentPane.add(btnRetry);
		
		JButton btnNewButton = new JButton("Create new");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//allows user to create new account
				InformationInput input = new InformationInput();
				input.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(190, 71, 89, 23);
		contentPane.add(btnNewButton);
	}

}
