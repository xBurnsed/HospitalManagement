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
import javax.swing.JTextArea;
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
		buttonNouAny.setBounds(220, 299, 170, 30);
		panelMenu.add(buttonNouAny);
		
		JButton buttonRealitzaProva = new JButton("Realitza Prova");
		buttonRealitzaProva.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonRealitzaProva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RealitzaProva();
			}
		});
		buttonRealitzaProva.setBounds(220, 167, 170, 30);
		panelMenu.add(buttonRealitzaProva);
		
		JButton buttonTancarExpedient = new JButton("Tancar Expedient");
		buttonTancarExpedient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TancarExpedient();
			}
		});
		buttonTancarExpedient.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonTancarExpedient.setBounds(220, 232, 170, 30);
		panelMenu.add(buttonTancarExpedient);
		
		JButton buttonIntroduirInforme = new JButton("Introduir Informe");
		buttonIntroduirInforme.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				IntroduirInforme();
			}
			
		});
		buttonIntroduirInforme.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonIntroduirInforme.setBounds(220, 96, 170, 30);
		panelMenu.add(buttonIntroduirInforme);
		
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
				JOptionPane.showConfirmDialog(f, "S'ha instal·lat el Llatzer amb éxit!", "Instal·la Llatzer", JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(f, "Introdueix un nom d'Hospital vàlid!");
				InstalaLlatzer();
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
				JOptionPane.showConfirmDialog(f, "S'ha creat el nou Patracol amb éxit!", "Alta Pacient", JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(f, e.getMessage());
		}
	} 
	
	private void TancarExpedient() {
		JFrame f = new JFrame();  
		String idExpedient = JOptionPane.showInputDialog(f,"Introdueix el ID del Expedient", "Tancar Expedient", 1);
		try {
			if (idExpedient != null && !idExpedient.isEmpty()) {
				c.tancar(idExpedient);
				JOptionPane.showConfirmDialog(f, "S'ha tancat l'expedient amb éxit!", "Tancar Expedient", JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(f, e.getMessage());
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
			"Introdueix el nom de la prova:",nomProva,
			"Introdueix el resultat:",resultat
			
		};
		JOptionPane.showConfirmDialog(f, inputObject, "Realitza Prova", JOptionPane.DEFAULT_OPTION);
		try {
			c.introdueixResultat(TSI.getText(), nomHospital.getText(), idInforme.getText(), nomProva.getText(), resultat.getText());
			JOptionPane.showConfirmDialog(f, "S'ha introduit el Resultat de la Prova amb éxit!", "Realitza Prova", JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE);
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(f, e.getMessage());
		}
	} 
	
	
	/**
	 * CU IntroduirInforme.
	 */
	private void IntroduirInforme(){  
		JFrame f = new JFrame();  
		
		JTextField idFacultatiu = new JTextField();
		JTextField TSI = new JTextField();
		JTextField idExpedient = new JTextField();
		JTextField patologia = new JTextField();
		JTextArea observacions = new JTextArea();
		observacions.setRows(3);
		
		Object[] inputObject = {
				"Introdueix el identificador del Facultatiu:",idFacultatiu,
				"Introdueix el TSI del Pacient:",TSI,
				"Introdueix el identificador del Expedient:",idExpedient,
				"Introdueix la patologia del Expedient (en cas de que sigui un nou):",patologia,
				"Introdueix les observacions del Informe:",observacions	
			};
		
		JOptionPane.showConfirmDialog(f, inputObject, "Introduir Informe", JOptionPane.DEFAULT_OPTION);
		
		try {
			c.iniciIntroduccioInforme(idFacultatiu.getText(), TSI.getText(), idExpedient.getText(), patologia.getText(), observacions.getText());
			
			JTextField nomMedicament = new JTextField();
			JTextField dosi = new JTextField();
			JTextField pauta = new JTextField();
			
			Object[] inputObjectMedicament = {
					"Introdueix Nom Medicament:",nomMedicament,
					"Introdueix dosi:",dosi,
					"Introdueix pauta:",pauta
			};
			Object[] optionsMedicament = {"Desa Medicament", "Següent"};
			
			int n = JOptionPane.showOptionDialog(f, inputObjectMedicament, "Introduir Medicament", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsMedicament, optionsMedicament[0]);
			while(n == 0) {
				try {
					c.nouMedicamentRecomanat(nomMedicament.getText(), dosi.getText(), pauta.getText());
					nomMedicament.setText("");
					dosi.setText("");
					pauta.setText("");
					n = JOptionPane.showOptionDialog(f, inputObjectMedicament, "Introduir Medicament", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsMedicament, optionsMedicament[0]);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(f, e.getMessage());
					n = JOptionPane.showOptionDialog(f, inputObjectMedicament, "Introduir Medicament", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsMedicament, optionsMedicament[0]);
				}
			}
			
			JTextField nomProva = new JTextField();
			
			Object[] inputObjectProva = {
					"Introdueix el nom de la Prova Sugerida:",nomProva,
			};
			Object[] optionsProva = {"Desa Prova", "Següent"};
			
			n = JOptionPane.showOptionDialog(f, inputObjectProva, "Introduir Prova", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsProva, optionsProva[0]);
			while(n == 0) {
				try {
					c.novaProvaSugerida(nomProva.getText());
					nomProva.setText("");
					n = JOptionPane.showOptionDialog(f, inputObjectProva, "Introduir Prova", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsProva, optionsProva[0]);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(f, e.getMessage());
					n = JOptionPane.showOptionDialog(f, inputObjectProva, "Introduir Prova", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsProva, optionsProva[0]);
				}
			}
			
			c.fiIntroduirInforme();
			JOptionPane.showConfirmDialog(f, "S'ha introduit l'informe amb éxit!", "Introduir Informe", JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(f, e.getMessage());
		}
		
	}
	
	/**
	 * CU NouAny.
	 */
	private void NouAny(){  
		c.iniciAny();
		
		JFrame f = new JFrame();  
		JTextField nomHospital = new JTextField();		
		Object[] inputObjectHospital = {
				"Introdueix Nom Hospital:",nomHospital,
		};
		
		JTextField idFacultatiu = new JTextField();
		Object[] inputObjectFacultatiu = {
				"Introdueix ID Facultatiu:",idFacultatiu,
		};

		Object[] options = {"Següent", "Fi"};
		
		int n = JOptionPane.showOptionDialog(f, inputObjectHospital, "Actualitza Hospital", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		while(n == 0 && nomHospital.getText() != null && !nomHospital.getText().isEmpty()) {
			try {
				c.actualitzaHospital(nomHospital.getText());
					
				n = JOptionPane.showOptionDialog(f, inputObjectFacultatiu, "Actualitza Facultatiu", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				while(n == 0 && idFacultatiu.getText() != null && !idFacultatiu.getText().isEmpty()) {
					try {
						c.actualitzaFacultatiu(idFacultatiu.getText());
					} catch (Exception e) {
						JOptionPane.showMessageDialog(f, e.getMessage());
					}
					idFacultatiu.setText("");
					n = JOptionPane.showOptionDialog(f, inputObjectFacultatiu, "Actualitza Facultatiu", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(f, e.getMessage());
			}
			nomHospital.setText("");
			n = JOptionPane.showOptionDialog(f, inputObjectHospital, "Actualitza Hospital", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		}
		c.fiAny();
	} 
}
