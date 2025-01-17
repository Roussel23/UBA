package Administration;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import ConnectionUBA.ConnectionUBA;
import Page.Login;

public class Administration_Clients {

	public JFrame frame;
	private JTable table;
	DefaultTableModel model;
	ResultSet rs;
	ConnectionUBA Con=new ConnectionUBA();
	private byte[] userimage;
	PreparedStatement pst;
	JComboBox Sex;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administration_Clients window = new Administration_Clients();
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
	String rq="SELECT * FROM clients";
	private JTextField ID;
	private JTextField Email;
	private JTextField Balance;
	private JTextField Name;
	private JTextField Surname;
	private JPasswordField Password;
	private JPasswordField PasswordAccount;
	private JTextField Job;
	private JTextField Age;
	JLabel Image;
	String RegisNum;
	private JTextField status;
	public Administration_Clients() {
		initialize();
		Table(rq);
	}
	public Administration_Clients(String id) {
		this.RegisNum=id;
		initialize();
		Table(rq);
	}
	public void update() {
		ID.setText(null);
		Email.setText(null);
		Password.setText(null);
		Name.setText(null);
		Surname.setText(null);
		Sex.setSelectedItem("Masculin");
		Age.setText(null);
		Job.setText(null);
		PasswordAccount.setText(null);
		Image.setIcon(null);
		Balance.setText(null);
		status.setText(null);
		
	}
	
