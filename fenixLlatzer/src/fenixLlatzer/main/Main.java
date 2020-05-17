package fenixLlatzer.main;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fenixLlatzer.controller.Controller;
import fenixLlatzer.utils.MockedData;

public class Main {

	private JFrame frame;
	private CardLayout cLayout;
	private static Controller c = new Controller();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Main() throws Exception {
		MockedData.mockData(c);
		initializeGUI();
	}
	
	
	private void initializeGUI() {
			
		
		frame = new JFrame();
		frame.setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 612, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(cLayout = new CardLayout(0, 0));
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_113099293959000");
		
		JButton buttonInstalacio = new JButton("Instal·lació de Llatzer");
		buttonInstalacio.setBounds(158, 156, 307, 29);
		buttonInstalacio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstalaLlatzer();
				cLayout = (CardLayout)frame.getContentPane().getLayout();
				cLayout.next(frame.getContentPane());
			}
		});
		panel.setLayout(null);
		buttonInstalacio.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(buttonInstalacio);
		
		JPanel panelMenu = new JPanel();
		frame.getContentPane().add(panelMenu, "name_113099302787100");
		panelMenu.setLayout(null);
		
		JButton buttonAltaPacient = new JButton("Alta Pacient");
		buttonAltaPacient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaPacient();
			}
		});
		buttonAltaPacient.setBounds(220, 22, 170, 30);
		buttonAltaPacient.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelMenu.add(buttonAltaPacient);
		
		JButton buttonNouAny = new JButton("Nou Any");
		buttonNouAny.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonNouAny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NouAny();
			}
		});
		buttonNouAny.setBounds(220, 250, 170, 30);
		panelMenu.add(buttonNouAny);
		
		JButton buttonRealitzaProva = new JButton("Realitza Prova");
		buttonRealitzaProva.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonRealitzaProva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RealitzaProva();
			}
		});
		buttonRealitzaProva.setBounds(220, 93, 170, 30);
		panelMenu.add(buttonRealitzaProva);
		
		JButton buttonTancarExpedient = new JButton("Tancar Expedient");
		buttonTancarExpedient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TancarExpedient();
			}
		});
		buttonTancarExpedient.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonTancarExpedient.setBounds(220, 154, 170, 30);
		panelMenu.add(buttonTancarExpedient);
		
	}
	
	/**
	 * CU InstalaLlatzer.
	 */
	private void InstalaLlatzer(){  
		JFrame f = new JFrame();  
		String nomHospital = JOptionPane.showInputDialog(f,"Introdueix el nom del Hospital", "Insta·lació Llatzer", 1);
		try {
			if ((nomHospital != null) && (nomHospital.length() > 0)) {
				c.novaInstalacio(nomHospital);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(f, e.getMessage());
			InstalaLlatzer();
		}
	} 
	
	/**
	 * CU AltaPacient.
	 */
	private void AltaPacient(){  
		JFrame f = new JFrame();  
		String tsiPacient = JOptionPane.showInputDialog(f,"Introdueix el TSI del Pacient", "Alta Pacient", 1);
		try {
			if (tsiPacient != null && !tsiPacient.isEmpty()) {
				c.nouPatracol(tsiPacient);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(f, e.getMessage());
			AltaPacient();
		}
	} 
	
	private void TancarExpedient() {
		JFrame f = new JFrame();  
		String idExpedient = JOptionPane.showInputDialog(f,"Introdueix el ID del Expedient", "TancarExpedient", 1);
		try {
			if (idExpedient != null && !idExpedient.isEmpty()) {
				c.tancar(idExpedient);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(f, e.getMessage());
			TancarExpedient();
		}
	}
	
	/**
	 * CU RealitzaProva.
	 */
	private void RealitzaProva(){  
		JFrame f = new JFrame();  
		
		JTextField TSI = new JTextField();
		JTextField nomHospital = new JTextField();
		JTextField idInforme = new JTextField();
		JTextField nomProva = new JTextField();
		JTextField resultat = new JTextField();
		Object[] inputObject = {
			"Introdueix el TSI del Pacient:",TSI,
			"Introdueix el nom del Hospital (en cas de que l'Informe pertanyi a un altre):",nomHospital,
			"Introdueix el id del Informe:",idInforme,
			"Introdueix el nom de la prova",nomProva,
			"Introdueix el resultat",resultat
			
		};
		JOptionPane.showConfirmDialog(f, inputObject, "Realitza Prova", JOptionPane.DEFAULT_OPTION);
		try {
			if(TSI.getText() != null && !TSI.getText().isEmpty() && idInforme != null && !idInforme.getText().isEmpty() 
					&& nomProva != null && !nomProva.getText().isEmpty() 
					&& resultat != null && !resultat.getText().isEmpty()) {
				
				c.introdueixResultat(TSI.getText(), nomHospital.getText(), idInforme.getText(), nomProva.getText(), resultat.getText());
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(f, e.getMessage());
			RealitzaProva();
		}
	} 
	
	/**
	 * CU NouAny.
	 */
	private void NouAny(){  
		c.iniciAny();
		
		JFrame f = new JFrame();  
		String nomHospital = JOptionPane.showInputDialog  (f,"Introdueix el nom del Hospital","Nou Any",1);
		while(nomHospital != null && !nomHospital.isEmpty()) {
			try {
				c.actualitzaHospital(nomHospital);
				String nomFacultatiu = JOptionPane.showInputDialog(f,"Introdueix el nom del Facultatiu", "Nou Any",1);
				while(nomFacultatiu != null && !nomFacultatiu.isEmpty()) {
					try {
						c.actualitzaFacultatiu(nomFacultatiu);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(f, e.getMessage());
					}
					nomFacultatiu = JOptionPane.showInputDialog(f,"Introdueix el nom del Facultatiu", "Nou Any",1);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(f, e.getMessage());
			}
			nomHospital = JOptionPane.showInputDialog(f,"Introdueix el nom del Hospital", "Nou Any",1);
		}
		c.fiAny();
	} 
}
