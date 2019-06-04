package aplicacaoTeste;

import fachada.Fachada;

public class Listar {

	public Listar(){
		Fachada.inicializar();
		try {
			System.out.println(Fachada.listarProdutos());
			System.out.println(Fachada.listarClientes());
			System.out.println(Fachada.listarVendedores());
			System.out.println(Fachada.listarMotorista());
			System.out.println(Fachada.listarPedidos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("---------------Fim do programa---------------");
	}


	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}

