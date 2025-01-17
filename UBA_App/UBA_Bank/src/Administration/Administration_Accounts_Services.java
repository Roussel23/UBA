package Administration;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ConnectionUBA.ConnectionUBA;
import Page.Login;

public class Administration_Accounts_Services {

	public JFrame frame;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();
	private final JTable table = new JTable();
	private final JLabel lblNewLabel_2_4_1 = new JLabel("TRANSACTION  DE RETRAIT");
	private final JLabel lblNewLabel_2_4_1_1 = new JLabel("Montant:");
	private final JLabel lblNewLabel_2_4_1_2 = new JLabel("Numero du compte  :");
	private final JLabel lblNewLabel_2_4_1_3 = new JLabel("TABLE DES DEPOTS EFFECTUES");
	private final JLabel lblNewLabel_2_4_1_4 = new JLabel("Entrer le numero du compte :");
	private final JLabel lblNewLabel_2_4_1_6 = new JLabel("Montant :");
	private final JLabel lblNewLabel_2_4_1_7 = new JLabel("Garantir :");
	private final JLabel lblNewLabel_2_4_1_8 = new JLabel("PAGE DE PRET");
	private final JLabel lblNewLabel_2_4_1_9 = new JLabel("Liste des actions");
	private final JTable table_1 = new JTable();
	private final JButton btnConsulter_3 = new JButton("SUPPRIMER");
	private final JButton btnConsulter_4 = new JButton("DEPOSER");
	private final JButton btnConsulter_5 = new JButton("DECONNECTER");
	private final JTable table_2 = new JTable();
	private final JTable table_3 = new JTable();
	private final JTable table_4 = new JTable();
	JTextArea GuaranteeP;
	String RegisNum;
	private JTextField IDD;
	private JTextField AmountD;
	private JTextField SearchD;
	DefaultTableModel model;
	ResultSet rs;
	
	Statement st;
	ConnectionUBA Con =new ConnectionUBA();
	Date date=new Date();
	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	String dat=dateFormat.format(date);
	PreparedStatement pst;
	
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administration_Accounts_Services window = new Administration_Accounts_Services();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void updateT() {
		IDT.setText(null);
		AmountT.setText(null);	
		ID_ReceiverT.setText(null);	
		DateT.setText(null);
	}
	/**
	 * Create the application.
	 */
	String rq2="SELECT * FROM deposit";
	String rq1="SELECT * FROM transfer";
	
