import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class PizzaToppingSelector extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PizzaToppingSelector frame = new PizzaToppingSelector(null, null, null, null);
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
	public PizzaToppingSelector(Pie za, String[] toppings, Double[] prices, FinalOrder order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Title = new JLabel("Please Select Toppings");
		Title.setFont(new Font("Tahoma", Font.BOLD, 18));
		Title.setBounds(29, 11, 214, 33);
		contentPane.add(Title);
		
		JLabel PepperoniLabel = new JLabel("Pepperoni");
		PepperoniLabel.setBounds(10, 55, 92, 14);
		contentPane.add(PepperoniLabel);
		
		JLabel ChickenLabel = new JLabel("Chicken Strips");
		ChickenLabel.setBounds(10, 80, 92, 14);
		contentPane.add(ChickenLabel);
		
		JLabel BaconLabel = new JLabel("Bacon");
		BaconLabel.setBounds(10, 105, 92, 14);
		contentPane.add(BaconLabel);
		
		JLabel HamLabel = new JLabel("Canadian Ham");
		HamLabel.setBounds(10, 130, 92, 14);
		contentPane.add(HamLabel);
		
		JLabel SalamiLabel = new JLabel("Salami");
		SalamiLabel.setBounds(10, 155, 92, 14);
		contentPane.add(SalamiLabel);
		
		JComboBox PepperoniBox = new JComboBox(toppings);
		PepperoniBox.setBounds(112, 52, 155, 20);
		contentPane.add(PepperoniBox);
		
		JComboBox ChickenStrips = new JComboBox(toppings);
		ChickenStrips.setBounds(112, 77, 155, 20);
		contentPane.add(ChickenStrips);
		
		JComboBox BaconBox = new JComboBox(toppings);
		BaconBox.setBounds(112, 102, 155, 20);
		contentPane.add(BaconBox);
		
		JComboBox HamBox = new JComboBox(toppings);
		HamBox.setBounds(112, 127, 155, 20);
		contentPane.add(HamBox);
		
		JComboBox SalamiBox = new JComboBox(toppings);
		SalamiBox.setBounds(112, 152, 155, 20);
		contentPane.add(SalamiBox);
		
		JButton Next = new JButton("Next");
		Next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JComboBox[] boxes = {PepperoniBox, ChickenStrips, BaconBox, HamBox, SalamiBox};
				JLabel[] labels = {PepperoniLabel, ChickenLabel, BaconLabel, HamLabel, SalamiLabel};
				boolean topped = false;
				
				for(int i = 0; i < boxes.length; i++)
				{
					String option = (String) boxes[i].getSelectedItem();
					
					if(option != "------")
					{
						topped = true;
						za.setToppings(labels[i].getText());
						za.setPrice(prices[i]);
					}
				}
				
				//if not topped, sets toppings to None 
				if(!topped)
					za.setToppings("None");
				
				PizzaExtraSelector selector = new PizzaExtraSelector(za, order, prices, toppings);
				selector.setVisible(true);
				dispose();
			}
		});
		Next.setBounds(178, 183, 89, 23);
		contentPane.add(Next);
		
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PizzaBaseSelector back = new PizzaBaseSelector(order);
				back.setVisible(true);
				dispose();
			}
		});
		Back.setBounds(10, 183, 89, 23);
		contentPane.add(Back);
	}

}
