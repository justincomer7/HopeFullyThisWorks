import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
					PaymentOption frame = new PaymentOption(null);
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
	public PaymentOption(FinalOrder order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 218, 54);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cash/Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinalPayment Final = new FinalPayment( 2, order);
				Final.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(31, 69, 174, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Card");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pizza newpizza = new Pizza();
				
				//if card is found, will display card number 
				//if card is not found, input screen will pop 
				if(newpizza.selectCard(order.getNumber()) != null)
				{
					FoundCard found = new FoundCard(order);
					found.setVisible(true);
					dispose();
				}
				
				else 
				{
					NewCard update = new NewCard(order);
					update.setVisible(true);
					dispose();
					
				}
			}
		});
		btnNewButton_1.setBounds(31, 126, 174, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBackground(Color.WHITE);
		Image img = new ImageIcon(this.getClass().getResource("Visa.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(115, 48, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(255, 109, 109, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel();
		Image img2 = new ImageIcon(this.getClass().getResource("MasterCard.jpeg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(new ImageIcon(img2).getImage().getScaledInstance(120, 60, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(255, 58, 109, 40);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel();
		Image img3 = new ImageIcon(this.getClass().getResource("AmEx.jpg")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(new ImageIcon(img3).getImage().getScaledInstance(120, 48, Image.SCALE_DEFAULT)));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(255, 160, 109, 40);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel();
		Image img4 = new ImageIcon(this.getClass().getResource("Discover.jpg")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(new ImageIcon(img4).getImage().getScaledInstance(113, 48, Image.SCALE_DEFAULT)));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(255, 11, 109, 40);
		contentPane.add(lblNewLabel_4);
	}
}
