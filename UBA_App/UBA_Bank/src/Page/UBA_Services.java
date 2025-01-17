package Page;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import ConnectionUBA.ConnectionUBA;

public class UBA_Services {

	JFrame frame;
	ConnectionUBA Con =new ConnectionUBA();
	ResultSet rs;
	String RegisNum;
	private JTextField IDC;
	private JPasswordField PasswordC;
	private JTextField IDTR;
	Statement st;
	JLabel greeting_4;
	private JTextField IDT;
	private JTextField AmountT;
	private JTextField ID_ReceiverT;
	private JPasswordField passwordAccountT;
	private JTextField IDR;
	private JTextField AmountR;
	private JPasswordField PasswordR;
	PreparedStatement pst;
	Date d= new Date(0);
	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	String dat=dateFormat.format(d);
	private JPasswordField passwordTR;
	private JTextField IDEp;
	private JPasswordField passwordEp;
	private JTextField AmountEp;
	String Password;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UBA_Services window = new UBA_Services();
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
	public UBA_Services() {
		initialize();
	}
	public UBA_Services(String regisNum,String password) {
		this.RegisNum=regisNum;
		this.Password=password;
		initialize();
		Greeting(RegisNum,Password);
	}
	public void Greeting(String regisNum,String password) {
		String sql="SELECT Name FROM clients WHERE ID='"+regisNum+"' and Password='"+password+"';";
		String name=null;
		try {
			Statement stmt=Con.getConnection().createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				 name=rs.getString("Name");
			
			}
			greeting_4.setText("Bienvenue "+name);
			//Con.Deconnect();
				
		}catch(Exception ex){
			ex.printStackTrace();
		//	JOptionPane.showMessageDialog(null,"Erreur durant le chargement des donnés de la table.");
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 8, 1090, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1076, 560);
		frame.getContentPane().add(tabbedPane);
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("PAGE D'ACCUEIL", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRESENTATION DE LA BANQUE UBA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(250, 37, 430, 18);
		panel.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(691, 95, 356, 340);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 356, 340);
		ImageIcon icon24=new ImageIcon("C:\\Users\\PC\\Desktop\\UBA_App\\UBA_Bank\\src\\Images\\045d34d07a8d6d496d7bc9104adf3a77_L.jpg");
		Image img24=icon24.getImage();
		Image ImgScale24=img24.getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ScaledIcon24 =new ImageIcon(ImgScale24);
		lblNewLabel_2.setIcon(ScaledIcon24);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("HISTORIQUES");
		lblNewLabel_1.setForeground(new Color(128, 255, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(21, 83, 251, 18);
		panel.add(lblNewLabel_1);
		
		 greeting_4 = new JLabel("Bienvenue");
		greeting_4.setForeground(new Color(255, 128, 0));
		greeting_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		greeting_4.setBounds(10, 10, 430, 18);
		panel.add(greeting_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("UBA a été constitué au Nigeria en tant que société à responsabilité limitée après avoir repris les actifs");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(31, 111, 649, 18);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("de la british and French Bank Limited, qui opérait auNigria depuis 1949. La United Bank for Africa a fu-");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(10, 139, 670, 18);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("sionné avec la Scandar Trust Bank en 2005 et,à partir d'un seul pays d'opération fondée en 1949 au Ni-");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(10, 167, 670, 18);
		panel.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("geria. - la plus grande économie d'Afrique, UBA est devenue l'un des principaux fournisseurs de services");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3.setBounds(10, 195, 670, 18);
		panel.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel(" banquaire et autres services financiers sur le continent africian. La banque fournit des services à plus de");
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_4.setBounds(10, 223, 670, 18);
		panel.add(lblNewLabel_1_2_4);
		
		JLabel lblNewLabel_1_2_5 = new JLabel(" 25 millions de clients dans le monde, via l'un des canaux de service les plus diversifiés d'Afrique subsa-");
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_5.setBounds(10, 251, 670, 18);
		panel.add(lblNewLabel_1_2_5);
		
		JLabel lblNewLabel_1_2_6 = new JLabel("harienne avec  plus de 1000 succursales et point de contact client et une solide plateforme bancaire en li-");
		lblNewLabel_1_2_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_6.setBounds(10, 280, 670, 18);
		panel.add(lblNewLabel_1_2_6);
		
		JLabel lblNewLabel_1_2_7 = new JLabel("United Bank for Africa Plc (UBA) est un groupe de services financiers panafricain de premier plan,");
		lblNewLabel_1_2_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_7.setBounds(31, 340, 649, 18);
		panel.add(lblNewLabel_1_2_7);
		
		JLabel lblNewLabel_1_2_8 = new JLabel(" présent dans 20 pays africains, ainsi qu'au Royaume Uni, aux Etats Unis d'Amerique");
		lblNewLabel_1_2_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_8.setBounds(10, 375, 670, 18);
		panel.add(lblNewLabel_1_2_8);
		
		JLabel lblNewLabel_1_2_10 = new JLabel("ACTIONS ET PARTENAIRES");
		lblNewLabel_1_2_10.setForeground(new Color(128, 255, 0));
		lblNewLabel_1_2_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_10.setBounds(31, 415, 649, 18);
		panel.add(lblNewLabel_1_2_10);
		
		JLabel lblNewLabel_1_2_11 = new JLabel("Les actions d'UBA sont cotées en bourse au conseil d'administration de Nigerian Exchange Limited (NGX) et la banque dispose d'une base d'actionnaire bien diver-");
		lblNewLabel_1_2_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_11.setBounds(27, 453, 1034, 18);
		panel.add(lblNewLabel_1_2_11);
		
		JLabel lblNewLabel_1_2_11_1 = new JLabel("sifiée, qui comprend des investisseurs institutionnels etrangers et locaux, ainsi que des actionnaires individuels. Elle peut effectué: le pret ,depot etc...");
		lblNewLabel_1_2_11_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_11_1.setBounds(10, 481, 1051, 18);
		panel.add(lblNewLabel_1_2_11_1);
		
		JLabel lblNewLabel_1_2_6_1 = new JLabel("gne et mobile.");
		lblNewLabel_1_2_6_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_6_1.setBounds(10, 308, 670, 18);
		panel.add(lblNewLabel_1_2_6_1);
		
		JButton btnConsulter_5 = new JButton("DECONNECTER");
		btnConsulter_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment quitter l'application ?");
				if(result==0){
				new Login().frame.setVisible(true);
				frame.dispose();
				}
			}
		});
		btnConsulter_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_5.setBackground(Color.RED);
		btnConsulter_5.setBounds(781, 56, 195, 29);
		panel.add(btnConsulter_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 128, 128));
		tabbedPane.addTab("PAGE DE TRANSFERT D'ARGENT", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblTransactionsDeTransfert = new JLabel("TRANSACTIONS DE TRANSFERT D'ARGENT");
		lblTransactionsDeTransfert.setForeground(new Color(255, 128, 0));
		lblTransactionsDeTransfert.setBounds(332, 10, 430, 18);
		lblTransactionsDeTransfert.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblTransactionsDeTransfert);
		
		JLabel greeting_2 = new JLabel("UBA s'engage également envers le développement communautaire à travers ses initiatives de responsabilité sociale d'entreprise et son soutien aux communautés");
		greeting_2.setBounds(23, 64, 1038, 18);
		greeting_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(greeting_2);
		
		JLabel greeting_3 = new JLabel(" dans lesquelles elle opère. La banque est reconnue pour son integrité, sa transparence et son engagement envers ses clients employés et actionnaires.");
		greeting_3.setBounds(23, 92, 938, 18);
		greeting_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(greeting_3);
		
		JLabel lblNumeroDuCompte = new JLabel("Numero du compte :");
		lblNumeroDuCompte.setBounds(96, 140, 146, 18);
		lblNumeroDuCompte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNumeroDuCompte);
		
		JLabel greeting_5 = new JLabel("Montant :");
		greeting_5.setBounds(106, 176, 107, 18);
		greeting_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(greeting_5);
		
		JLabel greeting_6 = new JLabel("Numero du compte du destinataire");
		greeting_6.setBounds(23, 218, 219, 18);
		greeting_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(greeting_6);
		
		IDT = new JTextField();
		IDT.setBounds(289, 138, 547, 22);
		IDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IDT.setColumns(10);
		panel_1.add(IDT);
		
		AmountT = new JTextField();
		AmountT.setBounds(289, 174, 547, 22);
		AmountT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AmountT.setColumns(10);
		panel_1.add(AmountT);
		
		ID_ReceiverT = new JTextField();
		ID_ReceiverT.setBounds(289, 214, 547, 22);
		ID_ReceiverT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ID_ReceiverT.setColumns(10);
		panel_1.add(ID_ReceiverT);
		
		JLabel greeting_5_1 = new JLabel("Mot de passe du compte");
		greeting_5_1.setBounds(75, 263, 167, 18);
		greeting_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(greeting_5_1);
		
		JButton btnConsulter_3_1_2 = new JButton("TRANSFERER");
		btnConsulter_3_1_2.setBounds(415, 321, 195, 29);
		btnConsulter_3_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sql1="Select Balance from clients where ID='"+IDT.getText()+"';";
				String sql2="update clients set Balance=? where ID='"+IDT.getText()+"';";
				String sql3="insert into transfer(Id_Account,Amount,Date,Id_Receiver) values (?,?,?,?)";
				String sql4="Select Balance from clients where ID='"+ID_ReceiverT.getText()+"';";
				String sql5="update clients set Balance=? where ID='"+ID_ReceiverT.getText()+"';";
				float Balance = 0,Balance_Receiver = 0;
				Float Result;
				if(IDT.getText()!=null && ID_ReceiverT.getText()!=null && AmountT.getText()!=null) {
				Result=Float.parseFloat(AmountT.getText());
				try {
					if(Result >0) {
						
						st=Con.getConnection().createStatement();
						rs=st.executeQuery(sql1);
						if(rs.next()) {
							Balance=Float.parseFloat(rs.getString("Balance"));
							
						}
						Float NewBalance=Balance-Result;
							if(NewBalance>0) {
								
								pst=Con.getConnection().prepareStatement(sql2);
								
								pst.setFloat(1,NewBalance);
								pst.executeUpdate();
								
								//Selection compte destinataire
								st=Con.getConnection().createStatement();
								rs=st.executeQuery(sql4);
								if(rs.next()) {
							
									Balance_Receiver=Float.parseFloat(rs.getString("Balance"));
									
								}
								
								//Modification du solde du destinataire
								pst=Con.getConnection().prepareStatement(sql5);
								pst.setFloat(1,Balance_Receiver+Result);
								pst.executeUpdate();
								
								//Insertion dans la table transfer
								pst= Con.getConnection().prepareStatement(sql3);	
								pst.setString(1,IDT.getText());
								pst.setString(2,AmountT.getText());
								pst.setString(3,dat.toString());
								pst.setString(4,ID_ReceiverT.getText());
								pst.executeUpdate();
								//Con.Deconnect();
								JOptionPane.showMessageDialog(null,"Le transfert au numero de compte "+ID_ReceiverT.getText()+" a été effectué avec succès.");
								
							
						}else {
							JOptionPane.showMessageDialog(null,"Votre solde est insuffisant.");
							
						}
					}else {
						JOptionPane.showMessageDialog(null,"Vous devez entrez un mountant constitué de chiffres.");
					}
				}catch(Exception except) {
					except.printStackTrace();
					//JOptionPane.showMessageDialog(null,except.getMessage(),"Vous devez entrez un mountant constitué de chiffres.",JOptionPane.ERROR_MESSAGE);
				}	
				}else {
					JOptionPane.showMessageDialog(null,"Vous devez remplir tous les champs.");
				}
					
				}
			
		});
		btnConsulter_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_1_2.setBackground(new Color(0, 255, 64));
		panel_1.add(btnConsulter_3_1_2);
		
		passwordAccountT = new JPasswordField();
		passwordAccountT.setBounds(289, 260, 547, 22);
		passwordAccountT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(passwordAccountT);
		
		JLabel greeting_2_1 = new JLabel("Le transfert d'argent fait reference à l'action de deplacer de l'argent d'un compte à un autre. Cela peut se fait entre comptes detenus par la meme personne dans");
		greeting_2_1.setBounds(39, 371, 1022, 18);
		greeting_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(greeting_2_1);
		
		JLabel greeting_2_2 = new JLabel("la même banque, entre comptes detenus par differents personnes dans une même banque,entre comptes detenus dans les banques differentes. Les transferts peu-");
		greeting_2_2.setBounds(23, 399, 1038, 18);
		greeting_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(greeting_2_2);
		
		JLabel greeting_2_3 = new JLabel("vent être effectué,ligne,par telephone ou en personne à la banque. Une fois que le transfert éffectué, l'argent est débité du compte source et crédité sur le ");
		greeting_2_3.setBounds(23, 427, 1038, 18);
		greeting_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(greeting_2_3);
		
		JLabel greeting_2_4 = new JLabel("compte de destination.");
		greeting_2_4.setBounds(23, 459, 1038, 18);
		greeting_2_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(greeting_2_4);
		
		JLabel greeting_2_5 = new JLabel("UBA pour la confiance renouveler. Elle offre aussi d'offre services comme le pret, l'epargne, le depot, le retrait et bien d'autres. Pour plus rendez dans nos guichets.");
		greeting_2_5.setBounds(23, 487, 1016, 18);
		greeting_2_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(greeting_2_5);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(846, 128, 202, 175);
		ImageIcon icon245=new ImageIcon("C:\\Users\\PC\\Desktop\\UBA_Bank\\New folder\\-453486.jpg");
		Image img245=icon245.getImage();
		Image ImgScale245=img245.getScaledInstance(lblNewLabel_5.getWidth(), lblNewLabel_5.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ScaledIcon245 =new ImageIcon(ImgScale245);
		lblNewLabel_5.setIcon(ScaledIcon245);
		panel_1.add(lblNewLabel_5);
	
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 128, 128));
		tabbedPane.addTab("PAGE DE RETRAIT", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblTransactionsDeRetrait = new JLabel("TRANSACTIONS DE RETRAIT D'ARGENT");
		lblTransactionsDeRetrait.setBounds(315, 17, 430, 18);
		lblTransactionsDeRetrait.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(lblTransactionsDeRetrait);
		
		JLabel greeting_1_4 = new JLabel("Numero du compte :");
		greeting_1_4.setBounds(15, 94, 150, 18);
		greeting_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(greeting_1_4);
		
		JLabel greeting_1_5 = new JLabel("Montant :");
		greeting_1_5.setBounds(28, 126, 123, 18);
		greeting_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(greeting_1_5);
		
		JLabel greeting_1_6 = new JLabel("Mot de passe :");
		greeting_1_6.setBounds(28, 159, 123, 18);
		greeting_1_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(greeting_1_6);
		
		JLabel greeting_1_7 = new JLabel("Definition du concept Retrait");
		greeting_1_7.setForeground(new Color(255, 0, 0));
		greeting_1_7.setBounds(76, 260, 285, 29);
		greeting_1_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(greeting_1_7);
		
		JLabel greeting_1_8 = new JLabel("deduit du solde du compte titulaire");
		greeting_1_8.setBounds(15, 415, 656, 18);
		greeting_1_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(greeting_1_8);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(695, 95, 362, 338);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(1, 0, 359, 337);
		ImageIcon icon3=new ImageIcon("C:\\Users\\PC\\Desktop\\UBA_App\\UBA_Bank\\src\\Images\\UBA-Cameroun-Biyemassi2-1024x592.jpg");
		Image img3=icon3.getImage();
		Image ImgScale3=img3.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ScaledIcon3 =new ImageIcon(ImgScale3);
		lblNewLabel_3.setIcon(ScaledIcon3);
		panel_6.add(lblNewLabel_3);
		
		IDR = new JTextField();
		IDR.setBounds(161, 90, 510, 22);
		IDR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IDR.setColumns(10);
		panel_2.add(IDR);
		
		AmountR = new JTextField();
		AmountR.setBounds(161, 122, 510, 22);
		AmountR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AmountR.setColumns(10);
		panel_2.add(AmountR);
		
		PasswordR = new JPasswordField();
		PasswordR.setBounds(161, 155, 510, 22);
		PasswordR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(PasswordR);
		
		JLabel greeting_1_8_1 = new JLabel("UBA est connue pour son engagement envers l'innovation et la technologie, offrant à ses clients des solutions numeriques avancées pour faciliter les transactions");
		greeting_1_8_1.setBounds(31, 449, 1026, 18);
		greeting_1_8_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(greeting_1_8_1);
		
		JLabel greeting_1_8_1_1 = new JLabel(" bancaires. La banque a remporté plusieurs prix pour sa technologie de pointe et ses services bancaires numeriques.");
		greeting_1_8_1_1.setBounds(15, 483, 1042, 18);
		greeting_1_8_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(greeting_1_8_1_1);
		
		JLabel greeting_1_7_1 = new JLabel("en effectuant un virement electronique vers un autre compte. Une fois que l'argent est retiré, il est");
		greeting_1_7_1.setBounds(15, 383, 656, 18);
		greeting_1_7_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(greeting_1_7_1);
		
		JLabel greeting_1_7_2 = new JLabel("faire en utilisant un guichet automatique, en effectunt un retrait en espèces à un succursale bancaire ou");
		greeting_1_7_2.setBounds(15, 355, 656, 18);
		greeting_1_7_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(greeting_1_7_2);
		
		JButton btnConsulter_3_1_3 = new JButton("RETIRER");
		btnConsulter_3_1_3.setBounds(248, 212, 195, 29);
		btnConsulter_3_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String R1="Select Balance from clients where ID='"+IDR.getText()+"';";
				String R2="update clients set Balance=? where ID='"+IDR.getText()+"';";
				String R3="insert into withdrawal(Id_Account,Amount,Date) values (?,?,?)";
			
				float Balance_IDR = 0;
				Float Result;
				if(IDR.getText()!=null && AmountR.getText()!=null) {
				Result=Float.parseFloat(AmountR.getText());
				try {
					if(Result >0) {
						
						st=Con.getConnection().createStatement();
						rs=st.executeQuery(R1);
						if(rs.next()) {
							//JOptionPane.showMessageDialog();
							Balance_IDR=Float.parseFloat(rs.getString("Balance"));
							
						}
						Float NewBalanceR=Balance_IDR-Result;
							if(NewBalanceR>0) {
								
								pst=Con.getConnection().prepareStatement(R2);
								
								pst.setFloat(1,NewBalanceR);
								pst.executeUpdate();
								
								//Insertion dans la table transfer
								pst= Con.getConnection().prepareStatement(R3);	
								pst.setString(1,IDT.getText());
								pst.setString(2,AmountT.getText());
								pst.setString(3,dat.toString());
								pst.executeUpdate();
								//Con.Deconnect();
								JOptionPane.showMessageDialog(null,"Le retrait a été effectué avec succès.");
								
							
						}else {
							JOptionPane.showMessageDialog(null,"Votre solde est insuffisant.");
							
						}
					}else {
						JOptionPane.showMessageDialog(null,"Vous devez entrez un mountant constitué de chiffres.");
					}
				}catch(Exception except) {
					JOptionPane.showMessageDialog(null,"Vous devez entrez un mountant constitué de chiffres.");
					
				}
			}else {
				JOptionPane.showMessageDialog(null,"Vous devez remplir tous les champs.");
			}
				
			}
		});
		btnConsulter_3_1_3.setForeground(new Color(0, 0, 0));
		btnConsulter_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_1_3.setBackground(new Color(0, 128, 192));
		panel_2.add(btnConsulter_3_1_3);
		
		JLabel greeting_1_7_2_1 = new JLabel("Le retrait d'argent est le processus qui consiste a retirer de l'argent d'un compte bancaire. Cela peut se");
		greeting_1_7_2_1.setBounds(15, 327, 656, 18);
		greeting_1_7_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(greeting_1_7_2_1);
		
		JLabel greeting_1_7_2_2 = new JLabel("UBA effectue les opérations bancaires comme le retrait d'argent.");
		greeting_1_7_2_2.setBounds(31, 299, 640, 18);
		greeting_1_7_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(greeting_1_7_2_2);
		lblNewLabel_3.setIcon(ScaledIcon3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("PAGE DE CONSULTATION DE SOLDE", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblConsultationSolde = new JLabel("CONSULTATION SOLDE / DERNIERES TRANSACTIONS ");
		lblConsultationSolde.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConsultationSolde.setBounds(259, 23, 573, 18);
		panel_3.add(lblConsultationSolde);
		
		JLabel lblConsultationDeSolde = new JLabel("CONSULTATION DE SOLDE");
		lblConsultationDeSolde.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConsultationDeSolde.setBounds(26, 68, 291, 18);
		panel_3.add(lblConsultationDeSolde);
		
		JLabel greeting_1 = new JLabel("Numero du compte :");
		greeting_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		greeting_1.setBounds(47, 122, 150, 18);
		panel_3.add(greeting_1);
		
		JLabel greeting_1_1 = new JLabel("Mot de passe du compte :");
		greeting_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		greeting_1_1.setBounds(26, 156, 171, 18);
		panel_3.add(greeting_1_1);
		
		IDC = new JTextField();
		IDC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IDC.setColumns(10);
		IDC.setBounds(202, 120, 551, 22);
		panel_3.add(IDC);
		
		PasswordC = new JPasswordField();
		PasswordC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PasswordC.setBounds(200, 155, 553, 22);
		panel_3.add(PasswordC);
		
		JButton btnConsulter_3_1 = new JButton("CONSULTER");
		btnConsulter_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String rq="select Balance from clients where ID='"+IDC.getText()+"' and passwordAccount='"+PasswordC.getText()+"';";
				
				if(RegisNum!=null &&!IDC.getText().isEmpty() && !PasswordC.getText().isEmpty()) {
					try {
						Statement stmt=Con.getConnection().createStatement();
						rs=stmt.executeQuery(rq);
						while(rs.next()) {
							
							JOptionPane.showMessageDialog(null,"Votre solde du compte est de : "+rs.getString("Balance")+" F");
							
						}
						//Con.Deconnect();
									
						
					}catch(Exception ex){
						JOptionPane.showMessageDialog(null,"Erreur durant la consultation de solde, Veuillez essayez plus tard !!!");
					}
				}else {
					JOptionPane.showMessageDialog(null,"Erreur!, vous n'avez pas accès.");
				}
			}

		});
		btnConsulter_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_1.setBackground(new Color(0, 255, 0));
		btnConsulter_3_1.setBounds(313, 193, 195, 29);
		panel_3.add(btnConsulter_3_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(64, 128, 128));
		panel_5.setBounds(0, 238, 1061, 10);
		panel_3.add(panel_5);
		
		JLabel lblDernieresTransactions = new JLabel("DERNIERES TRANSACTIONS");
		lblDernieresTransactions.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDernieresTransactions.setBounds(26, 283, 291, 18);
		panel_3.add(lblDernieresTransactions);
		
		JLabel greeting_1_2 = new JLabel("Si vous souhaitez savoir les dernières transactions ,entRer vos informations et cliquez sur << VOIR >>");
		greeting_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		greeting_1_2.setBounds(36, 319, 705, 18);
		panel_3.add(greeting_1_2);
		
		JLabel greeting_1_3 = new JLabel("Numero du compte :");
		greeting_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		greeting_1_3.setBounds(47, 375, 150, 18);
		panel_3.add(greeting_1_3);
		
		IDTR = new JTextField();
		IDTR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IDTR.setColumns(10);
		IDTR.setBounds(202, 373, 551, 22);
		panel_3.add(IDTR);
		
		JLabel greeting_1_1_1 = new JLabel("Mot de passe du compte :");
		greeting_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		greeting_1_1_1.setBounds(26, 411, 179, 18);
		panel_3.add(greeting_1_1_1);
		
		JButton btnConsulter_3_1_1 = new JButton("VOIR");
		btnConsulter_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tr1="Select Amount, Date from transfer where Id_Account='"+IDTR.getText()+"';";
				String tr2="Select Amount, Date from withdrawal where Id_Account='"+IDTR.getText()+"';";
				
				try {
					ResultSet rs1,rs2;
				//	Float[] AmountTR,BalanceTR;
					//int i=0;
					
						//Selection des transfers
						st=Con.getConnection().createStatement();
						rs1=st.executeQuery(tr1);
						
						st=Con.getConnection().createStatement();
						rs2=st.executeQuery(tr2);
						if(rs1!=null ||rs2!=null ) {
							if(rs1.next()) {
								JOptionPane.showMessageDialog(null,rs1.getString("Amount")+" a été effectué le: "+rs1.getString("Date"));
								
							}else {
								JOptionPane.showMessageDialog(null,"Vous n'avez pas encore effectué de transfert");
								
							}
									//Selection compte des retraits
									
							if(rs2.next()) {
								JOptionPane.showMessageDialog(null,rs2.getString("Amount")+" a été effectué le: "+rs2.getString("Date"));
										
							}else {
								JOptionPane.showMessageDialog(null,"Vous n'avez pas encore effectué de retrait");
								
							}
								
								//Con.Deconnect();	
							
						}else {
							JOptionPane.showMessageDialog(null,"Vous n'avez encore effectué aucune opérations bancaires recemmment.");
							
						}
					
				}catch(Exception exception) {
					JOptionPane.showMessageDialog(null,exception.getMessage(),"Vous avez encore effectué aucune opérations bancaires recemmment.",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnConsulter_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_1_1.setBackground(new Color(0, 128, 192));
		btnConsulter_3_1_1.setBounds(313, 459, 195, 29);
		panel_3.add(btnConsulter_3_1_1);
		
		passwordTR = new JPasswordField();
		passwordTR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordTR.setBounds(202, 405, 553, 22);
		panel_3.add(passwordTR);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(797, 51, 246, 171);
		ImageIcon iconC=new ImageIcon("C:\\Users\\PC\\Desktop\\UBA_Bank\\New folder\\8296893-3d-realiste-personne-ou-personnes-illustrationle-vectoriel.jpg");
		Image imgC=iconC.getImage();
		Image ImgScaleC=imgC.getScaledInstance(lblNewLabel_6.getWidth(), lblNewLabel_6.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ScaledIconC =new ImageIcon(ImgScaleC);
		lblNewLabel_6.setIcon(ScaledIconC);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("New label");
		lblNewLabel_6_1.setBounds(797, 269, 246, 171);
		ImageIcon iconT=new ImageIcon("C:\\Users\\PC\\Desktop\\UBA_Bank\\New folder\\transferer-de-largent-en-turquie.jpeg");
		Image imgT=iconT.getImage();
		Image ImgScaleT=imgT.getScaledInstance(lblNewLabel_6_1.getWidth(), lblNewLabel_6_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ScaledIconT =new ImageIcon(ImgScaleT);
		lblNewLabel_6_1.setIcon(ScaledIconT);
		panel_3.add(lblNewLabel_6_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(128, 128, 255));
		tabbedPane.addTab("PAGE D'EPARGNE", null, panel_7, null);
		panel_7.setLayout(null);
		
		JLabel lblTransactionLieeA = new JLabel("TRANSACTION LIEE A L'EPARGNE");
		lblTransactionLieeA.setForeground(new Color(128, 255, 0));
		lblTransactionLieeA.setBounds(323, 10, 364, 18);
		lblTransactionLieeA.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_7.add(lblTransactionLieeA);
		
		JLabel lblNumeroDuCompte_6 = new JLabel("Numero du compte :");
		lblNumeroDuCompte_6.setBounds(340, 104, 146, 18);
		lblNumeroDuCompte_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_7.add(lblNumeroDuCompte_6);
		
		JLabel lblNumeroDuCompte_3 = new JLabel("Mot de passe :");
		lblNumeroDuCompte_3.setBounds(340, 176, 146, 18);
		lblNumeroDuCompte_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_7.add(lblNumeroDuCompte_3);
		
		JLabel lblMontant = new JLabel("Montant :");
		lblMontant.setBounds(350, 142, 146, 18);
		lblMontant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_7.add(lblMontant);
		
		JLabel lblNumeroDuCompte_5 = new JLabel("L'Epargne d'argent consiste à mettre de coté une partie de ses revenus régulierement dans le but de contituer");
		lblNumeroDuCompte_5.setBounds(340, 276, 709, 18);
		lblNumeroDuCompte_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_7.add(lblNumeroDuCompte_5);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 72, 320, 299);
		panel_7.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(0, 0, 320, 299);
		ImageIcon icon5=new ImageIcon("C:\\Users\\PC\\Desktop\\UBA_Bank\\New folder\\quiz-billets-de-banque-demelez-le-vrai-du-faux.jpeg");
		Image img5=icon5.getImage();
		Image ImgScale5=img5.getScaledInstance(lblNewLabel_4.getWidth(), lblNewLabel_4.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ScaledIcon5 =new ImageIcon(ImgScale5);
		lblNewLabel_4.setIcon(ScaledIcon5);
		panel_8.add(lblNewLabel_4);
		
		IDEp = new JTextField();
		IDEp.setBounds(475, 104, 560, 22);
		IDEp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IDEp.setColumns(10);
		panel_7.add(IDEp);
		
		passwordEp = new JPasswordField();
		passwordEp.setBounds(474, 174, 561, 22);
		passwordEp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_7.add(passwordEp);
		
		AmountEp = new JTextField();
		AmountEp.setBounds(475, 139, 560, 22);
		AmountEp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AmountEp.setColumns(10);
		panel_7.add(AmountEp);
		
		JButton btnConsulter_3_1_2_1 = new JButton("EPARGNER");
		btnConsulter_3_1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String E1="Select Balance from clients where ID='"+IDEp.getText()+"';";
				String E2="update clients set Balance=? where ID='"+IDEp.getText()+"';";
				String E3="insert into UBA_Account(Id_Account,Amount,Date) values (?,?,?)";
				String E4="insert into saving_money(Id_Account,Amount,Date) values (?,?,?)";
			
				float Balance_IDEp = 0;
				Float ResultEp;
				ResultEp=Float.parseFloat(AmountEp.getText());
				try {
					if(ResultEp >0) {
						
						st=Con.getConnection().createStatement();
						rs=st.executeQuery(E1);
						if(rs.next()) {
							//JOptionPane.showMessageDialog();
							Balance_IDEp=Float.parseFloat(rs.getString("Balance"));
							
						}
						Float NewBalanceR=Balance_IDEp-ResultEp;
							if(NewBalanceR>0) {
								
								pst=Con.getConnection().prepareStatement(E2);
								
								pst.setFloat(1,NewBalanceR);
								pst.executeUpdate();
								
								//Insertion dans la table UBA_Account
								pst= Con.getConnection().prepareStatement(E3);	
								pst.setString(1,IDEp.getText());
								pst.setString(2,AmountEp.getText());
								pst.setString(3,dat.toString());
								pst.executeUpdate();
								//Con.Deconnect();
								

								//Insertion dans la table saving_money
								pst= Con.getConnection().prepareStatement(E4);	
								pst.setString(1,IDEp.getText());
								pst.setString(2,AmountEp.getText());
								pst.setString(3,dat.toString());
								pst.executeUpdate();
								//Con.Deconnect();
								JOptionPane.showMessageDialog(null,"L'epargne a été effectué avec succès.");
								
							
						}else {
							JOptionPane.showMessageDialog(null,"Votre solde est insuffisant.");
							
						}
					}else {
						JOptionPane.showMessageDialog(null,"Vous devez entrez un montant constitué de chiffres.");
					}
				}catch(Exception except) {
					JOptionPane.showMessageDialog(null,"Vous devez entrez un mountant constitué de chiffres.");
					
				}

			}
		});
		btnConsulter_3_1_2_1.setBounds(549, 229, 195, 29);
		btnConsulter_3_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_1_2_1.setBackground(new Color(0, 255, 64));
		panel_7.add(btnConsulter_3_1_2_1);
		
		JLabel lblNumeroDuCompte_5_1 = new JLabel("un fonds d'urgence, d'atteindre  des objectifs financiers à court, moyem ou long terme, ou de se premunir con-");
		lblNumeroDuCompte_5_1.setBounds(340, 304, 709, 18);
		lblNumeroDuCompte_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_7.add(lblNumeroDuCompte_5_1);
		
		JLabel lblNumeroDuCompte_5_2 = new JLabel("tre les imprevus. L'epargne peut se faire de differentes manieres, en fonction des besoins et objectifs de chacun");
		lblNumeroDuCompte_5_2.setBounds(340, 332, 709, 18);
		lblNumeroDuCompte_5_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_7.add(lblNumeroDuCompte_5_2);
		
		JLabel lblNumeroDuCompte_5_3 = new JLabel("L''epargne à UBA est un moyen de se constituer une reserve financiere pour realiser des projets futurs, se proteger des aléas de la vie, ou préparer sa retraite.");
		lblNumeroDuCompte_5_3.setBounds(26, 451, 1023, 18);
		lblNumeroDuCompte_5_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_7.add(lblNumeroDuCompte_5_3);
		
		JLabel lblNumeroDuCompte_5_3_1 = new JLabel("C'est une habitude finncière saine qui permet d'avoir une certaine tranquilité d'esprit et de renforcer sa sécurite financière.");
		lblNumeroDuCompte_5_3_1.setBounds(10, 479, 1039, 18);
		lblNumeroDuCompte_5_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_7.add(lblNumeroDuCompte_5_3_1);
		
		JLabel lblNewLabel_7 = new JLabel("Comment s'effectue l'epargne à  la banque UBA ?");
		lblNewLabel_7.setForeground(new Color(255, 0, 0));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(272, 402, 415, 29);
		panel_7.add(lblNewLabel_7);
	}
}
