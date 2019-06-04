package aplicacaoTeste;

import fachada.Fachada;


public class Atualizar {

	public Atualizar(){
		Fachada.inicializar();
		try {
			System.out.println("Alterando...");
			Fachada.alterarTelefone("44", "45");
			Fachada.alterarEndereco("22", "rua bc");
			System.out.println("Atualizações realizadas com sucesso!");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//erros
		try {Fachada.alterarEndereco("1010", "rua x"); }//produz erro 
		catch (Exception e) {System.out.println(e.getMessage());}
		try {Fachada.alterarTelefone("3030", "88883333"); }//produz erro 
		catch (Exception e) {System.out.println(e.getMessage());}

		Fachada.finalizar();
		System.out.println("----------------------Fim do programa-------------------");
	}




	//=================================================
	public static void main(String[] args) {
		new Atualizar();
	}
}