	String rq3="SELECT * FROM loan";
	String rq4="SELECT * FROM saving_money";
	String rq5="SELECT * FROM withdrawal";
	String[] tableHeader1= {"Numero compte DEPOSEUR ","Montant","Date","Numero compte RECEPTEUR"};
	String[] tableHeader2= {"Numero du Compte","Montant","Date"};
	String[] tableHeader3= {"Numero compte DEPOSEUR ","Montant","Date","Date de delais","Garanties"};
	String[] tableHeader4= {"Numero du Compte","Montant de l'Epargne","Date"};
	String[] tableHeader5= {"Numero du Compte","Montant","Date"};
	private final JTextField IDE = new JTextField();
	private final JTextField AmountE = new JTextField();
	private final JButton btnConsulter_3_2 = new JButton("SUPPRIMER");
	private final JButton btnConsulter_3_3 = new JButton("EPARGNER");
	private final JButton btnConsulter_3_4 = new JButton("DECONNECTER");
	private JTextField SearchE;
	private final JTextField IDP = new JTextField();
	private final JTextField AmountP = new JTextField();
	private final JTextField TimeP = new JTextField();
	private final JLabel lblNewLabel_2_4_1_6_1 = new JLabel("Date de Delais :");
	private JTextField SearchP;
	private JTextField IDT;
	private JTextField AmountT;
	private JTextField ID_ReceiverT;
	private JTextField SearchT;
	private JTextField IDR;
	private JTextField AmountR;
	private JTextField SearchR;
	private JTextField DateR;
	private JTextField DateT;
	public Administration_Accounts_Services() {
		initialize();
		Table2(table_4,tableHeader1,rq1);
		Table(table,tableHeader2,rq2);
		Table3(table_1,tableHeader3,rq3);
		Table(table_2,tableHeader4,rq4);
		Table(table_3,tableHeader5,rq5);
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(799, 10, 222, 170);
		ImageIcon icon22=new ImageIcon("C:\\Users\\PC\\Desktop\\UBA_Bank\\New folder\\77c261f9fb0e471f41b5029782032a83.jpg");
		Image img22=icon22.getImage();
		Image ImgScale22=img22.getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ScaledIcon22 =new ImageIcon(ImgScale22);
		lblNewLabel_2.setIcon(ScaledIcon22);
		panel_3.add(lblNewLabel_2);
		IDP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IDP.setColumns(10);
		IDP.setBounds(223, 73, 551, 22);
		panel_1.setBackground(new Color(128, 128, 255));
		
		panel_1.add(IDP);
		AmountP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AmountP.setColumns(10);
		AmountP.setBounds(223, 104, 551, 22);
		
		panel_1.add(AmountP);
		TimeP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TimeP.setColumns(10);
		TimeP.setBounds(223, 234, 551, 22);
		
		panel_1.add(TimeP);
		lblNewLabel_2_4_1_6_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_6_1.setBounds(80, 235, 128, 20);
		
		panel_1.add(lblNewLabel_2_4_1_6_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(61, 10, 154, 50);
		ImageIcon iconPT=new ImageIcon("C:\\Users\\PC\\Desktop\\UBA_Bank\\New folder\\UBA-logo-5(0).gif");
		Image imgPT=iconPT.getImage();
		Image ImgScalePT=imgPT.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ScaledIconPT =new ImageIcon(ImgScalePT);
		lblNewLabel_1.setIcon(ScaledIconPT);
		panel_1.add(lblNewLabel_1);
		
	}
	public Administration_Accounts_Services(String regisNum) {
		this.RegisNum=regisNum;
		initialize();
		Table2(table_4,tableHeader1,rq1);
		Table(table,tableHeader2,rq2);
		Table(table_3,tableHeader5,rq5);
		Table3(table_1,tableHeader3,rq3);
		Table(table_2,tableHeader4,rq4);
	
	}
	
	public void Table(JTable table,Object[] tableHeader,String sql) {
		
	
		Object [] elements=new Object[tableHeader.length];

		model=new DefaultTableModel(new Object[][] {
			tableHeader
		},
		new String[] {
				 "New column", "New column", "New column"
				
		});
		
		try {
			Statement stmt=Con.getConnection().createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				elements[0]=rs.getString("Id_Account");
				elements[1]=rs.getString("Amount");
				elements[2]=rs.getString("Date");
	
				model.addRow(elements);
			}
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					int select=table.getSelectedRow();
					if(select >0) {
						model=(DefaultTableModel)(table.getModel());
						IDD.setText(model.getValueAt(select,0).toString());
						AmountD.setText(model.getValueAt(select,1).toString());					
						
						}else {
							IDD.setText(null);
							AmountD.setText(null);					
													
						}
					
				}
			});
			table.setFont(new Font("Tahoma", Font.PLAIN, 14));
			table.setModel(model);
			//Con.Deconnect();
						
			
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null,"erreur durant la recuperation des données.");
		}
		
	}
	public void Table2(JTable table,Object[] tableHeader,String sql) {
		
		
		Object [] elements=new Object[tableHeader.length];

		model=new DefaultTableModel(new Object[][] {
			tableHeader
		},
		new String[] {
				 "New column", "New column", "New column", "New column"
				
		});
		
		try {
			Statement stmt=Con.getConnection().createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				elements[0]=rs.getString("Id_Account");
				elements[1]=rs.getString("Amount");
				elements[2]=rs.getString("Date");
				elements[3]=rs.getString("Id_Receiver");

	
				model.addRow(elements);
			}
			table_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					int select=table_3.getSelectedRow();
					if(select >0) {
						model=(DefaultTableModel)(table.getModel());
						IDR.setText(model.getValueAt(select,0).toString());
						AmountR.setText(model.getValueAt(select,1).toString());	
						DateR.setText(model.getValueAt(select,2).toString());		
						
						}else {
							IDR.setText(null);
							AmountR.setText(null);	
							DateR.setText(null);	
													
						}
				}
			});
			table.setFont(new Font("Tahoma", Font.PLAIN, 14));
			table.setModel(model);
			//Con.Deconnect();
						
			
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null,"Erreur durant la recuperation des données.");
		}
		
	}
	
