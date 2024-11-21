package Page;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Administration.Administration_Accounts_Services;

public class ESSAIE {

	public JFrame frame;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ESSAIE window = new ESSAIE();
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
	public ESSAIE() {
		initialize();
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
		tabbedPane.addTab("Page d'accueil", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administration clients");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Administration_Accounts_Services().frame.setVisible(true);
				frame.dispose();
			}
		});
		
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(446, 472, 180, 29);
		panel.add(lblNewLabel);
		
		JButton btnDeconnecter = new JButton("Deconnecter");
		btnDeconnecter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login().frame.setVisible(true);
				frame.dispose();
			}
		});
		btnDeconnecter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeconnecter.setBackground(Color.RED);
		btnDeconnecter.setBounds(883, 10, 144, 29);
		panel.add(btnDeconnecter);
		
		JButton btnDeconnecter_1 = new JButton("Deconnecter");
		btnDeconnecter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Administration_Accounts_Services().frame.setVisible(true);
				frame.dispose();
			}
		});
		btnDeconnecter_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnDeconnecter_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeconnecter_1.setBackground(Color.RED);
		btnDeconnecter_1.setBounds(673, 365, 144, 29);
		panel.add(btnDeconnecter_1);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("PAGE DE DEPOT", null, panel_6, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Page de transfert", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblAdministrationDesComptes = new JLabel("Administration des comptes");
		lblAdministrationDesComptes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Administration_Accounts_Services().frame.setVisible(true);
				frame.dispose();
			}
		});
		lblAdministrationDesComptes.setForeground(new Color(255, 128, 0));
		lblAdministrationDesComptes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAdministrationDesComptes.setBounds(413, 472, 236, 29);
		panel_1.add(lblAdministrationDesComptes);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Page de retrait", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Page d'epargne", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Page de pret", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Page de consultation solde", null, panel_5, null);
		
	
		
	}
}
