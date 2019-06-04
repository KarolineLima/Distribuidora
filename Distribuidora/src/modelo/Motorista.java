package modelo;

import java.util.ArrayList;

public class Motorista extends Pessoa {
	
	private ArrayList<Pedido> entregas = new ArrayList<Pedido>();

	public Motorista(String nome, String telefone, String endereco, String email) {
		super(nome, telefone, endereco, email);
		
	}

	public ArrayList<Pedido> getEntregas() {
		return entregas;
	}

	public void addEntrega(Pedido novaEntrega) {
		entregas.add(novaEntrega);
	}

	// -------- ToString ------- //
	
	@Override
	public String toString() {
		return "Motorista ->" + super.toString() + " Entregas -> \n " + entregas ;
	}
	
	
	
}
