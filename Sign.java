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

public class Sign extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		
		JLabel lblNewLabel_1 = new JLabel("Signature Required");
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setBounds(139, 407, 128, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Place Order ");
		btnNewButton.setBounds(248, 425, 113, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Change User");
		btnNewButton_1.setBounds(248, 11, 113, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Change Order");
		btnNewButton_2.setBounds(248, 45, 113, 23);
		contentPane.add(btnNewButton_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 10, 228, 386);
		contentPane.add(textArea);
		textArea.setText(newpizza.selectUser(order.getNumber()) + "\n" + newpizza.selectAddress(order.getNumber()) + "\n" + 
				newpizza.selectCard(order.getNumber()) + "\n" + order.getOrder() + "\n" + order.getPrice());
		textArea.setEditable(false);
		textArea.getScrollableTracksViewportHeight();
	}
}
