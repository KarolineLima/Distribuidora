package modelo;

import java.util.ArrayList;

public class Cliente extends Pessoa{
	
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

	public Cliente(String nome, String telefone, String endereco, String email) {
		super(nome, telefone, endereco, email);
		
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void addPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	// -------- ToString ------- //
	@Override
	public String toString() {
		return  "Cliente -> " + super.toString() + pedidos + " \n " ;
	}
	
	


}
