import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;

public class BeverageMenu extends JFrame{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeverageMenu window = new BeverageMenu((Double) null, null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BeverageMenu(double totalPrice, FinalOrder order) {
		setBounds(100, 100, 698, 389);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Beverage beverage = new Beverage();
		
		JButton btnCoke = new JButton();
		btnCoke.setForeground(Color.WHITE);
		btnCoke.setHorizontalAlignment(SwingConstants.TRAILING);
		btnCoke.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\justin\\eclipse-workspace\\DatabaseConnection\\src\\3mu54jrdyl_corporate_logo_coca_cola (1).jpg").getImage().getScaledInstance(160, 40, Image.SCALE_DEFAULT)));
		btnCoke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beverage.addPrice(2.50);
				beverage.setBeverage("Coke");
			}
		});
		btnCoke.setBackground(Color.WHITE);
		
		JButton btnPepsi = new JButton("Pepsi");
		btnPepsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beverage.addPrice(2.50);
				beverage.setBeverage("Pepsi");
			}
		});
		
		JButton btnSprite = new JButton("Sprite");
		btnSprite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beverage.addPrice(2.50);
				beverage.setBeverage("Sprite");
			}
		});
		
		JButton btnMountainDew = new JButton("Mountain Dew");
		btnMountainDew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beverage.addPrice(2.50);
				beverage.setBeverage("Mountain Dew");
			}
		});
		
		JButton btnOrangeFanta = new JButton("Orange Fanta");
		btnOrangeFanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beverage.addPrice(2.50);
				beverage.setBeverage("Orange Fanta");
			}
		});
		
		JButton btnDrpepper = new JButton("Dr.Pepper");
		btnDrpepper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beverage.addPrice(2.50);
				beverage.setBeverage("Dr.Pepper");
			}
		});
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beverageReceipt receipt = new beverageReceipt(beverage, totalPrice, order);
				receipt.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCoke, 12, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCoke, 0, SpringLayout.WEST, btnPepsi);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnCoke, -6, SpringLayout.NORTH, btnMountainDew);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 250, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 356, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 279, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 446, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnDrpepper, 210, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnDrpepper, 6, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnDrpepper, 239, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnDrpepper, 444, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnOrangeFanta, 170, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnOrangeFanta, 6, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnOrangeFanta, 199, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnOrangeFanta, 444, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnMountainDew, 47, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnMountainDew, 6, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnMountainDew, 76, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnMountainDew, 444, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSprite, 129, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSprite, 6, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSprite, 158, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSprite, 444, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnPepsi, 88, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnPepsi, 6, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnPepsi, 117, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnPepsi, 444, SpringLayout.WEST, contentPane);
		contentPane.setLayout(sl_contentPane);
		contentPane.add(btnCoke);
		contentPane.add(btnPepsi);
		contentPane.add(btnSprite);
		contentPane.add(btnMountainDew);
		contentPane.add(btnOrangeFanta);
		contentPane.add(btnDrpepper);
		contentPane.add(btnNewButton);
	}
}
