package aplicacaoTeste;

import fachada.Fachada;


public class Deletar {

	public Deletar(){
		Fachada.inicializar();
		try {
			System.out.println("Excluindo...");
			Fachada.excluirPessoa("11");
		
		
			System.out.println("----> Usuário excluida com sucesso!");

			
			Fachada.excluirProduto("maça");
			System.out.println("----> Produto excluido com sucesso!");

			Fachada.excluirPedido("11");
			System.out.println("----> Pedido excluido com sucesso!");
			
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("--------------- Fim do programa ---------------");
	}



	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}

