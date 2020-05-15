package fenixLlatzer.main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fenixLlatzer.controller.Controller;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

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
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void InstalaLlatzer(){  
		JFrame f = new JFrame();  
		String nomHospital = JOptionPane.showInputDialog(f,"Enter Name");
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
	
	private void initialize() {
		
		//TODO: Info initializer. Bucle for con randomStringGenerator y catch e.getMessage()
		try {
			c.addHospital("hey");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
		buttonAltaPacient.setBounds(219, 11, 163, 27);
		buttonAltaPacient.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelMenu.add(buttonAltaPacient);
		
		
		
		

	}
}
