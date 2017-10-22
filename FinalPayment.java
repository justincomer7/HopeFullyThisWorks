import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinalPayment extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalPayment frame = new FinalPayment((Double) null, null);
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
	public FinalPayment(double option, FinalOrder order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 11, 254, 116);
		contentPane.add(textPane);
		if(option == 1)
		{
			//displays payment option with price 
			Pizza newpizza = new Pizza();
			textPane.setText(newpizza.selectCard(order.getNumber()) + "\n" + order.getPrice());
		}
		
		if(option == 2)
		{
			textPane.setText("Cash" + "\n" + order.getPrice());
		}
		JButton btnFinalize = new JButton("Finalize");
		btnFinalize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sign sign = new Sign(order);
				sign.setVisible(true);
				dispose();
			}
		});
		btnFinalize.setBounds(274, 11, 123, 23);
		contentPane.add(btnFinalize);
		textPane.setEditable(false);
		
		JButton btnChange = new JButton("Change option");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PaymentOption option = new PaymentOption(order);
				option.setVisible(true);
				dispose();
			}
		});
		btnChange.setBounds(274, 58, 123, 23);
		contentPane.add(btnChange);
		
		JButton btnNewButton = new JButton("Start Over");
		btnNewButton.setBounds(274, 104, 123, 23);
		contentPane.add(btnNewButton);
	}

}
