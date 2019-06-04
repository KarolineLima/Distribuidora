package aplicacaoTeste;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Item;
import modelo.Motorista;
import modelo.Pedido;
//import modelo.Pessoa;
import modelo.Produto;
import modelo.Vendedor;



public class Cadastrar {

	public Cadastrar(){
		
		try {
			Fachada.inicializar();
			
			Produto p2,p3;
			Cliente c1,c2,c3;
			Vendedor v1,v2,v3;
			Motorista m1,m2,m3;
			Pedido pedido;
			Item it;
			System.out.println("Cadastrando...");
			
			//p1 = Fachada.cadastrarProduto("maça", 4, 50);
			p2 = Fachada.cadastrarProduto("uva", 3, 60);
			p3 = Fachada.cadastrarProduto("melancia", 1.30, 7);
			
			
			//Usuários - cliente
			c1 = Fachada.cadastrarCliente("Karol","11", "rua a","karol@gmail.com");
			c2 = Fachada.cadastrarCliente("Henrique", "22", "rua b","henrique@gmail.com");
			//c3 = Fachada.cadastrarCliente("Sérgio", "33", "rua c","sergio@gmail.com");
					
					
					
			//Usuarios - vendedor
					
			v1 = Fachada.cadastrarVendedor("Joana", "44", "rua d", "joana@gmail.com");
			v2 = Fachada.cadastrarVendedor("Marcelo", "55", "rua e", "marcelo@gmail.com");
			//v3 = Fachada.cadastrarVendedor("Pedro", "66", "rua f", "pedro@gmail.com");
					
					
			//Usuarios - motorista
			
			m1 = Fachada.cadastrarMotorista("Marta", "77", "rua g", "marta@gmail.com");
			m2 = Fachada.cadastrarMotorista("Jorge", "88", "rua h", "jorge@gmail.com");
			m3 = Fachada.cadastrarMotorista("Maria", "99", "rua i", "maria@gmail.com");
		
			
			System.out.println("---------> Usuarios e produtos cadastrados com sucesso!");
			//System.out.println("c1:" + c1);
			//System.out.println("v1" + v1);
			
			//Vendas
			
			
			pedido = Fachada.abrirPedido(c1.getTelefone(), v1.getTelefone());
			System.out.println("------> Pedido 1 aberto com sucesso! \n");
			pedido = Fachada.abrirPedido(c2.getTelefone(), v2.getTelefone());
			System.out.println("------> Pedido 2 aberto com sucesso! \n");
			 
			//Itens 
						 
			it = Fachada.adicionarItemPedido(p2.getNome(), 2 , c1.getTelefone());
			System.out.println("------> Item adicionado com sucesso! \n");

			it = Fachada.adicionarItemPedido(p3.getNome(), 1, c2.getTelefone());
			System.out.println("------> Item adicionado com sucesso! \n");
			
			
			System.out.println("Cadastro realizado com sucesso...");
			
			System.out.println("--------------Fechando pedido 1 -----------------");
			
			Fachada.fecharPedido("11", m1.getTelefone());
			
			System.out.println("Pedido 1 fechado com sucesso!");
		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}

		System.out.println("Fim do programa");
	}


	public void cadastrar(){

	}	


	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


