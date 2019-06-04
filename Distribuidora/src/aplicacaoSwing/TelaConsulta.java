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
import modelo.Motorista;
import modelo.Pedido;

public class TelaConsulta extends JFrame {
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnCriar;
	private JButton btnMotoristaEntrega;
	private JButton btnConsulta3;

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
	public TelaConsulta() {
		setTitle("Consultar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 655, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCriar = new JButton("Pedidos abertos do cliente");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String telefoneCliente = JOptionPane.showInputDialog("Informe telefone do cliente");
				try{
					Pedido cliente = Fachada.visualizarPedidoAbertoCliente(telefoneCliente);
					telefoneCliente = cliente.toString();
					textArea.setText(telefoneCliente);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(429, 13, 210, 23);
		contentPane.add(btnCriar);

		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(20, 11, 399, 160);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
		btnMotoristaEntrega = new JButton("Motorista da entrega");
		btnMotoristaEntrega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int telefoneMotorista = Integer.parseInt(JOptionPane.showInputDialog("Informe ID do pedido")) ;
				try {
					Motorista motorista = Fachada.visualizarMotoristaPedidoCliente(telefoneMotorista);
					String entrega = motorista.toString();
					textArea.setText(entrega);
				} 
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}

			}
		});
		btnMotoristaEntrega.setBounds(429, 47, 210, 23);
		contentPane.add(btnMotoristaEntrega);
		
		btnConsulta3 = new JButton("Consulta 3");
		btnConsulta3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String prefixo = JOptionPane.showInputDialog("digite o prefixo");
				textArea.setText(Fachada.consultarTelefonesPorPrefixo(prefixo));
*/
			
			}
		});
		btnConsulta3.setBounds(429, 81, 210, 23);
		contentPane.add(btnConsulta3);
	}
}
