
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
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class BeverageMenu extends JFrame{

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeverageMenu window = new BeverageMenu(null);
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
	public BeverageMenu(FinalOrder order) {
		setBounds(100, 100, 430, 454);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Beverage beverage = new Beverage();
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(214, 17, 194, 342);
		contentPane.add(textPane);
		textPane.setEditable(false);
		
		
		JButton btnCoke = new JButton("Coke");
		btnCoke.setBounds(10, 17, 194, 48);
		btnCoke.setForeground(Color.WHITE);
		btnCoke.setHorizontalAlignment(SwingConstants.TRAILING);
		Image img = new ImageIcon(this.getClass().getResource("3mu54jrdyl_corporate_logo_coca_cola.jpg")).getImage();
		btnCoke.setIcon(new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(160, 40, Image.SCALE_DEFAULT)));
		btnCoke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beverage.addPrice(2.59);
				beverage.setBeverage("Coke");
				textPane.setText(textPane.getText() + "\n" + "Coke......2.59");
			}
		});
		btnCoke.setBackground(Color.WHITE);
		
		JButton btnPepsi = new JButton("Pepsi");
		btnPepsi.setBounds(11, 134, 193, 48);
		btnPepsi.setBackground(Color.WHITE);
		btnPepsi.setForeground(Color.WHITE);
		Image img1 = new ImageIcon(this.getClass().getResource("Pepsi.jpg")).getImage();
		btnPepsi.setIcon(new ImageIcon(new ImageIcon(img1).getImage().getScaledInstance(275, 125, Image.SCALE_DEFAULT)));
		btnPepsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beverage.addPrice(2.59);
				beverage.setBeverage("Pepsi");
				textPane.setText(textPane.getText() + "\n" + "Pepsi......2.59");
			}
		});
		
		JButton btnSprite = new JButton("Sprite");
		btnSprite.setBounds(11, 193, 193, 48);
		btnSprite.setBackground(Color.WHITE);
		Image img2 = new ImageIcon(this.getClass().getResource("Sprite.png")).getImage();
		btnSprite.setIcon(new ImageIcon(new ImageIcon(img2).getImage().getScaledInstance(200, 75, Image.SCALE_DEFAULT)));
		btnSprite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beverage.addPrice(2.59);
				beverage.setBeverage("Sprite");
				textPane.setText(textPane.getText() + "\n" + "Sprite.........2.59");
			}
		});
		
		JButton btnMountainDew = new JButton();
		btnMountainDew.setBackground(Color.WHITE);
		Image img3 = new ImageIcon(this.getClass().getResource("MountainDew.jpg")).getImage();
		btnMountainDew.setIcon(new ImageIcon(new ImageIcon(img3).getImage().getScaledInstance(160, 80, Image.SCALE_DEFAULT)));
		btnMountainDew.setBounds(10, 75, 193, 48);
		btnMountainDew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beverage.addPrice(2.59);
				beverage.setBeverage("Mountain Dew");
				textPane.setText(textPane.getText() + "\n" + "Mountain Dew....2.59");
			}
		});
		
		JButton btnOrangeFanta = new JButton();
		Image img4 = new ImageIcon(this.getClass().getResource("fanta.jpg")).getImage();
		btnOrangeFanta.setIcon(new ImageIcon(new ImageIcon(img4).getImage().getScaledInstance(200, 75, Image.SCALE_DEFAULT)));
		btnOrangeFanta.setBounds(10, 252, 193, 48);
		btnOrangeFanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beverage.addPrice(2.59);
				beverage.setBeverage("Orange Fanta");
				textPane.setText(textPane.getText() + "\n" + "Orange Fanta...2.59");
			}
		});
		
		JButton btnDrpepper = new JButton();
		btnDrpepper.setBackground(Color.WHITE);
		Image img5 = new ImageIcon(this.getClass().getResource("DrPepper.jpg")).getImage();
		btnDrpepper.setIcon(new ImageIcon(new ImageIcon(img5).getImage().getScaledInstance(100, 48, Image.SCALE_DEFAULT)));
		btnDrpepper.setBounds(10, 311, 193, 48);
		btnDrpepper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beverage.addPrice(2.59);
				beverage.setBeverage("Dr.Pepper");
				textPane.setText(textPane.getText() + "\n" + "Dr.Pepper....2.59");
			}
		});
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setBounds(318, 370, 90, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beverageReceipt receipt = new beverageReceipt(beverage, order);
				receipt.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.add(btnCoke);
		contentPane.add(btnPepsi);
		contentPane.add(btnSprite);
		contentPane.add(btnMountainDew);
		contentPane.add(btnOrangeFanta);
		contentPane.add(btnDrpepper);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pie za = new Pie();
				FinalChecker check = new FinalChecker(za, order);
				check.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 370, 89, 30);
		contentPane.add(btnBack);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				beverage.clearBev();
				textPane.setText("");
			}
		});
		btnNewButton_1.setBounds(161, 370, 90, 29);
		contentPane.add(btnNewButton_1);
		

			
	}
}
