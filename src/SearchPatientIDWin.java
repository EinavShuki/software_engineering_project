
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class SearchPatientIDWin extends JFrame {

	private JPanel contentPane;
	private JTextField idText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					SearchPatientIDWin frame = new SearchPatientIDWin();
					frame.setTitle("Search Patient ID");
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
	public SearchPatientIDWin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(229, 242, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter Patinet ID");
		lblNewLabel.setBounds(349, 127, 302, 33);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 24));
		contentPane.add(lblNewLabel);

		idText = new JTextField();
		idText.setBounds(385, 176, 236, 39);
		contentPane.add(idText);
		idText.setColumns(10);

		JLabel invalidText = new JLabel("");
		invalidText.setBounds(395, 243, 203, 33);
		invalidText.setHorizontalAlignment(SwingConstants.LEFT);
		invalidText.setForeground(Color.RED);
		invalidText.setFont(new Font("Arial", Font.PLAIN, 16));
		contentPane.add(invalidText);

		JButton searchBtn = new JButton("Search");
		searchBtn.setBounds(427, 311, 171, 41);

		searchBtn.setFont(new Font("Arial", Font.PLAIN, 24));
		contentPane.add(searchBtn);
		
		idText.addKeyListener(new KeyAdapter() 
		{

			@Override
			public void keyTyped(KeyEvent e)
			{
				if (idText.getText().length() > 8) {
					e.consume();
				}
				//force the user typing numbers only
				try {
					int i = Integer.parseInt(idText.getText() + e.getKeyChar());
					invalidText.setText("");
				} catch (NumberFormatException e1) 
				{	
					e.consume();
					invalidText.setText("Numbers Only!");
				}
			}


		});
		
		
		searchBtn.addActionListener(new ActionListener() //search button pressed
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(!idText.getText().equals("")&&idText.getText().length()>8) 
				{
					int patientID = Integer.parseInt(idText.getText()); 
					
			        PatientRepository patientRep = new PatientRepository();
					patientRep.LoadFromFile();
			        Patient searchedPatient = patientRep.searchPatientByID(patientID);

			        //TODO what is happen if the patient exists
			        
			        if(searchedPatient!=null){//patient exists
			        	System.out.println(searchedPatient);
			        }
			        else {//create new patient
			        	Patient newPatient = new Patient(patientID);
			        	MedicalFileWin window = new MedicalFileWin(newPatient);
		        		window.setVisible(true);
			        }
			        
				}
			}
		});
		
		
	}
}
