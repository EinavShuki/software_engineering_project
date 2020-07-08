
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

public class ConsOrSurgWin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsOrSurgWin frame = new ConsOrSurgWin();
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
	public ConsOrSurgWin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 509);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(229, 242, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton consBtn = new JRadioButton("Consulation");
		consBtn.setFont(new Font("Arial Black", Font.PLAIN, 16));
		consBtn.setBounds(127, 95, 232, 29);
		contentPane.add(consBtn);
		
		JRadioButton surgBtn = new JRadioButton("Surgery");
		surgBtn.setFont(new Font("Arial Black", Font.PLAIN, 16));
		surgBtn.setBounds(390, 95, 254, 29);
		contentPane.add(surgBtn);
		group.add(consBtn);
		group.add(surgBtn);
		
		JLabel lblNewLabel = new JLabel("Please select requested procedure type:");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblNewLabel.setBounds(127, 32, 621, 35);
		contentPane.add(lblNewLabel);
		
		JComboBox procedureComboBox = new JComboBox();
		procedureComboBox.setEnabled(false);
		procedureComboBox.setBounds(127, 243, 232, 26);
		contentPane.add(procedureComboBox);
		
		JLabel lblPleaseSelectRequested = new JLabel("Please select requested procedure:");
		lblPleaseSelectRequested.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblPleaseSelectRequested.setBounds(127, 192, 529, 35);
		contentPane.add(lblPleaseSelectRequested);
		
		JLabel lblPleaseSelectA = new JLabel("Please select a doctor:");
		lblPleaseSelectA.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblPleaseSelectA.setBounds(127, 313, 529, 35);
		contentPane.add(lblPleaseSelectA);
		
		JComboBox doctorComboBox = new JComboBox();
		doctorComboBox.setEnabled(false);
		doctorComboBox.setBounds(127, 364, 232, 26);
		contentPane.add(doctorComboBox);
		
	
	}
}
