
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

public class GUI1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI1 frame = new GUI1();
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
	public GUI1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 509);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(229, 242, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		//buttons' definition
		
		JButton newAppointmentBtn = new JButton("");//new appointment button
		newAppointmentBtn.setBounds(47, 30, 247, 140);
		
		//placing image on the button
        Image img=new ImageIcon(this.getClass().getResource("/add.png")).getImage();
        newAppointmentBtn.setIcon(new ImageIcon(img));
        
		newAppointmentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SearchPatientIDWin window=new SearchPatientIDWin();//open home page
				window.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(newAppointmentBtn);
		
	
		
		JButton modifyBtn = new JButton("");//modify button
		modifyBtn.setBounds(662, 30, 254, 140);
		
		//placing image on the button
        Image img1=new ImageIcon(this.getClass().getResource("/calendar.png")).getImage();
        modifyBtn.setIcon(new ImageIcon(img1));
		
		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		contentPane.add(modifyBtn);
		
		JButton changeBtn = new JButton("");//change button
		changeBtn.setBounds(47, 250, 247, 140);
		
		//placing image on the button
        Image img2=new ImageIcon(this.getClass().getResource("/change.png")).getImage();
        changeBtn.setIcon(new ImageIcon(img2));
        
		changeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		contentPane.add(changeBtn);
		
		JButton deleteBtn = new JButton("");//delete button
		deleteBtn.setBounds(662, 250, 254, 140);
		
		//placing image on the button
        Image img3=new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
        deleteBtn.setIcon(new ImageIcon(img3));
        
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		contentPane.add(deleteBtn);
		
		JButton searchBtn = new JButton("");//search button
		searchBtn.setBounds(336, 141, 285, 140);
		
		//placing image on the button
        Image img4=new ImageIcon(this.getClass().getResource("/search.png")).getImage();
        searchBtn.setIcon(new ImageIcon(img4));
        
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		contentPane.add(searchBtn);
		
		JLabel lblNewLabel = new JLabel("New Appointment");//north-left label
		lblNewLabel.setBounds(47, 186, 247, 35);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 24));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search Appointment");//center label
		lblNewLabel_1.setBounds(336, 297, 285, 35);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 24));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Change Appointment");//south-left label
		lblNewLabel_2.setBounds(47, 388, 285, 35);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 24));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Delete Appointment");//south-right label
		lblNewLabel_3.setBounds(662, 388, 301, 35);
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 24));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Modifiy Reception ");//north-right label
		lblNewLabel_4.setBounds(662, 172, 359, 53);
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 24));
		contentPane.add(lblNewLabel_4);
	}

}


