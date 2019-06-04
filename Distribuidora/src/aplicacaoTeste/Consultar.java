package aplicacaoTeste;

//import com.db4o.query.Candidate;
//import com.db4o.query.Evaluation;

import fachada.Fachada;


public class Consultar {

	public Consultar(){
		Fachada.inicializar();
		try {
			System.out.println("--------------------- Pedido aberto de determinado cliente --------------------- \n");
			System.out.println(Fachada.visualizarPedidoAbertoCliente("22"));
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("--------------------- Motorista responsável por de determinada entrega ---------------------\n");
			System.out.println(Fachada.visualizarMotoristaPedidoCliente(1));
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		Fachada.finalizar();
		
		System.out.println("\n --------------- Fim do programa ---------------");
		
	}
	



	//=================================================
	public static void main(String[] args) {
		new Consultar();
	}
}

