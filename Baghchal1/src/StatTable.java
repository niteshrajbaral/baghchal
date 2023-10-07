import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatTable extends JFrame {

	private JPanel contentPane;
	String username1;
	private JTable table;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatTable frame = new StatTable("Nitesh");
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
	public StatTable(String username1) {
		this.username1=username1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel();
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		btnExit.setBounds(784, 529, 174, 44);
		contentPane.add(btnExit);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 48, 859, 435);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlconnection","root","root");
			if (con!=null) {
				System.out.println("database is connected");
			}
			Statement stmt= con.createStatement();  
			
			String sql2="select g.gameID,g.dateTime,l.username from gamedetails g join logindetails l on g.playerID=l.playerID and l.username='"+username1+"'";
			ResultSet rs= stmt.executeQuery(sql2);
			java.sql.ResultSetMetaData rsmd=rs.getMetaData();
			model=(DefaultTableModel) table.getModel();
			
			int cols = rsmd.getColumnCount();
			String[] colName= new String[cols];
            for (int i=0; i<cols; i++) {
                colName[i]=rsmd.getColumnName(i+1);
            }
            model.setColumnIdentifiers(colName);
            String gameID,dateTime,username;
            while (rs.next()) {
                gameID = rs.getString(1);
                dateTime=rs.getString(2);
                username=rs.getString(3);
                String[] rowData= {gameID,dateTime,username};
                model.addRow(rowData);
             }
             stmt.close();
             con.close();
//			DefaultTableModel model=(DefaultTableModel)table.getModel();
		}catch(Exception e1){
			System.out.println(e1);
		}
	}
}
