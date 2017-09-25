import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class PizzaBaseSelector extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PizzaBaseSelector frame = new PizzaBaseSelector(null);
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
	public PizzaBaseSelector( FinalOrder order) {
		
		Pie za = new Pie();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel SizeLabel = new JLabel("Select Size: ");
		SizeLabel.setBounds(10, 11, 89, 14);
		contentPane.add(SizeLabel);
		
		JLabel CrustLabel = new JLabel("Select Crust: ");
		CrustLabel.setBounds(10, 90, 89, 14);
		contentPane.add(CrustLabel);
		
		JLabel SauceLabel = new JLabel("Select Sauce: ");
		SauceLabel.setBounds(10, 140, 89, 14);
		contentPane.add(SauceLabel);
		
		ButtonGroup sauce = new ButtonGroup();
		ButtonGroup crust = new ButtonGroup();
		ButtonGroup size = new ButtonGroup();
		
		JRadioButton Six = new JRadioButton("6\"");
		Six.setActionCommand("6 inch");
		Six.setBounds(105, 7, 64, 23);
		contentPane.add(Six);
		
		JRadioButton Ten = new JRadioButton("10\"");
		Ten.setActionCommand("10 inch");
		Ten.setBounds(105, 33, 64, 23);
		contentPane.add(Ten);
		
		JRadioButton Four = new JRadioButton("14\"");
		Four.setActionCommand("14 inch");
		Four.setBounds(105, 59, 64, 23);
		contentPane.add(Four);
		
		JRadioButton Eight = new JRadioButton("18\"");
		Eight.setActionCommand("18 inch");
		Eight.setBounds(195, 7, 89, 23);
		contentPane.add(Eight);
		
		JRadioButton Two = new JRadioButton("22\"");
		Two.setActionCommand("22 inch");
		Two.setBounds(195, 33, 109, 23);
		contentPane.add(Two);
		
		size.add(Six); size.add(Ten); size.add(Ten); size.add(Four); size.add(Eight); size.add(Two);
		Six.setSelected(true);
		

		JRadioButton RegCrust = new JRadioButton("Regular");
		RegCrust.setActionCommand("Regular");
		RegCrust.setBounds(105, 86, 70, 23);
		contentPane.add(RegCrust);
		
		JRadioButton Thin = new JRadioButton("Thin");
		Thin.setActionCommand("Thin");
		Thin.setBounds(189, 86, 70, 23);
		contentPane.add(Thin);
		
		JRadioButton Stuffed = new JRadioButton("Stuffed");
		Stuffed.setActionCommand("Stuffed");
		Stuffed.setBounds(105, 112, 70, 23);
		contentPane.add(Stuffed);
		
		JRadioButton Deepdish = new JRadioButton("Deepdish");
		Deepdish.setActionCommand("Deepdish");
		Deepdish.setBounds(189, 112, 109, 23);
		contentPane.add(Deepdish);
		
		crust.add(RegCrust); crust.add(Thin); crust.add(Stuffed); crust.add(Deepdish);
		RegCrust.setSelected(true);
		
	
		JRadioButton RegSauce = new JRadioButton("Regular");
		RegSauce.setActionCommand("Regular");
		RegSauce.setBounds(105, 136, 70, 23);
		contentPane.add(RegSauce);
		
		JRadioButton Spicy = new JRadioButton("Spicy");
		Spicy.setActionCommand("Spicy");
		Spicy.setBounds(189, 136, 109, 23);
		contentPane.add(Spicy);
		
		JRadioButton Alfredo = new JRadioButton("Alfredo");
		Alfredo.setActionCommand("Alfredo");
		Alfredo.setBounds(105, 161, 70, 23);
		contentPane.add(Alfredo);
		
		JRadioButton BBQ = new JRadioButton("BBQ");
		BBQ.setActionCommand("BBQ");
		BBQ.setBounds(189, 162, 109, 23);
		contentPane.add(BBQ);
		
		sauce.add(RegSauce); sauce.add(Spicy); sauce.add(Alfredo); sauce.add(BBQ);
		RegSauce.setSelected(true);
		
		
		JButton Next = new JButton("Next");
		Next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				ButtonModel Size = size.getSelection();
				za.setSize(Size.getActionCommand());
				
				String  inches = Size.getActionCommand();
				String[] toppings = {" ", " ", " ", " ", " "};
				Double[] prices = {(double) 0,(double) 0,(double) 0,(double) 0,(double) 0}; 
				if(inches == "6 inch")
				{
					toppings[0] = "------"; toppings[1] = "Left Half--$0.49"; toppings[2] = "Right Half--$0.49";
					toppings[3] = "Whole--$0.99"; toppings[4] =  "Double--$1.49";
					
					prices[0] = 0.00; prices[1] = 0.49; prices[2] = 0.49; prices[3] = 0.99; prices[4] = 1.49;
					
					za.setPrice(4.99);
				}
				
				else if(inches == "10 inch")
				{
					toppings[0] = "------"; toppings[1] = "Left Half--$0.99"; toppings[2] = "Right Half--$0.99";
					toppings[3] = "Whole--$1.99"; toppings[4] =  "Double--$2.99";
					
					prices[0] = 0.00; prices[1] = 0.99; prices[2] = 0.99; prices[3] = 1.99; prices[4] = 2.99;
					
					za.setPrice(6.99);
				}
				
				else if(inches == "14 inch")
				{
					toppings[0] = "------"; toppings[1] = "Left Half--$1.49"; toppings[2] = "Right Half--$1.49";
					toppings[3] = "Whole--$2.49"; toppings[4] =  "Double--$3.49";
					
					prices[0] = 0.00; prices[1] = 1.49; prices[2] = 1.49; prices[3] = 2.49; prices[4] = 3.49;
					
					za.setPrice(9.99);
				}
				
				else if(inches == "18 inch")
				{
					toppings[0] = "------"; toppings[1] = "Left Half--$1.99"; toppings[2] = "Right Half--$1.99";
					toppings[3] = "Whole--$2.99"; toppings[4] =  "Double--$3.99";
					
					prices[0] = 0.00; prices[1] = 1.99; prices[2] = 1.99; prices[3] = 2.99; prices[4] = 3.99;
					
					za.setPrice(12.99);
				}
				
				else
				{
					toppings[0] = "------"; toppings[1] = "Left Half--$2.49"; toppings[2] = "Right Half--$2.49";
					toppings[3] = "Whole--$3.49"; toppings[4] =  "Double--$4.49";
					
					prices[0] = 0.00; prices[1] = 2.49; prices[2] = 2.49; prices[3] = 3.49; prices[4] = 4.49;
					
					za.setPrice(15.99);
				}
				
				ButtonModel Crust = crust.getSelection();
				za.setCrust(Crust.getActionCommand());
				
				ButtonModel Sauce = sauce.getSelection();
				za.setSauce(Sauce.getActionCommand());
				
				
				PizzaToppingSelector selector = new PizzaToppingSelector(za, toppings, prices, order);
				selector.setVisible(true);
				dispose();
				
			}
		});
		Next.setBounds(179, 192, 89, 23);
		contentPane.add(Next);
			
	}
	
}
