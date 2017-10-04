import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class beverageReceipt extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton button;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					beverageReceipt frame = new beverageReceipt(null, (Double) null, null);
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
	public beverageReceipt(Beverage beverage, double totalPrice, FinalOrder order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 305, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textArea = new JTextArea();
		textArea.setBounds(10, 11, 129, 239);
		contentPane.add(textArea);
		textArea.setText(beverage.getBeverage() + beverage.getPrice());
		
		
		button = new JButton("Change Selection");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BeverageMenu menu = new BeverageMenu(totalPrice, order);
				menu.setVisible(true);
				dispose();
			}
		});
		button.setBounds(149, 12, 129, 23);
		contentPane.add(button);
		
		btnNewButton = new JButton("Clear Order ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinalOrder neworder = new FinalOrder();
				PizzaBaseSelector base = new PizzaBaseSelector(neworder);
				base.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(149, 46, 129, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Continue");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double total = totalPrice + beverage.getPrice();
				order.setOrder(beverage.getBeverage());
				order.setNewPrice(beverage.getPrice());
				PaymentOption option = new PaymentOption(total, order);
				option.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(149, 80, 129, 23);
		contentPane.add(btnNewButton_1);
	}
}
