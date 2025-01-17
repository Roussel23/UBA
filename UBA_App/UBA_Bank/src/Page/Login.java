package Page;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Administration.Administration_Accounts_Services;
import Administration.Administration_Clients;
import ConnectionUBA.ConnectionUBA;
import javax.swing.ImageIcon;

public class Login {

	public JFrame frame;
	private JTextField ID;
	private JTextField Email;
	private JPasswordField Password;
	ResultSet rs;
	java.sql.Statement st;
	JComboBox trade ;
	ConnectionUBA Con =new ConnectionUBA();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}
	public void update() {
		ID.setText(null);
		Password.setText(null);
		Email.setText("");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(190, 60, 707,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		panel.setBounds(0, 0, 693, 453);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Identifiant :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(42, 131, 90, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email  :");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(56, 173, 61, 20);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Mot de passe:");
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(42, 219, 104, 20);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Creer un compte?");
		lblNewLabel_2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				new Create_Account().frame.setVisible(true);
				frame.dispose();
				
			}
		});
		lblNewLabel_2_3.setForeground(new Color(128, 255, 0));
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(493, 317, 129, 20);
		panel.add(lblNewLabel_2_3);
		
		JButton btnEnregistrer = new JButton("ENREGISTRER");
		btnEnregistrer.setForeground(new Color(255, 255, 255));
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					
					
					String sql1="select ID from clients where ID='"+ID.getText()+"'"+" and Email='"+Email.getText()+"'"+" and Password='"+Password.getText()+"';";
				if(ID.getText().isEmpty()||Password.getPassword()==null||Email.getText().isEmpty()) {
					JOptionPane.showMessageDialog( null, "Veuillez remplir tous les champs");
					
					
				}else {
					if(  trade.getSelectedItem().equals("Administrateur Comptes")&&!ID.getText().isEmpty()&&Password.getPassword()!=null && !Email.getText().isEmpty()){

						st=Con.getConnection().createStatement();
						rs=st.executeQuery(sql1);
						if(rs.next()) {
						new Administration_Accounts_Services(ID.getText()).frame.setVisible(true);
						frame.dispose();
						Con.Deconnect();
						}else {
							JOptionPane.showMessageDialog( null, "Oops!!! Votre identifiant , Email ou mot de passe n'est pas correct");
							update();
						
						}
					
					}else {
						if(  trade.getSelectedItem().equals("Administrateur Clients")&&!ID.getText().isEmpty()&&Password.getPassword()!=null && !Email.getText().isEmpty()){

							st=Con.getConnection().createStatement();
							rs=st.executeQuery(sql1);
							
							if(rs.next()) {
							new Administration_Clients(ID.getText()).frame.setVisible(true);
							frame.dispose();
							Con.Deconnect();
							}else {
								JOptionPane.showMessageDialog(null, "Oops!!! Votre identifiant , Email ou mot de passe n'est pas correct");
								update();
							
							}
						
						}else {
						
						st=Con.getConnection().createStatement();
						rs=st.executeQuery(sql1);
						if(rs.next()) {
						new UBA_Services(ID.getText(),Password.getText()).frame.setVisible(true);
						frame.dispose();
						Con.Deconnect();
						}else {
							JOptionPane.showMessageDialog( null, "Oops!!! Votre identifiant,Email ou mot de passe n'est pas correct");
							update();
						
						}
					}
					}
				}
			
			}catch(Exception ex) {
				JOptionPane.showMessageDialog( null, "Oops!!! Vos avez pas accès !!!");
			}
			}
		});
		btnEnregistrer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEnregistrer.setBackground(new Color(0, 0, 255));
		btnEnregistrer.setBounds(344, 414, 328, 29);
		panel.add(btnEnregistrer);
		
		JLabel lblPageDeConnection = new JLabel("PAGE DE CONNECTION");
		lblPageDeConnection.setForeground(new Color(255, 255, 255));
		lblPageDeConnection.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPageDeConnection.setBounds(220, 24, 234, 29);
		panel.add(lblPageDeConnection);
		
		ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(127, 131, 495, 22);
		panel.add(ID);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(127, 175, 495, 22);
		panel.add(Email);
		
		JButton btnFermer = new JButton("FERMER");
		btnFermer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnFermer.setForeground(new Color(255, 255, 255));
		btnFermer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFermer.setBackground(new Color(255, 0, 0));
		btnFermer.setBounds(10, 414, 307, 29);
		panel.add(btnFermer);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(260, 63, 134, 42);
		ImageIcon icon2=new ImageIcon("C:\\Users\\PC\\Desktop\\UBA_Bank\\New folder\\UBA-logo-2.gif");
		Image img2=icon2.getImage();
		Image ImgScale2=img2.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ScaledIcon2 =new ImageIcon(ImgScale2);
		lblNewLabel.setIcon(ScaledIcon2);
		panel.add(lblNewLabel);
		
		Password = new JPasswordField();
		Password.setBounds(138, 219, 484, 22);
		panel.add(Password);
		
		JLabel lblNewLabel_2_2_1 = new JLabel(" Metier  :");
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_1.setBounds(53, 263, 79, 20);
		panel.add(lblNewLabel_2_2_1);
		
		trade= new JComboBox();
		trade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		trade.setModel(new DefaultComboBoxModel(new String[] {"Prefet", "Maire", "Fonctionnaire", "Administrateur Comptes", "Administrateur Clients", "Commercant", "Eleve"}));
		trade.setBounds(142, 263, 480, 22);
		panel.add(trade);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(632, 128, 45, 27);
		ImageIcon icon3=new ImageIcon("C:\\Users\\PC\\Desktop\\UBA_Bank\\DCIM\\7296447-icone-utilisateur-dans-le-style-plat-icone-personne-symbole-client-vectoriel.jpg");
		Image img3=icon3.getImage();
		Image ImgScale3=img3.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ScaledIcon3 =new ImageIcon(ImgScale3);
		lblNewLabel_1.setIcon(ScaledIcon3);
		
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBounds(632, 173, 45, 27);
		ImageIcon iconE=new ImageIcon("C:\\Users\\PC\\Desktop\\UBA_Bank\\New folder\\8296893-3d-realiste-personne-ou-personnes-illustrationle-vectoriel.jpg");
		Image imgE=iconE.getImage();
		Image ImgScaleE=imgE.getScaledInstance(lblNewLabel_1_1.getWidth(), lblNewLabel_1_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ScaledIconE =new ImageIcon(ImgScaleE);
		lblNewLabel_1_1.setIcon(ScaledIconE);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setBounds(632, 216, 45, 27);
		ImageIcon iconP=new ImageIcon("C:\\Users\\PC\\Desktop\\UBA_Bank\\New folder\\1804429.png");
		Image imgP=iconP.getImage();
		Image ImgScaleP=imgP.getScaledInstance(lblNewLabel_1_2.getWidth(), lblNewLabel_1_2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ScaledIconP =new ImageIcon(ImgScaleP);
		lblNewLabel_1_2.setIcon(ScaledIconP);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.setBounds(632, 263, 45, 27);
		ImageIcon iconM=new ImageIcon("C:\\Users\\PC\\Desktop\\UBA_Bank\\New folder\\8443082.png");
		Image imgM=iconM.getImage();
		Image ImgScaleM=imgM.getScaledInstance(lblNewLabel_1_3.getWidth(), lblNewLabel_1_3.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ScaledIconM =new ImageIcon(ImgScaleM);
		lblNewLabel_1_3.setIcon(ScaledIconM);
		panel.add(lblNewLabel_1_3);
	}
}
