import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class second extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					second frame = new second();
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
	public second() {
		setTitle("PASSWARDpage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 509);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(229, 242, 255));
		contentPane.setToolTipText("");
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");//label
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 41));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(310, 68, 268, 95);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Passward");//label
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 41));
		lblNewLabel_1.setBounds(310, 252, 250, 52);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();//User Name's field 
		textField.setBounds(310, 161, 250, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();//Passward's field 
		
		
		passwordField.setBounds(310, 320, 250, 26);
		contentPane.add(passwordField);
		
		btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) //handling login button
			{
				String username=textField.getText();//input text to the textField
				String password=passwordField.getText();//input text to the passwordField
				
				
				if((username.contains("316223106") &&password.contains("EINAV123"))||
						(username.contains("313176794") &&password.contains("ASAF123")))//this is how we enter a user and his password 
																					//to the system
				{
					textField.setText(null);
					passwordField.setText(null); 
					
					GUI1 NEWbox=new GUI1();//opening home page
					NEWbox.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"One or more inputs are invalid\n","Error",JOptionPane.ERROR_MESSAGE);//if the input was wrong
					textField.setText(null);
					passwordField.setText(null);
				
				}
			}
			
		});
		
		passwordField.addKeyListener(new KeyAdapter() //if instead of Login we will press ENTER
		{
			@Override
			public void keyPressed(KeyEvent arg0) 
			{
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
				{
						String username=textField.getText();//input text to the textField
						String password=passwordField.getText();//input text to the passwordField
						
						
						if(username.contains("316223106") &&password.contains("EINAV123"))//this is how we enter a user and his password 
																						//to the system
						{
							textField.setText(null);
							passwordField.setText(null);
							
							GUI1 NEWbox=new GUI1();//opening home page
							NEWbox.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"One or more inputs are invalid\n","Error",JOptionPane.ERROR_MESSAGE);//if the input was wrong
							textField.setText(null);
							passwordField.setText(null);
						
						}
				}
			}
		}
		);
		
		
		btnNewButton.setBounds(779, 353, 115, 29);
		contentPane.add(btnNewButton);
	}
}
