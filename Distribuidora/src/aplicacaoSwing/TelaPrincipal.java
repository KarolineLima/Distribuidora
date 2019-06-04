package aplicacaoSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


import fachada.Fachada;
import java.awt.Color;

public class TelaPrincipal {

	private JFrame frmPrincipal;
	private JMenu mnConsulta;
	private JMenuItem mntmNewAddProd;
	private JMenuItem mntmlista1;
	private JMenuItem mntmConsulta1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();


		frmPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				Fachada.inicializar();
				JOptionPane.showMessageDialog(null, "Seja Bem-Vindo!");
			}
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
				JOptionPane.showMessageDialog(null, "Obrigado pela preferência. Volte Sempre!");
			}
		});
		frmPrincipal.setTitle("Distribuidora");
		frmPrincipal.setBounds(100, 100, 588, 335);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel imagem = new JLabel("");
		imagem.setBounds(0, 0, 572, 268);

		ImageIcon image = new ImageIcon(TelaPrincipal.class.getResource("/img/frutas.jpg"));
		Image img = image.getImage().getScaledInstance(imagem.getWidth(), imagem.getHeight(), Image.SCALE_SMOOTH);
		imagem.setIcon(new ImageIcon(img));

		frmPrincipal.getContentPane().add(imagem);


			JMenuBar menuBar = new JMenuBar();
			frmPrincipal.setJMenuBar(menuBar);
			frmPrincipal.getContentPane().setLayout(null);
			frmPrincipal.getContentPane().setLayout(null);
			frmPrincipal.getContentPane().setLayout(null);
			frmPrincipal.getContentPane().setLayout(null);
			frmPrincipal.getContentPane().setLayout(null);
				frmPrincipal.getContentPane().setLayout(null);
				frmPrincipal.getContentPane().setLayout(null);
						
						
						mntmNewAddProd = new JMenuItem("              Cadastrar");
						mntmNewAddProd.setBackground(Color.WHITE);
						mntmNewAddProd.setForeground(Color.GRAY);
						menuBar.add(mntmNewAddProd);
						mntmNewAddProd.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								TelaCadastrarProduto j = new TelaCadastrarProduto();
								j.setVisible(true);
							}
						});
						frmPrincipal.getContentPane().setLayout(null);
						
					
						
						mntmlista1 = new JMenuItem("              Listar");
						mntmlista1.setBackground(Color.WHITE);
						mntmlista1.setForeground(Color.GRAY);
						menuBar.add(mntmlista1);
						mntmlista1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								TelaListagem j = new TelaListagem();
								j.setVisible(true);
							}
						});
						frmPrincipal.getContentPane().setLayout(null);
						
						
						mntmConsulta1 = new JMenuItem("              Consultar");
						mntmConsulta1.setBackground(Color.WHITE);
						mntmConsulta1.setForeground(Color.GRAY);
						menuBar.add(mntmConsulta1);
						mntmConsulta1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								TelaConsulta j = new TelaConsulta();
								j.setVisible(true);
							}
						});
						frmPrincipal.getContentPane().setLayout(null);
				
	}
}
