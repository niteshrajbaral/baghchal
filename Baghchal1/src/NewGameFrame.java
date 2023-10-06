import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.prefs.Preferences;


public class NewGameFrame extends JFrame {

	private JPanel contentPane;
	java.util.Date date;
	java.sql.Date sqldate;
	public String username1;

//	/**
//	 * Launch the application.
//	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewGameFrame frame = new NewGameFrame("Nitesh");
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
	
	public NewGameFrame(String username1) {
		this.username1=username1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnNewButton_2_1 = new JButton("Play with Bot");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BotFrameStartup start= new BotFrameStartup();
				start.main(null);
				// Get the current date and time
		        LocalDateTime currentDateTime = LocalDateTime.now();

		        // Define a custom date and time format
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		        // Format the current date and time as a string
		        String formattedDateTime = currentDateTime.format(formatter);

		        // Print the formatted date and time
		        System.out.println("Current Date and Time: " + formattedDateTime);
				Connection con=null;
				
				try {
					con= (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlconnection","root","root");
					if (con!=null) {
						System.out.println("database is connected");
					}
					Statement stmt= con.createStatement();  
					
					String sql1="select playerID from loginDetails where username='"+username+"'";
					ResultSet rs= stmt.executeQuery(sql1);

					
				    while (rs.next()) {
				    	 
		                playerID = rs.getInt("playerID");
				    }
					String sql2="Insert into gamedetails(dateTime,playerID) values('"+formattedDateTime+"','"+playerID+"')";
					stmt.executeUpdate(sql2);
					con.close();
				}catch(Exception e1){
					System.out.println(e1);
				}
					
				dispose();
			}
		});
		btnNewButton_2_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Consolas", Font.PLAIN, 25));
		btnNewButton_2_1.setBorderPainted(false);
		btnNewButton_2_1.setIcon(new ImageIcon("src\\bot.png"));
		btnNewButton_2_1.setBackground(new Color(0, 102, 204));
		btnNewButton_2_1.setBounds(657, 470, 324, 91);
		contentPane.add(btnNewButton_2_1);
		
		
		JButton btnNewButton = new JButton("Play Locally");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MultiPlayStartup gameFrame= new MultiPlayStartup();
				gameFrame.main(null);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(0, 102, 204));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setIconTextGap(1);
		btnNewButton.setIcon(new ImageIcon("src\\play_with_friend.png"));
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 25));
		btnNewButton.setBounds(657, 330, 324, 91);
		contentPane.add(btnNewButton);
			
		
		JLabel lblNewLabel_1 = new JLabel("Let The Game Begin");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Chiller", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(419, 33, 469, 73);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src\\goat-on-mountain.png"));
		lblNewLabel.setBounds(243, 0, 768, 713);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("src\\back-arrow.png"));
		lblNewLabel_2.setBounds(53, 62, 45, 39);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Create and show the new JFrame when the label is clicked
                WelcomeFrame newFrame = new WelcomeFrame();
                newFrame.setVisible(true);
                dispose();
            }
        });
		contentPane.add(lblNewLabel_2);
	}
}
