package aplicacaoSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Produto;

public class TelaCadastrarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textnome;
	private JTextField txtestoque;
	private JTextField txtpreco;
	private JTextField textestoque;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarProduto frame = new TelaCadastrarProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastrarProduto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 602, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastramentoDeProduto = new JLabel("            Cadastramento de Produto");
		lblCadastramentoDeProduto.setFont(new Font("Arial", Font.BOLD, 30));
		lblCadastramentoDeProduto.setBounds(5, 5, 576, 35);
		contentPane.add(lblCadastramentoDeProduto);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(15, 74, 115, 31);
		contentPane.add(lblNewLabel);
		
		textnome = new JTextField();
		textnome.setBounds(98, 80, 157, 23);
		contentPane.add(textnome);
		textnome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pre\u00E7o:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(15, 134, 74, 31);
		contentPane.add(lblNewLabel_1);
		
		txtpreco = new JTextField();
		txtpreco.setBounds(98, 136, 157, 23);
		contentPane.add(txtpreco);
		txtpreco.setColumns(10);
		

		JLabel lblEstoque = new JLabel("Estoque:");
		lblEstoque.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEstoque.setBounds(15, 196, 95, 23);
		contentPane.add(lblEstoque);
		
		textestoque = new JTextField();
		textestoque.setBounds(98, 196, 157, 23);
		contentPane.add(textestoque);
		textestoque.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				try {
					if(textnome.getText().equals("")||txtpreco.getText().equals("")||txtestoque.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Informação obrigatória" , "Alerta", JOptionPane.DEFAULT_OPTION);     
					}
					else {
						String nome = textnome.getText();
						int estoque = Integer.parseInt(txtestoque.getText()); 
						double preco = Double.parseDouble(txtpreco.getText());
						
						
						Produto prod = Fachada.cadastrarProduto(nome, preco, estoque);
						if(prod != null) {
							JOptionPane.showMessageDialog(null, "Produto " + prod.getNome()+ " cadastrado com sucesso!", "Confirmação", JOptionPane.DEFAULT_OPTION);
						}

					}
					textnome.setText("");
					textnome.requestFocus();
					
					txtpreco.setText("");
					txtpreco.requestFocus();
					
					txtestoque.setText("");
					txtestoque.requestFocus();

			}
				catch(Exception erro) {
					JOptionPane.showConfirmDialog(null,erro.getMessage(),"Alerta",JOptionPane.DEFAULT_OPTION);
				}
			}
			}
		);
		
		
		
		btnCadastrar.setBounds(170, 256, 212, 31);
		contentPane.add(btnCadastrar);
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
