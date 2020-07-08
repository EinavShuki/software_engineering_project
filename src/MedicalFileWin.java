
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;

public class MedicalFileWin extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private static Patient patient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicalFileWin frame = new MedicalFileWin(patient);
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
	public MedicalFileWin(Patient patient) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 509);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(229, 242, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 48, 134, 33);
		contentPane.add(lblNewLabel);
		
		firstName = new JTextField();
		firstName.setColumns(10);
		firstName.setBounds(208, 45, 236, 39);
		contentPane.add(firstName);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 97, 134, 33);
		contentPane.add(lblNewLabel_1);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(208, 94, 236, 39);
		contentPane.add(lastName);
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 158, 115, 33);
		contentPane.add(lblNewLabel_2);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton male = new JRadioButton("Male");
		male.setBounds(208, 154, 106, 41);
		contentPane.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setBounds(321, 154, 143, 41);
		contentPane.add(female);
		group.add(male);
		group.add(female);
		
		JLabel lblNewLabel_3 = new JLabel("Year Of Birth");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 210, 161, 33);
		contentPane.add(lblNewLabel_3);
		
		//list of the passed 100 years
		Integer[] yearsArray = new Integer[100];
		  LocalDate date = LocalDate.now(); 
		  for(int i=0;i<100;i++) {
			  LocalDate generatedYear = date.minusDays(366*i); 
			  yearsArray[i]= generatedYear.getYear();
		  }
		  
		JComboBox year = new JComboBox(yearsArray);
		year.setBounds(208, 207, 134, 39);
		contentPane.add(year);
		
		JLabel lblNewLabel_4 = new JLabel("Month Of Birth");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 267, 207, 33);
		contentPane.add(lblNewLabel_4);
		
		Integer[] monthOpt =  new Integer[]{ 1, 2 , 3, 4, 5,6,7,8,9,10,11,12 };
		JComboBox month = new JComboBox(monthOpt);
		month.setBounds(207, 264, 68, 39);
		contentPane.add(month);
		
		JLabel lblNewLabel_5 = new JLabel("HMO");
		lblNewLabel_5.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(10, 331, 115, 33);
		contentPane.add(lblNewLabel_5);
		
		String[] HMOs = {"Clalit","Maccabi","Leumit","Meuhedet"};
		JComboBox hmo = new JComboBox(HMOs);
		hmo.setBounds(207, 328, 135, 39);
		contentPane.add(hmo);
		
		JTextArea allergies = new JTextArea();
		allergies.setBounds(549, 261, 279, 103);
		contentPane.add(allergies);
		
		JLabel lblNewLabel_7 = new JLabel("Allergies");
		lblNewLabel_7.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(549, 226, 115, 33);
		contentPane.add(lblNewLabel_7);
		
		JTextArea diseases = new JTextArea();
		diseases.setBounds(549, 108, 279, 103);
		contentPane.add(diseases);
		
		JLabel lblNewLabel_6 = new JLabel("Known Diseases");
		lblNewLabel_6.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(549, 72, 207, 33);
		contentPane.add(lblNewLabel_6);
		
		JButton nextBtn = new JButton("Next");
		nextBtn.setBounds(657, 403, 171, 41);
		contentPane.add(nextBtn);
		
		
		
        firstName.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });
        
        lastName.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });
        
        
        
		nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	   String formFirstName = firstName.getText();
            	   String formLastName = lastName.getText();
            	   char formSex = male.isSelected()? 'm':'f';
            	   int formYear = (Integer)year.getSelectedItem();
            	   int formMonth = (Integer)month.getSelectedItem();
            	   String formHMO = (String) hmo.getSelectedItem();
            	   String formDiseases = diseases.getText();
            	   String formAllergies = allergies.getText();
            	   MedicalFile mf= new MedicalFile(formSex, formYear,formMonth,formDiseases,formAllergies);
			       patient.addPatientDetails(formFirstName, formLastName, formHMO, mf);
			       PatientRepository patientRep = new PatientRepository();
			       patientRep.LoadFromFile();
			       patientRep.addPatientsToRepository(patient);
            }
        });
	}
}
