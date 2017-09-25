import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class FinalChecker extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalChecker frame = new FinalChecker(null, null);
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
	public FinalChecker(Pie za, FinalOrder order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		order.setOrder(za.getPizza());
		order.setNewPrice(za.getPrice());
		
		JButton btnNewButton = new JButton("Another ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PizzaBaseSelector selector = new PizzaBaseSelector(order);
				dispose();
				selector.setVisible(true);
			}
		});
		btnNewButton.setBounds(299, 146, 89, 23);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 279, 413);
		contentPane.add(textArea);
		textArea.setText(order.getOrder() + "\n" + order.getPrice() +"\n");
		
		JButton btnStartOver = new JButton("Start over");
		btnStartOver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinalOrder neworder = new FinalOrder();
				neworder.setNumber(order.getNumber());
				PizzaBaseSelector base = new PizzaBaseSelector(neworder);
				base.setVisible(true);
				dispose();
			}
		});
		btnStartOver.setBounds(299, 180, 89, 23);
		contentPane.add(btnStartOver);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BeverageMenu menu = new BeverageMenu(order.getPrice(), order);
				menu.setVisible(true);
				dispose();
			}
		});
		btnContinue.setBounds(299, 214, 89, 23);
		contentPane.add(btnContinue);
		za.clearPizza();
		
	}
}
