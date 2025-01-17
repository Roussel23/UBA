package Page;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import Administration.Administration_Accounts_Services;
import ConnectionUBA.ConnectionUBA;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;

public class Create_Account {

	JFrame frame;
	private JTextField ID;
	private JTextField Email;
	private JPasswordField Password;
	private JTextField Name;
	private JTextField Surname;
	private JTextField Age;
	private JTextField Job;
	private JPasswordField PasswordAccount;
	private JTextField Balance;
	private JComboBox Sex ;
	private JLabel Image;
	byte[] userimage;
	ConnectionUBA Con =new ConnectionUBA();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create_Account window = new Create_Account();
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

	public Create_Account() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 128, 0));
		frame.setBounds(0, 8, 1090, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPageDeCreation = new JLabel("PAGE DE CREATION DE COMPTE UBA");
		lblPageDeCreation.setForeground(new Color(255, 255, 255));
		lblPageDeCreation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPageDeCreation.setBounds(330, 15, 378, 29);
		frame.getContentPane().add(lblPageDeCreation);
		
		JLabel lblNewLabel_2 = new JLabel("Numero Compte");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 92, 122, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email :");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(42, 122, 90, 20);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Mot de passe:");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(42, 152, 103, 20);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Nom :");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(42, 182, 90, 20);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Prenom :");
		lblNewLabel_2_4.setForeground(Color.WHITE);
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4.setBounds(42, 212, 90, 20);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Sex :");
		lblNewLabel_2_5.setForeground(Color.WHITE);
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_5.setBounds(42, 242, 44, 20);
		frame.getContentPane().add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Age :");
		lblNewLabel_2_6.setForeground(Color.WHITE);
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_6.setBounds(42, 272, 90, 20);
		frame.getContentPane().add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel("Metier :");
		lblNewLabel_2_7.setForeground(Color.WHITE);
		lblNewLabel_2_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_7.setBounds(42, 302, 90, 20);
		frame.getContentPane().add(lblNewLabel_2_7);
		
		JLabel lblNewLabel_2_8 = new JLabel("Mot du passe du compte:");
		lblNewLabel_2_8.setForeground(Color.WHITE);
		lblNewLabel_2_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_8.setBounds(42, 332, 181, 20);
		frame.getContentPane().add(lblNewLabel_2_8);
		
		JLabel lblNewLabel_2_9 = new JLabel("Solde :");
		lblNewLabel_2_9.setForeground(Color.WHITE);
		lblNewLabel_2_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_9.setBounds(42, 362, 90, 20);
		frame.getContentPane().add(lblNewLabel_2_9);
		
		JLabel lblNewLabel_2_10 = new JLabel("NB: Veillez vous rassurez que vous avez remplir tous les champs et aussi que vous avez inserer une ");
		lblNewLabel_2_10.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_10.setBounds(233, 417, 720, 20);
		frame.getContentPane().add(lblNewLabel_2_10);
		
		JPanel panel = new JPanel();
		panel.setBounds(768, 92, 286, 226);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Image = new JLabel("Image");
		Image.setBounds(0, 0, 286, 226);
		Image.setBackground(new java.awt.Color(255,0,0));
		Image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		Image.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		panel.add(Image);
		
		JButton btnInsererUneImage = new JButton("INSERER UNE IMAGE");
		btnInsererUneImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SelectedImage();
			}
		});
		btnInsererUneImage.setForeground(Color.WHITE);
		btnInsererUneImage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInsererUneImage.setBackground(new Color(128, 255, 0));
		btnInsererUneImage.setBounds(768, 359, 286, 29);
		frame.getContentPane().add(btnInsererUneImage);
		
		JButton btnEnregistrer_1 = new JButton("ENREGISTRER");
		btnEnregistrer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rq2="insert into clients (ID,Email,Password,Name,Surname,Sex,Age,Job,PasswordAccount,Image,Balance,Status)values(?,?,?,?,?,?,?,?,?,?,?,?)";
				if(!ID.getText().isEmpty()&&!Email.getText().isEmpty()&&Password.getPassword()!=null&&!Name.getText().isEmpty()&&Sex.getSelectedItem().toString()!=null&&!Age.getText().isEmpty()&&!Job.getText().isEmpty()&&PasswordAccount.getPassword()!=null&&!Balance.getText().isEmpty()) {
				try {
					PreparedStatement ps=Con.getConnection().prepareStatement(rq2);
					ps.setString(1,ID.getText());
					ps.setString(2,Email.getText() );
					ps.setString(3,Password.getText());
					ps.setString(4,Name.getText().toString());
					ps.setString(5,Surname.getText().toString());
					ps.setString(6,Sex.getSelectedItem().toString());
					ps.setString(7,Age.getText().toString());
					ps.setString(8,Job.getText().toString());
					ps.setString(9,PasswordAccount.getText());
					userimage=SelectedImage();
					ps.setBytes(10, userimage);
					ps.setString(11,Balance.getText().toString());
					ps.setString(12,"Actif");	
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Les informations ont été bien envoyé",null,JOptionPane.INFORMATION_MESSAGE);
					new UBA_Services(ID.getText()).frame.setVisible(true);
					frame.dispose();
					
					//Con.Deconnect();
				}catch(SQLException except) {
					JOptionPane.showMessageDialog(null,"Erreur!,les informations n'ont pas été envoyé , Veuillez reessayez plus tard");
					
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"Erreur!, les informations n'ont pas été envoyé parce que tous les champs n'ont pas été rempli");
				
			}
			}
		});
		btnEnregistrer_1.setForeground(Color.WHITE);
		btnEnregistrer_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEnregistrer_1.setBackground(Color.BLUE);
		btnEnregistrer_1.setBounds(512, 499, 542, 29);
		frame.getContentPane().add(btnEnregistrer_1);
		
		JButton btnFermerLapplication = new JButton("FERMER L'APPLICATION");
		btnFermerLapplication.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnFermerLapplication.setForeground(Color.WHITE);
		btnFermerLapplication.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFermerLapplication.setBackground(new Color(255, 0, 0));
		btnFermerLapplication.setBounds(25, 499, 457, 29);
		frame.getContentPane().add(btnFermerLapplication);
		
		ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(124, 92, 578, 22);
		frame.getContentPane().add(ID);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(124, 125, 578, 22);
		frame.getContentPane().add(Email);
		
		Password = new JPasswordField();
		Password.setBounds(145, 152, 557, 22);
		frame.getContentPane().add(Password);
		
		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(124, 182, 578, 22);
		frame.getContentPane().add(Name);
		
		Surname = new JTextField();
		Surname.setColumns(10);
		Surname.setBounds(124, 212, 578, 22);
		frame.getContentPane().add(Surname);
		
		Sex = new JComboBox();
		Sex.setModel(new DefaultComboBoxModel(new String[] {"Masculin ", "Feminin"}));
		Sex.setBounds(123, 242, 578, 22);
		frame.getContentPane().add(Sex);
		
		Age = new JTextField();
		Age.setColumns(10);
		Age.setBounds(124, 272, 578, 22);
		frame.getContentPane().add(Age);
		
		Job = new JTextField();
		Job.setColumns(10);
		Job.setBounds(124, 302, 578, 22);
		frame.getContentPane().add(Job);
		
		PasswordAccount = new JPasswordField();
		PasswordAccount.setBounds(216, 335, 486, 22);
		frame.getContentPane().add(PasswordAccount);
		
		Balance = new JTextField();
		Balance.setColumns(10);
		Balance.setBounds(124, 366, 578, 22);
		frame.getContentPane().add(Balance);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(463, 54, 103, 28);
		ImageIcon icon2=new ImageIcon("C:\\Users\\PC\\Desktop\\UBA_Bank\\New folder\\UBA-logo-2.gif");
		Image img2=icon2.getImage();
		Image ImgScale2=img2.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.CENTER);
		ImageIcon ScaledIcon2 =new ImageIcon(ImgScale2);
		lblNewLabel.setIcon(ScaledIcon2);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(30, 417, 152, 72);
		ImageIcon icon1=new ImageIcon("C:\\Users\\PC\\Desktop\\UBA_Bank\\New folder\\UBA-logo-6.gif");
		Image img1=icon1.getImage();
		Image ImgScale1=img1.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.CENTER);
		ImageIcon ScaledIcon1 =new ImageIcon(ImgScale1);
		lblNewLabel_1.setIcon(ScaledIcon1);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_10_1 = new JLabel("photo de profil !!! Ces informations sont necessaire si vous souhaitez creer un compte.");
		lblNewLabel_2_10_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_10_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_10_1.setBounds(278, 457, 617, 20);
		frame.getContentPane().add(lblNewLabel_2_10_1);
	}
}