public void Table3(JTable table,Object[] tableHeader,String sql) {
		
		
		Object [] elements=new Object[tableHeader.length];

		model=new DefaultTableModel(new Object[][] {
			tableHeader
		},
		new String[] {
				 "New column", "New column", "New column", "New column", "New column"
				
		});
		
		try {
			Statement stmt=Con.getConnection().createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				elements[0]=rs.getString("Id_Account");
				elements[1]=rs.getString("Amount");
				elements[2]=rs.getString("Date");
				elements[3]=rs.getString("Submit_Date");
				elements[4]=rs.getString("Guarantee");

	
				model.addRow(elements);
			}
			table_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					int select=table_1.getSelectedRow();
					if(select >0) {
						model=(DefaultTableModel)(table.getModel());
						IDP.setText(model.getValueAt(select,0).toString());
						AmountP.setText(model.getValueAt(select,1).toString());	
						GuaranteeP.setText(model.getValueAt(select,3).toString());	
						TimeP.setText(model.getValueAt(select,4).toString());	
						
						}else {
							IDD.setText(null);
							AmountP.setText(null);	
							GuaranteeP.setText(null);	
							TimeP.setText(null);	
													
						}
					
				}
			});
			table.setFont(new Font("Tahoma", Font.PLAIN, 14));
			table.setModel(model);
			//Con.Deconnect();
						
			
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null,"Erreur durant la recuperation des données.");
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
		tabbedPane.setBounds(0, 0, 1076, 538);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("PAGE DES DEPOTS", null, panel, null);
		panel.setLayout(null);
		table.setBackground(new Color(192, 192, 192));
		table.setBounds(20, 327, 1019, 174);
		
		panel.add(table);
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_4_1.setBounds(355, 21, 304, 20);
		
		panel.add(lblNewLabel_2_4_1);
		lblNewLabel_2_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_1.setBounds(114, 131, 90, 20);
		
		panel.add(lblNewLabel_2_4_1_1);
		lblNewLabel_2_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_2.setBounds(83, 89, 146, 20);
		
		panel.add(lblNewLabel_2_4_1_2);
		lblNewLabel_2_4_1_3.setForeground(new Color(64, 128, 128));
		lblNewLabel_2_4_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_4_1_3.setBounds(334, 226, 325, 20);
		
		panel.add(lblNewLabel_2_4_1_3);
		lblNewLabel_2_4_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_4.setBounds(52, 273, 207, 20);
		
		panel.add(lblNewLabel_2_4_1_4);
		btnConsulter_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!IDD.getText().isEmpty()) {
				String delD="delete from deposit where Id_Account='"+IDD.getText()+"';";
				try {
					Statement st =Con.getConnection().createStatement();
					st.executeUpdate(delD);
					//Con.Deconnect();
					
					JOptionPane.showMessageDialog(null, "Le compte a éte supprimé avec succès.");
					Table2(table_4,tableHeader1,rq1);
					updateT();
				}catch(SQLException sqle) {
					JOptionPane.showMessageDialog(null, "Erreur durant le suppression!!!");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Vous avez pas accès , veuillez reessayez pus tard !!!");
			}
				
			}
		});
		
		btnConsulter_3.setBounds(234, 177, 195, 29);
		panel.add(btnConsulter_3);
		btnConsulter_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3.setBackground(new Color(255, 255, 0));
		btnConsulter_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String R1="Select Balance from clients where ID='"+IDD.getText()+"';";
				String R2="update clients set Balance=? where ID='"+IDD.getText()+"';";
				String R3="insert into deposit(Id_Account,Amount,Date) values (?,?,?)";
			
				float Balance_IDD = 0;
				float Result=0;
				if(!AmountD.getText().isEmpty()&& ! IDD.getText().isEmpty()) {
				Result=Float.parseFloat(AmountD.getText());
				try {
					if(Result >0) {
						
						st=Con.getConnection().createStatement();
						rs=st.executeQuery(R1);
						if(rs.next()) {

							Balance_IDD=Float.parseFloat(rs.getString("Balance"));
							
						}
						float NewBalanceR=Balance_IDD+Result;
							if(NewBalanceR>0) {
								
								pst=Con.getConnection().prepareStatement(R2);
								
								pst.setFloat(1,NewBalanceR);
								pst.executeUpdate();
								
								//Insertion dans la table transfer
								pst= Con.getConnection().prepareStatement(R3);	
								pst.setString(1,IDD.getText());
								pst.setString(2,AmountD.getText());
								pst.setString(3,dat.toString());
								pst.executeUpdate();
								//Con.Deconnect();
								JOptionPane.showMessageDialog(null,"Le depôt a été effectué avec succès.");
								
							
						}else {
							JOptionPane.showMessageDialog(null,"Votre solde est insuffisant.");
							
						}
					}else {
						JOptionPane.showMessageDialog(null,"Vous devez entrez un mountant constitué de chiffres.");
					}
				}catch(Exception except) {
					JOptionPane.showMessageDialog(null,"Vous devez entrez un mountant constitué de chiffres.");
					
				}

			}
			else {
				JOptionPane.showMessageDialog(null,"Vous devez remplir tous les champs.");
				
			}
			}
		});
		
		btnConsulter_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_4.setBackground(new Color(0, 255, 0));
		btnConsulter_4.setBounds(541, 177, 195, 29);
		
		panel.add(btnConsulter_4);
		btnConsulter_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Voulez vous vraiement quitter l'application?");
				if(result==0){
				new Login().frame.setVisible(true);
				frame.dispose();
				
				}
			}
		});
	
		btnConsulter_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_5.setBackground(new Color(255, 0, 0));
		btnConsulter_5.setBounds(809, 45, 195, 29);
		
		panel.add(btnConsulter_5);
		
		IDD = new JTextField();
		IDD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IDD.setColumns(10);
		IDD.setBounds(234, 88, 551, 22);
		panel.add(IDD);
		
		AmountD = new JTextField();
		AmountD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AmountD.setColumns(10);
		AmountD.setBounds(234, 130, 551, 22);
		panel.add(AmountD);
		
		SearchD = new JTextField();
		SearchD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SearchD.setColumns(10);
		SearchD.setBounds(258, 272, 466, 22);
		panel.add(SearchD);
		
		JButton btnConsulter_3_1 = new JButton("RECHERCHER");
		btnConsulter_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String num;
				num=SearchD.getText();
				try {
					if(!SearchD.getText().isEmpty()) {
						String rq11="SELECT * FROM transfer where Id_Account='"+num+"';";
						Table2(table_3,tableHeader1,rq11);
					}else {
						JOptionPane.showMessageDialog(null,"Erreur! Aucun client n'a ce numero de compte!!!");
						
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Erreur! Aucun client n'a ce numero de compte!!!");
					
				}
			}
		});
		btnConsulter_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_1.setBackground(new Color(0, 128, 192));
		btnConsulter_3_1.setBounds(734, 265, 195, 29);
		panel.add(btnConsulter_3_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(795, 95, 244, 151);
		ImageIcon icon2=new ImageIcon("C:\\Users\\PC\\Desktop\\UBA_Bank\\New folder\\UBA-logo-2.gif");
		Image img2=icon2.getImage();
		Image ImgScale2=img2.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ScaledIcon2 =new ImageIcon(ImgScale2);
		lblNewLabel.setIcon(ScaledIcon2);
		panel.add(lblNewLabel);
		
		GuaranteeP = new JTextArea();
		GuaranteeP.setBounds(223, 146, 551, 71);
		panel_1.add(GuaranteeP);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 279, 561, 0);
		panel_1.add(panel_6);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 255, 255));
		panel_5.setBounds(0, 269, 1071, 10);
		panel_1.add(panel_5);
		
		JLabel lblNewLabel_2_4_1_5 = new JLabel("Numero du compte :");
		lblNewLabel_2_4_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_5.setBounds(69, 307, 146, 20);
		panel_1.add(lblNewLabel_2_4_1_5);
		
		SearchP = new JTextField();
		SearchP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SearchP.setColumns(10);
		SearchP.setBounds(223, 305, 551, 22);
		panel_1.add(SearchP);
		
		JButton btnConsulter_3_1_1 = new JButton("DECONNECTER");
		btnConsulter_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Voulez vous vraiement quitter l'application?");
				if(result==0){
				new Login().frame.setVisible(true);
				frame.dispose();
				}
			}
		});
		btnConsulter_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_1_1.setBackground(new Color(255, 0, 0));
		btnConsulter_3_1_1.setBounds(812, 76, 195, 29);
		panel_1.add(btnConsulter_3_1_1);
		
		JButton btnConsulter_3_5 = new JButton("EFFECTUER PRET");
		btnConsulter_3_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sql1="Select Balance from clients where ID='"+IDP.getText()+"';";
				String sql2="update clients set Balance=? where ID='"+IDP.getText()+"';";
				String sql3="insert into loan(Id_Account,Amount.Date,Id_Receiver) values (?,?,?,?)";
				String sql4="Select Balance from UBA_Account where Id_Account='"+IDP.getText()+"';";
				String sql5="update UBA_Account set Balance=? where ID='"+IDP.getText()+"';";
				float Balance = 0,Balance_Receiver = 0;
				Float Result = (float) 0;
				if(!AmountP.getText().isEmpty() && !IDP.getText().isEmpty()&& !GuaranteeP.getText().isEmpty()&& !TimeP.getText().isEmpty()) {
				Result=Float.parseFloat(AmountP.getText());
				try {
					if(Result >0) {
						
						st=Con.getConnection().createStatement();
						rs=st.executeQuery(sql1);
						if(rs.next()) {
							//JOptionPane.showMessageDialog();
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
								pst.setString(1,IDP.getText());
								pst.setString(2,AmountP.getText());
								pst.setString(3,GuaranteeP.getText());
								pst.setString(4,TimeP.getText());
								pst.setString(5,dat.toString());
								
								pst.executeUpdate();
								//Con.Deconnect();
								JOptionPane.showMessageDialog(null,"Le prêt au numero de compte "+IDP.getText()+" a été effectué avec succès.");
								
							
						}else {
							JOptionPane.showMessageDialog(null,"Votre solde est insuffisant.");
							
						}
					}else {
						JOptionPane.showMessageDialog(null,"Vous devez entrez un mountant constitué de chiffres.");
					}
				}catch(Exception except) {
					JOptionPane.showMessageDialog(null,except.getMessage(),"Vous devez entrez un mountant constitué de chiffres.",JOptionPane.ERROR_MESSAGE);
					
				}
				}else{
					JOptionPane.showMessageDialog(null,"Vous devez remplir tous les champs.");
					
				}
			}
		});
		btnConsulter_3_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_5.setBackground(new Color(0, 255, 64));
		btnConsulter_3_5.setBounds(812, 135, 195, 29);
		panel_1.add(btnConsulter_3_5);
		
		JButton btnConsulter_3_6 = new JButton("SUPPRIMER");
		btnConsulter_3_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!IDP.getText().isEmpty()) {
				String delP="delete from loan where Id_Account='"+IDP.getText()+"';";
				if(!IDP.getText().isEmpty()) {
				try {
					Statement st =Con.getConnection().createStatement();
					st.executeUpdate(delP);
					//Con.Deconnect();
					
					JOptionPane.showMessageDialog(null, "Le pret a éte supprimé de la table avec succès.");
					Table3(table_1,tableHeader3,rq3);
					updateT();
				}catch(SQLException sqle) {
					JOptionPane.showMessageDialog(null, "Erreur durant le suppression !!!");
				}
			}else {
				JOptionPane.showMessageDialog(null, "vous devez remplir au moins le numero compte");
			}
				}
			}
		});
		btnConsulter_3_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_6.setBackground(Color.YELLOW);
		btnConsulter_3_6.setBounds(812, 202, 195, 29);
		panel_1.add(btnConsulter_3_6);
		
		JButton btnConsulter_3_7 = new JButton("RECHERCHER");
		btnConsulter_3_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String num;
				num=SearchP.getText();
				try {
					if(!SearchP.getText().isEmpty()) {
						String rq33="SELECT * FROM loan where Id_Account='"+num+"';";
					Table3(table_1,tableHeader3,rq33);
					}else {
						Table3(table_1,tableHeader3,rq3);
						
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage(),"Erreur! Aucun client n'a ce numero de compte!!!",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnConsulter_3_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_7.setBackground(new Color(0, 128, 192));
		btnConsulter_3_7.setBounds(812, 300, 195, 29);
		panel_1.add(btnConsulter_3_7);
		
		JLabel lblNewLabel_2_4_1_5_1 = new JLabel("Numero du compte :");
		lblNewLabel_2_4_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_5_1.setBounds(69, 74, 146, 20);
		panel_1.add(lblNewLabel_2_4_1_5_1);
		
		tabbedPane.addTab("PAGE DES PRETS", null, panel_1, null);
		panel_1.setLayout(null);
		lblNewLabel_2_4_1_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_6.setBounds(111, 104, 90, 20);
		
		panel_1.add(lblNewLabel_2_4_1_6);
		lblNewLabel_2_4_1_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_7.setBounds(97, 164, 90, 20);
		
		panel_1.add(lblNewLabel_2_4_1_7);
		lblNewLabel_2_4_1_8.setForeground(new Color(255, 128, 0));
		lblNewLabel_2_4_1_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_4_1_8.setBounds(426, 10, 167, 29);
		
		panel_1.add(lblNewLabel_2_4_1_8);
		lblNewLabel_2_4_1_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4_1_9.setBounds(854, 30, 146, 20);
		
		panel_1.add(lblNewLabel_2_4_1_9);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_1.setBackground(new Color(192, 192, 192));
		table_1.setBounds(21, 337, 1026, 164);
		
		panel_1.add(table_1);
		panel_2.setBackground(new Color(64, 128, 128));
		
		tabbedPane.addTab("PAGE DES EPARGNES", null, panel_2, null);
		panel_2.setLayout(null);
		
		table_2.setBackground(new Color(192, 192, 192));
		table_2.setBounds(28, 308, 1018, 193);
		
		panel_2.add(table_2);
		IDE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IDE.setColumns(10);
		IDE.setBounds(199, 81, 551, 22);
		
		panel_2.add(IDE);
		AmountE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AmountE.setColumns(10);
		AmountE.setBounds(199, 122, 551, 22);
		
		panel_2.add(AmountE);
		btnConsulter_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!IDE.getText().isEmpty()) {
				String delE="delete from saving_money where Id_Account='"+IDE.getText()+"';";
				try {
					Statement st =Con.getConnection().createStatement();
					st.executeUpdate(delE);
					//Con.Deconnect();
					
					JOptionPane.showMessageDialog(null, "Le compte a éte supprimé avec succès.");
					Table2(table_4,tableHeader1,rq1);
					updateT();
				}catch(SQLException sqle) {
					JOptionPane.showMessageDialog(null, "Erreur durant le suppression!!!");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Vous devez au moins remplir le numero du compte");
			}
				
			}
		});
		
		btnConsulter_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_2.setBackground(Color.YELLOW);
		btnConsulter_3_2.setBounds(199, 167, 195, 29);
		
		panel_2.add(btnConsulter_3_2);
		btnConsulter_3_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String E1="Select Balance from clients where ID='"+IDE.getText()+"';";
				String E2="update clients set Balance=? where ID='"+IDE.getText()+"';";
				String E3="insert into uba_acount(Id_Account,Amount,Date) values (?,?,?)";
				String E4="insert into saving_money(Id_Account,Amount,Date) values (?,?,?)";
			
				float Balance_IDR = 0;
				float Result=0;
				if(!IDE.getText().isEmpty() && !AmountE.getText().isEmpty()) {
				Result=Float.parseFloat(AmountR.getText());
				try {
					if(Result >0) {
						
						st=Con.getConnection().createStatement();
						rs=st.executeQuery(E1);
						if(rs.next()) {
						
							Balance_IDR=Float.parseFloat(rs.getString("Balance"));
							
						}
						Float NewBalanceR=Balance_IDR-Result;
							if(NewBalanceR>0) {
								
								pst=Con.getConnection().prepareStatement(E2);
								
								pst.setFloat(1,NewBalanceR);
								pst.executeUpdate();
								
								//Insertion dans la table UBA_Account
								pst= Con.getConnection().prepareStatement(E3);	
								pst.setString(1,IDE.getText());
								pst.setString(2,AmountE.getText());
								pst.setString(3,dat.toString());
								pst.executeUpdate();
								

								//Insertion dans la table saving_money
								pst= Con.getConnection().prepareStatement(E4);	
								pst.setString(1,IDE.getText());
								pst.setString(2,AmountE.getText());
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

			}else {
				JOptionPane.showMessageDialog(null,"Votre devez rempir tous les champs.");
			}
				
			}
		});
		
		btnConsulter_3_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_3.setBackground(new Color(0, 255, 64));
		btnConsulter_3_3.setBounds(503, 167, 195, 29);
		
		panel_2.add(btnConsulter_3_3);
		btnConsulter_3_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment quitter l'application ?");
				if(result==0){
				new Login().frame.setVisible(true);
				frame.dispose();
				}
			}
		});
		btnConsulter_3_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_4.setBackground(new Color(255, 0, 0));
		btnConsulter_3_4.setBounds(823, 52, 195, 29);
		
		panel_2.add(btnConsulter_3_4);
		
		JLabel lblNewLabel_2_4_1_2_2 = new JLabel("Montant :");
		lblNewLabel_2_4_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_2_2.setBounds(81, 123, 84, 20);
		panel_2.add(lblNewLabel_2_4_1_2_2);
		
		JLabel lblNewLabel_2_4_1_2_3 = new JLabel("Numero du compte  :");
		lblNewLabel_2_4_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_2_3.setBounds(57, 265, 146, 20);
		panel_2.add(lblNewLabel_2_4_1_2_3);
		
		JLabel lblNewLabel_2_4_1_2_4 = new JLabel("TRANSACTION  D'EPARGNE");
		lblNewLabel_2_4_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_4_1_2_4.setBounds(350, 10, 311, 29);
		panel_2.add(lblNewLabel_2_4_1_2_4);
		
		JButton btnConsulter_3_3_1 = new JButton("RECHERCHER");
		btnConsulter_3_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String num;
				num=SearchE.getText();
				try {
					if(!SearchE.getText().isEmpty()) {
						String rq44="SELECT * FROM saving_money where Id_Account='"+num+"';";
						Table(table_2,tableHeader4,rq44);
					}else {
						JOptionPane.showMessageDialog(null,"Erreur! Aucun client n'a ce numero de compte!!!");
						
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage(),"Erreur! Aucun client n'a ce numero de compte!!!",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnConsulter_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_3_1.setBackground(new Color(0, 128, 255));
		btnConsulter_3_3_1.setBounds(764, 256, 195, 29);
		panel_2.add(btnConsulter_3_3_1);
		
		SearchE = new JTextField();
		SearchE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SearchE.setColumns(10);
		SearchE.setBounds(209, 265, 541, 22);
		panel_2.add(SearchE);
		
		JLabel lblNewLabel_2_4_1_2_1 = new JLabel("TABLE DES EPARGNES EFFECTUES");
		lblNewLabel_2_4_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_4_1_2_1.setBounds(328, 219, 350, 29);
		panel_2.add(lblNewLabel_2_4_1_2_1);
		
		JLabel lblNewLabel_2_4_1_2_3_1 = new JLabel("Numero du compte  :");
		lblNewLabel_2_4_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_2_3_1.setBounds(43, 81, 146, 20);
		panel_2.add(lblNewLabel_2_4_1_2_3_1);
		panel_3.setBackground(new Color(0, 255, 255));
		
		tabbedPane.addTab("ADMNINISTRATION DES RETRAITS D'ARGENT", null, panel_3, null);
		panel_3.setLayout(null);
		table_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_3.setBackground(new Color(192, 192, 192));
		table_3.setBounds(10, 330, 1051, 171);
		
		panel_3.add(table_3);
		
		JLabel lblNewLabel_2_4_1_2_5_1 = new JLabel("Numero du compte  :");
		lblNewLabel_2_4_1_2_5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_2_5_1.setBounds(76, 75, 158, 20);
		panel_3.add(lblNewLabel_2_4_1_2_5_1);
		
		JLabel lblNewLabel_2_4_1_2_5_2 = new JLabel("Montant :");
		lblNewLabel_2_4_1_2_5_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_2_5_2.setBounds(102, 105, 106, 20);
		panel_3.add(lblNewLabel_2_4_1_2_5_2);
		
		JLabel lblNewLabel_2_4_1_2_5_3 = new JLabel("Date :");
		lblNewLabel_2_4_1_2_5_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_2_5_3.setBounds(120, 135, 66, 20);
		panel_3.add(lblNewLabel_2_4_1_2_5_3);
		
		JLabel lblNewLabel_2_4_1_2_5_4 = new JLabel("GESTION DES RETRAITS");
		lblNewLabel_2_4_1_2_5_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_4_1_2_5_4.setBounds(376, 10, 273, 20);
		panel_3.add(lblNewLabel_2_4_1_2_5_4);
		
		JLabel lblNewLabel_2_4_1_2_5_5 = new JLabel("Numero du compte :");
		lblNewLabel_2_4_1_2_5_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_2_5_5.setBounds(51, 280, 150, 20);
		panel_3.add(lblNewLabel_2_4_1_2_5_5);
		
		IDR = new JTextField();
		IDR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IDR.setColumns(10);
		IDR.setBounds(224, 78, 551, 22);
		panel_3.add(IDR);
		
		AmountR = new JTextField();
		AmountR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AmountR.setColumns(10);
		AmountR.setBounds(224, 105, 551, 22);
		panel_3.add(AmountR);
		
		SearchR = new JTextField();
		SearchR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SearchR.setColumns(10);
		SearchR.setBounds(224, 279, 551, 22);
		panel_3.add(SearchR);
		
		JButton btnConsulter_3_8 = new JButton("SUPPRIMER");
		btnConsulter_3_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String delR="delete from withdrawal where Id_Account='"+IDR.getText()+"';";
				if(!IDR.getText().isEmpty()) {
				try {
					Statement st =Con.getConnection().createStatement();
					st.executeUpdate(delR);
					//Con.Deconnect();
					
					JOptionPane.showMessageDialog(null, "Le compte a éte supprimé avec succès.");
					Table2(table_4,tableHeader1,rq1);
					updateT();
				}catch(SQLException sqle) {
					JOptionPane.showMessageDialog(null, "Erreur durant le suppression!!!");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Vous devez au moins rempir le champ numero de compte!!!");
			}
			}
		});
		btnConsulter_3_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_8.setBackground(Color.YELLOW);
		btnConsulter_3_8.setBounds(157, 190, 195, 29);
		panel_3.add(btnConsulter_3_8);
		
		JButton btnConsulter_3_9 = new JButton("MODIFIER");
		btnConsulter_3_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String modR="update withdrawal set Amount=?,Date=?,Id_Receiver=? where Id_Account='"+IDR.getText()+"';";
				if(!IDR.getText().isEmpty()&& !AmountR.getText().isEmpty()) {
				try {
				
					pst=Con.getConnection().prepareStatement(modR);
					
					pst.setString(1,IDR.getText());
					pst.setString(3,AmountR.getText());
					pst.setString(2,String.format(DateR.getText()));
				
					
					pst.executeUpdate();
				//	Con.Deconnect();
					JOptionPane.showMessageDialog(null,"Les informations ont été modifiées.");
					Table2(table_4,tableHeader1,rq1);
					
					
				}catch(Exception exc) {
					JOptionPane.showMessageDialog(null,"Les informations ont été modifiées.");
					
				}
				
			}else {
				JOptionPane.showMessageDialog(null,"Tous les champs doivent être remplir.");
			}
			}
		});
		btnConsulter_3_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_9.setBackground(new Color(255, 128, 0));
		btnConsulter_3_9.setBounds(418, 190, 195, 29);
		panel_3.add(btnConsulter_3_9);
		
		JButton btnConsulter_3_10 = new JButton("ENREGISTRER");
		btnConsulter_3_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_10.setBackground(new Color(0, 255, 64));
		btnConsulter_3_10.setBounds(685, 190, 195, 29);
		panel_3.add(btnConsulter_3_10);
		
		JButton btnConsulter_3_11 = new JButton("RECHERCHER");
		btnConsulter_3_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String num;
				num=SearchR.getText();
				try {
					if(num!=null) {
						String rq22="SELECT * FROM withdrawal where Id_Account='"+num+"';";
						Table2(table_3,tableHeader1,rq22);
						
					}else {
						
						JOptionPane.showMessageDialog(null,"Erreur! Aucun client n'a ce numero de compte!!!");
						Table2(table_3,tableHeader1,rq1);
						
					}
					
				}catch(Exception ex) {
	
					JOptionPane.showMessageDialog(null,"Erreur! Aucun client n'a ce numero de compte!!!");
					
				}
			}
		});
		btnConsulter_3_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_3_11.setBackground(new Color(0, 128, 192));
		btnConsulter_3_11.setBounds(799, 271, 195, 29);
		panel_3.add(btnConsulter_3_11);
		
		DateR = new JTextField();
		DateR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DateR.setColumns(10);
		DateR.setBounds(224, 135, 551, 22);
		panel_3.add(DateR);
		panel_4.setBackground(new Color(128, 0, 255));
		
		tabbedPane.addTab("ADMINISTRATION DES TRANSFERTS D'ARGENT", null, panel_4, null);
		panel_4.setLayout(null);
		table_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int select=table_4.getSelectedRow();
				if(select >0) {
					model=(DefaultTableModel)(table_4.getModel());
					IDT.setText(model.getValueAt(select,0).toString());
					AmountT.setText(model.getValueAt(select,1).toString());	
					DateT.setText(model.getValueAt(select,2).toString());	
					ID_ReceiverT.setText(model.getValueAt(select,3).toString());	
					
					
					}else {
						updateT();	
												
					}
				
			}
		});
		table_4.setBackground(new Color(192, 192, 192));
		table_4.setBounds(10, 286, 1051, 215);
		
		panel_4.add(table_4);
		
		IDT = new JTextField();
		IDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IDT.setColumns(10);
		IDT.setBounds(318, 68, 639, 22);
		panel_4.add(IDT);
		
		AmountT = new JTextField();
		AmountT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AmountT.setColumns(10);
		AmountT.setBounds(318, 100, 639, 22);
		panel_4.add(AmountT);
		
		JLabel lblNewLabel_2_4_1_2_5 = new JLabel("Numero du compte de l'envoyeur  :");
		lblNewLabel_2_4_1_2_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_2_5.setBounds(67, 69, 240, 20);
		panel_4.add(lblNewLabel_2_4_1_2_5);
		
		JLabel lblNewLabel_2_4_1_2_6 = new JLabel("Numero du compte du destinaire  :");
		lblNewLabel_2_4_1_2_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_2_6.setBounds(67, 129, 240, 20);
		panel_4.add(lblNewLabel_2_4_1_2_6);
		
		JLabel lblNewLabel_2_4_1_2_7 = new JLabel("Montant  :");
		lblNewLabel_2_4_1_2_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_2_7.setBounds(116, 99, 146, 20);
		panel_4.add(lblNewLabel_2_4_1_2_7);
		
		JLabel lblNewLabel_2_4_1_2_8 = new JLabel("Numero du compte  :");
		lblNewLabel_2_4_1_2_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_2_8.setBounds(67, 249, 146, 20);
		panel_4.add(lblNewLabel_2_4_1_2_8);
		
		JLabel lblNewLabel_2_4_1_2_9 = new JLabel("GESTION DES TRANSFERTS D'ARGENT");
		lblNewLabel_2_4_1_2_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_4_1_2_9.setBounds(321, 10, 392, 28);
		panel_4.add(lblNewLabel_2_4_1_2_9);
		
		ID_ReceiverT = new JTextField();
		ID_ReceiverT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ID_ReceiverT.setColumns(10);
		ID_ReceiverT.setBounds(318, 132, 639, 22);
		panel_4.add(ID_ReceiverT);
		
		SearchT = new JTextField();
		SearchT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SearchT.setColumns(10);
		SearchT.setBounds(214, 247, 499, 22);
		panel_4.add(SearchT);
		
		JButton btnConsulter_4_1 = new JButton("SUPPRIMER");
		btnConsulter_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String delT="delete from transfer where Id_Account='"+IDT.getText()+"';";
				if(!IDT.getText().isEmpty()) {
				try {
					Statement st =Con.getConnection().createStatement();
					st.executeUpdate(delT);
					//Con.Deconnect();
					
					JOptionPane.showMessageDialog(null, "Success delete");
					Table2(table_4,tableHeader1,rq1);
					updateT();
				}catch(SQLException sqle) {
					JOptionPane.showMessageDialog(null, "Error durant la suppression d'argent!!!");
				}
				
				}else {
					JOptionPane.showMessageDialog(null, "Error durant la suppression d'argent!!!");
				}
				
			}
			
			
		});
		btnConsulter_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_4_1.setBackground(new Color(255, 0, 0));
		btnConsulter_4_1.setBounds(158, 208, 195, 29);
		panel_4.add(btnConsulter_4_1);
		
		JButton btnConsulter_4_2 = new JButton("MODIFIER");
		btnConsulter_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String modT="update transfer set Amount=?,Date=?,Id_Receiver=? where Id_Account='"+IDT.getText()+"';";
				if(!IDT.getText().isEmpty() && !AmountT.getText().isEmpty() && !ID_ReceiverT.getText().isEmpty()) {
				try {
				
					pst=Con.getConnection().prepareStatement(modT);
					
					pst.setString(1,IDT.getText());
					pst.setString(2,String.format(DateT.getText()));
					pst.setString(3,ID_ReceiverT.getText());
					
					pst.executeUpdate();
				//	Con.Deconnect();
					JOptionPane.showMessageDialog(null,"Les informations ont été modifiées.");
					Table2(table_4,tableHeader1,rq1);
					
					
				}catch(Exception exc) {
					JOptionPane.showMessageDialog(null,"Erreur durant la modification.");
				}
					
				
			}else {
				JOptionPane.showMessageDialog(null,"Tous les champs doivent être remplir.");
			}
			}
		}
		);
		
		btnConsulter_4_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_4_2.setBackground(new Color(255, 128, 0));
		btnConsulter_4_2.setBounds(413, 208, 195, 29);
		panel_4.add(btnConsulter_4_2);
		
		JButton btnConsulter_4_3 = new JButton("ENREGISTRER");
		btnConsulter_4_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String addT="insert into transfer(Id_Account,Amount,Date,Id_Receiver) values(?,?,?,?)";
				PreparedStatement ps1;
				if(!IDT.getText().isEmpty() && ! AmountT.getText().isEmpty() && ! DateT.getText().isEmpty()) {
				try {
					ps1 = Con.getConnection().prepareStatement(addT);
					ps1.setString(1,IDT.getText());
					ps1.setString(2,AmountT.getText());
					ps1.setString(3,String.format(DateT.getText()));
					dateFormat.format(date);
					ps1.setString(4,ID_ReceiverT.getText());			
					ps1.executeUpdate();
					JOptionPane.showMessageDialog(null,"Le transfert a été enregistré.");
					Table2(table_4,tableHeader1,rq1);
				} catch (SQLException e1) {
			
					JOptionPane.showMessageDialog(null,"Erreur! Le transfer n'a pas été enregistré.");
					
				}
				
			}else {
				JOptionPane.showMessageDialog(null,"Erreur!vous devez remplir tous les champs.");
				
			}
				
			}
		});
		
		btnConsulter_4_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_4_3.setBackground(Color.GREEN);
		btnConsulter_4_3.setBounds(674, 208, 195, 29);
		panel_4.add(btnConsulter_4_3);
		
		JButton btnConsulter_4_4 = new JButton("RECHERCHER");
		btnConsulter_4_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				try {
					if(!SearchT.getText().isEmpty()) {
						String rq55="SELECT * FROM transfer where Id_Account='"+SearchT.getText()+"';";
					Table2(table_4,tableHeader5,rq55);
					}else {
						Table2(table_4,tableHeader1,rq1);
						
					}
				
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Erreur! Aucun client n'a ce numero de compte!!!");
					
				}
			}
		});
		btnConsulter_4_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulter_4_4.setBackground(new Color(0, 128, 192));
		btnConsulter_4_4.setBounds(731, 240, 195, 29);
		panel_4.add(btnConsulter_4_4);
		
		JLabel lblNewLabel_2_4_1_2_6_1 = new JLabel("Date :");
		lblNewLabel_2_4_1_2_6_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_2_6_1.setBounds(158, 167, 70, 20);
		panel_4.add(lblNewLabel_2_4_1_2_6_1);
		
		DateT = new JTextField();
		DateT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DateT.setColumns(10);
		DateT.setBounds(318, 164, 639, 22);
		panel_4.add(DateT);
	}
}