	public byte[] SelectedImage() {
		
		
		try {
			JFileChooser pic=new JFileChooser();
			FileNameExtensionFilter filter=new FileNameExtensionFilter("jpg","jpg","png","png");
			pic.setFileFilter(filter);
			pic.addChoosableFileFilter(filter);
			pic.setFileFilter(filter);
			pic.showOpenDialog(null);
			File picture =pic.getSelectedFile();
			String path = picture.getAbsolutePath();
			BufferedImage img;
		
	
			img=ImageIO.read(pic.getSelectedFile());
			ImageIcon imageic=new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(Image.getWidth(), 313, Image.getHeight()));
			Image.setIcon(imageic);
			File image=new File(path);
			FileInputStream fis=new FileInputStream(image);
			ByteArrayOutputStream bos=new ByteArrayOutputStream();
			byte[] buff=new byte[1024];
			
			for(int i;(i=fis.read(buff))!=-1;) {
				bos.write(buff,0,i);
			}
			userimage=bos.toByteArray();
			
			
			
		}catch(Exception ex) {
			
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erreur!,les informations n'ont pas été envoyées",JOptionPane.ERROR_MESSAGE);
			
		}
		return userimage;
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void Table(String sql) {
		Object[] tableHeader= {"Identifiant","Adresse Email","Mot de passe","Nom","Prenom","Sexe","Age","Metier","Mot de passe compte","Image","Solde","Statut"};
		Object [] elements=new Object[12];
		
	
		model=new DefaultTableModel(new Object[][] {
			//tableHeader
		},
		new String[] {
				"Identifiant","Adresse Email","Mot de passe","Nom","Prenom","Sexe","Age","Metier","Mot de passe compte","Image","Solde","Statut"
			//"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
		});

		try {
			Statement stmt=Con.getConnection().createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				elements[0]=rs.getString("ID");
				elements[1]=rs.getString("Email");
				elements[2]=rs.getString("Password");
				elements[3]=rs.getString("Name");
				elements[4]=rs.getString("Surname");
				elements[5]=rs.getString("Sex");
				elements[6]=rs.getString("Age");
				elements[7]=rs.getString("Job");
				elements[8]=rs.getString("PasswordAccount");
				elements[9]=rs.getBytes("Image");
				elements[10]=rs.getString("Balance");
				elements[11]=rs.getString("Status");
				model.addRow(elements);
			}
			table.setModel(model);
			//Con.Deconnect();
						
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		}
	public void LoadImage(){
		try {
			byte imageData[]=rs.getBytes("Image");
			ImageIcon format = new ImageIcon(imageData);
			Image mm=format.getImage();
			Image img2=mm.getScaledInstance(Image.getWidth(), 300,0);
		
			ImageIcon image=new ImageIcon(img2);
			Image.setIcon(image);
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	public void SearchImage(String index) {
		try {
			Statement stmt=Con.getConnection().createStatement();
			rs=stmt.executeQuery("SELECT Image from clients where ID='"+index+"';");
		
			if(rs.next()) {
				LoadImage();
			}else {
				Image.setIcon(null);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 8, 1090, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int select=table.getSelectedRow();
				if(select >0) {
				model=(DefaultTableModel)(table.getModel());
				ID.setText(model.getValueAt(select,0).toString());
				Email.setText(model.getValueAt(select,1).toString());
				Password.setText(model.getValueAt(select,2).toString());
				Name.setText(model.getValueAt(select,3).toString());
				Surname.setText(model.getValueAt(select,4).toString());
				Sex.setSelectedItem(model.getValueAt(select,5).toString());
				Age.setText(model.getValueAt(select,6).toString());
				Job.setText(model.getValueAt(select,7).toString());
				PasswordAccount.setText(model.getValueAt(select,8).toString());
				SearchImage(model.getValueAt(select,0).toString());
				Balance.setText(model.getValueAt(select,10).toString());
				status.setText(model.getValueAt(select,11).toString());
				
				
				}else {
					update();
					
					
				}
			}
		});
		scrollPane.setBounds(10, 330, 1056, 200);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBackground(new Color(192, 192, 192));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int select=table.getSelectedRow();
				if(select >0) {
				model=(DefaultTableModel)(table.getModel());
				ID.setText(model.getValueAt(select,0).toString());
				Email.setText(model.getValueAt(select,1).toString());
				Password.setText(model.getValueAt(select,2).toString());
				Name.setText(model.getValueAt(select,3).toString());
				Surname.setText(model.getValueAt(select,4).toString());
				Sex.setSelectedItem(model.getValueAt(select,5).toString());
				Age.setText(model.getValueAt(select,6).toString());
				Job.setText(model.getValueAt(select,7).toString());
				PasswordAccount.setText(model.getValueAt(select,8).toString());
				SearchImage(model.getValueAt(select,0).toString());
				Balance.setText(model.getValueAt(select,10).toString());
				status.setText(model.getValueAt(select,11).toString());
				
				
				}else {
					update();
					
					
				}
			}
		});
		
		JButton btnNewButton = new JButton("Enregister");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rq2="insert into clients (ID,Email,Password,Name,Surname,Sex,Age,Job,PasswordAccount,Image,Balance,Status)values(?,?,?,?,?,?,?,?,?,?,?,?)";
				if(!ID.getText().isEmpty()) {
				try {
					PreparedStatement ps=Con.getConnection().prepareStatement(rq2);
					ps.setString(1,ID.getText());
					ps.setString(2,Email.getText() );
					ps.setString(3,Password.getPassword().toString());
					ps.setString(4,Name.getText().toString());
					ps.setString(5,Surname.getText().toString());
					ps.setString(6,Sex.getSelectedItem().toString());
					ps.setString(7,Age.getText().toString());
					ps.setString(8,Job.getText().toString());
					ps.setString(9,PasswordAccount.getPassword().toString());
					userimage=SelectedImage();
					ps.setBytes(10, userimage);
					ps.setString(11,Balance.getText().toString());
					ps.setString(12,status.getText().toString());
					
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Les informations ont été ajouté",null,JOptionPane.INFORMATION_MESSAGE);
					Table(rq);
					update();
					
					//Con.Deconnect();
				}catch(SQLException except) {
					JOptionPane.showMessageDialog(null,except.getMessage(),"Erreur!,les informations n'ont pas été envoyées",JOptionPane.ERROR_MESSAGE);
					
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"Erreur!, les informations n'ont pas été envoyées parce que le Numero de compte est vide");
				
			}
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(842, 103, 144, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql4="update clients set ID=?,Email=?,Password=?,Name=?,Surname=?,Sex=?,Age=?,Job=?,PasswordAccount=?,Image=?,Balance=? Status=? where ID='"+ID.getText()+"';";
				if(ID.getText()!=null) {
				try {
				
					pst=Con.getConnection().prepareStatement(sql4);
					
					pst.setString(1,ID.getText());
					pst.setString(2,Email.getText());
					pst.setString(3,Password.getPassword().toString());
					pst.setString(4,Name.getText());
					pst.setString(5,Surname.getText());
					pst.setString(6,Sex.getSelectedItem().toString());
					pst.setString(7,Age.getText());
					pst.setString(8,Job.getText());
					pst.setString(9,PasswordAccount.getPassword().toString());
					userimage=SelectedImage();
					pst.setBytes(10,userimage);
					pst.setString(11,Balance.getText());
					pst.setString(12,status.getText());
					
					pst.executeUpdate();
				//	Con.Deconnect();
					JOptionPane.showMessageDialog(null,"Le client a été modifié");
					Table(rq);
					update();
					
					
				}catch(Exception exc) {
		
					JOptionPane.showMessageDialog(null,"Les informations n'ont pas éte modifiés");
				}

				}else {
					JOptionPane.showMessageDialog(null,"Tous les champs doivent etre remplis");
				}
					
				}
			
			
		});
		btnModifier.setBackground(new Color(255, 128, 0));
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModifier.setBounds(842, 158, 144, 29);
		frame.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(ID.getText()!=null) {
				String rq5="delete from clients where ID='"+ID.getText()+"';";
				try {
					Statement st =Con.getConnection().createStatement();
					st.executeUpdate(rq5);
				
					
					JOptionPane.showMessageDialog(null, "Supprimer avec succès");
					Table(rq);
					update();
					//Con.Deconnect();
				}catch(SQLException sqle) {
					JOptionPane.showMessageDialog(null, "Error during deleting!!!"+sqle.getMessage());
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Erreur durant la suppression!!!");
			}
			}
		});
		btnSupprimer.setBackground(new Color(255, 0, 0));
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSupprimer.setBounds(842, 213, 144, 29);
		frame.getContentPane().add(btnSupprimer);
		
		JLabel lblNewLabel = new JLabel("PAGE DE GESTION DES CLIENTS");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(351, 10, 332, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 55, 254, 187);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Image = new JLabel("Image");
		Image.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userimage=SelectedImage();
			}
		});
		panel.setBounds(21, 55, 254, 187); 
		Image.setBounds(0, 0, 254, 187);
		Image.setBackground(new java.awt.Color(255,0,0));
		Image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		Image.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		panel.add(Image);
		
		JLabel lblNewLabel_2 = new JLabel("Numero Compte");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(285, 77, 113, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email :");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(308, 107, 90, 20);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Mot de passe  :");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(308, 137, 114, 20);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Nom :");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(308, 167, 90, 20);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Prenom:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4.setBounds(308, 199, 90, 20);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Sexe  :");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_5.setBounds(308, 229, 90, 20);
		frame.getContentPane().add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_5_1 = new JLabel("Age :");
		lblNewLabel_2_5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_5_1.setBounds(21, 264, 45, 20);
		frame.getContentPane().add(lblNewLabel_2_5_1);
		
		JLabel lblNewLabel_2_5_2 = new JLabel("Metier :");
		lblNewLabel_2_5_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_5_2.setBounds(21, 294, 59, 20);
		frame.getContentPane().add(lblNewLabel_2_5_2);
		
		JLabel lblNewLabel_2_5_3 = new JLabel("Mot de passe du compte:");
		lblNewLabel_2_5_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_5_3.setBounds(476, 264, 183, 20);
		frame.getContentPane().add(lblNewLabel_2_5_3);
		
		JLabel lblNewLabel_2_5_4 = new JLabel("Solde :");
		lblNewLabel_2_5_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_5_4.setBounds(497, 300, 54, 20);
		frame.getContentPane().add(lblNewLabel_2_5_4);
		
		ID = new JTextField();
		ID.setBounds(413, 77, 396, 22);
		frame.getContentPane().add(ID);
		ID.setColumns(10);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(413, 109, 396, 22);
		frame.getContentPane().add(Email);
		
		Balance = new JTextField();
		Balance.setColumns(10);
		Balance.setBounds(546, 300, 263, 22);
		frame.getContentPane().add(Balance);
		
		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(413, 170, 396, 22);
		frame.getContentPane().add(Name);
		
		Surname = new JTextField();
		Surname.setColumns(10);
		Surname.setBounds(413, 200, 396, 22);
		frame.getContentPane().add(Surname);
		
		Password = new JPasswordField();
		Password.setBounds(415, 140, 394, 22);
		frame.getContentPane().add(Password);
		
		PasswordAccount = new JPasswordField();
		PasswordAccount.setBounds(648, 266, 394, 22);
		frame.getContentPane().add(PasswordAccount);
		
		Job = new JTextField();
		Job.setColumns(10);
		Job.setBounds(74, 298, 396, 22);
		frame.getContentPane().add(Job);
		
		Age = new JTextField();
		Age.setColumns(10);
		Age.setBounds(61, 266, 396, 22);
		frame.getContentPane().add(Age);
		
		JButton btnPagePrecedente = new JButton("DECONNECTER");
		btnPagePrecedente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Do you really want to leave ?");
				if(result==0){
				new Login().frame.setVisible(true);
				frame.dispose();
				}
			}
		});
		btnPagePrecedente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPagePrecedente.setBackground(new Color(0, 255, 255));
		btnPagePrecedente.setBounds(842, 55, 158, 29);
		frame.getContentPane().add(btnPagePrecedente);
		
		 Sex = new JComboBox();
		Sex.setModel(new DefaultComboBoxModel(new String[] {"Masculin ", "Feminin"}));
		Sex.setBounds(412, 231, 397, 22);
		frame.getContentPane().add(Sex);
		
		JLabel lblNewLabel_2_5_4_1 = new JLabel("Statut:");
		lblNewLabel_2_5_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_5_4_1.setBounds(819, 300, 54, 20);
		frame.getContentPane().add(lblNewLabel_2_5_4_1);
		
		status = new JTextField();
		status.setColumns(10);
		status.setBounds(873, 300, 169, 22);
		frame.getContentPane().add(status);
	}
}
