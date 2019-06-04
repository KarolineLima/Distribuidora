 package modelo;

import java.util.ArrayList;

public class Produto {
	private String nome;
	private int estoque;
	private double preco;
	private  ArrayList<Item>itens = new ArrayList<Item>();
	
	public Produto() {}
	
	public Produto(String nome, int estoque, double preco) {
		this.nome = nome;
		this.estoque = estoque;
		this.preco = preco;
		
	}
	
	
	// ----------------Getters/Setters---------------------//
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}

	
	//---------------Relacionamento--------------//
	
	//Produto -> Item
	
		public void adicionar(Item i) {
			itens.add(i);
		}
		
		
		
		public void remover(Item i) {
			itens.remove(i);
		}

		public Item localizar(Produto nome) { 
			for(Item i: itens) {
				if(i.getProduto().equals(nome)) {
					return i; } 
				}
			return null;		
			}
	 
	
	// -------- ToString ------- //
	
	
		public String toString() {
			return "Produto -> Nome = " + nome + ", Preço = " + preco + ", Estoque = " + estoque;
		}

		//item
	
}

