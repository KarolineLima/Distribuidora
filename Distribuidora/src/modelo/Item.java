package modelo;

//import java.util.ArrayList;

public class Item {
	
	private int quantidade;
	private double valor;
	private Produto produto;
	private Pedido venda;
	
	
	public Item( Produto produto, int quantidade, Pedido venda) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.venda = venda;
		valor = produto.getPreco() * quantidade;
	}


	// ----------------Getters/Setters---------------------//
	
	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Pedido getVenda() {
		return venda;
	}


	public void setVenda(Pedido venda) {
		this.venda = venda;
	}


	// -------- ToString ------- //
	

	public String toString() {
		return "Item -> Quantidade = " + quantidade + ", valor = " + valor + ", produto = " + produto + ", venda = " + venda;
	}




}	
	
