package modelo;

import java.util.ArrayList;

public class Vendedor extends Pessoa {
	
	private ArrayList<Pedido> vendas = new ArrayList<Pedido>();

	public Vendedor(String nome, String telefone, String endereco, String email) {
		super(nome, telefone, endereco, email);
	}

	public ArrayList<Pedido> getVendas() {
		return vendas;
	}

	public void addVenda(Pedido novaVenda) {
		vendas.add(novaVenda);
	}

	// -------- ToString ------- //
	
	@Override
	public String toString() {
		return "Vendedor -> "+ super.toString() +  " Vendas -> \n " + vendas + "\n";
	}
	
	
}
