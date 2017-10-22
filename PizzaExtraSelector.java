import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class PizzaExtraSelector extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PizzaExtraSelector frame = new PizzaExtraSelector(null, null, null, null);
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
	public PizzaExtraSelector(Pie za, FinalOrder order, Double[] prices, String[] toppings) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 276, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Title = new JLabel("Please Select Extras");
		Title.setFont(new Font("Tahoma", Font.BOLD, 18));
		Title.setBounds(41, 11, 233, 22);
		contentPane.add(Title);
		
		JLabel OlivesLabel = new JLabel("Olives ");
		OlivesLabel.setBounds(10, 42, 99, 14);
		contentPane.add(OlivesLabel);
		
		JLabel OnionsLabel = new JLabel("Onions");
		OnionsLabel.setBounds(10, 67, 99, 14);
		contentPane.add(OnionsLabel);
		
		JLabel JalepenosLabel = new JLabel("Jalepenos");
		JalepenosLabel.setBounds(10, 92, 99, 14);
		contentPane.add(JalepenosLabel);
		
		JLabel TomatoesLabel = new JLabel("Tomatoes");
		TomatoesLabel.setBounds(10, 117, 99, 14);
		contentPane.add(TomatoesLabel);
		
		JLabel PineappleLabel = new JLabel("Pineapple");
		PineappleLabel.setBounds(10, 142, 99, 14);
		contentPane.add(PineappleLabel);
		
		JLabel GreenPepperLabel = new JLabel("Green Pepper");
		GreenPepperLabel.setBounds(10, 167, 99, 14);
		contentPane.add(GreenPepperLabel);
		
		JLabel BananaPeppersLabel = new JLabel("Banana Peppers");
		BananaPeppersLabel.setBounds(10, 192, 99, 14);
		contentPane.add(BananaPeppersLabel);
		
		String[] extras = {"------", "Right Side", "Left Side", "Whole"};
		JComboBox OlivesBox = new JComboBox(extras);
		OlivesBox.setBounds(119, 39, 126, 20);
		contentPane.add(OlivesBox);
		
		JComboBox OnionBox = new JComboBox(extras);
		OnionBox.setBounds(119, 64, 126, 20);
		contentPane.add(OnionBox);
		
		JComboBox JalepenosBox = new JComboBox(extras);
		JalepenosBox.setBounds(119, 89, 126, 20);
		contentPane.add(JalepenosBox);
		
		JComboBox TomatoesBox = new JComboBox(extras);
		TomatoesBox.setBounds(119, 114, 126, 20);
		contentPane.add(TomatoesBox);
		
		JComboBox PineappleBox = new JComboBox(extras);
		PineappleBox.setBounds(119, 139, 126, 20);
		contentPane.add(PineappleBox);
		
		JComboBox GreenBox = new JComboBox(extras);
		GreenBox.setBounds(119, 164, 126, 20);
		contentPane.add(GreenBox);
		
		JComboBox BananaBox = new JComboBox(extras);
		BananaBox.setBounds(119, 189, 126, 20);
		contentPane.add(BananaBox);
		
		JButton Next = new JButton("Next");
		Next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JComboBox[] boxes = {OlivesBox, OnionBox, JalepenosBox, TomatoesBox, PineappleBox, GreenBox, BananaBox};
				JLabel[] labels = {OlivesLabel, OnionsLabel, JalepenosLabel, TomatoesLabel, PineappleLabel, GreenPepperLabel, BananaPeppersLabel};
				boolean extrad = false;
				
				for(int i = 0; i < boxes.length; i++)
				{
					
					String option = (String) boxes[i].getSelectedItem();
							
					if(option != "------")
					{
						extrad = true;
						za.setExtras(labels[i].getText());
					}
				}
				
				if(!extrad)
					za.setExtras("None");
				//if no extras selected, sets it to None 
				
				FinalChecker checker = new FinalChecker(za, order);
				checker.setVisible(true);
				dispose();
			}
		});
		Next.setBounds(156, 220, 89, 23);
		contentPane.add(Next);
		
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PizzaToppingSelector back = new PizzaToppingSelector(za, toppings, prices, order);
				back.setVisible(true);
				dispose();
			}
		});
		Back.setBounds(10, 220, 89, 23);
		contentPane.add(Back);
		
	}

}
