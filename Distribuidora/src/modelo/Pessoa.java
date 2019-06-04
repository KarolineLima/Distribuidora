package modelo;

import java.util.ArrayList;

public class Pessoa {
	
	private String nome;  
	private String telefone;
	private String endereco;
	private String email;
	private  ArrayList<Pedido>pedidos = new ArrayList<Pedido>();
	
	public Pessoa(String nome, String telefone, String endereco,String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
	}
	

	// ----------------Getters/Setters---------------------//
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	
	//---------------Relacionamento--------------//
	
	
	//Pessoa -> Pedido
	public void adicionar(Pedido ped) {
		pedidos.add(ped);
	}
	
	public void remover(Pedido ped) {
		pedidos.remove(ped);
	}

	public Pedido localizar(int id) {
		for(Pedido ped: pedidos) {
			if(ped.getId() == id) {
				return ped;
			}
		}
		return null;	
	}
	
	// -------- ToString ------- //

	public String toString() {
		return " Nome = " + nome + ", Telefone = " + telefone + ",  Endereço = " + endereco 
				+ ", Email = " + email  + " \n";
	}

}
