package aplicacaoSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;

public class TelaListagem extends JFrame {
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnListarProdutos;
	private JButton btnListarClientes;
	private JButton btnListarVendedores;
	private JButton btnListarMotoristas;
	private JButton btnListarPedidos;
	private JButton btnListarvendedores;
	private JButton btnListarmotorista;
	

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaListagem window = new TelaListagem();
//					window.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TelaListagem() {
		setTitle("Listar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 770, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnListarProdutos = new JButton("Listar Produtos");
		btnListarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

					textArea.setText(Fachada.listarProdutos());
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnListarProdutos.setBounds(10, 64, 115, 23);
		contentPane.add(btnListarProdutos);
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(182, 46, 545, 168);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
				textArea = new JTextArea();
				scroll.setViewportView(textArea);

		btnListarClientes = new JButton("Listar Clientes");
		btnListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{

					textArea.setText(Fachada.listarClientes());
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		
		
		btnListarClientes.setBounds(10, 132, 115, 23);
		contentPane.add(btnListarClientes);
				
				btnListarPedidos = new JButton("Listar Pedidos");
				btnListarPedidos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{

							textArea.setText(Fachada.listarPedidos());
						}
						catch(Exception erro){
							JOptionPane.showMessageDialog(null,erro.getMessage());
						}
					}
				});
				
				btnListarPedidos.setBounds(10, 98, 115, 23);
				contentPane.add(btnListarPedidos);
				
				
				
				btnListarvendedores = new JButton("Listar Vendedores");
				btnListarvendedores.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{

							textArea.setText(Fachada.listarVendedores());
						}
						catch(Exception erro){
							JOptionPane.showMessageDialog(null,erro.getMessage());
						}
					}
				});
				btnListarvendedores.setBounds(10, 166, 115, 23);
				contentPane.add(btnListarvendedores);
				
				
				
				btnListarmotorista = new JButton("Listar Motorista");
				btnListarmotorista.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{

							textArea.setText(Fachada.listarMotorista());
						}
						catch(Exception erro){
							JOptionPane.showMessageDialog(null,erro.getMessage());
						}
					}
				});
				btnListarmotorista.setBounds(10, 200, 115, 23);
				contentPane.add(btnListarmotorista);
		
		
		
		
	}
}
