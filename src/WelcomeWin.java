
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class WelcomeWin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeWin window = new WelcomeWin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(229, 242, 255));
		frame.setBounds(100, 100, 1000, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("Welcome");
		btnNewButton.setBackground(new Color(240,240,240));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 41));
		btnNewButton.setBounds(350, 164, 285, 109);
		
		frame.getContentPane().add(btnNewButton);
		
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUI1 NEWbox=new GUI1();//opening home page
				NEWbox.setVisible(true);
				
//				second secondbox=new second();
//				secondbox.setVisible(true);
				
				//פתיחת חלון חדש אחרי לחיצה על כפתור במקרה זה יפתח פריים נוסף לפריים הנוכחי
//				class2 nw=new class2();
//				nw.newScreen();
			}
		
	
		});
		
		
		
	}
}
